/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.sohlman.ddmfieldattribute.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchDDMFieldAttributeException extends NoSuchModelException {

	public NoSuchDDMFieldAttributeException() {
	}

	public NoSuchDDMFieldAttributeException(String msg) {
		super(msg);
	}

	public NoSuchDDMFieldAttributeException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchDDMFieldAttributeException(Throwable throwable) {
		super(throwable);
	}

}