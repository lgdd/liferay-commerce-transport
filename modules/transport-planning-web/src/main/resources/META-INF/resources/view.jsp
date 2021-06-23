<%@ page import="com.github.lgdd.liferay.commerce.transport.planning.internal.frontend.AvailableShipmentsTable" %><%@
page import="com.github.lgdd.liferay.commerce.transport.planning.internal.frontend.PlannedShipmentsTable" %>

<%@ include file="/init.jsp" %>

<h1>Planned Shipments</h1>
<clay:data-set-display
	dataProviderKey="<%= PlannedShipmentsTable.NAME %>"
	id="<%= PlannedShipmentsTable.NAME %>"
	itemsPerPage="<%= 10 %>"
	namespace="<%= liferayPortletResponse.getNamespace() %>"
	pageNumber="<%= 1 %>"
	portletURL="<%= liferayPortletResponse.createRenderURL() %>"
/>

<h1 class="mt-5">Available Shipments</h1>
<clay:data-set-display
	dataProviderKey="<%= AvailableShipmentsTable.NAME %>"
	id="<%= AvailableShipmentsTable.NAME %>"
	itemsPerPage="<%= 10 %>"
	namespace="<%= liferayPortletResponse.getNamespace() %>"
	pageNumber="<%= 1 %>"
	portletURL="<%= liferayPortletResponse.createRenderURL() %>"
/>