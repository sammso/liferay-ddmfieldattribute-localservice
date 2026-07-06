/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.sohlman.ddmfieldattribute.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import com.sohlman.ddmfieldattribute.exception.NoSuchDDMFieldAttributeException;
import com.sohlman.ddmfieldattribute.model.DDMFieldAttribute;
import com.sohlman.ddmfieldattribute.service.DDMFieldAttributeLocalServiceUtil;
import com.sohlman.ddmfieldattribute.service.persistence.DDMFieldAttributePersistence;
import com.sohlman.ddmfieldattribute.service.persistence.DDMFieldAttributeUtil;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class DDMFieldAttributePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.sohlman.ddmfieldattribute.service"));

	@Before
	public void setUp() {
		_persistence = DDMFieldAttributeUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<DDMFieldAttribute> iterator = _ddmFieldAttributes.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DDMFieldAttribute ddmFieldAttribute = _persistence.create(pk);

		Assert.assertNotNull(ddmFieldAttribute);

		Assert.assertEquals(ddmFieldAttribute.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		DDMFieldAttribute newDDMFieldAttribute = addDDMFieldAttribute();

		_persistence.remove(newDDMFieldAttribute);

		DDMFieldAttribute existingDDMFieldAttribute =
			_persistence.fetchByPrimaryKey(
				newDDMFieldAttribute.getPrimaryKey());

		Assert.assertNull(existingDDMFieldAttribute);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addDDMFieldAttribute();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DDMFieldAttribute newDDMFieldAttribute = _persistence.create(pk);

		_ddmFieldAttributes.add(_persistence.update(newDDMFieldAttribute));

		DDMFieldAttribute existingDDMFieldAttribute =
			_persistence.findByPrimaryKey(newDDMFieldAttribute.getPrimaryKey());

		Assert.assertEquals(
			existingDDMFieldAttribute.getDdmFieldAttributeId(),
			newDDMFieldAttribute.getDdmFieldAttributeId());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		DDMFieldAttribute newDDMFieldAttribute = addDDMFieldAttribute();

		DDMFieldAttribute existingDDMFieldAttribute =
			_persistence.findByPrimaryKey(newDDMFieldAttribute.getPrimaryKey());

		Assert.assertEquals(existingDDMFieldAttribute, newDDMFieldAttribute);
	}

	@Test(expected = NoSuchDDMFieldAttributeException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<DDMFieldAttribute> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"DDMFA_DDMFieldAttribute", "ddmFieldAttributeId", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		DDMFieldAttribute newDDMFieldAttribute = addDDMFieldAttribute();

		DDMFieldAttribute existingDDMFieldAttribute =
			_persistence.fetchByPrimaryKey(
				newDDMFieldAttribute.getPrimaryKey());

		Assert.assertEquals(existingDDMFieldAttribute, newDDMFieldAttribute);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DDMFieldAttribute missingDDMFieldAttribute =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingDDMFieldAttribute);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		DDMFieldAttribute newDDMFieldAttribute1 = addDDMFieldAttribute();
		DDMFieldAttribute newDDMFieldAttribute2 = addDDMFieldAttribute();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDDMFieldAttribute1.getPrimaryKey());
		primaryKeys.add(newDDMFieldAttribute2.getPrimaryKey());

		Map<Serializable, DDMFieldAttribute> ddmFieldAttributes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, ddmFieldAttributes.size());
		Assert.assertEquals(
			newDDMFieldAttribute1,
			ddmFieldAttributes.get(newDDMFieldAttribute1.getPrimaryKey()));
		Assert.assertEquals(
			newDDMFieldAttribute2,
			ddmFieldAttributes.get(newDDMFieldAttribute2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, DDMFieldAttribute> ddmFieldAttributes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(ddmFieldAttributes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		DDMFieldAttribute newDDMFieldAttribute = addDDMFieldAttribute();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDDMFieldAttribute.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, DDMFieldAttribute> ddmFieldAttributes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, ddmFieldAttributes.size());
		Assert.assertEquals(
			newDDMFieldAttribute,
			ddmFieldAttributes.get(newDDMFieldAttribute.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, DDMFieldAttribute> ddmFieldAttributes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(ddmFieldAttributes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		DDMFieldAttribute newDDMFieldAttribute = addDDMFieldAttribute();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDDMFieldAttribute.getPrimaryKey());

		Map<Serializable, DDMFieldAttribute> ddmFieldAttributes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, ddmFieldAttributes.size());
		Assert.assertEquals(
			newDDMFieldAttribute,
			ddmFieldAttributes.get(newDDMFieldAttribute.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			DDMFieldAttributeLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<DDMFieldAttribute>() {

				@Override
				public void performAction(DDMFieldAttribute ddmFieldAttribute) {
					Assert.assertNotNull(ddmFieldAttribute);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		DDMFieldAttribute newDDMFieldAttribute = addDDMFieldAttribute();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DDMFieldAttribute.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"ddmFieldAttributeId",
				newDDMFieldAttribute.getDdmFieldAttributeId()));

		List<DDMFieldAttribute> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		DDMFieldAttribute existingDDMFieldAttribute = result.get(0);

		Assert.assertEquals(existingDDMFieldAttribute, newDDMFieldAttribute);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DDMFieldAttribute.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"ddmFieldAttributeId", RandomTestUtil.nextLong()));

		List<DDMFieldAttribute> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		DDMFieldAttribute newDDMFieldAttribute = addDDMFieldAttribute();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DDMFieldAttribute.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("ddmFieldAttributeId"));

		Object newDdmFieldAttributeId =
			newDDMFieldAttribute.getDdmFieldAttributeId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"ddmFieldAttributeId", new Object[] {newDdmFieldAttributeId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingDdmFieldAttributeId = result.get(0);

		Assert.assertEquals(
			existingDdmFieldAttributeId, newDdmFieldAttributeId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DDMFieldAttribute.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("ddmFieldAttributeId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"ddmFieldAttributeId",
				new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected DDMFieldAttribute addDDMFieldAttribute() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DDMFieldAttribute ddmFieldAttribute = _persistence.create(pk);

		_ddmFieldAttributes.add(_persistence.update(ddmFieldAttribute));

		return ddmFieldAttribute;
	}

	private List<DDMFieldAttribute> _ddmFieldAttributes =
		new ArrayList<DDMFieldAttribute>();
	private DDMFieldAttributePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}