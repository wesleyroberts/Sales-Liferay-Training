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
import com.liferay.sales.exception.NoSuchCartProductsListException;
import com.liferay.sales.model.CartProductsList;
import com.liferay.sales.service.CartProductsListLocalServiceUtil;
import com.liferay.sales.service.persistence.CartProductsListPersistence;
import com.liferay.sales.service.persistence.CartProductsListUtil;

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
public class CartProductsListPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.liferay.sales.service"));

	@Before
	public void setUp() {
		_persistence = CartProductsListUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<CartProductsList> iterator = _cartProductsLists.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CartProductsList cartProductsList = _persistence.create(pk);

		Assert.assertNotNull(cartProductsList);

		Assert.assertEquals(cartProductsList.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		CartProductsList newCartProductsList = addCartProductsList();

		_persistence.remove(newCartProductsList);

		CartProductsList existingCartProductsList =
			_persistence.fetchByPrimaryKey(newCartProductsList.getPrimaryKey());

		Assert.assertNull(existingCartProductsList);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCartProductsList();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CartProductsList newCartProductsList = _persistence.create(pk);

		newCartProductsList.setCartId(RandomTestUtil.nextLong());

		newCartProductsList.setQuantity(RandomTestUtil.nextInt());

		_cartProductsLists.add(_persistence.update(newCartProductsList));

		CartProductsList existingCartProductsList =
			_persistence.findByPrimaryKey(newCartProductsList.getPrimaryKey());

		Assert.assertEquals(
			existingCartProductsList.getProductId(),
			newCartProductsList.getProductId());
		Assert.assertEquals(
			existingCartProductsList.getCartId(),
			newCartProductsList.getCartId());
		Assert.assertEquals(
			existingCartProductsList.getQuantity(),
			newCartProductsList.getQuantity());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		CartProductsList newCartProductsList = addCartProductsList();

		CartProductsList existingCartProductsList =
			_persistence.findByPrimaryKey(newCartProductsList.getPrimaryKey());

		Assert.assertEquals(existingCartProductsList, newCartProductsList);
	}

	@Test(expected = NoSuchCartProductsListException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<CartProductsList> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"SalesTaxe_CartProductsList", "productId", true, "cartId", true,
			"quantity", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		CartProductsList newCartProductsList = addCartProductsList();

		CartProductsList existingCartProductsList =
			_persistence.fetchByPrimaryKey(newCartProductsList.getPrimaryKey());

		Assert.assertEquals(existingCartProductsList, newCartProductsList);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CartProductsList missingCartProductsList =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCartProductsList);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		CartProductsList newCartProductsList1 = addCartProductsList();
		CartProductsList newCartProductsList2 = addCartProductsList();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCartProductsList1.getPrimaryKey());
		primaryKeys.add(newCartProductsList2.getPrimaryKey());

		Map<Serializable, CartProductsList> cartProductsLists =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, cartProductsLists.size());
		Assert.assertEquals(
			newCartProductsList1,
			cartProductsLists.get(newCartProductsList1.getPrimaryKey()));
		Assert.assertEquals(
			newCartProductsList2,
			cartProductsLists.get(newCartProductsList2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, CartProductsList> cartProductsLists =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(cartProductsLists.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		CartProductsList newCartProductsList = addCartProductsList();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCartProductsList.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, CartProductsList> cartProductsLists =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, cartProductsLists.size());
		Assert.assertEquals(
			newCartProductsList,
			cartProductsLists.get(newCartProductsList.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, CartProductsList> cartProductsLists =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(cartProductsLists.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		CartProductsList newCartProductsList = addCartProductsList();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCartProductsList.getPrimaryKey());

		Map<Serializable, CartProductsList> cartProductsLists =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, cartProductsLists.size());
		Assert.assertEquals(
			newCartProductsList,
			cartProductsLists.get(newCartProductsList.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			CartProductsListLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<CartProductsList>() {

				@Override
				public void performAction(CartProductsList cartProductsList) {
					Assert.assertNotNull(cartProductsList);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		CartProductsList newCartProductsList = addCartProductsList();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CartProductsList.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"productId", newCartProductsList.getProductId()));

		List<CartProductsList> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		CartProductsList existingCartProductsList = result.get(0);

		Assert.assertEquals(existingCartProductsList, newCartProductsList);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CartProductsList.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("productId", RandomTestUtil.nextLong()));

		List<CartProductsList> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		CartProductsList newCartProductsList = addCartProductsList();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CartProductsList.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("productId"));

		Object newProductId = newCartProductsList.getProductId();

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
			CartProductsList.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("productId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"productId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected CartProductsList addCartProductsList() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CartProductsList cartProductsList = _persistence.create(pk);

		cartProductsList.setCartId(RandomTestUtil.nextLong());

		cartProductsList.setQuantity(RandomTestUtil.nextInt());

		_cartProductsLists.add(_persistence.update(cartProductsList));

		return cartProductsList;
	}

	private List<CartProductsList> _cartProductsLists =
		new ArrayList<CartProductsList>();
	private CartProductsListPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}