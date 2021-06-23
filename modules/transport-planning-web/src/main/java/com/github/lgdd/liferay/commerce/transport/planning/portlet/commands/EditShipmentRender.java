package com.github.lgdd.liferay.commerce.transport.planning.portlet.commands;

import com.github.lgdd.liferay.commerce.transport.planning.constants.TransportPlanningCommandNames;
import com.github.lgdd.liferay.commerce.transport.planning.constants.TransportPlanningPortletKeys;
import com.liferay.commerce.model.CommerceShipment;
import com.liferay.commerce.service.CommerceShipmentLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + TransportPlanningPortletKeys.PORTLET_ID,
		"mvc.command.name=" + TransportPlanningCommandNames.RENDER_EDIT_SHIPMENT
	},
	service = MVCRenderCommand.class
)
public class EditShipmentRender implements MVCRenderCommand {

	public static final Logger _log = LoggerFactory.getLogger(
		EditShipmentRender.class);

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		long commerceShipmentId = ParamUtil.getLong(
			renderRequest, "commerceShipmentId", 0);

		if (commerceShipmentId > 0) {
			try {
				CommerceShipment commerceShipment =
					_shipmentService.getCommerceShipment(commerceShipmentId);

				renderRequest.setAttribute("shipment", commerceShipment);
			}
			catch (PortalException e) {
				_log.error(e.getLocalizedMessage(), e);
			}
		}

		return "/edit_shipment.jsp";
	}

	@Reference
	private CommerceShipmentLocalService _shipmentService;

}