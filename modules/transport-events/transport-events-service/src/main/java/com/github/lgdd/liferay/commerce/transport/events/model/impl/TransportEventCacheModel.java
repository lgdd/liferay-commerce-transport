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

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TransportEvent in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TransportEventCacheModel
	implements CacheModel<TransportEvent>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TransportEventCacheModel)) {
			return false;
		}

		TransportEventCacheModel transportEventCacheModel =
			(TransportEventCacheModel)object;

		if (transportEventId == transportEventCacheModel.transportEventId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, transportEventId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", transportEventId=");
		sb.append(transportEventId);
		sb.append(", commerceShipmentId=");
		sb.append(commerceShipmentId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", carrier=");
		sb.append(carrier);
		sb.append(", trackingNumber=");
		sb.append(trackingNumber);
		sb.append(", expectedDate=");
		sb.append(expectedDate);
		sb.append(", shippingDate=");
		sb.append(shippingDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", commerceAccountName=");
		sb.append(commerceAccountName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TransportEvent toEntityModel() {
		TransportEventImpl transportEventImpl = new TransportEventImpl();

		if (uuid == null) {
			transportEventImpl.setUuid("");
		}
		else {
			transportEventImpl.setUuid(uuid);
		}

		transportEventImpl.setTransportEventId(transportEventId);
		transportEventImpl.setCommerceShipmentId(commerceShipmentId);
		transportEventImpl.setGroupId(groupId);
		transportEventImpl.setCompanyId(companyId);
		transportEventImpl.setUserId(userId);

		if (userName == null) {
			transportEventImpl.setUserName("");
		}
		else {
			transportEventImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			transportEventImpl.setCreateDate(null);
		}
		else {
			transportEventImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			transportEventImpl.setModifiedDate(null);
		}
		else {
			transportEventImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (carrier == null) {
			transportEventImpl.setCarrier("");
		}
		else {
			transportEventImpl.setCarrier(carrier);
		}

		if (trackingNumber == null) {
			transportEventImpl.setTrackingNumber("");
		}
		else {
			transportEventImpl.setTrackingNumber(trackingNumber);
		}

		if (expectedDate == Long.MIN_VALUE) {
			transportEventImpl.setExpectedDate(null);
		}
		else {
			transportEventImpl.setExpectedDate(new Date(expectedDate));
		}

		if (shippingDate == Long.MIN_VALUE) {
			transportEventImpl.setShippingDate(null);
		}
		else {
			transportEventImpl.setShippingDate(new Date(shippingDate));
		}

		transportEventImpl.setStatus(status);

		if (commerceAccountName == null) {
			transportEventImpl.setCommerceAccountName("");
		}
		else {
			transportEventImpl.setCommerceAccountName(commerceAccountName);
		}

		transportEventImpl.resetOriginalValues();

		return transportEventImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		transportEventId = objectInput.readLong();

		commerceShipmentId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		carrier = objectInput.readUTF();
		trackingNumber = objectInput.readUTF();
		expectedDate = objectInput.readLong();
		shippingDate = objectInput.readLong();

		status = objectInput.readInt();
		commerceAccountName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(transportEventId);

		objectOutput.writeLong(commerceShipmentId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (carrier == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(carrier);
		}

		if (trackingNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(trackingNumber);
		}

		objectOutput.writeLong(expectedDate);
		objectOutput.writeLong(shippingDate);

		objectOutput.writeInt(status);

		if (commerceAccountName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(commerceAccountName);
		}
	}

	public String uuid;
	public long transportEventId;
	public long commerceShipmentId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String carrier;
	public String trackingNumber;
	public long expectedDate;
	public long shippingDate;
	public int status;
	public String commerceAccountName;

}