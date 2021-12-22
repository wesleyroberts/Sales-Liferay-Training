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
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;
import com.liferay.sales.exception.NoSuchStockProductsListException;
import com.liferay.sales.model.StockProductsList;
import com.liferay.sales.service.StockProductsListLocalServiceUtil;
import com.liferay.sales.service.persistence.StockProductsListPersistence;
import com.liferay.sales.service.persistence.StockProductsListUtil;

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
public class StockProductsListPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.liferay.sales.service"));

	@Before
	public void setUp() {
		_persistence = StockProductsListUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<StockProductsList> iterator = _stockProductsLists.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		StockProductsList stockProductsList = _persistence.create(pk);

		Assert.assertNotNull(stockProductsList);

		Assert.assertEquals(stockProductsList.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		StockProductsList newStockProductsList = addStockProductsList();

		_persistence.remove(newStockProductsList);

		StockProductsList existingStockProductsList =
			_persistence.fetchByPrimaryKey(
				newStockProductsList.getPrimaryKey());

		Assert.assertNull(existingStockProductsList);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addStockProductsList();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		StockProductsList newStockProductsList = _persistence.create(pk);

		newStockProductsList.setStockId(RandomTestUtil.nextLong());

		_stockProductsLists.add(_persistence.update(newStockProductsList));

		StockProductsList existingStockProductsList =
			_persistence.findByPrimaryKey(newStockProductsList.getPrimaryKey());

		Assert.assertEquals(
			existingStockProductsList.getProductId(),
			newStockProductsList.getProductId());
		Assert.assertEquals(
			existingStockProductsList.getStockId(),
			newStockProductsList.getStockId());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		StockProductsList newStockProductsList = addStockProductsList();

		StockProductsList existingStockProductsList =
			_persistence.findByPrimaryKey(newStockProductsList.getPrimaryKey());

		Assert.assertEquals(existingStockProductsList, newStockProductsList);
	}

	@Test(expected = NoSuchStockProductsListException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<StockProductsList> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"SalesTaxe_StockProductsList", "productId", true, "StockId", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		StockProductsList newStockProductsList = addStockProductsList();

		StockProductsList existingStockProductsList =
			_persistence.fetchByPrimaryKey(
				newStockProductsList.getPrimaryKey());

		Assert.assertEquals(existingStockProductsList, newStockProductsList);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		StockProductsList missingStockProductsList =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingStockProductsList);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		StockProductsList newStockProductsList1 = addStockProductsList();
		StockProductsList newStockProductsList2 = addStockProductsList();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newStockProductsList1.getPrimaryKey());
		primaryKeys.add(newStockProductsList2.getPrimaryKey());

		Map<Serializable, StockProductsList> stockProductsLists =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, stockProductsLists.size());
		Assert.assertEquals(
			newStockProductsList1,
			stockProductsLists.get(newStockProductsList1.getPrimaryKey()));
		Assert.assertEquals(
			newStockProductsList2,
			stockProductsLists.get(newStockProductsList2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, StockProductsList> stockProductsLists =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(stockProductsLists.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		StockProductsList newStockProductsList = addStockProductsList();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newStockProductsList.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, StockProductsList> stockProductsLists =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, stockProductsLists.size());
		Assert.assertEquals(
			newStockProductsList,
			stockProductsLists.get(newStockProductsList.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, StockProductsList> stockProductsLists =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(stockProductsLists.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		StockProductsList newStockProductsList = addStockProductsList();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newStockProductsList.getPrimaryKey());

		Map<Serializable, StockProductsList> stockProductsLists =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, stockProductsLists.size());
		Assert.assertEquals(
			newStockProductsList,
			stockProductsLists.get(newStockProductsList.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			StockProductsListLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<StockProductsList>() {

				@Override
				public void performAction(StockProductsList stockProductsList) {
					Assert.assertNotNull(stockProductsList);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		StockProductsList newStockProductsList = addStockProductsList();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			StockProductsList.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"productId", newStockProductsList.getProductId()));

		List<StockProductsList> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		StockProductsList existingStockProductsList = result.get(0);

		Assert.assertEquals(existingStockProductsList, newStockProductsList);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			StockProductsList.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("productId", RandomTestUtil.nextLong()));

		List<StockProductsList> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		StockProductsList newStockProductsList = addStockProductsList();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			StockProductsList.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("productId"));

		Object newProductId = newStockProductsList.getProductId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"productId", new Object[] {newProductId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingProductId = result.get(0);

		Assert.assertEquals(existingProductId, newProductId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			StockProductsList.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("productId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"productId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected StockProductsList addStockProductsList() throws Exception {
		long pk = RandomTestUtil.nextLong();

		StockProductsList stockProductsList = _persistence.create(pk);

		stockProductsList.setStockId(RandomTestUtil.nextLong());

		_stockProductsLists.add(_persistence.update(stockProductsList));

		return stockProductsList;
	}

	private List<StockProductsList> _stockProductsLists =
		new ArrayList<StockProductsList>();
	private StockProductsListPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}