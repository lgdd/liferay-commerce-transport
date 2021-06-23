/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or (at your option) any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.github.lgdd.liferay.commerce.transport.events.service.impl;

import com.github.lgdd.liferay.commerce.transport.events.model.TransportEvent;
import com.github.lgdd.liferay.commerce.transport.events.service.base.TransportEventLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import java.util.Date;
import java.util.List;
import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the transport event local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.github.lgdd.liferay.commerce.transport.events.service.TransportEventLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TransportEventLocalServiceBaseImpl
 */
@Component(
    property = "model.class.name=com.github.lgdd.liferay.commerce.transport.events.model.TransportEvent",
    service = AopService.class
)
public class TransportEventLocalServiceImpl
    extends TransportEventLocalServiceBaseImpl {

  /*
   * NOTE FOR DEVELOPERS:
   *
   * Never reference this class directly. Use <code>com.github.lgdd.liferay.commerce.transport.events.service.TransportEventLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.github.lgdd.liferay.commerce.transport.events.service.TransportEventLocalServiceUtil</code>.
   */
  public TransportEvent addTransportEvent(
      long groupId, long commerceShipmentId,
      String carrier, String trackingNumber,
      Date expectedDate, Date shippingDate,
      int status, String commerceAccountName, ServiceContext serviceContext)
      throws PortalException {

    // Get group and user.

    Group group = groupLocalService.getGroup(groupId);

    long userId = serviceContext.getUserId();

    User user = userLocalService.getUser(userId);

    // Generate primary key for the assignment.

    long transportEventId = counterLocalService.increment(TransportEvent.class.getName());

    TransportEvent transportEvent = createTransportEvent(transportEventId);

    transportEvent.setCompanyId(group.getCompanyId());
    transportEvent.setGroupId(groupId);

    transportEvent.setUserId(user.getUserId());
    transportEvent.setUserName(user.getFullName());
    transportEvent.setUserUuid(user.getUserUuid());

    transportEvent.setCreateDate(serviceContext.getCreateDate(new Date()));
    transportEvent.setModifiedDate(serviceContext.getModifiedDate(new Date()));

    transportEvent.setCommerceShipmentId(commerceShipmentId);
    transportEvent.setCarrier(carrier);
    transportEvent.setTrackingNumber(trackingNumber);
    transportEvent.setExpectedDate(expectedDate);
    transportEvent.setShippingDate(shippingDate);
    transportEvent.setStatus(status);
    transportEvent.setCommerceAccountName(commerceAccountName);

    return super.addTransportEvent(transportEvent);
  }

  public List<TransportEvent> getTransportEventsByCommerceShipmentId(long commerceShipmentId) {

    return transportEventPersistence.findByCommerceShipmentId(commerceShipmentId);
  }
}