/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.sohlman.ddmfieldattribute.service;

import com.liferay.portal.kernel.module.service.Snapshot;

/**
 * Provides the local service utility for DDMFieldAttribute. This utility wraps
 * <code>com.sohlman.ddmfieldattribute.service.impl.DDMFieldAttributeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DDMFieldAttributeLocalService
 * @generated
 */
public class DDMFieldAttributeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.sohlman.ddmfieldattribute.service.impl.DDMFieldAttributeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.dynamic.data.mapping.model.DDMFieldAttribute
		fetchByPrimaryKey(long fieldAttributeId) {

		return getService().fetchByPrimaryKey(fieldAttributeId);
	}

	public static com.liferay.dynamic.data.mapping.model.DDMFieldAttribute
			findByPrimaryKey(long fieldAttributeId)
		throws com.liferay.dynamic.data.mapping.exception.
			NoSuchFieldAttributeException {

		return getService().findByPrimaryKey(fieldAttributeId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.dynamic.data.mapping.model.DDMFieldAttribute
		update(
			com.liferay.dynamic.data.mapping.model.DDMFieldAttribute
				ddmFieldAttribute) {

		return getService().update(ddmFieldAttribute);
	}

	public static com.liferay.dynamic.data.mapping.model.DDMFieldAttribute
		update(
			com.liferay.dynamic.data.mapping.model.DDMFieldAttribute
				ddmFieldAttribute,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().update(ddmFieldAttribute, serviceContext);
	}

	public static DDMFieldAttributeLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<DDMFieldAttributeLocalService>
		_serviceSnapshot = new Snapshot<>(
			DDMFieldAttributeLocalServiceUtil.class,
			DDMFieldAttributeLocalService.class);

}