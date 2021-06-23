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

package com.github.lgdd.liferay.commerce.transport.events.model.impl;

import com.github.lgdd.liferay.commerce.transport.events.model.TransportEvent;
import com.github.lgdd.liferay.commerce.transport.events.model.TransportEventModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the TransportEvent service. Represents a row in the &quot;CommerceDemo_TransportEvent&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>TransportEventModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TransportEventImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TransportEventImpl
 * @generated
 */
public class TransportEventModelImpl
	extends BaseModelImpl<TransportEvent> implements TransportEventModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a transport event model instance should use the <code>TransportEvent</code> interface instead.
	 */
	public static final String TABLE_NAME = "CommerceDemo_TransportEvent";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"transportEventId", Types.BIGINT},
		{"commerceShipmentId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"carrier", Types.VARCHAR},
		{"trackingNumber", Types.VARCHAR}, {"expectedDate", Types.TIMESTAMP},
		{"shippingDate", Types.TIMESTAMP}, {"status", Types.INTEGER},
		{"commerceAccountName", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("transportEventId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("commerceShipmentId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("carrier", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("trackingNumber", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("expectedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("shippingDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("commerceAccountName", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table CommerceDemo_TransportEvent (uuid_ VARCHAR(75) null,transportEventId LONG not null primary key,commerceShipmentId LONG,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,carrier VARCHAR(75) null,trackingNumber VARCHAR(75) null,expectedDate DATE null,shippingDate DATE null,status INTEGER,commerceAccountName VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table CommerceDemo_TransportEvent";

	public static final String ORDER_BY_JPQL =
		" ORDER BY transportEvent.createDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY CommerceDemo_TransportEvent.createDate DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CARRIER_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMMERCESHIPMENTID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long TRACKINGNUMBER_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CREATEDATE_COLUMN_BITMASK = 64L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public TransportEventModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _transportEventId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTransportEventId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _transportEventId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return TransportEvent.class;
	}

	@Override
	public String getModelClassName() {
		return TransportEvent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<TransportEvent, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<TransportEvent, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TransportEvent, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((TransportEvent)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<TransportEvent, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<TransportEvent, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(TransportEvent)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<TransportEvent, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<TransportEvent, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, TransportEvent>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			TransportEvent.class.getClassLoader(), TransportEvent.class,
			ModelWrapper.class);

		try {
			Constructor<TransportEvent> constructor =
				(Constructor<TransportEvent>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<TransportEvent, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<TransportEvent, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<TransportEvent, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<TransportEvent, Object>>();
		Map<String, BiConsumer<TransportEvent, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<TransportEvent, ?>>();

		attributeGetterFunctions.put("uuid", TransportEvent::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<TransportEvent, String>)TransportEvent::setUuid);
		attributeGetterFunctions.put(
			"transportEventId", TransportEvent::getTransportEventId);
		attributeSetterBiConsumers.put(
			"transportEventId",
			(BiConsumer<TransportEvent, Long>)
				TransportEvent::setTransportEventId);
		attributeGetterFunctions.put(
			"commerceShipmentId", TransportEvent::getCommerceShipmentId);
		attributeSetterBiConsumers.put(
			"commerceShipmentId",
			(BiConsumer<TransportEvent, Long>)
				TransportEvent::setCommerceShipmentId);
		attributeGetterFunctions.put("groupId", TransportEvent::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<TransportEvent, Long>)TransportEvent::setGroupId);
		attributeGetterFunctions.put("companyId", TransportEvent::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<TransportEvent, Long>)TransportEvent::setCompanyId);
		attributeGetterFunctions.put("userId", TransportEvent::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<TransportEvent, Long>)TransportEvent::setUserId);
		attributeGetterFunctions.put("userName", TransportEvent::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<TransportEvent, String>)TransportEvent::setUserName);
		attributeGetterFunctions.put(
			"createDate", TransportEvent::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<TransportEvent, Date>)TransportEvent::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", TransportEvent::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<TransportEvent, Date>)TransportEvent::setModifiedDate);
		attributeGetterFunctions.put("carrier", TransportEvent::getCarrier);
		attributeSetterBiConsumers.put(
			"carrier",
			(BiConsumer<TransportEvent, String>)TransportEvent::setCarrier);
		attributeGetterFunctions.put(
			"trackingNumber", TransportEvent::getTrackingNumber);
		attributeSetterBiConsumers.put(
			"trackingNumber",
			(BiConsumer<TransportEvent, String>)
				TransportEvent::setTrackingNumber);
		attributeGetterFunctions.put(
			"expectedDate", TransportEvent::getExpectedDate);
		attributeSetterBiConsumers.put(
			"expectedDate",
			(BiConsumer<TransportEvent, Date>)TransportEvent::setExpectedDate);
		attributeGetterFunctions.put(
			"shippingDate", TransportEvent::getShippingDate);
		attributeSetterBiConsumers.put(
			"shippingDate",
			(BiConsumer<TransportEvent, Date>)TransportEvent::setShippingDate);
		attributeGetterFunctions.put("status", TransportEvent::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<TransportEvent, Integer>)TransportEvent::setStatus);
		attributeGetterFunctions.put(
			"commerceAccountName", TransportEvent::getCommerceAccountName);
		attributeSetterBiConsumers.put(
			"commerceAccountName",
			(BiConsumer<TransportEvent, String>)
				TransportEvent::setCommerceAccountName);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@Override
	public long getTransportEventId() {
		return _transportEventId;
	}

	@Override
	public void setTransportEventId(long transportEventId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_transportEventId = transportEventId;
	}

	@Override
	public long getCommerceShipmentId() {
		return _commerceShipmentId;
	}

	@Override
	public void setCommerceShipmentId(long commerceShipmentId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_commerceShipmentId = commerceShipmentId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCommerceShipmentId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("commerceShipmentId"));
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getCarrier() {
		if (_carrier == null) {
			return "";
		}
		else {
			return _carrier;
		}
	}

	@Override
	public void setCarrier(String carrier) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_carrier = carrier;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalCarrier() {
		return getColumnOriginalValue("carrier");
	}

	@Override
	public String getTrackingNumber() {
		if (_trackingNumber == null) {
			return "";
		}
		else {
			return _trackingNumber;
		}
	}

	@Override
	public void setTrackingNumber(String trackingNumber) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_trackingNumber = trackingNumber;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalTrackingNumber() {
		return getColumnOriginalValue("trackingNumber");
	}

	@Override
	public Date getExpectedDate() {
		return _expectedDate;
	}

	@Override
	public void setExpectedDate(Date expectedDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_expectedDate = expectedDate;
	}

	@Override
	public Date getShippingDate() {
		return _shippingDate;
	}

	@Override
	public void setShippingDate(Date shippingDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_shippingDate = shippingDate;
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_status = status;
	}

	@Override
	public String getCommerceAccountName() {
		if (_commerceAccountName == null) {
			return "";
		}
		else {
			return _commerceAccountName;
		}
	}

	@Override
	public void setCommerceAccountName(String commerceAccountName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_commerceAccountName = commerceAccountName;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(TransportEvent.class.getName()));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), TransportEvent.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TransportEvent toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, TransportEvent>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TransportEventImpl transportEventImpl = new TransportEventImpl();

		transportEventImpl.setUuid(getUuid());
		transportEventImpl.setTransportEventId(getTransportEventId());
		transportEventImpl.setCommerceShipmentId(getCommerceShipmentId());
		transportEventImpl.setGroupId(getGroupId());
		transportEventImpl.setCompanyId(getCompanyId());
		transportEventImpl.setUserId(getUserId());
		transportEventImpl.setUserName(getUserName());
		transportEventImpl.setCreateDate(getCreateDate());
		transportEventImpl.setModifiedDate(getModifiedDate());
		transportEventImpl.setCarrier(getCarrier());
		transportEventImpl.setTrackingNumber(getTrackingNumber());
		transportEventImpl.setExpectedDate(getExpectedDate());
		transportEventImpl.setShippingDate(getShippingDate());
		transportEventImpl.setStatus(getStatus());
		transportEventImpl.setCommerceAccountName(getCommerceAccountName());

		transportEventImpl.resetOriginalValues();

		return transportEventImpl;
	}

	@Override
	public int compareTo(TransportEvent transportEvent) {
		int value = 0;

		value = DateUtil.compareTo(
			getCreateDate(), transportEvent.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TransportEvent)) {
			return false;
		}

		TransportEvent transportEvent = (TransportEvent)object;

		long primaryKey = transportEvent.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<TransportEvent> toCacheModel() {
		TransportEventCacheModel transportEventCacheModel =
			new TransportEventCacheModel();

		transportEventCacheModel.uuid = getUuid();

		String uuid = transportEventCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			transportEventCacheModel.uuid = null;
		}

		transportEventCacheModel.transportEventId = getTransportEventId();

		transportEventCacheModel.commerceShipmentId = getCommerceShipmentId();

		transportEventCacheModel.groupId = getGroupId();

		transportEventCacheModel.companyId = getCompanyId();

		transportEventCacheModel.userId = getUserId();

		transportEventCacheModel.userName = getUserName();

		String userName = transportEventCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			transportEventCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			transportEventCacheModel.createDate = createDate.getTime();
		}
		else {
			transportEventCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			transportEventCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			transportEventCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		transportEventCacheModel.carrier = getCarrier();

		String carrier = transportEventCacheModel.carrier;

		if ((carrier != null) && (carrier.length() == 0)) {
			transportEventCacheModel.carrier = null;
		}

		transportEventCacheModel.trackingNumber = getTrackingNumber();

		String trackingNumber = transportEventCacheModel.trackingNumber;

		if ((trackingNumber != null) && (trackingNumber.length() == 0)) {
			transportEventCacheModel.trackingNumber = null;
		}

		Date expectedDate = getExpectedDate();

		if (expectedDate != null) {
			transportEventCacheModel.expectedDate = expectedDate.getTime();
		}
		else {
			transportEventCacheModel.expectedDate = Long.MIN_VALUE;
		}

		Date shippingDate = getShippingDate();

		if (shippingDate != null) {
			transportEventCacheModel.shippingDate = shippingDate.getTime();
		}
		else {
			transportEventCacheModel.shippingDate = Long.MIN_VALUE;
		}

		transportEventCacheModel.status = getStatus();

		transportEventCacheModel.commerceAccountName = getCommerceAccountName();

		String commerceAccountName =
			transportEventCacheModel.commerceAccountName;

		if ((commerceAccountName != null) &&
			(commerceAccountName.length() == 0)) {

			transportEventCacheModel.commerceAccountName = null;
		}

		return transportEventCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<TransportEvent, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<TransportEvent, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TransportEvent, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((TransportEvent)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<TransportEvent, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<TransportEvent, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TransportEvent, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((TransportEvent)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, TransportEvent>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private long _transportEventId;
	private long _commerceShipmentId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _carrier;
	private String _trackingNumber;
	private Date _expectedDate;
	private Date _shippingDate;
	private int _status;
	private String _commerceAccountName;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<TransportEvent, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((TransportEvent)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("transportEventId", _transportEventId);
		_columnOriginalValues.put("commerceShipmentId", _commerceShipmentId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("carrier", _carrier);
		_columnOriginalValues.put("trackingNumber", _trackingNumber);
		_columnOriginalValues.put("expectedDate", _expectedDate);
		_columnOriginalValues.put("shippingDate", _shippingDate);
		_columnOriginalValues.put("status", _status);
		_columnOriginalValues.put("commerceAccountName", _commerceAccountName);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("transportEventId", 2L);

		columnBitmasks.put("commerceShipmentId", 4L);

		columnBitmasks.put("groupId", 8L);

		columnBitmasks.put("companyId", 16L);

		columnBitmasks.put("userId", 32L);

		columnBitmasks.put("userName", 64L);

		columnBitmasks.put("createDate", 128L);

		columnBitmasks.put("modifiedDate", 256L);

		columnBitmasks.put("carrier", 512L);

		columnBitmasks.put("trackingNumber", 1024L);

		columnBitmasks.put("expectedDate", 2048L);

		columnBitmasks.put("shippingDate", 4096L);

		columnBitmasks.put("status", 8192L);

		columnBitmasks.put("commerceAccountName", 16384L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private TransportEvent _escapedModel;

}