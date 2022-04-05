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

package com.github.lgdd.liferay.commerce.transport.events.listener;

import com.github.lgdd.liferay.commerce.transport.events.model.TransportEvent;
import com.github.lgdd.liferay.commerce.transport.events.service.TransportEventLocalService;
import com.liferay.commerce.model.CommerceShipment;
import com.liferay.commerce.product.model.CProduct;
import com.liferay.friendly.url.exception.DuplicateFriendlyURLEntryException;
import com.liferay.friendly.url.exception.NoSuchFriendlyURLEntryMappingException;
import com.liferay.friendly.url.model.FriendlyURLEntry;
import com.liferay.friendly.url.service.FriendlyURLEntryLocalService;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.service.ClassNameLocalService;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.transaction.TransactionCommitCallbackUtil;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true, service = ModelListener.class)
public class ShipmentListener
    extends BaseModelListener<CommerceShipment> {

	public static final Logger log = LoggerFactory.getLogger(
		ShipmentListener.class);

	@Override
	public void onAfterCreate(CommerceShipment shipment)
		throws ModelListenerException {

		registerEvent(shipment);

		super.onAfterCreate(shipment);
	}

	@Override
	public void onAfterRemove(CommerceShipment shipment)
		throws ModelListenerException {

		registerEvent(shipment);
		updateFriendlyURLEntries(shipment);

		super.onAfterRemove(shipment);
	}

	@Override
	public void onAfterUpdate(CommerceShipment originalShipment, CommerceShipment shipment)
		throws ModelListenerException {

		registerEvent(originalShipment);
		updateFriendlyURLEntries(originalShipment);

		super.onAfterUpdate(originalShipment,shipment);
	}

	protected void registerEvent(CommerceShipment shipment)
		throws ModelListenerException {

		TransactionCommitCallbackUtil.registerCallback(
			() -> {
				ServiceContext serviceContext =
					ServiceContextThreadLocal.getServiceContext();

				try {
					TransportEvent transportEvent =
						_transportEventLocalService.addTransportEvent(
							shipment.getGroupId(),
							shipment.getCommerceShipmentId(),
							shipment.getCarrier(), shipment.getTrackingNumber(),
							shipment.getExpectedDate(),
							shipment.getShippingDate(), shipment.getStatus(),
							shipment.getCommerceAccountName(), serviceContext);

					log.info(
						"Register new transport event: {}",
						transportEvent.toString());
				}
				catch (PortalException e) {
					throw new ModelListenerException(e);
				}

				return null;
			});
	}

	protected void updateFriendlyURLEntries(CommerceShipment shipment) {
		TransactionCommitCallbackUtil.registerCallback(
			() -> {
				log.info("updateFriendlyURLEntries");

				try {
					ServiceContext serviceContext =
						ServiceContextThreadLocal.getServiceContext();

					long companyId = serviceContext.getCompanyId();

					long classNameId = _classNameLocalService.getClassNameId(
						CProduct.class);
					long classPK = shipment.getCommerceShipmentId();

					Group companyGroup = _groupLocalService.getCompanyGroup(
						companyId);

					Set<Locale> locales =
						LanguageUtil.getCompanyAvailableLocales(companyId);
					Map<String, String> newUrlTitleMap = new HashMap<>();

					for (Locale locale : locales) {
						log.debug(
							"{}: {}", LanguageUtil.getLanguageId(locale),
							classPK);
						newUrlTitleMap.put(
							LanguageUtil.getLanguageId(locale),
							String.valueOf(classPK));
					}

					try {
						log.debug("newUrlTitleMap");
						FriendlyURLEntry friendlyURLEntry =
							_friendlyURLEntryLocalService.
								getMainFriendlyURLEntry(classNameId, classPK);

						try {
							_friendlyURLEntryLocalService.
								updateFriendlyURLEntry(
									friendlyURLEntry.getFriendlyURLEntryId(),
									friendlyURLEntry.getClassNameId(),
									friendlyURLEntry.getClassPK(),
									friendlyURLEntry.getDefaultLanguageId(),
									newUrlTitleMap);
						}
						catch (DuplicateFriendlyURLEntryException e) {
							Map<String, String> friendlyURLTitleNames =
								_createFriendlyURLName(
									newUrlTitleMap, companyGroup.getGroupId(),
									friendlyURLEntry, classPK);

							_friendlyURLEntryLocalService.
								updateFriendlyURLEntry(
									friendlyURLEntry.getFriendlyURLEntryId(),
									friendlyURLEntry.getClassNameId(),
									friendlyURLEntry.getClassPK(),
									friendlyURLEntry.getDefaultLanguageId(),
									friendlyURLTitleNames);
						}
					}
					catch (NoSuchFriendlyURLEntryMappingException e) {
						_friendlyURLEntryLocalService.addFriendlyURLEntry(
							companyGroup.getGroupId(), classNameId, classPK,
							newUrlTitleMap, serviceContext);
					}
				}
				catch (PortalException e) {
					throw new ModelListenerException(e);
				}

				return null;
			});
	}

	private Map<String, String> _createFriendlyURLName(
		Map<String, String> duplicateUrlTitleMap, long companyGroupId,
		FriendlyURLEntry friendlyURLEntry, long shipmentId) {

		Map<String, String> newUrlTitleMap = new HashMap<>();

		for (Map.Entry<String, String> nameEntry :
				duplicateUrlTitleMap.entrySet()) {

			String uniqueUrlTitle =
				_friendlyURLEntryLocalService.getUniqueUrlTitle(
					companyGroupId, friendlyURLEntry.getClassNameId(),
					friendlyURLEntry.getClassPK(), String.valueOf(shipmentId));

			if (uniqueUrlTitle != null) {
				newUrlTitleMap.put(
					nameEntry.getKey(), String.valueOf(shipmentId));
			}
			else {
				newUrlTitleMap.put(
					nameEntry.getKey(), String.valueOf(shipmentId));
			}
		}

		return newUrlTitleMap;
	}

	@Reference
	private ClassNameLocalService _classNameLocalService;

	@Reference
	private FriendlyURLEntryLocalService _friendlyURLEntryLocalService;

	@Reference
	private GroupLocalService _groupLocalService;

	@Reference
	private TransportEventLocalService _transportEventLocalService;

}