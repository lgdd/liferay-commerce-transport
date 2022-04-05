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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TransportEventLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TransportEventLocalService
 * @generated
 */
public class TransportEventLocalServiceWrapper
	implements ServiceWrapper<TransportEventLocalService>,
			   TransportEventLocalService {

	public TransportEventLocalServiceWrapper() {
		this(null);
	}

	public TransportEventLocalServiceWrapper(
		TransportEventLocalService transportEventLocalService) {

		_transportEventLocalService = transportEventLocalService;
	}

	@Override
	public
		com.github.lgdd.liferay.commerce.transport.events.model.TransportEvent
				addTransportEvent(
					long groupId, long commerceShipmentId, String carrier,
					String trackingNumber, java.util.Date expectedDate,
					java.util.Date shippingDate, int status,
					String commerceAccountName,
					com.liferay.portal.kernel.service.ServiceContext
						serviceContext)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _transportEventLocalService.addTransportEvent(
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
	@Override
	public
		com.github.lgdd.liferay.commerce.transport.events.model.TransportEvent
			addTransportEvent(
				com.github.lgdd.liferay.commerce.transport.events.model.
					TransportEvent transportEvent) {

		return _transportEventLocalService.addTransportEvent(transportEvent);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _transportEventLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new transport event with the primary key. Does not add the transport event to the database.
	 *
	 * @param transportEventId the primary key for the new transport event
	 * @return the new transport event
	 */
	@Override
	public
		com.github.lgdd.liferay.commerce.transport.events.model.TransportEvent
			createTransportEvent(long transportEventId) {

		return _transportEventLocalService.createTransportEvent(
			transportEventId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _transportEventLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public
		com.github.lgdd.liferay.commerce.transport.events.model.TransportEvent
				deleteTransportEvent(long transportEventId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _transportEventLocalService.deleteTransportEvent(
			transportEventId);
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
	@Override
	public
		com.github.lgdd.liferay.commerce.transport.events.model.TransportEvent
			deleteTransportEvent(
				com.github.lgdd.liferay.commerce.transport.events.model.
					TransportEvent transportEvent) {

		return _transportEventLocalService.deleteTransportEvent(transportEvent);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _transportEventLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _transportEventLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _transportEventLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _transportEventLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _transportEventLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _transportEventLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _transportEventLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _transportEventLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public
		com.github.lgdd.liferay.commerce.transport.events.model.TransportEvent
			fetchTransportEvent(long transportEventId) {

		return _transportEventLocalService.fetchTransportEvent(
			transportEventId);
	}

	/**
	 * Returns the transport event matching the UUID and group.
	 *
	 * @param uuid the transport event's UUID
	 * @param groupId the primary key of the group
	 * @return the matching transport event, or <code>null</code> if a matching transport event could not be found
	 */
	@Override
	public
		com.github.lgdd.liferay.commerce.transport.events.model.TransportEvent
			fetchTransportEventByUuidAndGroupId(String uuid, long groupId) {

		return _transportEventLocalService.fetchTransportEventByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _transportEventLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _transportEventLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _transportEventLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _transportEventLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _transportEventLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the transport event with the primary key.
	 *
	 * @param transportEventId the primary key of the transport event
	 * @return the transport event
	 * @throws PortalException if a transport event with the primary key could not be found
	 */
	@Override
	public
		com.github.lgdd.liferay.commerce.transport.events.model.TransportEvent
				getTransportEvent(long transportEventId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _transportEventLocalService.getTransportEvent(transportEventId);
	}

	/**
	 * Returns the transport event matching the UUID and group.
	 *
	 * @param uuid the transport event's UUID
	 * @param groupId the primary key of the group
	 * @return the matching transport event
	 * @throws PortalException if a matching transport event could not be found
	 */
	@Override
	public
		com.github.lgdd.liferay.commerce.transport.events.model.TransportEvent
				getTransportEventByUuidAndGroupId(String uuid, long groupId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _transportEventLocalService.getTransportEventByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List
		<com.github.lgdd.liferay.commerce.transport.events.model.TransportEvent>
			getTransportEvents(int start, int end) {

		return _transportEventLocalService.getTransportEvents(start, end);
	}

	@Override
	public java.util.List
		<com.github.lgdd.liferay.commerce.transport.events.model.TransportEvent>
			getTransportEventsByCommerceShipmentId(long commerceShipmentId) {

		return _transportEventLocalService.
			getTransportEventsByCommerceShipmentId(commerceShipmentId);
	}

	/**
	 * Returns all the transport events matching the UUID and company.
	 *
	 * @param uuid the UUID of the transport events
	 * @param companyId the primary key of the company
	 * @return the matching transport events, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.github.lgdd.liferay.commerce.transport.events.model.TransportEvent>
			getTransportEventsByUuidAndCompanyId(String uuid, long companyId) {

		return _transportEventLocalService.getTransportEventsByUuidAndCompanyId(
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
	@Override
	public java.util.List
		<com.github.lgdd.liferay.commerce.transport.events.model.TransportEvent>
			getTransportEventsByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.github.lgdd.liferay.commerce.transport.events.model.
						TransportEvent> orderByComparator) {

		return _transportEventLocalService.getTransportEventsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of transport events.
	 *
	 * @return the number of transport events
	 */
	@Override
	public int getTransportEventsCount() {
		return _transportEventLocalService.getTransportEventsCount();
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
	@Override
	public
		com.github.lgdd.liferay.commerce.transport.events.model.TransportEvent
			updateTransportEvent(
				com.github.lgdd.liferay.commerce.transport.events.model.
					TransportEvent transportEvent) {

		return _transportEventLocalService.updateTransportEvent(transportEvent);
	}

	@Override
	public TransportEventLocalService getWrappedService() {
		return _transportEventLocalService;
	}

	@Override
	public void setWrappedService(
		TransportEventLocalService transportEventLocalService) {

		_transportEventLocalService = transportEventLocalService;
	}

	private TransportEventLocalService _transportEventLocalService;

}