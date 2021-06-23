<%@ page import="com.liferay.commerce.account.model.CommerceAccount" %><%@
page import="com.liferay.commerce.constants.CommerceWebKeys" %><%@
page import="com.liferay.commerce.context.CommerceContext" %><%@
page import="com.liferay.commerce.model.CommerceShipment" %><%@
page import="com.liferay.portal.kernel.util.CalendarFactoryUtil" %><%@
page import="com.liferay.portal.kernel.util.Validator" %>

<%@ page import="java.util.Calendar" %><%@
page import="java.util.Date" %>

<%@ page import="com.github.lgdd.liferay.commerce.transport.planning.constants.TransportPlanningCommandNames" %>

<%@ include file="/init.jsp" %>

<%
	CommerceContext commerceContext = (CommerceContext)request
			.getAttribute(CommerceWebKeys.COMMERCE_CONTEXT);

	CommerceAccount commerceAccount = commerceContext.getCommerceAccount();

	CommerceShipment shipment = (CommerceShipment)request.getAttribute("shipment");

	if (Validator.isNull(shipment.getCarrier())) {
	  shipment.setCarrier(commerceAccount.getName());
	}

	Date today = new Date();

	Date expectedDate = shipment.getExpectedDate();
	int expectedDay;
	int expectedMonth;
	int expectedYear;

	if (expectedDate != null) {
		Calendar calendar = CalendarFactoryUtil.getCalendar(expectedDate.getTime());

		expectedDay = calendar.get(Calendar.DAY_OF_MONTH);
		expectedMonth = calendar.get(Calendar.MONTH);
		expectedYear = calendar.get(Calendar.YEAR);
	}
else {
		Calendar calendar = CalendarFactoryUtil.getCalendar(today.getTime());

		expectedDay = calendar.get(Calendar.DAY_OF_MONTH);
		expectedMonth = calendar.get(Calendar.MONTH);
		expectedYear = calendar.get(Calendar.YEAR);
	}

	Date shippingDate = shipment.getExpectedDate();
	int shippingDay;
	int shippingMonth;
	int shippingYear;

	if (shippingDate != null) {
		Calendar calendar = CalendarFactoryUtil.getCalendar(shippingDate.getTime());

		shippingDay = calendar.get(Calendar.DAY_OF_MONTH);
		shippingMonth = calendar.get(Calendar.MONTH);
		shippingYear = calendar.get(Calendar.YEAR);
	}
else {
		Calendar calendar = CalendarFactoryUtil.getCalendar(today.getTime());

		shippingDay = calendar.get(Calendar.DAY_OF_MONTH);
		shippingMonth = calendar.get(Calendar.MONTH);
		shippingYear = calendar.get(Calendar.YEAR);
	}
%>

<portlet:actionURL
	name="<%= TransportPlanningCommandNames.ACTION_EDIT_SHIPMENT %>"
	var="editShipmentActionURL"
/>

<div class="commerce-panel">
	<div class="commerce-panel__title">
		<h3>Shipment Plan</h3>
	</div>

	<div class="commerce-panel__content">
		<aui:form action="${editShipmentActionURL}" name="fm">
			<aui:model-context bean="<%= shipment %>" model="<%= CommerceShipment.class %>" />
			<aui:input name="commerceShipmentId" type="hidden" />

			<aui:input
				name="carrier"
				required="<%= true %>"
				value="<%= commerceAccount.getName() %>"
				wrapperCssClass="form-group-item"
			/>

			<aui:input name="trackingNumber" wrapperCssClass="form-group-item" />

			<div class="form-group form-group-item">
				<label class="control-label">Estimated Shipping Date</label>

				<liferay-ui:input-date
					dayParam="shippingDateDay"
					dayValue="<%= shippingDay %>"
					disabled="<%= false %>"
					monthParam="shippingDateMonth"
					monthValue="<%= shippingMonth %>"
					name="shippingDate"
					nullable="<%= false %>"
					required="true"
					showDisableCheckbox="<%= false %>"
					yearParam="shippingDateYear"
					yearValue="<%= shippingYear %>"
				/>
			</div>

			<div class="form-group form-group-item">
				<label class="control-label">Estimated Delivery Date</label>

				<liferay-ui:input-date
					dayParam="expectedDateDay"
					dayValue="<%= expectedDay %>"
					disabled="<%= false %>"
					monthParam="expectedDateMonth"
					monthValue="<%= expectedMonth %>"
					name="expectedDeliveryDate"
					nullable="<%= false %>"
					required="true"
					showDisableCheckbox="<%= false %>"
					yearParam="expectedDateYear"
					yearValue="<%= expectedYear %>"
				/>
			</div>

			<aui:button type="submit" value="Save" />
		</aui:form>
	</div>
</div>