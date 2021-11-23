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
import com.liferay.sales.exception.NoSuchSaleProductException;
import com.liferay.sales.model.SaleProduct;
import com.liferay.sales.service.SaleProductLocalServiceUtil;
import com.liferay.sales.service.persistence.SaleProductPersistence;
import com.liferay.sales.service.persistence.SaleProductUtil;

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
public class SaleProductPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.liferay.sales.service"));

	@Before
	public void setUp() {
		_persistence = SaleProductUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<SaleProduct> iterator = _saleProducts.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SaleProduct saleProduct = _persistence.create(pk);

		Assert.assertNotNull(saleProduct);

		Assert.assertEquals(saleProduct.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		SaleProduct newSaleProduct = addSaleProduct();

		_persistence.remove(newSaleProduct);

		SaleProduct existingSaleProduct = _persistence.fetchByPrimaryKey(
			newSaleProduct.getPrimaryKey());

		Assert.assertNull(existingSaleProduct);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addSaleProduct();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SaleProduct newSaleProduct = _persistence.create(pk);

		newSaleProduct.setName(RandomTestUtil.randomString());

		newSaleProduct.setPrice(RandomTestUtil.nextDouble());

		newSaleProduct.setCategoryId(RandomTestUtil.nextLong());

		newSaleProduct.setTypeId(RandomTestUtil.nextLong());

		_saleProducts.add(_persistence.update(newSaleProduct));

		SaleProduct existingSaleProduct = _persistence.findByPrimaryKey(
			newSaleProduct.getPrimaryKey());

		Assert.assertEquals(
			existingSaleProduct.getProductId(), newSaleProduct.getProductId());
		Assert.assertEquals(
			existingSaleProduct.getName(), newSaleProduct.getName());
		AssertUtils.assertEquals(
			existingSaleProduct.getPrice(), newSaleProduct.getPrice());
		Assert.assertEquals(
			existingSaleProduct.getCategoryId(),
			newSaleProduct.getCategoryId());
		Assert.assertEquals(
			existingSaleProduct.getTypeId(), newSaleProduct.getTypeId());
	}

	@Test
	public void testCountByName() throws Exception {
		_persistence.countByName("");

		_persistence.countByName("null");

		_persistence.countByName((String)null);
	}

	@Test
	public void testCountByPrice() throws Exception {
		_persistence.countByPrice(RandomTestUtil.nextDouble());

		_persistence.countByPrice(0D);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		SaleProduct newSaleProduct = addSaleProduct();

		SaleProduct existingSaleProduct = _persistence.findByPrimaryKey(
			newSaleProduct.getPrimaryKey());

		Assert.assertEquals(existingSaleProduct, newSaleProduct);
	}

	@Test(expected = NoSuchSaleProductException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<SaleProduct> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"SalesTaxe_SaleProduct", "productId", true, "name", true, "price",
			true, "categoryId", true, "typeId", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		SaleProduct newSaleProduct = addSaleProduct();

		SaleProduct existingSaleProduct = _persistence.fetchByPrimaryKey(
			newSaleProduct.getPrimaryKey());

		Assert.assertEquals(existingSaleProduct, newSaleProduct);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SaleProduct missingSaleProduct = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingSaleProduct);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		SaleProduct newSaleProduct1 = addSaleProduct();
		SaleProduct newSaleProduct2 = addSaleProduct();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSaleProduct1.getPrimaryKey());
		primaryKeys.add(newSaleProduct2.getPrimaryKey());

		Map<Serializable, SaleProduct> saleProducts =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, saleProducts.size());
		Assert.assertEquals(
			newSaleProduct1, saleProducts.get(newSaleProduct1.getPrimaryKey()));
		Assert.assertEquals(
			newSaleProduct2, saleProducts.get(newSaleProduct2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, SaleProduct> saleProducts =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(saleProducts.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		SaleProduct newSaleProduct = addSaleProduct();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSaleProduct.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, SaleProduct> saleProducts =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, saleProducts.size());
		Assert.assertEquals(
			newSaleProduct, saleProducts.get(newSaleProduct.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, SaleProduct> saleProducts =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(saleProducts.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		SaleProduct newSaleProduct = addSaleProduct();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSaleProduct.getPrimaryKey());

		Map<Serializable, SaleProduct> saleProducts =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, saleProducts.size());
		Assert.assertEquals(
			newSaleProduct, saleProducts.get(newSaleProduct.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			SaleProductLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<SaleProduct>() {

				@Override
				public void performAction(SaleProduct saleProduct) {
					Assert.assertNotNull(saleProduct);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		SaleProduct newSaleProduct = addSaleProduct();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SaleProduct.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"productId", newSaleProduct.getProductId()));

		List<SaleProduct> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		SaleProduct existingSaleProduct = result.get(0);

		Assert.assertEquals(existingSaleProduct, newSaleProduct);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SaleProduct.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("productId", RandomTestUtil.nextLong()));

		List<SaleProduct> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		SaleProduct newSaleProduct = addSaleProduct();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SaleProduct.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("productId"));

		Object newProductId = newSaleProduct.getProductId();

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
			SaleProduct.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("productId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"productId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		SaleProduct newSaleProduct = addSaleProduct();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newSaleProduct.getPrimaryKey()));
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

		SaleProduct newSaleProduct = addSaleProduct();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SaleProduct.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"productId", newSaleProduct.getProductId()));

		List<SaleProduct> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(SaleProduct saleProduct) {
		Assert.assertEquals(
			saleProduct.getName(),
			ReflectionTestUtil.invoke(
				saleProduct, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "name"));
	}

	protected SaleProduct addSaleProduct() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SaleProduct saleProduct = _persistence.create(pk);

		saleProduct.setName(RandomTestUtil.randomString());

		saleProduct.setPrice(RandomTestUtil.nextDouble());

		saleProduct.setCategoryId(RandomTestUtil.nextLong());

		saleProduct.setTypeId(RandomTestUtil.nextLong());

		_saleProducts.add(_persistence.update(saleProduct));

		return saleProduct;
	}

	private List<SaleProduct> _saleProducts = new ArrayList<SaleProduct>();
	private SaleProductPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}