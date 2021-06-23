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

package com.github.lgdd.liferay.commerce.transport.events.service.persistence;

import com.github.lgdd.liferay.commerce.transport.events.model.TransportEvent;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the transport event service. This utility wraps <code>com.github.lgdd.liferay.commerce.transport.events.service.persistence.impl.TransportEventPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TransportEventPersistence
 * @generated
 */
public class TransportEventUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(TransportEvent transportEvent) {
		getPersistence().clearCache(transportEvent);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, TransportEvent> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TransportEvent> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TransportEvent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TransportEvent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TransportEvent> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TransportEvent update(TransportEvent transportEvent) {
		return getPersistence().update(transportEvent);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TransportEvent update(
		TransportEvent transportEvent, ServiceContext serviceContext) {

		return getPersistence().update(transportEvent, serviceContext);
	}

	/**
	 * Returns all the transport events where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching transport events
	 */
	public static List<TransportEvent> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the transport events where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TransportEventModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of transport events
	 * @param end the upper bound of the range of transport events (not inclusive)
	 * @return the range of matching transport events
	 */
	public static List<TransportEvent> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the transport events where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TransportEventModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of transport events
	 * @param end the upper bound of the range of transport events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching transport events
	 */
	public static List<TransportEvent> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TransportEvent> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the transport events where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TransportEventModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of transport events
	 * @param end the upper bound of the range of transport events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching transport events
	 */
	public static List<TransportEvent> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TransportEvent> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first transport event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transport event
	 * @throws NoSuchTransportEventException if a matching transport event could not be found
	 */
	public static TransportEvent findByUuid_First(
			String uuid, OrderByComparator<TransportEvent> orderByComparator)
		throws com.github.lgdd.liferay.commerce.transport.events.exception.
			NoSuchTransportEventException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first transport event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transport event, or <code>null</code> if a matching transport event could not be found
	 */
	public static TransportEvent fetchByUuid_First(
		String uuid, OrderByComparator<TransportEvent> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last transport event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transport event
	 * @throws NoSuchTransportEventException if a matching transport event could not be found
	 */
	public static TransportEvent findByUuid_Last(
			String uuid, OrderByComparator<TransportEvent> orderByComparator)
		throws com.github.lgdd.liferay.commerce.transport.events.exception.
			NoSuchTransportEventException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last transport event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transport event, or <code>null</code> if a matching transport event could not be found
	 */
	public static TransportEvent fetchByUuid_Last(
		String uuid, OrderByComparator<TransportEvent> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the transport events before and after the current transport event in the ordered set where uuid = &#63;.
	 *
	 * @param transportEventId the primary key of the current transport event
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next transport event
	 * @throws NoSuchTransportEventException if a transport event with the primary key could not be found
	 */
	public static TransportEvent[] findByUuid_PrevAndNext(
			long transportEventId, String uuid,
			OrderByComparator<TransportEvent> orderByComparator)
		throws com.github.lgdd.liferay.commerce.transport.events.exception.
			NoSuchTransportEventException {

		return getPersistence().findByUuid_PrevAndNext(
			transportEventId, uuid, orderByComparator);
	}

	/**
	 * Removes all the transport events where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of transport events where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching transport events
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the transport event where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTransportEventException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching transport event
	 * @throws NoSuchTransportEventException if a matching transport event could not be found
	 */
	public static TransportEvent findByUUID_G(String uuid, long groupId)
		throws com.github.lgdd.liferay.commerce.transport.events.exception.
			NoSuchTransportEventException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the transport event where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching transport event, or <code>null</code> if a matching transport event could not be found
	 */
	public static TransportEvent fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the transport event where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching transport event, or <code>null</code> if a matching transport event could not be found
	 */
	public static TransportEvent fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the transport event where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the transport event that was removed
	 */
	public static TransportEvent removeByUUID_G(String uuid, long groupId)
		throws com.github.lgdd.liferay.commerce.transport.events.exception.
			NoSuchTransportEventException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of transport events where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching transport events
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the transport events where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching transport events
	 */
	public static List<TransportEvent> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the transport events where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TransportEventModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of transport events
	 * @param end the upper bound of the range of transport events (not inclusive)
	 * @return the range of matching transport events
	 */
	public static List<TransportEvent> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the transport events where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TransportEventModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of transport events
	 * @param end the upper bound of the range of transport events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching transport events
	 */
	public static List<TransportEvent> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TransportEvent> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the transport events where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TransportEventModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of transport events
	 * @param end the upper bound of the range of transport events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching transport events
	 */
	public static List<TransportEvent> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TransportEvent> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first transport event in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transport event
	 * @throws NoSuchTransportEventException if a matching transport event could not be found
	 */
	public static TransportEvent findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TransportEvent> orderByComparator)
		throws com.github.lgdd.liferay.commerce.transport.events.exception.
			NoSuchTransportEventException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first transport event in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transport event, or <code>null</code> if a matching transport event could not be found
	 */
	public static TransportEvent fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TransportEvent> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last transport event in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transport event
	 * @throws NoSuchTransportEventException if a matching transport event could not be found
	 */
	public static TransportEvent findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TransportEvent> orderByComparator)
		throws com.github.lgdd.liferay.commerce.transport.events.exception.
			NoSuchTransportEventException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last transport event in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transport event, or <code>null</code> if a matching transport event could not be found
	 */
	public static TransportEvent fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TransportEvent> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the transport events before and after the current transport event in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param transportEventId the primary key of the current transport event
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next transport event
	 * @throws NoSuchTransportEventException if a transport event with the primary key could not be found
	 */
	public static TransportEvent[] findByUuid_C_PrevAndNext(
			long transportEventId, String uuid, long companyId,
			OrderByComparator<TransportEvent> orderByComparator)
		throws com.github.lgdd.liferay.commerce.transport.events.exception.
			NoSuchTransportEventException {

		return getPersistence().findByUuid_C_PrevAndNext(
			transportEventId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the transport events where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of transport events where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching transport events
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the transport events where commerceShipmentId = &#63;.
	 *
	 * @param commerceShipmentId the commerce shipment ID
	 * @return the matching transport events
	 */
	public static List<TransportEvent> findByCommerceShipmentId(
		long commerceShipmentId) {

		return getPersistence().findByCommerceShipmentId(commerceShipmentId);
	}

	/**
	 * Returns a range of all the transport events where commerceShipmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TransportEventModelImpl</code>.
	 * </p>
	 *
	 * @param commerceShipmentId the commerce shipment ID
	 * @param start the lower bound of the range of transport events
	 * @param end the upper bound of the range of transport events (not inclusive)
	 * @return the range of matching transport events
	 */
	public static List<TransportEvent> findByCommerceShipmentId(
		long commerceShipmentId, int start, int end) {

		return getPersistence().findByCommerceShipmentId(
			commerceShipmentId, start, end);
	}

	/**
	 * Returns an ordered range of all the transport events where commerceShipmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TransportEventModelImpl</code>.
	 * </p>
	 *
	 * @param commerceShipmentId the commerce shipment ID
	 * @param start the lower bound of the range of transport events
	 * @param end the upper bound of the range of transport events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching transport events
	 */
	public static List<TransportEvent> findByCommerceShipmentId(
		long commerceShipmentId, int start, int end,
		OrderByComparator<TransportEvent> orderByComparator) {

		return getPersistence().findByCommerceShipmentId(
			commerceShipmentId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the transport events where commerceShipmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TransportEventModelImpl</code>.
	 * </p>
	 *
	 * @param commerceShipmentId the commerce shipment ID
	 * @param start the lower bound of the range of transport events
	 * @param end the upper bound of the range of transport events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching transport events
	 */
	public static List<TransportEvent> findByCommerceShipmentId(
		long commerceShipmentId, int start, int end,
		OrderByComparator<TransportEvent> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCommerceShipmentId(
			commerceShipmentId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first transport event in the ordered set where commerceShipmentId = &#63;.
	 *
	 * @param commerceShipmentId the commerce shipment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transport event
	 * @throws NoSuchTransportEventException if a matching transport event could not be found
	 */
	public static TransportEvent findByCommerceShipmentId_First(
			long commerceShipmentId,
			OrderByComparator<TransportEvent> orderByComparator)
		throws com.github.lgdd.liferay.commerce.transport.events.exception.
			NoSuchTransportEventException {

		return getPersistence().findByCommerceShipmentId_First(
			commerceShipmentId, orderByComparator);
	}

	/**
	 * Returns the first transport event in the ordered set where commerceShipmentId = &#63;.
	 *
	 * @param commerceShipmentId the commerce shipment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transport event, or <code>null</code> if a matching transport event could not be found
	 */
	public static TransportEvent fetchByCommerceShipmentId_First(
		long commerceShipmentId,
		OrderByComparator<TransportEvent> orderByComparator) {

		return getPersistence().fetchByCommerceShipmentId_First(
			commerceShipmentId, orderByComparator);
	}

	/**
	 * Returns the last transport event in the ordered set where commerceShipmentId = &#63;.
	 *
	 * @param commerceShipmentId the commerce shipment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transport event
	 * @throws NoSuchTransportEventException if a matching transport event could not be found
	 */
	public static TransportEvent findByCommerceShipmentId_Last(
			long commerceShipmentId,
			OrderByComparator<TransportEvent> orderByComparator)
		throws com.github.lgdd.liferay.commerce.transport.events.exception.
			NoSuchTransportEventException {

		return getPersistence().findByCommerceShipmentId_Last(
			commerceShipmentId, orderByComparator);
	}

	/**
	 * Returns the last transport event in the ordered set where commerceShipmentId = &#63;.
	 *
	 * @param commerceShipmentId the commerce shipment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transport event, or <code>null</code> if a matching transport event could not be found
	 */
	public static TransportEvent fetchByCommerceShipmentId_Last(
		long commerceShipmentId,
		OrderByComparator<TransportEvent> orderByComparator) {

		return getPersistence().fetchByCommerceShipmentId_Last(
			commerceShipmentId, orderByComparator);
	}

	/**
	 * Returns the transport events before and after the current transport event in the ordered set where commerceShipmentId = &#63;.
	 *
	 * @param transportEventId the primary key of the current transport event
	 * @param commerceShipmentId the commerce shipment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next transport event
	 * @throws NoSuchTransportEventException if a transport event with the primary key could not be found
	 */
	public static TransportEvent[] findByCommerceShipmentId_PrevAndNext(
			long transportEventId, long commerceShipmentId,
			OrderByComparator<TransportEvent> orderByComparator)
		throws com.github.lgdd.liferay.commerce.transport.events.exception.
			NoSuchTransportEventException {

		return getPersistence().findByCommerceShipmentId_PrevAndNext(
			transportEventId, commerceShipmentId, orderByComparator);
	}

	/**
	 * Removes all the transport events where commerceShipmentId = &#63; from the database.
	 *
	 * @param commerceShipmentId the commerce shipment ID
	 */
	public static void removeByCommerceShipmentId(long commerceShipmentId) {
		getPersistence().removeByCommerceShipmentId(commerceShipmentId);
	}

	/**
	 * Returns the number of transport events where commerceShipmentId = &#63;.
	 *
	 * @param commerceShipmentId the commerce shipment ID
	 * @return the number of matching transport events
	 */
	public static int countByCommerceShipmentId(long commerceShipmentId) {
		return getPersistence().countByCommerceShipmentId(commerceShipmentId);
	}

	/**
	 * Returns all the transport events where trackingNumber = &#63;.
	 *
	 * @param trackingNumber the tracking number
	 * @return the matching transport events
	 */
	public static List<TransportEvent> findByTrackingNumber(
		String trackingNumber) {

		return getPersistence().findByTrackingNumber(trackingNumber);
	}

	/**
	 * Returns a range of all the transport events where trackingNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TransportEventModelImpl</code>.
	 * </p>
	 *
	 * @param trackingNumber the tracking number
	 * @param start the lower bound of the range of transport events
	 * @param end the upper bound of the range of transport events (not inclusive)
	 * @return the range of matching transport events
	 */
	public static List<TransportEvent> findByTrackingNumber(
		String trackingNumber, int start, int end) {

		return getPersistence().findByTrackingNumber(
			trackingNumber, start, end);
	}

	/**
	 * Returns an ordered range of all the transport events where trackingNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TransportEventModelImpl</code>.
	 * </p>
	 *
	 * @param trackingNumber the tracking number
	 * @param start the lower bound of the range of transport events
	 * @param end the upper bound of the range of transport events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching transport events
	 */
	public static List<TransportEvent> findByTrackingNumber(
		String trackingNumber, int start, int end,
		OrderByComparator<TransportEvent> orderByComparator) {

		return getPersistence().findByTrackingNumber(
			trackingNumber, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the transport events where trackingNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TransportEventModelImpl</code>.
	 * </p>
	 *
	 * @param trackingNumber the tracking number
	 * @param start the lower bound of the range of transport events
	 * @param end the upper bound of the range of transport events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching transport events
	 */
	public static List<TransportEvent> findByTrackingNumber(
		String trackingNumber, int start, int end,
		OrderByComparator<TransportEvent> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTrackingNumber(
			trackingNumber, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first transport event in the ordered set where trackingNumber = &#63;.
	 *
	 * @param trackingNumber the tracking number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transport event
	 * @throws NoSuchTransportEventException if a matching transport event could not be found
	 */
	public static TransportEvent findByTrackingNumber_First(
			String trackingNumber,
			OrderByComparator<TransportEvent> orderByComparator)
		throws com.github.lgdd.liferay.commerce.transport.events.exception.
			NoSuchTransportEventException {

		return getPersistence().findByTrackingNumber_First(
			trackingNumber, orderByComparator);
	}

	/**
	 * Returns the first transport event in the ordered set where trackingNumber = &#63;.
	 *
	 * @param trackingNumber the tracking number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transport event, or <code>null</code> if a matching transport event could not be found
	 */
	public static TransportEvent fetchByTrackingNumber_First(
		String trackingNumber,
		OrderByComparator<TransportEvent> orderByComparator) {

		return getPersistence().fetchByTrackingNumber_First(
			trackingNumber, orderByComparator);
	}

	/**
	 * Returns the last transport event in the ordered set where trackingNumber = &#63;.
	 *
	 * @param trackingNumber the tracking number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transport event
	 * @throws NoSuchTransportEventException if a matching transport event could not be found
	 */
	public static TransportEvent findByTrackingNumber_Last(
			String trackingNumber,
			OrderByComparator<TransportEvent> orderByComparator)
		throws com.github.lgdd.liferay.commerce.transport.events.exception.
			NoSuchTransportEventException {

		return getPersistence().findByTrackingNumber_Last(
			trackingNumber, orderByComparator);
	}

	/**
	 * Returns the last transport event in the ordered set where trackingNumber = &#63;.
	 *
	 * @param trackingNumber the tracking number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transport event, or <code>null</code> if a matching transport event could not be found
	 */
	public static TransportEvent fetchByTrackingNumber_Last(
		String trackingNumber,
		OrderByComparator<TransportEvent> orderByComparator) {

		return getPersistence().fetchByTrackingNumber_Last(
			trackingNumber, orderByComparator);
	}

	/**
	 * Returns the transport events before and after the current transport event in the ordered set where trackingNumber = &#63;.
	 *
	 * @param transportEventId the primary key of the current transport event
	 * @param trackingNumber the tracking number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next transport event
	 * @throws NoSuchTransportEventException if a transport event with the primary key could not be found
	 */
	public static TransportEvent[] findByTrackingNumber_PrevAndNext(
			long transportEventId, String trackingNumber,
			OrderByComparator<TransportEvent> orderByComparator)
		throws com.github.lgdd.liferay.commerce.transport.events.exception.
			NoSuchTransportEventException {

		return getPersistence().findByTrackingNumber_PrevAndNext(
			transportEventId, trackingNumber, orderByComparator);
	}

	/**
	 * Removes all the transport events where trackingNumber = &#63; from the database.
	 *
	 * @param trackingNumber the tracking number
	 */
	public static void removeByTrackingNumber(String trackingNumber) {
		getPersistence().removeByTrackingNumber(trackingNumber);
	}

	/**
	 * Returns the number of transport events where trackingNumber = &#63;.
	 *
	 * @param trackingNumber the tracking number
	 * @return the number of matching transport events
	 */
	public static int countByTrackingNumber(String trackingNumber) {
		return getPersistence().countByTrackingNumber(trackingNumber);
	}

	/**
	 * Returns all the transport events where carrier = &#63;.
	 *
	 * @param carrier the carrier
	 * @return the matching transport events
	 */
	public static List<TransportEvent> findByCarrier(String carrier) {
		return getPersistence().findByCarrier(carrier);
	}

	/**
	 * Returns a range of all the transport events where carrier = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TransportEventModelImpl</code>.
	 * </p>
	 *
	 * @param carrier the carrier
	 * @param start the lower bound of the range of transport events
	 * @param end the upper bound of the range of transport events (not inclusive)
	 * @return the range of matching transport events
	 */
	public static List<TransportEvent> findByCarrier(
		String carrier, int start, int end) {

		return getPersistence().findByCarrier(carrier, start, end);
	}

	/**
	 * Returns an ordered range of all the transport events where carrier = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TransportEventModelImpl</code>.
	 * </p>
	 *
	 * @param carrier the carrier
	 * @param start the lower bound of the range of transport events
	 * @param end the upper bound of the range of transport events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching transport events
	 */
	public static List<TransportEvent> findByCarrier(
		String carrier, int start, int end,
		OrderByComparator<TransportEvent> orderByComparator) {

		return getPersistence().findByCarrier(
			carrier, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the transport events where carrier = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TransportEventModelImpl</code>.
	 * </p>
	 *
	 * @param carrier the carrier
	 * @param start the lower bound of the range of transport events
	 * @param end the upper bound of the range of transport events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching transport events
	 */
	public static List<TransportEvent> findByCarrier(
		String carrier, int start, int end,
		OrderByComparator<TransportEvent> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCarrier(
			carrier, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first transport event in the ordered set where carrier = &#63;.
	 *
	 * @param carrier the carrier
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transport event
	 * @throws NoSuchTransportEventException if a matching transport event could not be found
	 */
	public static TransportEvent findByCarrier_First(
			String carrier, OrderByComparator<TransportEvent> orderByComparator)
		throws com.github.lgdd.liferay.commerce.transport.events.exception.
			NoSuchTransportEventException {

		return getPersistence().findByCarrier_First(carrier, orderByComparator);
	}

	/**
	 * Returns the first transport event in the ordered set where carrier = &#63;.
	 *
	 * @param carrier the carrier
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transport event, or <code>null</code> if a matching transport event could not be found
	 */
	public static TransportEvent fetchByCarrier_First(
		String carrier, OrderByComparator<TransportEvent> orderByComparator) {

		return getPersistence().fetchByCarrier_First(
			carrier, orderByComparator);
	}

	/**
	 * Returns the last transport event in the ordered set where carrier = &#63;.
	 *
	 * @param carrier the carrier
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transport event
	 * @throws NoSuchTransportEventException if a matching transport event could not be found
	 */
	public static TransportEvent findByCarrier_Last(
			String carrier, OrderByComparator<TransportEvent> orderByComparator)
		throws com.github.lgdd.liferay.commerce.transport.events.exception.
			NoSuchTransportEventException {

		return getPersistence().findByCarrier_Last(carrier, orderByComparator);
	}

	/**
	 * Returns the last transport event in the ordered set where carrier = &#63;.
	 *
	 * @param carrier the carrier
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transport event, or <code>null</code> if a matching transport event could not be found
	 */
	public static TransportEvent fetchByCarrier_Last(
		String carrier, OrderByComparator<TransportEvent> orderByComparator) {

		return getPersistence().fetchByCarrier_Last(carrier, orderByComparator);
	}

	/**
	 * Returns the transport events before and after the current transport event in the ordered set where carrier = &#63;.
	 *
	 * @param transportEventId the primary key of the current transport event
	 * @param carrier the carrier
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next transport event
	 * @throws NoSuchTransportEventException if a transport event with the primary key could not be found
	 */
	public static TransportEvent[] findByCarrier_PrevAndNext(
			long transportEventId, String carrier,
			OrderByComparator<TransportEvent> orderByComparator)
		throws com.github.lgdd.liferay.commerce.transport.events.exception.
			NoSuchTransportEventException {

		return getPersistence().findByCarrier_PrevAndNext(
			transportEventId, carrier, orderByComparator);
	}

	/**
	 * Removes all the transport events where carrier = &#63; from the database.
	 *
	 * @param carrier the carrier
	 */
	public static void removeByCarrier(String carrier) {
		getPersistence().removeByCarrier(carrier);
	}

	/**
	 * Returns the number of transport events where carrier = &#63;.
	 *
	 * @param carrier the carrier
	 * @return the number of matching transport events
	 */
	public static int countByCarrier(String carrier) {
		return getPersistence().countByCarrier(carrier);
	}

	/**
	 * Caches the transport event in the entity cache if it is enabled.
	 *
	 * @param transportEvent the transport event
	 */
	public static void cacheResult(TransportEvent transportEvent) {
		getPersistence().cacheResult(transportEvent);
	}

	/**
	 * Caches the transport events in the entity cache if it is enabled.
	 *
	 * @param transportEvents the transport events
	 */
	public static void cacheResult(List<TransportEvent> transportEvents) {
		getPersistence().cacheResult(transportEvents);
	}

	/**
	 * Creates a new transport event with the primary key. Does not add the transport event to the database.
	 *
	 * @param transportEventId the primary key for the new transport event
	 * @return the new transport event
	 */
	public static TransportEvent create(long transportEventId) {
		return getPersistence().create(transportEventId);
	}

	/**
	 * Removes the transport event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param transportEventId the primary key of the transport event
	 * @return the transport event that was removed
	 * @throws NoSuchTransportEventException if a transport event with the primary key could not be found
	 */
	public static TransportEvent remove(long transportEventId)
		throws com.github.lgdd.liferay.commerce.transport.events.exception.
			NoSuchTransportEventException {

		return getPersistence().remove(transportEventId);
	}

	public static TransportEvent updateImpl(TransportEvent transportEvent) {
		return getPersistence().updateImpl(transportEvent);
	}

	/**
	 * Returns the transport event with the primary key or throws a <code>NoSuchTransportEventException</code> if it could not be found.
	 *
	 * @param transportEventId the primary key of the transport event
	 * @return the transport event
	 * @throws NoSuchTransportEventException if a transport event with the primary key could not be found
	 */
	public static TransportEvent findByPrimaryKey(long transportEventId)
		throws com.github.lgdd.liferay.commerce.transport.events.exception.
			NoSuchTransportEventException {

		return getPersistence().findByPrimaryKey(transportEventId);
	}

	/**
	 * Returns the transport event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param transportEventId the primary key of the transport event
	 * @return the transport event, or <code>null</code> if a transport event with the primary key could not be found
	 */
	public static TransportEvent fetchByPrimaryKey(long transportEventId) {
		return getPersistence().fetchByPrimaryKey(transportEventId);
	}

	/**
	 * Returns all the transport events.
	 *
	 * @return the transport events
	 */
	public static List<TransportEvent> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the transport events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TransportEventModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of transport events
	 * @param end the upper bound of the range of transport events (not inclusive)
	 * @return the range of transport events
	 */
	public static List<TransportEvent> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the transport events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TransportEventModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of transport events
	 * @param end the upper bound of the range of transport events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of transport events
	 */
	public static List<TransportEvent> findAll(
		int start, int end,
		OrderByComparator<TransportEvent> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the transport events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TransportEventModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of transport events
	 * @param end the upper bound of the range of transport events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of transport events
	 */
	public static List<TransportEvent> findAll(
		int start, int end, OrderByComparator<TransportEvent> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the transport events from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of transport events.
	 *
	 * @return the number of transport events
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TransportEventPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TransportEventPersistence, TransportEventPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			TransportEventPersistence.class);

		ServiceTracker<TransportEventPersistence, TransportEventPersistence>
			serviceTracker =
				new ServiceTracker
					<TransportEventPersistence, TransportEventPersistence>(
						bundle.getBundleContext(),
						TransportEventPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}