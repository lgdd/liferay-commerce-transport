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

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TransportEventPK
	implements Comparable<TransportEventPK>, Serializable {

	public long transportEventId;
	public long commerceShipmentId;

	public TransportEventPK() {
	}

	public TransportEventPK(long transportEventId, long commerceShipmentId) {
		this.transportEventId = transportEventId;
		this.commerceShipmentId = commerceShipmentId;
	}

	public long getTransportEventId() {
		return transportEventId;
	}

	public void setTransportEventId(long transportEventId) {
		this.transportEventId = transportEventId;
	}

	public long getCommerceShipmentId() {
		return commerceShipmentId;
	}

	public void setCommerceShipmentId(long commerceShipmentId) {
		this.commerceShipmentId = commerceShipmentId;
	}

	@Override
	public int compareTo(TransportEventPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (transportEventId < pk.transportEventId) {
			value = -1;
		}
		else if (transportEventId > pk.transportEventId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (commerceShipmentId < pk.commerceShipmentId) {
			value = -1;
		}
		else if (commerceShipmentId > pk.commerceShipmentId) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(object instanceof TransportEventPK)) {
			return false;
		}

		TransportEventPK pk = (TransportEventPK)object;

		if ((transportEventId == pk.transportEventId) &&
			(commerceShipmentId == pk.commerceShipmentId)) {

			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, transportEventId);
		hashCode = HashUtil.hash(hashCode, commerceShipmentId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("transportEventId=");

		sb.append(transportEventId);
		sb.append(", commerceShipmentId=");

		sb.append(commerceShipmentId);

		sb.append("}");

		return sb.toString();
	}

}