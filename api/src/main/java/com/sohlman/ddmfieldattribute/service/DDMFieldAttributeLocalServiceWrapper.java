/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.sohlman.ddmfieldattribute.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DDMFieldAttributeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DDMFieldAttributeLocalService
 * @generated
 */
public class DDMFieldAttributeLocalServiceWrapper
	implements DDMFieldAttributeLocalService,
			   ServiceWrapper<DDMFieldAttributeLocalService> {

	public DDMFieldAttributeLocalServiceWrapper() {
		this(null);
	}

	public DDMFieldAttributeLocalServiceWrapper(
		DDMFieldAttributeLocalService ddmFieldAttributeLocalService) {

		_ddmFieldAttributeLocalService = ddmFieldAttributeLocalService;
	}

	@Override
	public com.liferay.dynamic.data.mapping.model.DDMFieldAttribute
		fetchByPrimaryKey(long fieldAttributeId) {

		return _ddmFieldAttributeLocalService.fetchByPrimaryKey(
			fieldAttributeId);
	}

	@Override
	public com.liferay.dynamic.data.mapping.model.DDMFieldAttribute
			findByPrimaryKey(long fieldAttributeId)
		throws com.liferay.dynamic.data.mapping.exception.
			NoSuchFieldAttributeException {

		return _ddmFieldAttributeLocalService.findByPrimaryKey(
			fieldAttributeId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ddmFieldAttributeLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.dynamic.data.mapping.model.DDMFieldAttribute update(
		com.liferay.dynamic.data.mapping.model.DDMFieldAttribute
			ddmFieldAttribute) {

		return _ddmFieldAttributeLocalService.update(ddmFieldAttribute);
	}

	@Override
	public com.liferay.dynamic.data.mapping.model.DDMFieldAttribute update(
		com.liferay.dynamic.data.mapping.model.DDMFieldAttribute
			ddmFieldAttribute,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _ddmFieldAttributeLocalService.update(
			ddmFieldAttribute, serviceContext);
	}

	@Override
	public DDMFieldAttributeLocalService getWrappedService() {
		return _ddmFieldAttributeLocalService;
	}

	@Override
	public void setWrappedService(
		DDMFieldAttributeLocalService ddmFieldAttributeLocalService) {

		_ddmFieldAttributeLocalService = ddmFieldAttributeLocalService;
	}

	private DDMFieldAttributeLocalService _ddmFieldAttributeLocalService;

}