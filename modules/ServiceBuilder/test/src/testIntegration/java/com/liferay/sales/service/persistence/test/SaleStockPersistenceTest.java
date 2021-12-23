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
import com.liferay.sales.exception.NoSuchSaleStockException;
import com.liferay.sales.model.SaleStock;
import com.liferay.sales.service.SaleStockLocalServiceUtil;
import com.liferay.sales.service.persistence.SaleStockPersistence;
import com.liferay.sales.service.persistence.SaleStockUtil;

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
public class SaleStockPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.liferay.sales.service"));

	@Before
	public void setUp() {
		_persistence = SaleStockUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<SaleStock> iterator = _saleStocks.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SaleStock saleStock = _persistence.create(pk);

		Assert.assertNotNull(saleStock);

		Assert.assertEquals(saleStock.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		SaleStock newSaleStock = addSaleStock();

		_persistence.remove(newSaleStock);

		SaleStock existingSaleStock = _persistence.fetchByPrimaryKey(
			newSaleStock.getPrimaryKey());

		Assert.assertNull(existingSaleStock);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addSaleStock();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SaleStock newSaleStock = _persistence.create(pk);

		newSaleStock.setName(RandomTestUtil.randomString());

		newSaleStock.setQuantity(RandomTestUtil.nextInt());

		newSaleStock.setTypeId(RandomTestUtil.nextLong());

		newSaleStock.setCategoryId(RandomTestUtil.nextLong());

		newSaleStock.setPrice(RandomTestUtil.nextDouble());

		_saleStocks.add(_persistence.update(newSaleStock));

		SaleStock existingSaleStock = _persistence.findByPrimaryKey(
			newSaleStock.getPrimaryKey());

		Assert.assertEquals(
			existingSaleStock.getStockId(), newSaleStock.getStockId());
		Assert.assertEquals(
			existingSaleStock.getName(), newSaleStock.getName());
		Assert.assertEquals(
			existingSaleStock.getQuantity(), newSaleStock.getQuantity());
		Assert.assertEquals(
			existingSaleStock.getTypeId(), newSaleStock.getTypeId());
		Assert.assertEquals(
			existingSaleStock.getCategoryId(), newSaleStock.getCategoryId());
		AssertUtils.assertEquals(
			existingSaleStock.getPrice(), newSaleStock.getPrice());
	}

	@Test
	public void testCountByName_Type_Category() throws Exception {
		_persistence.countByName_Type_Category(
			"", RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByName_Type_Category("null", 0L, 0L);

		_persistence.countByName_Type_Category((String)null, 0L, 0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		SaleStock newSaleStock = addSaleStock();

		SaleStock existingSaleStock = _persistence.findByPrimaryKey(
			newSaleStock.getPrimaryKey());

		Assert.assertEquals(existingSaleStock, newSaleStock);
	}

	@Test(expected = NoSuchSaleStockException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<SaleStock> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"SalesTaxe_SaleStock", "StockId", true, "name", true, "quantity",
			true, "typeId", true, "categoryId", true, "price", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		SaleStock newSaleStock = addSaleStock();

		SaleStock existingSaleStock = _persistence.fetchByPrimaryKey(
			newSaleStock.getPrimaryKey());

		Assert.assertEquals(existingSaleStock, newSaleStock);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SaleStock missingSaleStock = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingSaleStock);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		SaleStock newSaleStock1 = addSaleStock();
		SaleStock newSaleStock2 = addSaleStock();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSaleStock1.getPrimaryKey());
		primaryKeys.add(newSaleStock2.getPrimaryKey());

		Map<Serializable, SaleStock> saleStocks =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, saleStocks.size());
		Assert.assertEquals(
			newSaleStock1, saleStocks.get(newSaleStock1.getPrimaryKey()));
		Assert.assertEquals(
			newSaleStock2, saleStocks.get(newSaleStock2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, SaleStock> saleStocks =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(saleStocks.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		SaleStock newSaleStock = addSaleStock();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSaleStock.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, SaleStock> saleStocks =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, saleStocks.size());
		Assert.assertEquals(
			newSaleStock, saleStocks.get(newSaleStock.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, SaleStock> saleStocks =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(saleStocks.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		SaleStock newSaleStock = addSaleStock();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSaleStock.getPrimaryKey());

		Map<Serializable, SaleStock> saleStocks =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, saleStocks.size());
		Assert.assertEquals(
			newSaleStock, saleStocks.get(newSaleStock.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			SaleStockLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<SaleStock>() {

				@Override
				public void performAction(SaleStock saleStock) {
					Assert.assertNotNull(saleStock);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		SaleStock newSaleStock = addSaleStock();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SaleStock.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("StockId", newSaleStock.getStockId()));

		List<SaleStock> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		SaleStock existingSaleStock = result.get(0);

		Assert.assertEquals(existingSaleStock, newSaleStock);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SaleStock.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("StockId", RandomTestUtil.nextLong()));

		List<SaleStock> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		SaleStock newSaleStock = addSaleStock();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SaleStock.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("StockId"));

		Object newStockId = newSaleStock.getStockId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("StockId", new Object[] {newStockId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingStockId = result.get(0);

		Assert.assertEquals(existingStockId, newStockId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SaleStock.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("StockId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"StockId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		SaleStock newSaleStock = addSaleStock();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newSaleStock.getPrimaryKey()));
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

		SaleStock newSaleStock = addSaleStock();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SaleStock.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("StockId", newSaleStock.getStockId()));

		List<SaleStock> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(SaleStock saleStock) {
		Assert.assertEquals(
			saleStock.getName(),
			ReflectionTestUtil.invoke(
				saleStock, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "name"));
		Assert.assertEquals(
			Long.valueOf(saleStock.getTypeId()),
			ReflectionTestUtil.<Long>invoke(
				saleStock, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "typeId"));
		Assert.assertEquals(
			Long.valueOf(saleStock.getCategoryId()),
			ReflectionTestUtil.<Long>invoke(
				saleStock, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "categoryId"));
	}

	protected SaleStock addSaleStock() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SaleStock saleStock = _persistence.create(pk);

		saleStock.setName(RandomTestUtil.randomString());

		saleStock.setQuantity(RandomTestUtil.nextInt());

		saleStock.setTypeId(RandomTestUtil.nextLong());

		saleStock.setCategoryId(RandomTestUtil.nextLong());

		saleStock.setPrice(RandomTestUtil.nextDouble());

		_saleStocks.add(_persistence.update(saleStock));

		return saleStock;
	}

	private List<SaleStock> _saleStocks = new ArrayList<SaleStock>();
	private SaleStockPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}