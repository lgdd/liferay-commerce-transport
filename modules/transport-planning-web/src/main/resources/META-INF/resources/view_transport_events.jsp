<%@ page import="com.liferay.portal.kernel.util.HashMapBuilder" %><%@
page import="com.liferay.portal.kernel.util.ParamUtil" %>

<%@ page import="java.util.Map" %>

<%@ page import="com.github.lgdd.liferay.commerce.transport.planning.internal.frontend.ShipmentTransportEventsTable" %>

<%@ include file="/init.jsp" %>

<%
String commerceShipmentId = ParamUtil.getString(request, "commerceShipmentId");
Map<String, String> contextParams =
		HashMapBuilder.put("commerceShipmentId", commerceShipmentId)
					  .build();
%>

<h1>Shipment (<%= commerceShipmentId %>): Events</h1>
<clay:data-set-display
	contextParams="<%= contextParams %>"
	dataProviderKey="<%= ShipmentTransportEventsTable.NAME %>"
	id="<%= ShipmentTransportEventsTable.NAME %>"
	itemsPerPage="<%= 10 %>"
	namespace="<%= liferayPortletResponse.getNamespace() %>"
	pageNumber="<%= 1 %>"
	portletURL="<%= liferayPortletResponse.createRenderURL() %>"
/>