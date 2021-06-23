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

import com.github.lgdd.liferay.commerce.transport.events.exception.NoSuchTransportEventException;
import com.github.lgdd.liferay.commerce.transport.events.model.TransportEvent;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the transport event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TransportEventUtil
 * @generated
 */
@ProviderType
public interface TransportEventPersistence
	extends BasePersistence<TransportEvent> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TransportEventUtil} to access the transport event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the transport events where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching transport events
	 */
	public java.util.List<TransportEvent> findByUuid(String uuid);

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
	public java.util.List<TransportEvent> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<TransportEvent> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TransportEvent>
			orderByComparator);

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
	public java.util.List<TransportEvent> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TransportEvent>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first transport event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transport event
	 * @throws NoSuchTransportEventException if a matching transport event could not be found
	 */
	public TransportEvent findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TransportEvent>
				orderByComparator)
		throws NoSuchTransportEventException;

	/**
	 * Returns the first transport event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transport event, or <code>null</code> if a matching transport event could not be found
	 */
	public TransportEvent fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TransportEvent>
			orderByComparator);

	/**
	 * Returns the last transport event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transport event
	 * @throws NoSuchTransportEventException if a matching transport event could not be found
	 */
	public TransportEvent findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TransportEvent>
				orderByComparator)
		throws NoSuchTransportEventException;

	/**
	 * Returns the last transport event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transport event, or <code>null</code> if a matching transport event could not be found
	 */
	public TransportEvent fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TransportEvent>
			orderByComparator);

	/**
	 * Returns the transport events before and after the current transport event in the ordered set where uuid = &#63;.
	 *
	 * @param transportEventId the primary key of the current transport event
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next transport event
	 * @throws NoSuchTransportEventException if a transport event with the primary key could not be found
	 */
	public TransportEvent[] findByUuid_PrevAndNext(
			long transportEventId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TransportEvent>
				orderByComparator)
		throws NoSuchTransportEventException;

	/**
	 * Removes all the transport events where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of transport events where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching transport events
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the transport event where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTransportEventException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching transport event
	 * @throws NoSuchTransportEventException if a matching transport event could not be found
	 */
	public TransportEvent findByUUID_G(String uuid, long groupId)
		throws NoSuchTransportEventException;

	/**
	 * Returns the transport event where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching transport event, or <code>null</code> if a matching transport event could not be found
	 */
	public TransportEvent fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the transport event where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching transport event, or <code>null</code> if a matching transport event could not be found
	 */
	public TransportEvent fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the transport event where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the transport event that was removed
	 */
	public TransportEvent removeByUUID_G(String uuid, long groupId)
		throws NoSuchTransportEventException;

	/**
	 * Returns the number of transport events where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching transport events
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the transport events where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching transport events
	 */
	public java.util.List<TransportEvent> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<TransportEvent> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<TransportEvent> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TransportEvent>
			orderByComparator);

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
	public java.util.List<TransportEvent> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TransportEvent>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first transport event in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transport event
	 * @throws NoSuchTransportEventException if a matching transport event could not be found
	 */
	public TransportEvent findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TransportEvent>
				orderByComparator)
		throws NoSuchTransportEventException;

	/**
	 * Returns the first transport event in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transport event, or <code>null</code> if a matching transport event could not be found
	 */
	public TransportEvent fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TransportEvent>
			orderByComparator);

	/**
	 * Returns the last transport event in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transport event
	 * @throws NoSuchTransportEventException if a matching transport event could not be found
	 */
	public TransportEvent findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TransportEvent>
				orderByComparator)
		throws NoSuchTransportEventException;

	/**
	 * Returns the last transport event in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transport event, or <code>null</code> if a matching transport event could not be found
	 */
	public TransportEvent fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TransportEvent>
			orderByComparator);

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
	public TransportEvent[] findByUuid_C_PrevAndNext(
			long transportEventId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TransportEvent>
				orderByComparator)
		throws NoSuchTransportEventException;

	/**
	 * Removes all the transport events where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of transport events where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching transport events
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the transport events where commerceShipmentId = &#63;.
	 *
	 * @param commerceShipmentId the commerce shipment ID
	 * @return the matching transport events
	 */
	public java.util.List<TransportEvent> findByCommerceShipmentId(
		long commerceShipmentId);

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
	public java.util.List<TransportEvent> findByCommerceShipmentId(
		long commerceShipmentId, int start, int end);

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
	public java.util.List<TransportEvent> findByCommerceShipmentId(
		long commerceShipmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TransportEvent>
			orderByComparator);

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
	public java.util.List<TransportEvent> findByCommerceShipmentId(
		long commerceShipmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TransportEvent>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first transport event in the ordered set where commerceShipmentId = &#63;.
	 *
	 * @param commerceShipmentId the commerce shipment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transport event
	 * @throws NoSuchTransportEventException if a matching transport event could not be found
	 */
	public TransportEvent findByCommerceShipmentId_First(
			long commerceShipmentId,
			com.liferay.portal.kernel.util.OrderByComparator<TransportEvent>
				orderByComparator)
		throws NoSuchTransportEventException;

	/**
	 * Returns the first transport event in the ordered set where commerceShipmentId = &#63;.
	 *
	 * @param commerceShipmentId the commerce shipment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transport event, or <code>null</code> if a matching transport event could not be found
	 */
	public TransportEvent fetchByCommerceShipmentId_First(
		long commerceShipmentId,
		com.liferay.portal.kernel.util.OrderByComparator<TransportEvent>
			orderByComparator);

	/**
	 * Returns the last transport event in the ordered set where commerceShipmentId = &#63;.
	 *
	 * @param commerceShipmentId the commerce shipment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transport event
	 * @throws NoSuchTransportEventException if a matching transport event could not be found
	 */
	public TransportEvent findByCommerceShipmentId_Last(
			long commerceShipmentId,
			com.liferay.portal.kernel.util.OrderByComparator<TransportEvent>
				orderByComparator)
		throws NoSuchTransportEventException;

	/**
	 * Returns the last transport event in the ordered set where commerceShipmentId = &#63;.
	 *
	 * @param commerceShipmentId the commerce shipment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transport event, or <code>null</code> if a matching transport event could not be found
	 */
	public TransportEvent fetchByCommerceShipmentId_Last(
		long commerceShipmentId,
		com.liferay.portal.kernel.util.OrderByComparator<TransportEvent>
			orderByComparator);

	/**
	 * Returns the transport events before and after the current transport event in the ordered set where commerceShipmentId = &#63;.
	 *
	 * @param transportEventId the primary key of the current transport event
	 * @param commerceShipmentId the commerce shipment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next transport event
	 * @throws NoSuchTransportEventException if a transport event with the primary key could not be found
	 */
	public TransportEvent[] findByCommerceShipmentId_PrevAndNext(
			long transportEventId, long commerceShipmentId,
			com.liferay.portal.kernel.util.OrderByComparator<TransportEvent>
				orderByComparator)
		throws NoSuchTransportEventException;

	/**
	 * Removes all the transport events where commerceShipmentId = &#63; from the database.
	 *
	 * @param commerceShipmentId the commerce shipment ID
	 */
	public void removeByCommerceShipmentId(long commerceShipmentId);

	/**
	 * Returns the number of transport events where commerceShipmentId = &#63;.
	 *
	 * @param commerceShipmentId the commerce shipment ID
	 * @return the number of matching transport events
	 */
	public int countByCommerceShipmentId(long commerceShipmentId);

	/**
	 * Returns all the transport events where trackingNumber = &#63;.
	 *
	 * @param trackingNumber the tracking number
	 * @return the matching transport events
	 */
	public java.util.List<TransportEvent> findByTrackingNumber(
		String trackingNumber);

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
	public java.util.List<TransportEvent> findByTrackingNumber(
		String trackingNumber, int start, int end);

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
	public java.util.List<TransportEvent> findByTrackingNumber(
		String trackingNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TransportEvent>
			orderByComparator);

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
	public java.util.List<TransportEvent> findByTrackingNumber(
		String trackingNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TransportEvent>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first transport event in the ordered set where trackingNumber = &#63;.
	 *
	 * @param trackingNumber the tracking number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transport event
	 * @throws NoSuchTransportEventException if a matching transport event could not be found
	 */
	public TransportEvent findByTrackingNumber_First(
			String trackingNumber,
			com.liferay.portal.kernel.util.OrderByComparator<TransportEvent>
				orderByComparator)
		throws NoSuchTransportEventException;

	/**
	 * Returns the first transport event in the ordered set where trackingNumber = &#63;.
	 *
	 * @param trackingNumber the tracking number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transport event, or <code>null</code> if a matching transport event could not be found
	 */
	public TransportEvent fetchByTrackingNumber_First(
		String trackingNumber,
		com.liferay.portal.kernel.util.OrderByComparator<TransportEvent>
			orderByComparator);

	/**
	 * Returns the last transport event in the ordered set where trackingNumber = &#63;.
	 *
	 * @param trackingNumber the tracking number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transport event
	 * @throws NoSuchTransportEventException if a matching transport event could not be found
	 */
	public TransportEvent findByTrackingNumber_Last(
			String trackingNumber,
			com.liferay.portal.kernel.util.OrderByComparator<TransportEvent>
				orderByComparator)
		throws NoSuchTransportEventException;

	/**
	 * Returns the last transport event in the ordered set where trackingNumber = &#63;.
	 *
	 * @param trackingNumber the tracking number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transport event, or <code>null</code> if a matching transport event could not be found
	 */
	public TransportEvent fetchByTrackingNumber_Last(
		String trackingNumber,
		com.liferay.portal.kernel.util.OrderByComparator<TransportEvent>
			orderByComparator);

	/**
	 * Returns the transport events before and after the current transport event in the ordered set where trackingNumber = &#63;.
	 *
	 * @param transportEventId the primary key of the current transport event
	 * @param trackingNumber the tracking number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next transport event
	 * @throws NoSuchTransportEventException if a transport event with the primary key could not be found
	 */
	public TransportEvent[] findByTrackingNumber_PrevAndNext(
			long transportEventId, String trackingNumber,
			com.liferay.portal.kernel.util.OrderByComparator<TransportEvent>
				orderByComparator)
		throws NoSuchTransportEventException;

	/**
	 * Removes all the transport events where trackingNumber = &#63; from the database.
	 *
	 * @param trackingNumber the tracking number
	 */
	public void removeByTrackingNumber(String trackingNumber);

	/**
	 * Returns the number of transport events where trackingNumber = &#63;.
	 *
	 * @param trackingNumber the tracking number
	 * @return the number of matching transport events
	 */
	public int countByTrackingNumber(String trackingNumber);

	/**
	 * Returns all the transport events where carrier = &#63;.
	 *
	 * @param carrier the carrier
	 * @return the matching transport events
	 */
	public java.util.List<TransportEvent> findByCarrier(String carrier);

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
	public java.util.List<TransportEvent> findByCarrier(
		String carrier, int start, int end);

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
	public java.util.List<TransportEvent> findByCarrier(
		String carrier, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TransportEvent>
			orderByComparator);

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
	public java.util.List<TransportEvent> findByCarrier(
		String carrier, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TransportEvent>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first transport event in the ordered set where carrier = &#63;.
	 *
	 * @param carrier the carrier
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transport event
	 * @throws NoSuchTransportEventException if a matching transport event could not be found
	 */
	public TransportEvent findByCarrier_First(
			String carrier,
			com.liferay.portal.kernel.util.OrderByComparator<TransportEvent>
				orderByComparator)
		throws NoSuchTransportEventException;

	/**
	 * Returns the first transport event in the ordered set where carrier = &#63;.
	 *
	 * @param carrier the carrier
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transport event, or <code>null</code> if a matching transport event could not be found
	 */
	public TransportEvent fetchByCarrier_First(
		String carrier,
		com.liferay.portal.kernel.util.OrderByComparator<TransportEvent>
			orderByComparator);

	/**
	 * Returns the last transport event in the ordered set where carrier = &#63;.
	 *
	 * @param carrier the carrier
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transport event
	 * @throws NoSuchTransportEventException if a matching transport event could not be found
	 */
	public TransportEvent findByCarrier_Last(
			String carrier,
			com.liferay.portal.kernel.util.OrderByComparator<TransportEvent>
				orderByComparator)
		throws NoSuchTransportEventException;

	/**
	 * Returns the last transport event in the ordered set where carrier = &#63;.
	 *
	 * @param carrier the carrier
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transport event, or <code>null</code> if a matching transport event could not be found
	 */
	public TransportEvent fetchByCarrier_Last(
		String carrier,
		com.liferay.portal.kernel.util.OrderByComparator<TransportEvent>
			orderByComparator);

	/**
	 * Returns the transport events before and after the current transport event in the ordered set where carrier = &#63;.
	 *
	 * @param transportEventId the primary key of the current transport event
	 * @param carrier the carrier
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next transport event
	 * @throws NoSuchTransportEventException if a transport event with the primary key could not be found
	 */
	public TransportEvent[] findByCarrier_PrevAndNext(
			long transportEventId, String carrier,
			com.liferay.portal.kernel.util.OrderByComparator<TransportEvent>
				orderByComparator)
		throws NoSuchTransportEventException;

	/**
	 * Removes all the transport events where carrier = &#63; from the database.
	 *
	 * @param carrier the carrier
	 */
	public void removeByCarrier(String carrier);

	/**
	 * Returns the number of transport events where carrier = &#63;.
	 *
	 * @param carrier the carrier
	 * @return the number of matching transport events
	 */
	public int countByCarrier(String carrier);

	/**
	 * Caches the transport event in the entity cache if it is enabled.
	 *
	 * @param transportEvent the transport event
	 */
	public void cacheResult(TransportEvent transportEvent);

	/**
	 * Caches the transport events in the entity cache if it is enabled.
	 *
	 * @param transportEvents the transport events
	 */
	public void cacheResult(java.util.List<TransportEvent> transportEvents);

	/**
	 * Creates a new transport event with the primary key. Does not add the transport event to the database.
	 *
	 * @param transportEventId the primary key for the new transport event
	 * @return the new transport event
	 */
	public TransportEvent create(long transportEventId);

	/**
	 * Removes the transport event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param transportEventId the primary key of the transport event
	 * @return the transport event that was removed
	 * @throws NoSuchTransportEventException if a transport event with the primary key could not be found
	 */
	public TransportEvent remove(long transportEventId)
		throws NoSuchTransportEventException;

	public TransportEvent updateImpl(TransportEvent transportEvent);

	/**
	 * Returns the transport event with the primary key or throws a <code>NoSuchTransportEventException</code> if it could not be found.
	 *
	 * @param transportEventId the primary key of the transport event
	 * @return the transport event
	 * @throws NoSuchTransportEventException if a transport event with the primary key could not be found
	 */
	public TransportEvent findByPrimaryKey(long transportEventId)
		throws NoSuchTransportEventException;

	/**
	 * Returns the transport event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param transportEventId the primary key of the transport event
	 * @return the transport event, or <code>null</code> if a transport event with the primary key could not be found
	 */
	public TransportEvent fetchByPrimaryKey(long transportEventId);

	/**
	 * Returns all the transport events.
	 *
	 * @return the transport events
	 */
	public java.util.List<TransportEvent> findAll();

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
	public java.util.List<TransportEvent> findAll(int start, int end);

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
	public java.util.List<TransportEvent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TransportEvent>
			orderByComparator);

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
	public java.util.List<TransportEvent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TransportEvent>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the transport events from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of transport events.
	 *
	 * @return the number of transport events
	 */
	public int countAll();

}