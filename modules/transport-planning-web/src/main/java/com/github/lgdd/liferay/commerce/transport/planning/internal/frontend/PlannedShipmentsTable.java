package com.github.lgdd.liferay.commerce.transport.planning.internal.frontend;

import com.github.lgdd.liferay.commerce.transport.planning.constants.TransportPlanningCommandNames;
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
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.FastDateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.DateFormat;
import java.text.Format;

import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
	immediate = true,
	property = {
		"clay.data.provider.key=" + PlannedShipmentsTable.NAME,
		"clay.data.set.display.name=" + PlannedShipmentsTable.NAME
	},
	service = {
		ClayDataSetActionProvider.class, ClayDataSetDataProvider.class,
		ClayDataSetDisplayView.class
	}
)
public class PlannedShipmentsTable
	extends BaseTableClayDataSetDisplayView
	implements ClayDataSetActionProvider, ClayDataSetDataProvider<Shipment> {

	public static final String NAME = "commerce-planned-shipments";

	@Override
	public ClayTableSchema getClayTableSchema() {
		ClayTableSchemaBuilder clayTableSchemaBuilder =
			_clayTableSchemaBuilderFactory.create();

		ClayTableSchemaField shipmentIdField =
			clayTableSchemaBuilder.addClayTableSchemaField(
				"shipmentId", "shipment-id");

		shipmentIdField.setContentRenderer("actionLink");

		clayTableSchemaBuilder.addClayTableSchemaField("address", "address");

		clayTableSchemaBuilder.addClayTableSchemaField(
			"createDate", "create-date");

		ClayTableSchemaField statusField =
			clayTableSchemaBuilder.addClayTableSchemaField("status", "status");

		statusField.setContentRenderer("label");

		clayTableSchemaBuilder.addClayTableSchemaField("tracking", "tracking");

		return clayTableSchemaBuilder.build();
	}

	@Override
	public List<DropdownItem> getDropdownItems(
		HttpServletRequest httpServletRequest, long groupId, Object model) {

		Shipment shipment = (Shipment)model;

		return DropdownItemListBuilder.add(
			dropdownItem -> {
				dropdownItem.setHref(
					_getTransportEventsViewURL(
						shipment.getShipmentId(), httpServletRequest));
				dropdownItem.setLabel(
					LanguageUtil.get(httpServletRequest, "view"));
			}
		).add(
			dropdownItem -> {
				dropdownItem.setHref(
					_getShipmentEditURL(
						shipment.getShipmentId(), httpServletRequest));
				dropdownItem.setLabel(
					LanguageUtil.get(httpServletRequest, "update"));
			}
		).build();
	}

	@Override
	public List<Shipment> getItems(
			HttpServletRequest httpServletRequest, Filter filter,
			Pagination pagination, Sort sort)
		throws PortalException {

		return _getPlannedShipment(httpServletRequest);
	}

	@Override
	public int getItemsCount(
			HttpServletRequest httpServletRequest, Filter filter)
		throws PortalException {

		return _getPlannedShipment(
			httpServletRequest
		).size();
	}

	List<Shipment> _getPlannedShipment(HttpServletRequest httpServletRequest) {
		return _shipmentService.getCommerceShipments(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS
		).stream(
		).filter(
			shipment ->
				Validator.isNotNull(shipment.getExpectedDate()) &&
				Validator.isNotNull(shipment.getShippingDate())
		).map(
			commerceShipment -> {
				try {
					User user = _portal.getUser(httpServletRequest);

					CommerceChannel commerceChannel =
						_commerceChannelLocalService.
							getCommerceChannelByOrderGroupId(
								commerceShipment.getGroupId());

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

					if (commerceShipment.getExpectedDate() != null) {
						expectedDate = dateFormat.format(
							commerceShipment.getExpectedDate());
					}

					String shippingDate = null;

					if (commerceShipment.getShippingDate() != null) {
						shippingDate = dateFormat.format(
							commerceShipment.getShippingDate());
					}

					return new Shipment(
						commerceShipment.getCommerceAccountName(),
						_getDescriptiveAddress(commerceShipment),
						commerceChannel.getName(),
						dateTimeFormat.format(commerceShipment.getCreateDate()),
						expectedDate, shippingDate,
						commerceShipment.getCommerceShipmentId(),
						new LabelField(
							CommerceShipmentConstants.getShipmentLabelStyle(
								commerceShipment.getStatus()),
							LanguageUtil.get(
								httpServletRequest,
								CommerceShipmentConstants.
									getShipmentStatusLabel(
										commerceShipment.getStatus()))),
						commerceShipment.getTrackingNumber());
				}
				catch (PortalException e) {
					throw new RuntimeException(e);
				}
			}
		).collect(
			Collectors.toList()
		);
	}

	private String _getDescriptiveAddress(CommerceShipment commerceShipment)
		throws PortalException {

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

	private String _getShipmentEditURL(
			long commerceShipmentId, HttpServletRequest httpServletRequest)
		throws PortalException {

		ThemeDisplay themeDisplay =
			(ThemeDisplay)httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

		HttpServletRequest originalHttpServletRequest =
			PortalUtil.getOriginalServletRequest(httpServletRequest);

		PortletURL portletURL = PortletURLFactoryUtil.create(
			originalHttpServletRequest, portletDisplay.getId(),
			themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);

		portletURL.setParameter("backURL", portletURL.toString());

		portletURL.setParameter(
        "mvcRenderCommandName",
        TransportPlanningCommandNames.RENDER_EDIT_SHIPMENT);

		String redirect = ParamUtil.getString(
			httpServletRequest, "currentUrl",
			_portal.getCurrentURL(httpServletRequest));

		portletURL.setParameter("redirect", redirect);

		portletURL.setParameter(
			"commerceShipmentId", String.valueOf(commerceShipmentId));

		return portletURL.toString();
	}

	private String _getTransportEventsViewURL(
			long commerceShipmentId, HttpServletRequest httpServletRequest)
		throws PortalException {

		ThemeDisplay themeDisplay =
			(ThemeDisplay)httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

		HttpServletRequest originalHttpServletRequest =
			PortalUtil.getOriginalServletRequest(httpServletRequest);

		PortletURL portletURL = PortletURLFactoryUtil.create(
			originalHttpServletRequest, portletDisplay.getId(),
			themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);

		portletURL.setParameter("backURL", portletURL.toString());

		portletURL.setParameter(
        "mvcRenderCommandName",
        TransportPlanningCommandNames.RENDER_TRANSPORT_EVENTS);

		String redirect = ParamUtil.getString(
			httpServletRequest, "currentUrl",
			_portal.getCurrentURL(httpServletRequest));

		portletURL.setParameter("redirect", redirect);

		portletURL.setParameter(
			"commerceShipmentId", String.valueOf(commerceShipmentId));

		return portletURL.toString();
	}

	private static final Logger _log = LoggerFactory.getLogger(
		PlannedShipmentsTable.class);

	@Reference
	private ClayTableSchemaBuilderFactory _clayTableSchemaBuilderFactory;

	@Reference
	private CommerceChannelLocalService _commerceChannelLocalService;

	@Reference
	private Portal _portal;

	@Reference
	private CommerceShipmentLocalService _shipmentService;

}