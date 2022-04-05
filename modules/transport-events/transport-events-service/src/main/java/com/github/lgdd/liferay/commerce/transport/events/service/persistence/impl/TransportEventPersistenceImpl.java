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

package com.github.lgdd.liferay.commerce.transport.events.service.persistence.impl;

import com.github.lgdd.liferay.commerce.transport.events.exception.NoSuchTransportEventException;
import com.github.lgdd.liferay.commerce.transport.events.model.TransportEvent;
import com.github.lgdd.liferay.commerce.transport.events.model.TransportEventTable;
import com.github.lgdd.liferay.commerce.transport.events.model.impl.TransportEventImpl;
import com.github.lgdd.liferay.commerce.transport.events.model.impl.TransportEventModelImpl;
import com.github.lgdd.liferay.commerce.transport.events.service.persistence.TransportEventPersistence;
import com.github.lgdd.liferay.commerce.transport.events.service.persistence.TransportEventUtil;
import com.github.lgdd.liferay.commerce.transport.events.service.persistence.impl.constants.CommerceDemoPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the transport event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {TransportEventPersistence.class, BasePersistence.class})
public class TransportEventPersistenceImpl
	extends BasePersistenceImpl<TransportEvent>
	implements TransportEventPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TransportEventUtil</code> to access the transport event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TransportEventImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the transport events where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching transport events
	 */
	@Override
	public List<TransportEvent> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TransportEvent> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<TransportEvent> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TransportEvent> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<TransportEvent> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TransportEvent> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<TransportEvent> list = null;

		if (useFinderCache) {
			list = (List<TransportEvent>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TransportEvent transportEvent : list) {
					if (!uuid.equals(transportEvent.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_TRANSPORTEVENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TransportEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<TransportEvent>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first transport event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transport event
	 * @throws NoSuchTransportEventException if a matching transport event could not be found
	 */
	@Override
	public TransportEvent findByUuid_First(
			String uuid, OrderByComparator<TransportEvent> orderByComparator)
		throws NoSuchTransportEventException {

		TransportEvent transportEvent = fetchByUuid_First(
			uuid, orderByComparator);

		if (transportEvent != null) {
			return transportEvent;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTransportEventException(sb.toString());
	}

	/**
	 * Returns the first transport event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transport event, or <code>null</code> if a matching transport event could not be found
	 */
	@Override
	public TransportEvent fetchByUuid_First(
		String uuid, OrderByComparator<TransportEvent> orderByComparator) {

		List<TransportEvent> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last transport event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transport event
	 * @throws NoSuchTransportEventException if a matching transport event could not be found
	 */
	@Override
	public TransportEvent findByUuid_Last(
			String uuid, OrderByComparator<TransportEvent> orderByComparator)
		throws NoSuchTransportEventException {

		TransportEvent transportEvent = fetchByUuid_Last(
			uuid, orderByComparator);

		if (transportEvent != null) {
			return transportEvent;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTransportEventException(sb.toString());
	}

	/**
	 * Returns the last transport event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transport event, or <code>null</code> if a matching transport event could not be found
	 */
	@Override
	public TransportEvent fetchByUuid_Last(
		String uuid, OrderByComparator<TransportEvent> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<TransportEvent> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TransportEvent[] findByUuid_PrevAndNext(
			long transportEventId, String uuid,
			OrderByComparator<TransportEvent> orderByComparator)
		throws NoSuchTransportEventException {

		uuid = Objects.toString(uuid, "");

		TransportEvent transportEvent = findByPrimaryKey(transportEventId);

		Session session = null;

		try {
			session = openSession();

			TransportEvent[] array = new TransportEventImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, transportEvent, uuid, orderByComparator, true);

			array[1] = transportEvent;

			array[2] = getByUuid_PrevAndNext(
				session, transportEvent, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TransportEvent getByUuid_PrevAndNext(
		Session session, TransportEvent transportEvent, String uuid,
		OrderByComparator<TransportEvent> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TRANSPORTEVENT_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(TransportEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						transportEvent)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TransportEvent> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the transport events where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (TransportEvent transportEvent :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(transportEvent);
		}
	}

	/**
	 * Returns the number of transport events where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching transport events
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRANSPORTEVENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"transportEvent.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(transportEvent.uuid IS NULL OR transportEvent.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the transport event where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTransportEventException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching transport event
	 * @throws NoSuchTransportEventException if a matching transport event could not be found
	 */
	@Override
	public TransportEvent findByUUID_G(String uuid, long groupId)
		throws NoSuchTransportEventException {

		TransportEvent transportEvent = fetchByUUID_G(uuid, groupId);

		if (transportEvent == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchTransportEventException(sb.toString());
		}

		return transportEvent;
	}

	/**
	 * Returns the transport event where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching transport event, or <code>null</code> if a matching transport event could not be found
	 */
	@Override
	public TransportEvent fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the transport event where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching transport event, or <code>null</code> if a matching transport event could not be found
	 */
	@Override
	public TransportEvent fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs);
		}

		if (result instanceof TransportEvent) {
			TransportEvent transportEvent = (TransportEvent)result;

			if (!Objects.equals(uuid, transportEvent.getUuid()) ||
				(groupId != transportEvent.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_TRANSPORTEVENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<TransportEvent> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					TransportEvent transportEvent = list.get(0);

					result = transportEvent;

					cacheResult(transportEvent);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (TransportEvent)result;
		}
	}

	/**
	 * Removes the transport event where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the transport event that was removed
	 */
	@Override
	public TransportEvent removeByUUID_G(String uuid, long groupId)
		throws NoSuchTransportEventException {

		TransportEvent transportEvent = findByUUID_G(uuid, groupId);

		return remove(transportEvent);
	}

	/**
	 * Returns the number of transport events where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching transport events
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TRANSPORTEVENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"transportEvent.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(transportEvent.uuid IS NULL OR transportEvent.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"transportEvent.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the transport events where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching transport events
	 */
	@Override
	public List<TransportEvent> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TransportEvent> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<TransportEvent> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TransportEvent> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<TransportEvent> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TransportEvent> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<TransportEvent> list = null;

		if (useFinderCache) {
			list = (List<TransportEvent>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TransportEvent transportEvent : list) {
					if (!uuid.equals(transportEvent.getUuid()) ||
						(companyId != transportEvent.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_TRANSPORTEVENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TransportEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<TransportEvent>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public TransportEvent findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TransportEvent> orderByComparator)
		throws NoSuchTransportEventException {

		TransportEvent transportEvent = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (transportEvent != null) {
			return transportEvent;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTransportEventException(sb.toString());
	}

	/**
	 * Returns the first transport event in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transport event, or <code>null</code> if a matching transport event could not be found
	 */
	@Override
	public TransportEvent fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TransportEvent> orderByComparator) {

		List<TransportEvent> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TransportEvent findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TransportEvent> orderByComparator)
		throws NoSuchTransportEventException {

		TransportEvent transportEvent = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (transportEvent != null) {
			return transportEvent;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTransportEventException(sb.toString());
	}

	/**
	 * Returns the last transport event in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transport event, or <code>null</code> if a matching transport event could not be found
	 */
	@Override
	public TransportEvent fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TransportEvent> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<TransportEvent> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TransportEvent[] findByUuid_C_PrevAndNext(
			long transportEventId, String uuid, long companyId,
			OrderByComparator<TransportEvent> orderByComparator)
		throws NoSuchTransportEventException {

		uuid = Objects.toString(uuid, "");

		TransportEvent transportEvent = findByPrimaryKey(transportEventId);

		Session session = null;

		try {
			session = openSession();

			TransportEvent[] array = new TransportEventImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, transportEvent, uuid, companyId, orderByComparator,
				true);

			array[1] = transportEvent;

			array[2] = getByUuid_C_PrevAndNext(
				session, transportEvent, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TransportEvent getByUuid_C_PrevAndNext(
		Session session, TransportEvent transportEvent, String uuid,
		long companyId, OrderByComparator<TransportEvent> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_TRANSPORTEVENT_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(TransportEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						transportEvent)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TransportEvent> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the transport events where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (TransportEvent transportEvent :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(transportEvent);
		}
	}

	/**
	 * Returns the number of transport events where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching transport events
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TRANSPORTEVENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"transportEvent.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(transportEvent.uuid IS NULL OR transportEvent.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"transportEvent.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByCommerceShipmentId;
	private FinderPath _finderPathWithoutPaginationFindByCommerceShipmentId;
	private FinderPath _finderPathCountByCommerceShipmentId;

	/**
	 * Returns all the transport events where commerceShipmentId = &#63;.
	 *
	 * @param commerceShipmentId the commerce shipment ID
	 * @return the matching transport events
	 */
	@Override
	public List<TransportEvent> findByCommerceShipmentId(
		long commerceShipmentId) {

		return findByCommerceShipmentId(
			commerceShipmentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TransportEvent> findByCommerceShipmentId(
		long commerceShipmentId, int start, int end) {

		return findByCommerceShipmentId(commerceShipmentId, start, end, null);
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
	@Override
	public List<TransportEvent> findByCommerceShipmentId(
		long commerceShipmentId, int start, int end,
		OrderByComparator<TransportEvent> orderByComparator) {

		return findByCommerceShipmentId(
			commerceShipmentId, start, end, orderByComparator, true);
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
	@Override
	public List<TransportEvent> findByCommerceShipmentId(
		long commerceShipmentId, int start, int end,
		OrderByComparator<TransportEvent> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByCommerceShipmentId;
				finderArgs = new Object[] {commerceShipmentId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCommerceShipmentId;
			finderArgs = new Object[] {
				commerceShipmentId, start, end, orderByComparator
			};
		}

		List<TransportEvent> list = null;

		if (useFinderCache) {
			list = (List<TransportEvent>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TransportEvent transportEvent : list) {
					if (commerceShipmentId !=
							transportEvent.getCommerceShipmentId()) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_TRANSPORTEVENT_WHERE);

			sb.append(_FINDER_COLUMN_COMMERCESHIPMENTID_COMMERCESHIPMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TransportEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(commerceShipmentId);

				list = (List<TransportEvent>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first transport event in the ordered set where commerceShipmentId = &#63;.
	 *
	 * @param commerceShipmentId the commerce shipment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transport event
	 * @throws NoSuchTransportEventException if a matching transport event could not be found
	 */
	@Override
	public TransportEvent findByCommerceShipmentId_First(
			long commerceShipmentId,
			OrderByComparator<TransportEvent> orderByComparator)
		throws NoSuchTransportEventException {

		TransportEvent transportEvent = fetchByCommerceShipmentId_First(
			commerceShipmentId, orderByComparator);

		if (transportEvent != null) {
			return transportEvent;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("commerceShipmentId=");
		sb.append(commerceShipmentId);

		sb.append("}");

		throw new NoSuchTransportEventException(sb.toString());
	}

	/**
	 * Returns the first transport event in the ordered set where commerceShipmentId = &#63;.
	 *
	 * @param commerceShipmentId the commerce shipment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transport event, or <code>null</code> if a matching transport event could not be found
	 */
	@Override
	public TransportEvent fetchByCommerceShipmentId_First(
		long commerceShipmentId,
		OrderByComparator<TransportEvent> orderByComparator) {

		List<TransportEvent> list = findByCommerceShipmentId(
			commerceShipmentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last transport event in the ordered set where commerceShipmentId = &#63;.
	 *
	 * @param commerceShipmentId the commerce shipment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transport event
	 * @throws NoSuchTransportEventException if a matching transport event could not be found
	 */
	@Override
	public TransportEvent findByCommerceShipmentId_Last(
			long commerceShipmentId,
			OrderByComparator<TransportEvent> orderByComparator)
		throws NoSuchTransportEventException {

		TransportEvent transportEvent = fetchByCommerceShipmentId_Last(
			commerceShipmentId, orderByComparator);

		if (transportEvent != null) {
			return transportEvent;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("commerceShipmentId=");
		sb.append(commerceShipmentId);

		sb.append("}");

		throw new NoSuchTransportEventException(sb.toString());
	}

	/**
	 * Returns the last transport event in the ordered set where commerceShipmentId = &#63;.
	 *
	 * @param commerceShipmentId the commerce shipment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transport event, or <code>null</code> if a matching transport event could not be found
	 */
	@Override
	public TransportEvent fetchByCommerceShipmentId_Last(
		long commerceShipmentId,
		OrderByComparator<TransportEvent> orderByComparator) {

		int count = countByCommerceShipmentId(commerceShipmentId);

		if (count == 0) {
			return null;
		}

		List<TransportEvent> list = findByCommerceShipmentId(
			commerceShipmentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TransportEvent[] findByCommerceShipmentId_PrevAndNext(
			long transportEventId, long commerceShipmentId,
			OrderByComparator<TransportEvent> orderByComparator)
		throws NoSuchTransportEventException {

		TransportEvent transportEvent = findByPrimaryKey(transportEventId);

		Session session = null;

		try {
			session = openSession();

			TransportEvent[] array = new TransportEventImpl[3];

			array[0] = getByCommerceShipmentId_PrevAndNext(
				session, transportEvent, commerceShipmentId, orderByComparator,
				true);

			array[1] = transportEvent;

			array[2] = getByCommerceShipmentId_PrevAndNext(
				session, transportEvent, commerceShipmentId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TransportEvent getByCommerceShipmentId_PrevAndNext(
		Session session, TransportEvent transportEvent, long commerceShipmentId,
		OrderByComparator<TransportEvent> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TRANSPORTEVENT_WHERE);

		sb.append(_FINDER_COLUMN_COMMERCESHIPMENTID_COMMERCESHIPMENTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(TransportEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(commerceShipmentId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						transportEvent)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TransportEvent> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the transport events where commerceShipmentId = &#63; from the database.
	 *
	 * @param commerceShipmentId the commerce shipment ID
	 */
	@Override
	public void removeByCommerceShipmentId(long commerceShipmentId) {
		for (TransportEvent transportEvent :
				findByCommerceShipmentId(
					commerceShipmentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(transportEvent);
		}
	}

	/**
	 * Returns the number of transport events where commerceShipmentId = &#63;.
	 *
	 * @param commerceShipmentId the commerce shipment ID
	 * @return the number of matching transport events
	 */
	@Override
	public int countByCommerceShipmentId(long commerceShipmentId) {
		FinderPath finderPath = _finderPathCountByCommerceShipmentId;

		Object[] finderArgs = new Object[] {commerceShipmentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRANSPORTEVENT_WHERE);

			sb.append(_FINDER_COLUMN_COMMERCESHIPMENTID_COMMERCESHIPMENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(commerceShipmentId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_COMMERCESHIPMENTID_COMMERCESHIPMENTID_2 =
			"transportEvent.commerceShipmentId = ?";

	private FinderPath _finderPathWithPaginationFindByTrackingNumber;
	private FinderPath _finderPathWithoutPaginationFindByTrackingNumber;
	private FinderPath _finderPathCountByTrackingNumber;

	/**
	 * Returns all the transport events where trackingNumber = &#63;.
	 *
	 * @param trackingNumber the tracking number
	 * @return the matching transport events
	 */
	@Override
	public List<TransportEvent> findByTrackingNumber(String trackingNumber) {
		return findByTrackingNumber(
			trackingNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TransportEvent> findByTrackingNumber(
		String trackingNumber, int start, int end) {

		return findByTrackingNumber(trackingNumber, start, end, null);
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
	@Override
	public List<TransportEvent> findByTrackingNumber(
		String trackingNumber, int start, int end,
		OrderByComparator<TransportEvent> orderByComparator) {

		return findByTrackingNumber(
			trackingNumber, start, end, orderByComparator, true);
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
	@Override
	public List<TransportEvent> findByTrackingNumber(
		String trackingNumber, int start, int end,
		OrderByComparator<TransportEvent> orderByComparator,
		boolean useFinderCache) {

		trackingNumber = Objects.toString(trackingNumber, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTrackingNumber;
				finderArgs = new Object[] {trackingNumber};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTrackingNumber;
			finderArgs = new Object[] {
				trackingNumber, start, end, orderByComparator
			};
		}

		List<TransportEvent> list = null;

		if (useFinderCache) {
			list = (List<TransportEvent>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TransportEvent transportEvent : list) {
					if (!trackingNumber.equals(
							transportEvent.getTrackingNumber())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_TRANSPORTEVENT_WHERE);

			boolean bindTrackingNumber = false;

			if (trackingNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_TRACKINGNUMBER_TRACKINGNUMBER_3);
			}
			else {
				bindTrackingNumber = true;

				sb.append(_FINDER_COLUMN_TRACKINGNUMBER_TRACKINGNUMBER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TransportEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTrackingNumber) {
					queryPos.add(trackingNumber);
				}

				list = (List<TransportEvent>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first transport event in the ordered set where trackingNumber = &#63;.
	 *
	 * @param trackingNumber the tracking number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transport event
	 * @throws NoSuchTransportEventException if a matching transport event could not be found
	 */
	@Override
	public TransportEvent findByTrackingNumber_First(
			String trackingNumber,
			OrderByComparator<TransportEvent> orderByComparator)
		throws NoSuchTransportEventException {

		TransportEvent transportEvent = fetchByTrackingNumber_First(
			trackingNumber, orderByComparator);

		if (transportEvent != null) {
			return transportEvent;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("trackingNumber=");
		sb.append(trackingNumber);

		sb.append("}");

		throw new NoSuchTransportEventException(sb.toString());
	}

	/**
	 * Returns the first transport event in the ordered set where trackingNumber = &#63;.
	 *
	 * @param trackingNumber the tracking number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transport event, or <code>null</code> if a matching transport event could not be found
	 */
	@Override
	public TransportEvent fetchByTrackingNumber_First(
		String trackingNumber,
		OrderByComparator<TransportEvent> orderByComparator) {

		List<TransportEvent> list = findByTrackingNumber(
			trackingNumber, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last transport event in the ordered set where trackingNumber = &#63;.
	 *
	 * @param trackingNumber the tracking number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transport event
	 * @throws NoSuchTransportEventException if a matching transport event could not be found
	 */
	@Override
	public TransportEvent findByTrackingNumber_Last(
			String trackingNumber,
			OrderByComparator<TransportEvent> orderByComparator)
		throws NoSuchTransportEventException {

		TransportEvent transportEvent = fetchByTrackingNumber_Last(
			trackingNumber, orderByComparator);

		if (transportEvent != null) {
			return transportEvent;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("trackingNumber=");
		sb.append(trackingNumber);

		sb.append("}");

		throw new NoSuchTransportEventException(sb.toString());
	}

	/**
	 * Returns the last transport event in the ordered set where trackingNumber = &#63;.
	 *
	 * @param trackingNumber the tracking number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transport event, or <code>null</code> if a matching transport event could not be found
	 */
	@Override
	public TransportEvent fetchByTrackingNumber_Last(
		String trackingNumber,
		OrderByComparator<TransportEvent> orderByComparator) {

		int count = countByTrackingNumber(trackingNumber);

		if (count == 0) {
			return null;
		}

		List<TransportEvent> list = findByTrackingNumber(
			trackingNumber, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TransportEvent[] findByTrackingNumber_PrevAndNext(
			long transportEventId, String trackingNumber,
			OrderByComparator<TransportEvent> orderByComparator)
		throws NoSuchTransportEventException {

		trackingNumber = Objects.toString(trackingNumber, "");

		TransportEvent transportEvent = findByPrimaryKey(transportEventId);

		Session session = null;

		try {
			session = openSession();

			TransportEvent[] array = new TransportEventImpl[3];

			array[0] = getByTrackingNumber_PrevAndNext(
				session, transportEvent, trackingNumber, orderByComparator,
				true);

			array[1] = transportEvent;

			array[2] = getByTrackingNumber_PrevAndNext(
				session, transportEvent, trackingNumber, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TransportEvent getByTrackingNumber_PrevAndNext(
		Session session, TransportEvent transportEvent, String trackingNumber,
		OrderByComparator<TransportEvent> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TRANSPORTEVENT_WHERE);

		boolean bindTrackingNumber = false;

		if (trackingNumber.isEmpty()) {
			sb.append(_FINDER_COLUMN_TRACKINGNUMBER_TRACKINGNUMBER_3);
		}
		else {
			bindTrackingNumber = true;

			sb.append(_FINDER_COLUMN_TRACKINGNUMBER_TRACKINGNUMBER_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(TransportEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindTrackingNumber) {
			queryPos.add(trackingNumber);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						transportEvent)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TransportEvent> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the transport events where trackingNumber = &#63; from the database.
	 *
	 * @param trackingNumber the tracking number
	 */
	@Override
	public void removeByTrackingNumber(String trackingNumber) {
		for (TransportEvent transportEvent :
				findByTrackingNumber(
					trackingNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(transportEvent);
		}
	}

	/**
	 * Returns the number of transport events where trackingNumber = &#63;.
	 *
	 * @param trackingNumber the tracking number
	 * @return the number of matching transport events
	 */
	@Override
	public int countByTrackingNumber(String trackingNumber) {
		trackingNumber = Objects.toString(trackingNumber, "");

		FinderPath finderPath = _finderPathCountByTrackingNumber;

		Object[] finderArgs = new Object[] {trackingNumber};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRANSPORTEVENT_WHERE);

			boolean bindTrackingNumber = false;

			if (trackingNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_TRACKINGNUMBER_TRACKINGNUMBER_3);
			}
			else {
				bindTrackingNumber = true;

				sb.append(_FINDER_COLUMN_TRACKINGNUMBER_TRACKINGNUMBER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTrackingNumber) {
					queryPos.add(trackingNumber);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TRACKINGNUMBER_TRACKINGNUMBER_2 =
		"transportEvent.trackingNumber = ?";

	private static final String _FINDER_COLUMN_TRACKINGNUMBER_TRACKINGNUMBER_3 =
		"(transportEvent.trackingNumber IS NULL OR transportEvent.trackingNumber = '')";

	private FinderPath _finderPathWithPaginationFindByCarrier;
	private FinderPath _finderPathWithoutPaginationFindByCarrier;
	private FinderPath _finderPathCountByCarrier;

	/**
	 * Returns all the transport events where carrier = &#63;.
	 *
	 * @param carrier the carrier
	 * @return the matching transport events
	 */
	@Override
	public List<TransportEvent> findByCarrier(String carrier) {
		return findByCarrier(
			carrier, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TransportEvent> findByCarrier(
		String carrier, int start, int end) {

		return findByCarrier(carrier, start, end, null);
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
	@Override
	public List<TransportEvent> findByCarrier(
		String carrier, int start, int end,
		OrderByComparator<TransportEvent> orderByComparator) {

		return findByCarrier(carrier, start, end, orderByComparator, true);
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
	@Override
	public List<TransportEvent> findByCarrier(
		String carrier, int start, int end,
		OrderByComparator<TransportEvent> orderByComparator,
		boolean useFinderCache) {

		carrier = Objects.toString(carrier, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCarrier;
				finderArgs = new Object[] {carrier};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCarrier;
			finderArgs = new Object[] {carrier, start, end, orderByComparator};
		}

		List<TransportEvent> list = null;

		if (useFinderCache) {
			list = (List<TransportEvent>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TransportEvent transportEvent : list) {
					if (!carrier.equals(transportEvent.getCarrier())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_TRANSPORTEVENT_WHERE);

			boolean bindCarrier = false;

			if (carrier.isEmpty()) {
				sb.append(_FINDER_COLUMN_CARRIER_CARRIER_3);
			}
			else {
				bindCarrier = true;

				sb.append(_FINDER_COLUMN_CARRIER_CARRIER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TransportEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCarrier) {
					queryPos.add(carrier);
				}

				list = (List<TransportEvent>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first transport event in the ordered set where carrier = &#63;.
	 *
	 * @param carrier the carrier
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transport event
	 * @throws NoSuchTransportEventException if a matching transport event could not be found
	 */
	@Override
	public TransportEvent findByCarrier_First(
			String carrier, OrderByComparator<TransportEvent> orderByComparator)
		throws NoSuchTransportEventException {

		TransportEvent transportEvent = fetchByCarrier_First(
			carrier, orderByComparator);

		if (transportEvent != null) {
			return transportEvent;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("carrier=");
		sb.append(carrier);

		sb.append("}");

		throw new NoSuchTransportEventException(sb.toString());
	}

	/**
	 * Returns the first transport event in the ordered set where carrier = &#63;.
	 *
	 * @param carrier the carrier
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transport event, or <code>null</code> if a matching transport event could not be found
	 */
	@Override
	public TransportEvent fetchByCarrier_First(
		String carrier, OrderByComparator<TransportEvent> orderByComparator) {

		List<TransportEvent> list = findByCarrier(
			carrier, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last transport event in the ordered set where carrier = &#63;.
	 *
	 * @param carrier the carrier
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transport event
	 * @throws NoSuchTransportEventException if a matching transport event could not be found
	 */
	@Override
	public TransportEvent findByCarrier_Last(
			String carrier, OrderByComparator<TransportEvent> orderByComparator)
		throws NoSuchTransportEventException {

		TransportEvent transportEvent = fetchByCarrier_Last(
			carrier, orderByComparator);

		if (transportEvent != null) {
			return transportEvent;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("carrier=");
		sb.append(carrier);

		sb.append("}");

		throw new NoSuchTransportEventException(sb.toString());
	}

	/**
	 * Returns the last transport event in the ordered set where carrier = &#63;.
	 *
	 * @param carrier the carrier
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transport event, or <code>null</code> if a matching transport event could not be found
	 */
	@Override
	public TransportEvent fetchByCarrier_Last(
		String carrier, OrderByComparator<TransportEvent> orderByComparator) {

		int count = countByCarrier(carrier);

		if (count == 0) {
			return null;
		}

		List<TransportEvent> list = findByCarrier(
			carrier, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TransportEvent[] findByCarrier_PrevAndNext(
			long transportEventId, String carrier,
			OrderByComparator<TransportEvent> orderByComparator)
		throws NoSuchTransportEventException {

		carrier = Objects.toString(carrier, "");

		TransportEvent transportEvent = findByPrimaryKey(transportEventId);

		Session session = null;

		try {
			session = openSession();

			TransportEvent[] array = new TransportEventImpl[3];

			array[0] = getByCarrier_PrevAndNext(
				session, transportEvent, carrier, orderByComparator, true);

			array[1] = transportEvent;

			array[2] = getByCarrier_PrevAndNext(
				session, transportEvent, carrier, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TransportEvent getByCarrier_PrevAndNext(
		Session session, TransportEvent transportEvent, String carrier,
		OrderByComparator<TransportEvent> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TRANSPORTEVENT_WHERE);

		boolean bindCarrier = false;

		if (carrier.isEmpty()) {
			sb.append(_FINDER_COLUMN_CARRIER_CARRIER_3);
		}
		else {
			bindCarrier = true;

			sb.append(_FINDER_COLUMN_CARRIER_CARRIER_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(TransportEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCarrier) {
			queryPos.add(carrier);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						transportEvent)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TransportEvent> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the transport events where carrier = &#63; from the database.
	 *
	 * @param carrier the carrier
	 */
	@Override
	public void removeByCarrier(String carrier) {
		for (TransportEvent transportEvent :
				findByCarrier(
					carrier, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(transportEvent);
		}
	}

	/**
	 * Returns the number of transport events where carrier = &#63;.
	 *
	 * @param carrier the carrier
	 * @return the number of matching transport events
	 */
	@Override
	public int countByCarrier(String carrier) {
		carrier = Objects.toString(carrier, "");

		FinderPath finderPath = _finderPathCountByCarrier;

		Object[] finderArgs = new Object[] {carrier};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRANSPORTEVENT_WHERE);

			boolean bindCarrier = false;

			if (carrier.isEmpty()) {
				sb.append(_FINDER_COLUMN_CARRIER_CARRIER_3);
			}
			else {
				bindCarrier = true;

				sb.append(_FINDER_COLUMN_CARRIER_CARRIER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCarrier) {
					queryPos.add(carrier);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CARRIER_CARRIER_2 =
		"transportEvent.carrier = ?";

	private static final String _FINDER_COLUMN_CARRIER_CARRIER_3 =
		"(transportEvent.carrier IS NULL OR transportEvent.carrier = '')";

	public TransportEventPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(TransportEvent.class);

		setModelImplClass(TransportEventImpl.class);
		setModelPKClass(long.class);

		setTable(TransportEventTable.INSTANCE);
	}

	/**
	 * Caches the transport event in the entity cache if it is enabled.
	 *
	 * @param transportEvent the transport event
	 */
	@Override
	public void cacheResult(TransportEvent transportEvent) {
		entityCache.putResult(
			TransportEventImpl.class, transportEvent.getPrimaryKey(),
			transportEvent);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				transportEvent.getUuid(), transportEvent.getGroupId()
			},
			transportEvent);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the transport events in the entity cache if it is enabled.
	 *
	 * @param transportEvents the transport events
	 */
	@Override
	public void cacheResult(List<TransportEvent> transportEvents) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (transportEvents.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TransportEvent transportEvent : transportEvents) {
			if (entityCache.getResult(
					TransportEventImpl.class, transportEvent.getPrimaryKey()) ==
						null) {

				cacheResult(transportEvent);
			}
		}
	}

	/**
	 * Clears the cache for all transport events.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TransportEventImpl.class);

		finderCache.clearCache(TransportEventImpl.class);
	}

	/**
	 * Clears the cache for the transport event.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TransportEvent transportEvent) {
		entityCache.removeResult(TransportEventImpl.class, transportEvent);
	}

	@Override
	public void clearCache(List<TransportEvent> transportEvents) {
		for (TransportEvent transportEvent : transportEvents) {
			entityCache.removeResult(TransportEventImpl.class, transportEvent);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(TransportEventImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(TransportEventImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		TransportEventModelImpl transportEventModelImpl) {

		Object[] args = new Object[] {
			transportEventModelImpl.getUuid(),
			transportEventModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, transportEventModelImpl);
	}

	/**
	 * Creates a new transport event with the primary key. Does not add the transport event to the database.
	 *
	 * @param transportEventId the primary key for the new transport event
	 * @return the new transport event
	 */
	@Override
	public TransportEvent create(long transportEventId) {
		TransportEvent transportEvent = new TransportEventImpl();

		transportEvent.setNew(true);
		transportEvent.setPrimaryKey(transportEventId);

		String uuid = PortalUUIDUtil.generate();

		transportEvent.setUuid(uuid);

		transportEvent.setCompanyId(CompanyThreadLocal.getCompanyId());

		return transportEvent;
	}

	/**
	 * Removes the transport event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param transportEventId the primary key of the transport event
	 * @return the transport event that was removed
	 * @throws NoSuchTransportEventException if a transport event with the primary key could not be found
	 */
	@Override
	public TransportEvent remove(long transportEventId)
		throws NoSuchTransportEventException {

		return remove((Serializable)transportEventId);
	}

	/**
	 * Removes the transport event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the transport event
	 * @return the transport event that was removed
	 * @throws NoSuchTransportEventException if a transport event with the primary key could not be found
	 */
	@Override
	public TransportEvent remove(Serializable primaryKey)
		throws NoSuchTransportEventException {

		Session session = null;

		try {
			session = openSession();

			TransportEvent transportEvent = (TransportEvent)session.get(
				TransportEventImpl.class, primaryKey);

			if (transportEvent == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTransportEventException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(transportEvent);
		}
		catch (NoSuchTransportEventException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected TransportEvent removeImpl(TransportEvent transportEvent) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(transportEvent)) {
				transportEvent = (TransportEvent)session.get(
					TransportEventImpl.class,
					transportEvent.getPrimaryKeyObj());
			}

			if (transportEvent != null) {
				session.delete(transportEvent);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (transportEvent != null) {
			clearCache(transportEvent);
		}

		return transportEvent;
	}

	@Override
	public TransportEvent updateImpl(TransportEvent transportEvent) {
		boolean isNew = transportEvent.isNew();

		if (!(transportEvent instanceof TransportEventModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(transportEvent.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					transportEvent);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in transportEvent proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TransportEvent implementation " +
					transportEvent.getClass());
		}

		TransportEventModelImpl transportEventModelImpl =
			(TransportEventModelImpl)transportEvent;

		if (Validator.isNull(transportEvent.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			transportEvent.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (transportEvent.getCreateDate() == null)) {
			if (serviceContext == null) {
				transportEvent.setCreateDate(date);
			}
			else {
				transportEvent.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!transportEventModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				transportEvent.setModifiedDate(date);
			}
			else {
				transportEvent.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(transportEvent);
			}
			else {
				transportEvent = (TransportEvent)session.merge(transportEvent);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TransportEventImpl.class, transportEventModelImpl, false, true);

		cacheUniqueFindersCache(transportEventModelImpl);

		if (isNew) {
			transportEvent.setNew(false);
		}

		transportEvent.resetOriginalValues();

		return transportEvent;
	}

	/**
	 * Returns the transport event with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the transport event
	 * @return the transport event
	 * @throws NoSuchTransportEventException if a transport event with the primary key could not be found
	 */
	@Override
	public TransportEvent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTransportEventException {

		TransportEvent transportEvent = fetchByPrimaryKey(primaryKey);

		if (transportEvent == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTransportEventException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return transportEvent;
	}

	/**
	 * Returns the transport event with the primary key or throws a <code>NoSuchTransportEventException</code> if it could not be found.
	 *
	 * @param transportEventId the primary key of the transport event
	 * @return the transport event
	 * @throws NoSuchTransportEventException if a transport event with the primary key could not be found
	 */
	@Override
	public TransportEvent findByPrimaryKey(long transportEventId)
		throws NoSuchTransportEventException {

		return findByPrimaryKey((Serializable)transportEventId);
	}

	/**
	 * Returns the transport event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param transportEventId the primary key of the transport event
	 * @return the transport event, or <code>null</code> if a transport event with the primary key could not be found
	 */
	@Override
	public TransportEvent fetchByPrimaryKey(long transportEventId) {
		return fetchByPrimaryKey((Serializable)transportEventId);
	}

	/**
	 * Returns all the transport events.
	 *
	 * @return the transport events
	 */
	@Override
	public List<TransportEvent> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TransportEvent> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<TransportEvent> findAll(
		int start, int end,
		OrderByComparator<TransportEvent> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<TransportEvent> findAll(
		int start, int end, OrderByComparator<TransportEvent> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<TransportEvent> list = null;

		if (useFinderCache) {
			list = (List<TransportEvent>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TRANSPORTEVENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TRANSPORTEVENT;

				sql = sql.concat(TransportEventModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TransportEvent>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the transport events from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TransportEvent transportEvent : findAll()) {
			remove(transportEvent);
		}
	}

	/**
	 * Returns the number of transport events.
	 *
	 * @return the number of transport events
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TRANSPORTEVENT);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "transportEventId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TRANSPORTEVENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TransportEventModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the transport event persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByCommerceShipmentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCommerceShipmentId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"commerceShipmentId"}, true);

		_finderPathWithoutPaginationFindByCommerceShipmentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCommerceShipmentId", new String[] {Long.class.getName()},
			new String[] {"commerceShipmentId"}, true);

		_finderPathCountByCommerceShipmentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCommerceShipmentId", new String[] {Long.class.getName()},
			new String[] {"commerceShipmentId"}, false);

		_finderPathWithPaginationFindByTrackingNumber = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTrackingNumber",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"trackingNumber"}, true);

		_finderPathWithoutPaginationFindByTrackingNumber = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTrackingNumber",
			new String[] {String.class.getName()},
			new String[] {"trackingNumber"}, true);

		_finderPathCountByTrackingNumber = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTrackingNumber",
			new String[] {String.class.getName()},
			new String[] {"trackingNumber"}, false);

		_finderPathWithPaginationFindByCarrier = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCarrier",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"carrier"}, true);

		_finderPathWithoutPaginationFindByCarrier = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCarrier",
			new String[] {String.class.getName()}, new String[] {"carrier"},
			true);

		_finderPathCountByCarrier = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCarrier",
			new String[] {String.class.getName()}, new String[] {"carrier"},
			false);

		_setTransportEventUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTransportEventUtilPersistence(null);

		entityCache.removeCache(TransportEventImpl.class.getName());
	}

	private void _setTransportEventUtilPersistence(
		TransportEventPersistence transportEventPersistence) {

		try {
			Field field = TransportEventUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, transportEventPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = CommerceDemoPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = CommerceDemoPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = CommerceDemoPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_TRANSPORTEVENT =
		"SELECT transportEvent FROM TransportEvent transportEvent";

	private static final String _SQL_SELECT_TRANSPORTEVENT_WHERE =
		"SELECT transportEvent FROM TransportEvent transportEvent WHERE ";

	private static final String _SQL_COUNT_TRANSPORTEVENT =
		"SELECT COUNT(transportEvent) FROM TransportEvent transportEvent";

	private static final String _SQL_COUNT_TRANSPORTEVENT_WHERE =
		"SELECT COUNT(transportEvent) FROM TransportEvent transportEvent WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "transportEvent.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TransportEvent exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TransportEvent exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TransportEventPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private TransportEventModelArgumentsResolver
		_transportEventModelArgumentsResolver;

}