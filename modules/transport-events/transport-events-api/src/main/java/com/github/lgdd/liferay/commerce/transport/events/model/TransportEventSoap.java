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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class TransportEventSoap implements Serializable {

	public static TransportEventSoap toSoapModel(TransportEvent model) {
		TransportEventSoap soapModel = new TransportEventSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setTransportEventId(model.getTransportEventId());
		soapModel.setCommerceShipmentId(model.getCommerceShipmentId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCarrier(model.getCarrier());
		soapModel.setTrackingNumber(model.getTrackingNumber());
		soapModel.setExpectedDate(model.getExpectedDate());
		soapModel.setShippingDate(model.getShippingDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setCommerceAccountName(model.getCommerceAccountName());

		return soapModel;
	}

	public static TransportEventSoap[] toSoapModels(TransportEvent[] models) {
		TransportEventSoap[] soapModels = new TransportEventSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TransportEventSoap[][] toSoapModels(
		TransportEvent[][] models) {

		TransportEventSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new TransportEventSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TransportEventSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TransportEventSoap[] toSoapModels(
		List<TransportEvent> models) {

		List<TransportEventSoap> soapModels = new ArrayList<TransportEventSoap>(
			models.size());

		for (TransportEvent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TransportEventSoap[soapModels.size()]);
	}

	public TransportEventSoap() {
	}

	public long getPrimaryKey() {
		return _transportEventId;
	}

	public void setPrimaryKey(long pk) {
		setTransportEventId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getTransportEventId() {
		return _transportEventId;
	}

	public void setTransportEventId(long transportEventId) {
		_transportEventId = transportEventId;
	}

	public long getCommerceShipmentId() {
		return _commerceShipmentId;
	}

	public void setCommerceShipmentId(long commerceShipmentId) {
		_commerceShipmentId = commerceShipmentId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getCarrier() {
		return _carrier;
	}

	public void setCarrier(String carrier) {
		_carrier = carrier;
	}

	public String getTrackingNumber() {
		return _trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		_trackingNumber = trackingNumber;
	}

	public Date getExpectedDate() {
		return _expectedDate;
	}

	public void setExpectedDate(Date expectedDate) {
		_expectedDate = expectedDate;
	}

	public Date getShippingDate() {
		return _shippingDate;
	}

	public void setShippingDate(Date shippingDate) {
		_shippingDate = shippingDate;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public String getCommerceAccountName() {
		return _commerceAccountName;
	}

	public void setCommerceAccountName(String commerceAccountName) {
		_commerceAccountName = commerceAccountName;
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
	private String _carrier;
	private String _trackingNumber;
	private Date _expectedDate;
	private Date _shippingDate;
	private int _status;
	private String _commerceAccountName;

}