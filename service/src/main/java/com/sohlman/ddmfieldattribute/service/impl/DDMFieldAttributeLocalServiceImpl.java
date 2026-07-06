/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.sohlman.ddmfieldattribute.service.impl;

import com.liferay.dynamic.data.mapping.exception.NoSuchFieldAttributeException;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.service.ServiceContext;
import com.sohlman.ddmfieldattribute.service.base.DDMFieldAttributeLocalServiceBaseImpl;

import com.liferay.dynamic.data.mapping.service.persistence.DDMFieldAttributePersistence;
import com.liferay.dynamic.data.mapping.model.DDMFieldAttribute;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.dynamic.data.mapping.model.DDMFieldAttribute",
	service = AopService.class
)
public class DDMFieldAttributeLocalServiceImpl
	extends DDMFieldAttributeLocalServiceBaseImpl {

	public DDMFieldAttribute fetchByPrimaryKey(long fieldAttributeId) {
		return ddmDDMFieldAttributePersistence.fetchByPrimaryKey(fieldAttributeId);
	}

	public DDMFieldAttribute findByPrimaryKey(long fieldAttributeId)
			throws NoSuchFieldAttributeException {
		return ddmDDMFieldAttributePersistence.findByPrimaryKey(fieldAttributeId);
	}

	public DDMFieldAttribute update(DDMFieldAttribute ddmFieldAttribute) {
		return ddmDDMFieldAttributePersistence.update(ddmFieldAttribute);
	}

	public DDMFieldAttribute update(DDMFieldAttribute ddmFieldAttribute, ServiceContext serviceContext) {
		return ddmDDMFieldAttributePersistence.update(ddmFieldAttribute,serviceContext);
	}

	@Reference
	private DDMFieldAttributePersistence ddmDDMFieldAttributePersistence;
}