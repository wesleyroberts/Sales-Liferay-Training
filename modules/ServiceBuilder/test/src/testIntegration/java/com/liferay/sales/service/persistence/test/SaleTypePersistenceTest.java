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

package com.liferay.sales.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.test.AssertUtils;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;
import com.liferay.sales.exception.NoSuchSaleTypeException;
import com.liferay.sales.model.SaleType;
import com.liferay.sales.service.SaleTypeLocalServiceUtil;
import com.liferay.sales.service.persistence.SaleTypePersistence;
import com.liferay.sales.service.persistence.SaleTypeUtil;

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
public class SaleTypePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.liferay.sales.service"));

	@Before
	public void setUp() {
		_persistence = SaleTypeUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<SaleType> iterator = _saleTypes.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SaleType saleType = _persistence.create(pk);

		Assert.assertNotNull(saleType);

		Assert.assertEquals(saleType.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		SaleType newSaleType = addSaleType();

		_persistence.remove(newSaleType);

		SaleType existingSaleType = _persistence.fetchByPrimaryKey(
			newSaleType.getPrimaryKey());

		Assert.assertNull(existingSaleType);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addSaleType();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SaleType newSaleType = _persistence.create(pk);

		newSaleType.setName(RandomTestUtil.randomString());

		newSaleType.setTax(RandomTestUtil.nextDouble());

		_saleTypes.add(_persistence.update(newSaleType));

		SaleType existingSaleType = _persistence.findByPrimaryKey(
			newSaleType.getPrimaryKey());

		Assert.assertEquals(
			existingSaleType.getTypeId(), newSaleType.getTypeId());
		Assert.assertEquals(existingSaleType.getName(), newSaleType.getName());
		AssertUtils.assertEquals(
			existingSaleType.getTax(), newSaleType.getTax());
	}

	@Test
	public void testCountByName() throws Exception {
		_persistence.countByName("");

		_persistence.countByName("null");

		_persistence.countByName((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		SaleType newSaleType = addSaleType();

		SaleType existingSaleType = _persistence.findByPrimaryKey(
			newSaleType.getPrimaryKey());

		Assert.assertEquals(existingSaleType, newSaleType);
	}

	@Test(expected = NoSuchSaleTypeException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<SaleType> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"SalesTaxe_SaleType", "typeId", true, "name", true, "tax", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		SaleType newSaleType = addSaleType();

		SaleType existingSaleType = _persistence.fetchByPrimaryKey(
			newSaleType.getPrimaryKey());

		Assert.assertEquals(existingSaleType, newSaleType);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SaleType missingSaleType = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingSaleType);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		SaleType newSaleType1 = addSaleType();
		SaleType newSaleType2 = addSaleType();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSaleType1.getPrimaryKey());
		primaryKeys.add(newSaleType2.getPrimaryKey());

		Map<Serializable, SaleType> saleTypes = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, saleTypes.size());
		Assert.assertEquals(
			newSaleType1, saleTypes.get(newSaleType1.getPrimaryKey()));
		Assert.assertEquals(
			newSaleType2, saleTypes.get(newSaleType2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, SaleType> saleTypes = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(saleTypes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		SaleType newSaleType = addSaleType();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSaleType.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, SaleType> saleTypes = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, saleTypes.size());
		Assert.assertEquals(
			newSaleType, saleTypes.get(newSaleType.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, SaleType> saleTypes = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(saleTypes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		SaleType newSaleType = addSaleType();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSaleType.getPrimaryKey());

		Map<Serializable, SaleType> saleTypes = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, saleTypes.size());
		Assert.assertEquals(
			newSaleType, saleTypes.get(newSaleType.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			SaleTypeLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<SaleType>() {

				@Override
				public void performAction(SaleType saleType) {
					Assert.assertNotNull(saleType);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		SaleType newSaleType = addSaleType();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SaleType.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("typeId", newSaleType.getTypeId()));

		List<SaleType> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		SaleType existingSaleType = result.get(0);

		Assert.assertEquals(existingSaleType, newSaleType);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SaleType.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("typeId", RandomTestUtil.nextLong()));

		List<SaleType> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		SaleType newSaleType = addSaleType();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SaleType.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("typeId"));

		Object newTypeId = newSaleType.getTypeId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("typeId", new Object[] {newTypeId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingTypeId = result.get(0);

		Assert.assertEquals(existingTypeId, newTypeId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SaleType.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("typeId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"typeId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		SaleType newSaleType = addSaleType();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newSaleType.getPrimaryKey()));
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromDatabase()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(true);
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromSession()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(false);
	}

	private void _testResetOriginalValuesWithDynamicQuery(boolean clearSession)
		throws Exception {

		SaleType newSaleType = addSaleType();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SaleType.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("typeId", newSaleType.getTypeId()));

		List<SaleType> result = _persistence.findWithDynamicQuery(dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(SaleType saleType) {
		Assert.assertEquals(
			saleType.getName(),
			ReflectionTestUtil.invoke(
				saleType, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "name"));
	}

	protected SaleType addSaleType() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SaleType saleType = _persistence.create(pk);

		saleType.setName(RandomTestUtil.randomString());

		saleType.setTax(RandomTestUtil.nextDouble());

		_saleTypes.add(_persistence.update(saleType));

		return saleType;
	}

	private List<SaleType> _saleTypes = new ArrayList<SaleType>();
	private SaleTypePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}