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
import com.liferay.sales.exception.NoSuchSaleCategoryException;
import com.liferay.sales.model.SaleCategory;
import com.liferay.sales.service.SaleCategoryLocalServiceUtil;
import com.liferay.sales.service.persistence.SaleCategoryPersistence;
import com.liferay.sales.service.persistence.SaleCategoryUtil;

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
public class SaleCategoryPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.liferay.sales.service"));

	@Before
	public void setUp() {
		_persistence = SaleCategoryUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<SaleCategory> iterator = _saleCategories.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SaleCategory saleCategory = _persistence.create(pk);

		Assert.assertNotNull(saleCategory);

		Assert.assertEquals(saleCategory.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		SaleCategory newSaleCategory = addSaleCategory();

		_persistence.remove(newSaleCategory);

		SaleCategory existingSaleCategory = _persistence.fetchByPrimaryKey(
			newSaleCategory.getPrimaryKey());

		Assert.assertNull(existingSaleCategory);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addSaleCategory();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SaleCategory newSaleCategory = _persistence.create(pk);

		newSaleCategory.setName(RandomTestUtil.randomString());

		newSaleCategory.setTax(RandomTestUtil.nextDouble());

		_saleCategories.add(_persistence.update(newSaleCategory));

		SaleCategory existingSaleCategory = _persistence.findByPrimaryKey(
			newSaleCategory.getPrimaryKey());

		Assert.assertEquals(
			existingSaleCategory.getCategoryId(),
			newSaleCategory.getCategoryId());
		Assert.assertEquals(
			existingSaleCategory.getName(), newSaleCategory.getName());
		AssertUtils.assertEquals(
			existingSaleCategory.getTax(), newSaleCategory.getTax());
	}

	@Test
	public void testCountByName() throws Exception {
		_persistence.countByName("");

		_persistence.countByName("null");

		_persistence.countByName((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		SaleCategory newSaleCategory = addSaleCategory();

		SaleCategory existingSaleCategory = _persistence.findByPrimaryKey(
			newSaleCategory.getPrimaryKey());

		Assert.assertEquals(existingSaleCategory, newSaleCategory);
	}

	@Test(expected = NoSuchSaleCategoryException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<SaleCategory> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"SalesTaxe_SaleCategory", "categoryId", true, "name", true, "tax",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		SaleCategory newSaleCategory = addSaleCategory();

		SaleCategory existingSaleCategory = _persistence.fetchByPrimaryKey(
			newSaleCategory.getPrimaryKey());

		Assert.assertEquals(existingSaleCategory, newSaleCategory);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SaleCategory missingSaleCategory = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingSaleCategory);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		SaleCategory newSaleCategory1 = addSaleCategory();
		SaleCategory newSaleCategory2 = addSaleCategory();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSaleCategory1.getPrimaryKey());
		primaryKeys.add(newSaleCategory2.getPrimaryKey());

		Map<Serializable, SaleCategory> saleCategories =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, saleCategories.size());
		Assert.assertEquals(
			newSaleCategory1,
			saleCategories.get(newSaleCategory1.getPrimaryKey()));
		Assert.assertEquals(
			newSaleCategory2,
			saleCategories.get(newSaleCategory2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, SaleCategory> saleCategories =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(saleCategories.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		SaleCategory newSaleCategory = addSaleCategory();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSaleCategory.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, SaleCategory> saleCategories =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, saleCategories.size());
		Assert.assertEquals(
			newSaleCategory,
			saleCategories.get(newSaleCategory.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, SaleCategory> saleCategories =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(saleCategories.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		SaleCategory newSaleCategory = addSaleCategory();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSaleCategory.getPrimaryKey());

		Map<Serializable, SaleCategory> saleCategories =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, saleCategories.size());
		Assert.assertEquals(
			newSaleCategory,
			saleCategories.get(newSaleCategory.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			SaleCategoryLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<SaleCategory>() {

				@Override
				public void performAction(SaleCategory saleCategory) {
					Assert.assertNotNull(saleCategory);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		SaleCategory newSaleCategory = addSaleCategory();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SaleCategory.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"categoryId", newSaleCategory.getCategoryId()));

		List<SaleCategory> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		SaleCategory existingSaleCategory = result.get(0);

		Assert.assertEquals(existingSaleCategory, newSaleCategory);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SaleCategory.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"categoryId", RandomTestUtil.nextLong()));

		List<SaleCategory> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		SaleCategory newSaleCategory = addSaleCategory();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SaleCategory.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("categoryId"));

		Object newCategoryId = newSaleCategory.getCategoryId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"categoryId", new Object[] {newCategoryId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingCategoryId = result.get(0);

		Assert.assertEquals(existingCategoryId, newCategoryId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SaleCategory.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("categoryId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"categoryId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		SaleCategory newSaleCategory = addSaleCategory();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newSaleCategory.getPrimaryKey()));
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

		SaleCategory newSaleCategory = addSaleCategory();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SaleCategory.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"categoryId", newSaleCategory.getCategoryId()));

		List<SaleCategory> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(SaleCategory saleCategory) {
		Assert.assertEquals(
			saleCategory.getName(),
			ReflectionTestUtil.invoke(
				saleCategory, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "name"));
	}

	protected SaleCategory addSaleCategory() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SaleCategory saleCategory = _persistence.create(pk);

		saleCategory.setName(RandomTestUtil.randomString());

		saleCategory.setTax(RandomTestUtil.nextDouble());

		_saleCategories.add(_persistence.update(saleCategory));

		return saleCategory;
	}

	private List<SaleCategory> _saleCategories = new ArrayList<SaleCategory>();
	private SaleCategoryPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}