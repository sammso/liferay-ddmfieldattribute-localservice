/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.sohlman.ddmfieldattribute.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the DDMFieldAttribute service. Represents a row in the &quot;DDMFA_DDMFieldAttribute&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see DDMFieldAttributeModel
 * @generated
 */
@ImplementationClassName(
	"com.sohlman.ddmfieldattribute.model.impl.DDMFieldAttributeImpl"
)
@ProviderType
public interface DDMFieldAttribute
	extends DDMFieldAttributeModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.sohlman.ddmfieldattribute.model.impl.DDMFieldAttributeImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<DDMFieldAttribute, Long>
		DDM_FIELD_ATTRIBUTE_ID_ACCESSOR =
			new Accessor<DDMFieldAttribute, Long>() {

				@Override
				public Long get(DDMFieldAttribute ddmFieldAttribute) {
					return ddmFieldAttribute.getDdmFieldAttributeId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<DDMFieldAttribute> getTypeClass() {
					return DDMFieldAttribute.class;
				}

			};

}