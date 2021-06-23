/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.github.lgdd.liferay.commerce.transport.events.service;

import com.github.lgdd.liferay.commerce.transport.events.model.TransportEvent;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for TransportEvent. This utility wraps
 * <code>com.github.lgdd.liferay.commerce.transport.events.service.impl.TransportEventLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TransportEventLocalService
 * @generated
 */
public class TransportEventLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.github.lgdd.liferay.commerce.transport.events.service.impl.TransportEventLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static TransportEvent addTransportEvent(
			long groupId, long commerceShipmentId, String carrier,
			String trackingNumber, java.util.Date expectedDate,
			java.util.Date shippingDate, int status, String commerceAccountName,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addTransportEvent(
			groupId, commerceShipmentId, carrier, trackingNumber, expectedDate,
			shippingDate, status, commerceAccountName, serviceContext);
	}

	/**
	 * Adds the transport event to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TransportEventLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param transportEvent the transport event
	 * @return the transport event that was added
	 */
	public static TransportEvent addTransportEvent(
		TransportEvent transportEvent) {

		return getService().addTransportEvent(transportEvent);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new transport event with the primary key. Does not add the transport event to the database.
	 *
	 * @param transportEventId the primary key for the new transport event
	 * @return the new transport event
	 */
	public static TransportEvent createTransportEvent(long transportEventId) {
		return getService().createTransportEvent(transportEventId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the transport event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TransportEventLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param transportEventId the primary key of the transport event
	 * @return the transport event that was removed
	 * @throws PortalException if a transport event with the primary key could not be found
	 */
	public static TransportEvent deleteTransportEvent(long transportEventId)
		throws PortalException {

		return getService().deleteTransportEvent(transportEventId);
	}

	/**
	 * Deletes the transport event from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TransportEventLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param transportEvent the transport event
	 * @return the transport event that was removed
	 */
	public static TransportEvent deleteTransportEvent(
		TransportEvent transportEvent) {

		return getService().deleteTransportEvent(transportEvent);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.github.lgdd.liferay.commerce.transport.events.model.impl.TransportEventModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.github.lgdd.liferay.commerce.transport.events.model.impl.TransportEventModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static TransportEvent fetchTransportEvent(long transportEventId) {
		return getService().fetchTransportEvent(transportEventId);
	}

	/**
	 * Returns the transport event matching the UUID and group.
	 *
	 * @param uuid the transport event's UUID
	 * @param groupId the primary key of the group
	 * @return the matching transport event, or <code>null</code> if a matching transport event could not be found
	 */
	public static TransportEvent fetchTransportEventByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchTransportEventByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the transport event with the primary key.
	 *
	 * @param transportEventId the primary key of the transport event
	 * @return the transport event
	 * @throws PortalException if a transport event with the primary key could not be found
	 */
	public static TransportEvent getTransportEvent(long transportEventId)
		throws PortalException {

		return getService().getTransportEvent(transportEventId);
	}

	/**
	 * Returns the transport event matching the UUID and group.
	 *
	 * @param uuid the transport event's UUID
	 * @param groupId the primary key of the group
	 * @return the matching transport event
	 * @throws PortalException if a matching transport event could not be found
	 */
	public static TransportEvent getTransportEventByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getTransportEventByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the transport events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.github.lgdd.liferay.commerce.transport.events.model.impl.TransportEventModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of transport events
	 * @param end the upper bound of the range of transport events (not inclusive)
	 * @return the range of transport events
	 */
	public static List<TransportEvent> getTransportEvents(int start, int end) {
		return getService().getTransportEvents(start, end);
	}

	public static List<TransportEvent> getTransportEventsByCommerceShipmentId(
		long commerceShipmentId) {

		return getService().getTransportEventsByCommerceShipmentId(
			commerceShipmentId);
	}

	/**
	 * Returns all the transport events matching the UUID and company.
	 *
	 * @param uuid the UUID of the transport events
	 * @param companyId the primary key of the company
	 * @return the matching transport events, or an empty list if no matches were found
	 */
	public static List<TransportEvent> getTransportEventsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getTransportEventsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of transport events matching the UUID and company.
	 *
	 * @param uuid the UUID of the transport events
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of transport events
	 * @param end the upper bound of the range of transport events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching transport events, or an empty list if no matches were found
	 */
	public static List<TransportEvent> getTransportEventsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TransportEvent> orderByComparator) {

		return getService().getTransportEventsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of transport events.
	 *
	 * @return the number of transport events
	 */
	public static int getTransportEventsCount() {
		return getService().getTransportEventsCount();
	}

	/**
	 * Updates the transport event in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TransportEventLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param transportEvent the transport event
	 * @return the transport event that was updated
	 */
	public static TransportEvent updateTransportEvent(
		TransportEvent transportEvent) {

		return getService().updateTransportEvent(transportEvent);
	}

	public static TransportEventLocalService getService() {
		return _service;
	}

	private static volatile TransportEventLocalService _service;

}