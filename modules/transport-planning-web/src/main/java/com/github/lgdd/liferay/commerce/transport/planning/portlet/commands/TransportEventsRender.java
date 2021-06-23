package com.github.lgdd.liferay.commerce.transport.planning.portlet.commands;

import com.github.lgdd.liferay.commerce.transport.planning.constants.TransportPlanningCommandNames;
import com.github.lgdd.liferay.commerce.transport.planning.constants.TransportPlanningPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.Portal;

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
		"mvc.command.name=" + TransportPlanningCommandNames.RENDER_TRANSPORT_EVENTS
	},
	service = MVCRenderCommand.class
)
public class TransportEventsRender implements MVCRenderCommand {

	public static final Logger _log = LoggerFactory.getLogger(
		TransportEventsRender.class);

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		return "/view_transport_events.jsp";
	}

	@Reference
	private Portal _portal;

}