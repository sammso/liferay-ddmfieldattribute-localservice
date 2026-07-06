/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.sohlman.ddmfieldattribute.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.sohlman.ddmfieldattribute.model.DDMFieldAttribute;
import com.sohlman.ddmfieldattribute.service.base.DDMFieldAttributeLocalServiceBaseImpl;
import com.sohlman.ddmfieldattribute.service.persistence.DDMFieldAttributePersistence;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.sohlman.ddmfieldattribute.model.DDMFieldAttribute",
	service = AopService.class
)
public class DDMFieldAttributeLocalServiceImpl
	extends DDMFieldAttributeLocalServiceBaseImpl {

	public DDMFieldAttribute addDDMFieldAttribute(
		DDMFieldAttribute ddmFieldAttribute) {

		return _ddmFieldAttributePersistence.update(ddmFieldAttribute);
	}

	public DDMFieldAttribute createDDMFieldAttribute(
		long ddmFieldAttributeId) {

		return _ddmFieldAttributePersistence.create(ddmFieldAttributeId);
	}

	public DDMFieldAttribute deleteDDMFieldAttribute(
		DDMFieldAttribute ddmFieldAttribute) {

		return _ddmFieldAttributePersistence.remove(ddmFieldAttribute);
	}

	public DDMFieldAttribute deleteDDMFieldAttribute(long ddmFieldAttributeId)
		throws PortalException {

		return _ddmFieldAttributePersistence.remove(ddmFieldAttributeId);
	}

	public DDMFieldAttribute fetchDDMFieldAttribute(long ddmFieldAttributeId) {
		return _ddmFieldAttributePersistence.fetchByPrimaryKey(
			ddmFieldAttributeId);
	}

	public DDMFieldAttribute getDDMFieldAttribute(long ddmFieldAttributeId)
		throws PortalException {

		return _ddmFieldAttributePersistence.findByPrimaryKey(
			ddmFieldAttributeId);
	}

	public List<DDMFieldAttribute> getDDMFieldAttributes() {
		return _ddmFieldAttributePersistence.findAll();
	}

	public List<DDMFieldAttribute> getDDMFieldAttributes(int start, int end) {
		return _ddmFieldAttributePersistence.findAll(start, end);
	}

	public List<DDMFieldAttribute> getDDMFieldAttributes(
		int start, int end,
		OrderByComparator<DDMFieldAttribute> orderByComparator) {

		return _ddmFieldAttributePersistence.findAll(
			start, end, orderByComparator);
	}

	public int getDDMFieldAttributesCount() {
		return _ddmFieldAttributePersistence.countAll();
	}

	public DDMFieldAttribute updateDDMFieldAttribute(
		DDMFieldAttribute ddmFieldAttribute) {

		return _ddmFieldAttributePersistence.update(ddmFieldAttribute);
	}

	@Reference
	private DDMFieldAttributePersistence _ddmFieldAttributePersistence;

}