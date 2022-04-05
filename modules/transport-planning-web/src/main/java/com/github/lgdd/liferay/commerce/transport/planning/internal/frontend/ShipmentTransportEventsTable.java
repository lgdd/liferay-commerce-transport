package com.github.lgdd.liferay.commerce.transport.planning.internal.frontend;

import com.liferay.commerce.constants.CommerceShipmentConstants;
import com.liferay.commerce.frontend.model.LabelField;
import com.liferay.commerce.frontend.model.Shipment;
import com.liferay.commerce.model.CommerceAddress;
import com.liferay.portal.kernel.model.Region;
import com.liferay.commerce.model.CommerceShipment;
import com.liferay.commerce.product.model.CommerceChannel;
import com.liferay.commerce.product.service.CommerceChannelLocalService;
import com.liferay.commerce.service.CommerceShipmentLocalService;
import com.liferay.frontend.taglib.clay.data.Filter;
import com.liferay.frontend.taglib.clay.data.Pagination;
import com.liferay.frontend.taglib.clay.data.set.ClayDataSetActionProvider;
import com.liferay.frontend.taglib.clay.data.set.ClayDataSetDisplayView;
import com.liferay.frontend.taglib.clay.data.set.provider.ClayDataSetDataProvider;
import com.liferay.frontend.taglib.clay.data.set.view.table.BaseTableClayDataSetDisplayView;
import com.liferay.frontend.taglib.clay.data.set.view.table.ClayTableSchema;
import com.liferay.frontend.taglib.clay.data.set.view.table.ClayTableSchemaBuilder;
import com.liferay.frontend.taglib.clay.data.set.view.table.ClayTableSchemaBuilderFactory;
import com.liferay.frontend.taglib.clay.data.set.view.table.ClayTableSchemaField;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.util.FastDateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;

import java.text.DateFormat;
import java.text.Format;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import com.github.lgdd.liferay.commerce.transport.events.service.TransportEventLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
	immediate = true,
	property = {
		"clay.data.provider.key=" + ShipmentTransportEventsTable.NAME,
		"clay.data.set.display.name=" + ShipmentTransportEventsTable.NAME
	},
	service = {
		ClayDataSetActionProvider.class, ClayDataSetDataProvider.class,
		ClayDataSetDisplayView.class
	}
)
public class ShipmentTransportEventsTable
	extends BaseTableClayDataSetDisplayView
	implements ClayDataSetActionProvider, ClayDataSetDataProvider<Shipment> {

	public static final String NAME = "commerce-shipment-transport-events";

	@Override
	public ClayTableSchema getClayTableSchema() {
		ClayTableSchemaBuilder clayTableSchemaBuilder =
			_clayTableSchemaBuilderFactory.create();

		clayTableSchemaBuilder.addClayTableSchemaField("createDate", "update");

		clayTableSchemaBuilder.addClayTableSchemaField("address", "address");

		clayTableSchemaBuilder.addClayTableSchemaField(
			"expectedDeliveryDate", "expected-date");

		clayTableSchemaBuilder.addClayTableSchemaField(
			"expectedShipDate", "shipping-date");

		ClayTableSchemaField statusField =
			clayTableSchemaBuilder.addClayTableSchemaField("status", "status");

		statusField.setContentRenderer("label");

		clayTableSchemaBuilder.addClayTableSchemaField("tracking", "tracking");

		return clayTableSchemaBuilder.build();
	}

	@Override
	public List<DropdownItem> getDropdownItems(
		HttpServletRequest httpServletRequest, long groupId, Object model) {

		return Collections.emptyList();
	}

	@Override
	public List<Shipment> getItems(
			HttpServletRequest httpServletRequest, Filter filter,
			Pagination pagination, Sort sort)
		throws PortalException {

		return _getShipmentEvents(httpServletRequest);
	}

	@Override
	public int getItemsCount(
			HttpServletRequest httpServletRequest, Filter filter)
		throws PortalException {

		return _getShipmentEvents(
			httpServletRequest
		).size();
	}

	List<Shipment> _getShipmentEvents(HttpServletRequest httpServletRequest)
		throws PortalException {

		long commerceShipmentId = ParamUtil.getLong(
			httpServletRequest, "commerceShipmentId", -1);

		return _transportEventService.getTransportEventsByCommerceShipmentId(
			commerceShipmentId
		).stream(
		).map(
			transportEvent -> {
				try {
					User user = _portal.getUser(httpServletRequest);

					CommerceChannel commerceChannel =
						_commerceChannelLocalService.
							getCommerceChannelByOrderGroupId(
								transportEvent.getGroupId());

					Format dateTimeFormat =
						FastDateFormatFactoryUtil.getDateTime(
							DateFormat.MEDIUM, DateFormat.MEDIUM,
							_portal.getLocale(httpServletRequest),
							user.getTimeZone());

					Format dateFormat = FastDateFormatFactoryUtil.getDate(
						DateFormat.MEDIUM,
						_portal.getLocale(httpServletRequest),
						user.getTimeZone());

					String expectedDate = null;

					if (transportEvent.getExpectedDate() != null) {
						expectedDate = dateFormat.format(
							transportEvent.getExpectedDate());
					}

					String shippingDate = null;

					if (transportEvent.getShippingDate() != null) {
						shippingDate = dateFormat.format(
							transportEvent.getShippingDate());
					}

					return new Shipment(
						transportEvent.getCommerceAccountName(),
						_getDescriptiveAddress(commerceShipmentId),
						commerceChannel.getName(),
						dateTimeFormat.format(transportEvent.getCreateDate()),
						expectedDate, shippingDate,
						transportEvent.getTransportEventId(),
						new LabelField(
							CommerceShipmentConstants.getShipmentLabelStyle(
								transportEvent.getStatus()),
							LanguageUtil.get(
								httpServletRequest,
								CommerceShipmentConstants.
									getShipmentStatusLabel(
										transportEvent.getStatus()))),
						transportEvent.getTrackingNumber());
				}
				catch (PortalException e) {
					throw new RuntimeException(e);
				}
			}
		).collect(
			Collectors.toList()
		);
	}

	private String _getDescriptiveAddress(long commerceShipmentId)
		throws PortalException {

		CommerceShipment commerceShipment =
			_shipmentService.getCommerceShipment(commerceShipmentId);

		CommerceAddress commerceAddress =
			commerceShipment.fetchCommerceAddress();

		if (commerceAddress == null) {
			return StringPool.BLANK;
		}

		Region commerceRegion = commerceAddress.getRegion();

		StringBundler sb = new StringBundler((commerceRegion == null) ? 5 : 7);

		sb.append(commerceAddress.getStreet1());
		sb.append(StringPool.SPACE);
		sb.append(commerceAddress.getCity());
		sb.append(StringPool.NEW_LINE);

		if (commerceRegion != null) {
			sb.append(commerceRegion.getRegionCode());
			sb.append(StringPool.SPACE);
		}

		sb.append(commerceAddress.getZip());

		return sb.toString();
	}

	private static final Logger _log = LoggerFactory.getLogger(
		ShipmentTransportEventsTable.class);

	@Reference
	private ClayTableSchemaBuilderFactory _clayTableSchemaBuilderFactory;

	@Reference
	private CommerceChannelLocalService _commerceChannelLocalService;

	@Reference
	private Portal _portal;

	@Reference
	private CommerceShipmentLocalService _shipmentService;

	@Reference
	private TransportEventLocalService _transportEventService;

}