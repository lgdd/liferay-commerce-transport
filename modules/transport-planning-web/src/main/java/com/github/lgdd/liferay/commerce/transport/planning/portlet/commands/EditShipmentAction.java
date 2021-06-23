package com.github.lgdd.liferay.commerce.transport.planning.portlet.commands;

import com.github.lgdd.liferay.commerce.transport.planning.constants.TransportPlanningCommandNames;
import com.github.lgdd.liferay.commerce.transport.planning.constants.TransportPlanningPortletKeys;
import com.liferay.commerce.constants.CommerceOrderConstants;
import com.liferay.commerce.constants.CommerceShipmentConstants;
import com.liferay.commerce.inventory.model.CommerceInventoryWarehouse;
import com.liferay.commerce.inventory.service.CommerceInventoryWarehouseLocalService;
import com.liferay.commerce.model.CommerceOrderItem;
import com.liferay.commerce.model.CommerceShipment;
import com.liferay.commerce.model.CommerceShipmentItem;
import com.liferay.commerce.service.CommerceOrderItemLocalService;
import com.liferay.commerce.service.CommerceShipmentItemLocalService;
import com.liferay.commerce.service.CommerceShipmentLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + TransportPlanningPortletKeys.PORTLET_ID,
		"mvc.command.name=" + TransportPlanningCommandNames.ACTION_EDIT_SHIPMENT
	},
	service = MVCActionCommand.class
)
public class EditShipmentAction extends BaseMVCActionCommand {

	public static final Logger _log = LoggerFactory.getLogger(
		EditShipmentAction.class);

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		long shipmentId = ParamUtil.getLong(
			actionRequest, "commerceShipmentId", 0);
		String carrier = ParamUtil.getString(
			actionRequest, "carrier", StringPool.BLANK);
		String trackingNumber = ParamUtil.getString(
			actionRequest, "trackingNumber", String.valueOf(shipmentId));
		Date expectedDeliveryDate = ParamUtil.getDate(
			actionRequest, "expectedDeliveryDate", dateFormat);
		Date shippingDate = ParamUtil.getDate(
			actionRequest, "shippingDate", dateFormat);

		_log.info("Shipment Plan:");
		_log.info("ID={}", shipmentId);
		_log.info("Carrier={}", carrier);
		_log.info("Tracking Number={}", trackingNumber);
		_log.info("Expected Delivery={}", expectedDeliveryDate);
		_log.info("Expected Shipping={}", shippingDate);

		CommerceShipment shipment = _shipmentService.getCommerceShipment(
			shipmentId);

		shipment.setCarrier(carrier);
		shipment.setTrackingNumber(trackingNumber);
		shipment.setExpectedDate(expectedDeliveryDate);
		shipment.setShippingDate(shippingDate);

		List<CommerceInventoryWarehouse> warehouses =
			_warehouseService.getCommerceInventoryWarehouses(
				QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		CommerceInventoryWarehouse warehouse = warehouses.get(0);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			CommerceShipmentItem.class.getName(), actionRequest);

		List<CommerceOrderItem> orderItems =
			_orderItemService.getCommerceOrderItems(
				shipment.getGroupId(), shipment.getCommerceAccountId(),
				orderStatuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		for (CommerceOrderItem orderItem : orderItems) {
			_shipmentItemService.addCommerceShipmentItem(
				shipmentId, orderItem.getCommerceOrderItemId(),
				warehouse.getCommerceInventoryWarehouseId(),
				orderItem.getQuantity(), serviceContext);
		}

		shipment.setStatus(
			CommerceShipmentConstants.SHIPMENT_STATUS_READY_TO_BE_SHIPPED);

		_shipmentService.updateCommerceShipment(shipment);
	}

	protected int[] orderStatuses = {
		CommerceOrderConstants.ORDER_STATUS_PROCESSING,
		CommerceOrderConstants.ORDER_STATUS_PARTIALLY_SHIPPED
	};

	@Reference
	private CommerceOrderItemLocalService _orderItemService;

	@Reference
	private CommerceShipmentItemLocalService _shipmentItemService;

	@Reference
	private CommerceShipmentLocalService _shipmentService;

	@Reference
	private CommerceInventoryWarehouseLocalService _warehouseService;

}