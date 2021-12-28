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
import com.liferay.portal.kernel.test.AssertUtils;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;
import com.liferay.sales.exception.NoSuchSaleCartException;
import com.liferay.sales.model.SaleCart;
import com.liferay.sales.service.SaleCartLocalServiceUtil;
import com.liferay.sales.service.persistence.SaleCartPersistence;
import com.liferay.sales.service.persistence.SaleCartUtil;

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
public class SaleCartPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.liferay.sales.service"));

	@Before
	public void setUp() {
		_persistence = SaleCartUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<SaleCart> iterator = _saleCarts.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SaleCart saleCart = _persistence.create(pk);

		Assert.assertNotNull(saleCart);

		Assert.assertEquals(saleCart.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		SaleCart newSaleCart = addSaleCart();

		_persistence.remove(newSaleCart);

		SaleCart existingSaleCart = _persistence.fetchByPrimaryKey(
			newSaleCart.getPrimaryKey());

		Assert.assertNull(existingSaleCart);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addSaleCart();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SaleCart newSaleCart = _persistence.create(pk);

		newSaleCart.setTotalPrice(RandomTestUtil.nextDouble());

		newSaleCart.setAble(RandomTestUtil.randomBoolean());

		_saleCarts.add(_persistence.update(newSaleCart));

		SaleCart existingSaleCart = _persistence.findByPrimaryKey(
			newSaleCart.getPrimaryKey());

		Assert.assertEquals(
			existingSaleCart.getCartId(), newSaleCart.getCartId());
		AssertUtils.assertEquals(
			existingSaleCart.getTotalPrice(), newSaleCart.getTotalPrice());
		Assert.assertEquals(existingSaleCart.isAble(), newSaleCart.isAble());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		SaleCart newSaleCart = addSaleCart();

		SaleCart existingSaleCart = _persistence.findByPrimaryKey(
			newSaleCart.getPrimaryKey());

		Assert.assertEquals(existingSaleCart, newSaleCart);
	}

	@Test(expected = NoSuchSaleCartException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<SaleCart> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"SalesTaxe_SaleCart", "cartId", true, "totalPrice", true, "able",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		SaleCart newSaleCart = addSaleCart();

		SaleCart existingSaleCart = _persistence.fetchByPrimaryKey(
			newSaleCart.getPrimaryKey());

		Assert.assertEquals(existingSaleCart, newSaleCart);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SaleCart missingSaleCart = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingSaleCart);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		SaleCart newSaleCart1 = addSaleCart();
		SaleCart newSaleCart2 = addSaleCart();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSaleCart1.getPrimaryKey());
		primaryKeys.add(newSaleCart2.getPrimaryKey());

		Map<Serializable, SaleCart> saleCarts = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, saleCarts.size());
		Assert.assertEquals(
			newSaleCart1, saleCarts.get(newSaleCart1.getPrimaryKey()));
		Assert.assertEquals(
			newSaleCart2, saleCarts.get(newSaleCart2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, SaleCart> saleCarts = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(saleCarts.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		SaleCart newSaleCart = addSaleCart();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSaleCart.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, SaleCart> saleCarts = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, saleCarts.size());
		Assert.assertEquals(
			newSaleCart, saleCarts.get(newSaleCart.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, SaleCart> saleCarts = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(saleCarts.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		SaleCart newSaleCart = addSaleCart();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSaleCart.getPrimaryKey());

		Map<Serializable, SaleCart> saleCarts = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, saleCarts.size());
		Assert.assertEquals(
			newSaleCart, saleCarts.get(newSaleCart.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			SaleCartLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<SaleCart>() {

				@Override
				public void performAction(SaleCart saleCart) {
					Assert.assertNotNull(saleCart);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		SaleCart newSaleCart = addSaleCart();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SaleCart.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("cartId", newSaleCart.getCartId()));

		List<SaleCart> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		SaleCart existingSaleCart = result.get(0);

		Assert.assertEquals(existingSaleCart, newSaleCart);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SaleCart.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("cartId", RandomTestUtil.nextLong()));

		List<SaleCart> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		SaleCart newSaleCart = addSaleCart();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SaleCart.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("cartId"));

		Object newCartId = newSaleCart.getCartId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("cartId", new Object[] {newCartId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingCartId = result.get(0);

		Assert.assertEquals(existingCartId, newCartId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SaleCart.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("cartId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"cartId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected SaleCart addSaleCart() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SaleCart saleCart = _persistence.create(pk);

		saleCart.setTotalPrice(RandomTestUtil.nextDouble());

		saleCart.setAble(RandomTestUtil.randomBoolean());

		_saleCarts.add(_persistence.update(saleCart));

		return saleCart;
	}

	private List<SaleCart> _saleCarts = new ArrayList<SaleCart>();
	private SaleCartPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}