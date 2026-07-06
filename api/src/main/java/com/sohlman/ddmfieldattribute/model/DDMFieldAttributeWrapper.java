/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.sohlman.ddmfieldattribute.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DDMFieldAttribute}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DDMFieldAttribute
 * @generated
 */
public class DDMFieldAttributeWrapper
	extends BaseModelWrapper<DDMFieldAttribute>
	implements DDMFieldAttribute, ModelWrapper<DDMFieldAttribute> {

	public DDMFieldAttributeWrapper(DDMFieldAttribute ddmFieldAttribute) {
		super(ddmFieldAttribute);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ddmFieldAttributeId", getDdmFieldAttributeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ddmFieldAttributeId = (Long)attributes.get("ddmFieldAttributeId");

		if (ddmFieldAttributeId != null) {
			setDdmFieldAttributeId(ddmFieldAttributeId);
		}
	}

	@Override
	public DDMFieldAttribute cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the ddm field attribute ID of this ddm field attribute.
	 *
	 * @return the ddm field attribute ID of this ddm field attribute
	 */
	@Override
	public long getDdmFieldAttributeId() {
		return model.getDdmFieldAttributeId();
	}

	/**
	 * Returns the primary key of this ddm field attribute.
	 *
	 * @return the primary key of this ddm field attribute
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the ddm field attribute ID of this ddm field attribute.
	 *
	 * @param ddmFieldAttributeId the ddm field attribute ID of this ddm field attribute
	 */
	@Override
	public void setDdmFieldAttributeId(long ddmFieldAttributeId) {
		model.setDdmFieldAttributeId(ddmFieldAttributeId);
	}

	/**
	 * Sets the primary key of this ddm field attribute.
	 *
	 * @param primaryKey the primary key of this ddm field attribute
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected DDMFieldAttributeWrapper wrap(
		DDMFieldAttribute ddmFieldAttribute) {

		return new DDMFieldAttributeWrapper(ddmFieldAttribute);
	}

}