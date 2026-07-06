/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.sohlman.ddmfieldattribute.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.sohlman.ddmfieldattribute.model.DDMFieldAttribute;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the ddm field attribute service. This utility wraps <code>com.sohlman.ddmfieldattribute.service.persistence.impl.DDMFieldAttributePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DDMFieldAttributePersistence
 * @generated
 */
public class DDMFieldAttributeUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(DDMFieldAttribute ddmFieldAttribute) {
		getPersistence().clearCache(ddmFieldAttribute);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, DDMFieldAttribute> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DDMFieldAttribute> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DDMFieldAttribute> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DDMFieldAttribute> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DDMFieldAttribute> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DDMFieldAttribute update(
		DDMFieldAttribute ddmFieldAttribute) {

		return getPersistence().update(ddmFieldAttribute);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DDMFieldAttribute update(
		DDMFieldAttribute ddmFieldAttribute, ServiceContext serviceContext) {

		return getPersistence().update(ddmFieldAttribute, serviceContext);
	}

	/**
	 * Caches the ddm field attribute in the entity cache if it is enabled.
	 *
	 * @param ddmFieldAttribute the ddm field attribute
	 */
	public static void cacheResult(DDMFieldAttribute ddmFieldAttribute) {
		getPersistence().cacheResult(ddmFieldAttribute);
	}

	/**
	 * Caches the ddm field attributes in the entity cache if it is enabled.
	 *
	 * @param ddmFieldAttributes the ddm field attributes
	 */
	public static void cacheResult(List<DDMFieldAttribute> ddmFieldAttributes) {
		getPersistence().cacheResult(ddmFieldAttributes);
	}

	/**
	 * Creates a new ddm field attribute with the primary key. Does not add the ddm field attribute to the database.
	 *
	 * @param ddmFieldAttributeId the primary key for the new ddm field attribute
	 * @return the new ddm field attribute
	 */
	public static DDMFieldAttribute create(long ddmFieldAttributeId) {
		return getPersistence().create(ddmFieldAttributeId);
	}

	/**
	 * Removes the ddm field attribute with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ddmFieldAttributeId the primary key of the ddm field attribute
	 * @return the ddm field attribute that was removed
	 * @throws NoSuchDDMFieldAttributeException if a ddm field attribute with the primary key could not be found
	 */
	public static DDMFieldAttribute remove(long ddmFieldAttributeId)
		throws com.sohlman.ddmfieldattribute.exception.
			NoSuchDDMFieldAttributeException {

		return getPersistence().remove(ddmFieldAttributeId);
	}

	public static DDMFieldAttribute updateImpl(
		DDMFieldAttribute ddmFieldAttribute) {

		return getPersistence().updateImpl(ddmFieldAttribute);
	}

	/**
	 * Returns the ddm field attribute with the primary key or throws a <code>NoSuchDDMFieldAttributeException</code> if it could not be found.
	 *
	 * @param ddmFieldAttributeId the primary key of the ddm field attribute
	 * @return the ddm field attribute
	 * @throws NoSuchDDMFieldAttributeException if a ddm field attribute with the primary key could not be found
	 */
	public static DDMFieldAttribute findByPrimaryKey(long ddmFieldAttributeId)
		throws com.sohlman.ddmfieldattribute.exception.
			NoSuchDDMFieldAttributeException {

		return getPersistence().findByPrimaryKey(ddmFieldAttributeId);
	}

	/**
	 * Returns the ddm field attribute with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ddmFieldAttributeId the primary key of the ddm field attribute
	 * @return the ddm field attribute, or <code>null</code> if a ddm field attribute with the primary key could not be found
	 */
	public static DDMFieldAttribute fetchByPrimaryKey(
		long ddmFieldAttributeId) {

		return getPersistence().fetchByPrimaryKey(ddmFieldAttributeId);
	}

	/**
	 * Returns all the ddm field attributes.
	 *
	 * @return the ddm field attributes
	 */
	public static List<DDMFieldAttribute> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the ddm field attributes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DDMFieldAttributeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ddm field attributes
	 * @param end the upper bound of the range of ddm field attributes (not inclusive)
	 * @return the range of ddm field attributes
	 */
	public static List<DDMFieldAttribute> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the ddm field attributes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DDMFieldAttributeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ddm field attributes
	 * @param end the upper bound of the range of ddm field attributes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ddm field attributes
	 */
	public static List<DDMFieldAttribute> findAll(
		int start, int end,
		OrderByComparator<DDMFieldAttribute> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ddm field attributes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DDMFieldAttributeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ddm field attributes
	 * @param end the upper bound of the range of ddm field attributes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ddm field attributes
	 */
	public static List<DDMFieldAttribute> findAll(
		int start, int end,
		OrderByComparator<DDMFieldAttribute> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ddm field attributes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ddm field attributes.
	 *
	 * @return the number of ddm field attributes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DDMFieldAttributePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		DDMFieldAttributePersistence persistence) {

		_persistence = persistence;
	}

	private static volatile DDMFieldAttributePersistence _persistence;

}