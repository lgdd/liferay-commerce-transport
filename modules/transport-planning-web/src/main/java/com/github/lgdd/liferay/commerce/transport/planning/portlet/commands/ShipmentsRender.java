package com.github.lgdd.liferay.commerce.transport.planning.portlet.commands;

import com.github.lgdd.liferay.commerce.transport.planning.constants.TransportPlanningCommandNames;
import com.github.lgdd.liferay.commerce.transport.planning.constants.TransportPlanningPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + TransportPlanningPortletKeys.PORTLET_ID,
		"mvc.command.name=" + TransportPlanningCommandNames.RENDER_DEFAULT,
		"mvc.command.name=" + TransportPlanningCommandNames.RENDER_SHIPMENTS
	},
	service = MVCRenderCommand.class
)
public class ShipmentsRender implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		return "/view.jsp";
	}

}