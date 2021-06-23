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

package com.github.lgdd.liferay.commerce.transport.events.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TransportEvent}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TransportEvent
 * @generated
 */
public class TransportEventWrapper
	extends BaseModelWrapper<TransportEvent>
	implements ModelWrapper<TransportEvent>, TransportEvent {

	public TransportEventWrapper(TransportEvent transportEvent) {
		super(transportEvent);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("transportEventId", getTransportEventId());
		attributes.put("commerceShipmentId", getCommerceShipmentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("carrier", getCarrier());
		attributes.put("trackingNumber", getTrackingNumber());
		attributes.put("expectedDate", getExpectedDate());
		attributes.put("shippingDate", getShippingDate());
		attributes.put("status", getStatus());
		attributes.put("commerceAccountName", getCommerceAccountName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long transportEventId = (Long)attributes.get("transportEventId");

		if (transportEventId != null) {
			setTransportEventId(transportEventId);
		}

		Long commerceShipmentId = (Long)attributes.get("commerceShipmentId");

		if (commerceShipmentId != null) {
			setCommerceShipmentId(commerceShipmentId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String carrier = (String)attributes.get("carrier");

		if (carrier != null) {
			setCarrier(carrier);
		}

		String trackingNumber = (String)attributes.get("trackingNumber");

		if (trackingNumber != null) {
			setTrackingNumber(trackingNumber);
		}

		Date expectedDate = (Date)attributes.get("expectedDate");

		if (expectedDate != null) {
			setExpectedDate(expectedDate);
		}

		Date shippingDate = (Date)attributes.get("shippingDate");

		if (shippingDate != null) {
			setShippingDate(shippingDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String commerceAccountName = (String)attributes.get(
			"commerceAccountName");

		if (commerceAccountName != null) {
			setCommerceAccountName(commerceAccountName);
		}
	}

	/**
	 * Returns the carrier of this transport event.
	 *
	 * @return the carrier of this transport event
	 */
	@Override
	public String getCarrier() {
		return model.getCarrier();
	}

	/**
	 * Returns the commerce account name of this transport event.
	 *
	 * @return the commerce account name of this transport event
	 */
	@Override
	public String getCommerceAccountName() {
		return model.getCommerceAccountName();
	}

	/**
	 * Returns the commerce shipment ID of this transport event.
	 *
	 * @return the commerce shipment ID of this transport event
	 */
	@Override
	public long getCommerceShipmentId() {
		return model.getCommerceShipmentId();
	}

	/**
	 * Returns the company ID of this transport event.
	 *
	 * @return the company ID of this transport event
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this transport event.
	 *
	 * @return the create date of this transport event
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the expected date of this transport event.
	 *
	 * @return the expected date of this transport event
	 */
	@Override
	public Date getExpectedDate() {
		return model.getExpectedDate();
	}

	/**
	 * Returns the group ID of this transport event.
	 *
	 * @return the group ID of this transport event
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this transport event.
	 *
	 * @return the modified date of this transport event
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this transport event.
	 *
	 * @return the primary key of this transport event
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the shipping date of this transport event.
	 *
	 * @return the shipping date of this transport event
	 */
	@Override
	public Date getShippingDate() {
		return model.getShippingDate();
	}

	/**
	 * Returns the status of this transport event.
	 *
	 * @return the status of this transport event
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the tracking number of this transport event.
	 *
	 * @return the tracking number of this transport event
	 */
	@Override
	public String getTrackingNumber() {
		return model.getTrackingNumber();
	}

	/**
	 * Returns the transport event ID of this transport event.
	 *
	 * @return the transport event ID of this transport event
	 */
	@Override
	public long getTransportEventId() {
		return model.getTransportEventId();
	}

	/**
	 * Returns the user ID of this transport event.
	 *
	 * @return the user ID of this transport event
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this transport event.
	 *
	 * @return the user name of this transport event
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this transport event.
	 *
	 * @return the user uuid of this transport event
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this transport event.
	 *
	 * @return the uuid of this transport event
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the carrier of this transport event.
	 *
	 * @param carrier the carrier of this transport event
	 */
	@Override
	public void setCarrier(String carrier) {
		model.setCarrier(carrier);
	}

	/**
	 * Sets the commerce account name of this transport event.
	 *
	 * @param commerceAccountName the commerce account name of this transport event
	 */
	@Override
	public void setCommerceAccountName(String commerceAccountName) {
		model.setCommerceAccountName(commerceAccountName);
	}

	/**
	 * Sets the commerce shipment ID of this transport event.
	 *
	 * @param commerceShipmentId the commerce shipment ID of this transport event
	 */
	@Override
	public void setCommerceShipmentId(long commerceShipmentId) {
		model.setCommerceShipmentId(commerceShipmentId);
	}

	/**
	 * Sets the company ID of this transport event.
	 *
	 * @param companyId the company ID of this transport event
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this transport event.
	 *
	 * @param createDate the create date of this transport event
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the expected date of this transport event.
	 *
	 * @param expectedDate the expected date of this transport event
	 */
	@Override
	public void setExpectedDate(Date expectedDate) {
		model.setExpectedDate(expectedDate);
	}

	/**
	 * Sets the group ID of this transport event.
	 *
	 * @param groupId the group ID of this transport event
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this transport event.
	 *
	 * @param modifiedDate the modified date of this transport event
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this transport event.
	 *
	 * @param primaryKey the primary key of this transport event
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the shipping date of this transport event.
	 *
	 * @param shippingDate the shipping date of this transport event
	 */
	@Override
	public void setShippingDate(Date shippingDate) {
		model.setShippingDate(shippingDate);
	}

	/**
	 * Sets the status of this transport event.
	 *
	 * @param status the status of this transport event
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the tracking number of this transport event.
	 *
	 * @param trackingNumber the tracking number of this transport event
	 */
	@Override
	public void setTrackingNumber(String trackingNumber) {
		model.setTrackingNumber(trackingNumber);
	}

	/**
	 * Sets the transport event ID of this transport event.
	 *
	 * @param transportEventId the transport event ID of this transport event
	 */
	@Override
	public void setTransportEventId(long transportEventId) {
		model.setTransportEventId(transportEventId);
	}

	/**
	 * Sets the user ID of this transport event.
	 *
	 * @param userId the user ID of this transport event
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this transport event.
	 *
	 * @param userName the user name of this transport event
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this transport event.
	 *
	 * @param userUuid the user uuid of this transport event
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this transport event.
	 *
	 * @param uuid the uuid of this transport event
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected TransportEventWrapper wrap(TransportEvent transportEvent) {
		return new TransportEventWrapper(transportEvent);
	}

}