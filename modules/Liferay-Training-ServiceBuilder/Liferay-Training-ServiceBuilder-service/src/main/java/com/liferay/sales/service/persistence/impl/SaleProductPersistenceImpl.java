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

package com.liferay.sales.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.sales.exception.NoSuchSaleProductException;
import com.liferay.sales.model.SaleProduct;
import com.liferay.sales.model.impl.SaleProductImpl;
import com.liferay.sales.model.impl.SaleProductModelImpl;
import com.liferay.sales.service.persistence.SaleProductPersistence;
import com.liferay.sales.service.persistence.impl.constants.SalesTaxePersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the sale product service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SaleProductPersistence.class)
public class SaleProductPersistenceImpl
	extends BasePersistenceImpl<SaleProduct> implements SaleProductPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SaleProductUtil</code> to access the sale product persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SaleProductImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByName;
	private FinderPath _finderPathCountByName;

	/**
	 * Returns the sale product where name = &#63; or throws a <code>NoSuchSaleProductException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching sale product
	 * @throws NoSuchSaleProductException if a matching sale product could not be found
	 */
	@Override
	public SaleProduct findByName(String name)
		throws NoSuchSaleProductException {

		SaleProduct saleProduct = fetchByName(name);

		if (saleProduct == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("name=");
			sb.append(name);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchSaleProductException(sb.toString());
		}

		return saleProduct;
	}

	/**
	 * Returns the sale product where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching sale product, or <code>null</code> if a matching sale product could not be found
	 */
	@Override
	public SaleProduct fetchByName(String name) {
		return fetchByName(name, true);
	}

	/**
	 * Returns the sale product where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sale product, or <code>null</code> if a matching sale product could not be found
	 */
	@Override
	public SaleProduct fetchByName(String name, boolean useFinderCache) {
		name = Objects.toString(name, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {name};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByName, finderArgs, this);
		}

		if (result instanceof SaleProduct) {
			SaleProduct saleProduct = (SaleProduct)result;

			if (!Objects.equals(name, saleProduct.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_SALEPRODUCT_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				List<SaleProduct> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByName, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {name};
							}

							_log.warn(
								"SaleProductPersistenceImpl.fetchByName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					SaleProduct saleProduct = list.get(0);

					result = saleProduct;

					cacheResult(saleProduct);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (SaleProduct)result;
		}
	}

	/**
	 * Removes the sale product where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the sale product that was removed
	 */
	@Override
	public SaleProduct removeByName(String name)
		throws NoSuchSaleProductException {

		SaleProduct saleProduct = findByName(name);

		return remove(saleProduct);
	}

	/**
	 * Returns the number of sale products where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching sale products
	 */
	@Override
	public int countByName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SALEPRODUCT_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_NAME_NAME_2 =
		"saleProduct.name = ?";

	private static final String _FINDER_COLUMN_NAME_NAME_3 =
		"(saleProduct.name IS NULL OR saleProduct.name = '')";

	private FinderPath _finderPathWithPaginationFindByPrice;
	private FinderPath _finderPathWithoutPaginationFindByPrice;
	private FinderPath _finderPathCountByPrice;

	/**
	 * Returns all the sale products where price = &#63;.
	 *
	 * @param price the price
	 * @return the matching sale products
	 */
	@Override
	public List<SaleProduct> findByPrice(double price) {
		return findByPrice(price, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sale products where price = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaleProductModelImpl</code>.
	 * </p>
	 *
	 * @param price the price
	 * @param start the lower bound of the range of sale products
	 * @param end the upper bound of the range of sale products (not inclusive)
	 * @return the range of matching sale products
	 */
	@Override
	public List<SaleProduct> findByPrice(double price, int start, int end) {
		return findByPrice(price, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sale products where price = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaleProductModelImpl</code>.
	 * </p>
	 *
	 * @param price the price
	 * @param start the lower bound of the range of sale products
	 * @param end the upper bound of the range of sale products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sale products
	 */
	@Override
	public List<SaleProduct> findByPrice(
		double price, int start, int end,
		OrderByComparator<SaleProduct> orderByComparator) {

		return findByPrice(price, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sale products where price = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaleProductModelImpl</code>.
	 * </p>
	 *
	 * @param price the price
	 * @param start the lower bound of the range of sale products
	 * @param end the upper bound of the range of sale products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sale products
	 */
	@Override
	public List<SaleProduct> findByPrice(
		double price, int start, int end,
		OrderByComparator<SaleProduct> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPrice;
				finderArgs = new Object[] {price};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPrice;
			finderArgs = new Object[] {price, start, end, orderByComparator};
		}

		List<SaleProduct> list = null;

		if (useFinderCache) {
			list = (List<SaleProduct>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SaleProduct saleProduct : list) {
					if (price != saleProduct.getPrice()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SALEPRODUCT_WHERE);

			sb.append(_FINDER_COLUMN_PRICE_PRICE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SaleProductModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(price);

				list = (List<SaleProduct>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first sale product in the ordered set where price = &#63;.
	 *
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sale product
	 * @throws NoSuchSaleProductException if a matching sale product could not be found
	 */
	@Override
	public SaleProduct findByPrice_First(
			double price, OrderByComparator<SaleProduct> orderByComparator)
		throws NoSuchSaleProductException {

		SaleProduct saleProduct = fetchByPrice_First(price, orderByComparator);

		if (saleProduct != null) {
			return saleProduct;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("price=");
		sb.append(price);

		sb.append("}");

		throw new NoSuchSaleProductException(sb.toString());
	}

	/**
	 * Returns the first sale product in the ordered set where price = &#63;.
	 *
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sale product, or <code>null</code> if a matching sale product could not be found
	 */
	@Override
	public SaleProduct fetchByPrice_First(
		double price, OrderByComparator<SaleProduct> orderByComparator) {

		List<SaleProduct> list = findByPrice(price, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sale product in the ordered set where price = &#63;.
	 *
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sale product
	 * @throws NoSuchSaleProductException if a matching sale product could not be found
	 */
	@Override
	public SaleProduct findByPrice_Last(
			double price, OrderByComparator<SaleProduct> orderByComparator)
		throws NoSuchSaleProductException {

		SaleProduct saleProduct = fetchByPrice_Last(price, orderByComparator);

		if (saleProduct != null) {
			return saleProduct;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("price=");
		sb.append(price);

		sb.append("}");

		throw new NoSuchSaleProductException(sb.toString());
	}

	/**
	 * Returns the last sale product in the ordered set where price = &#63;.
	 *
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sale product, or <code>null</code> if a matching sale product could not be found
	 */
	@Override
	public SaleProduct fetchByPrice_Last(
		double price, OrderByComparator<SaleProduct> orderByComparator) {

		int count = countByPrice(price);

		if (count == 0) {
			return null;
		}

		List<SaleProduct> list = findByPrice(
			price, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sale products before and after the current sale product in the ordered set where price = &#63;.
	 *
	 * @param productId the primary key of the current sale product
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sale product
	 * @throws NoSuchSaleProductException if a sale product with the primary key could not be found
	 */
	@Override
	public SaleProduct[] findByPrice_PrevAndNext(
			long productId, double price,
			OrderByComparator<SaleProduct> orderByComparator)
		throws NoSuchSaleProductException {

		SaleProduct saleProduct = findByPrimaryKey(productId);

		Session session = null;

		try {
			session = openSession();

			SaleProduct[] array = new SaleProductImpl[3];

			array[0] = getByPrice_PrevAndNext(
				session, saleProduct, price, orderByComparator, true);

			array[1] = saleProduct;

			array[2] = getByPrice_PrevAndNext(
				session, saleProduct, price, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SaleProduct getByPrice_PrevAndNext(
		Session session, SaleProduct saleProduct, double price,
		OrderByComparator<SaleProduct> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SALEPRODUCT_WHERE);

		sb.append(_FINDER_COLUMN_PRICE_PRICE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SaleProductModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(price);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(saleProduct)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SaleProduct> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sale products where price = &#63; from the database.
	 *
	 * @param price the price
	 */
	@Override
	public void removeByPrice(double price) {
		for (SaleProduct saleProduct :
				findByPrice(
					price, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(saleProduct);
		}
	}

	/**
	 * Returns the number of sale products where price = &#63;.
	 *
	 * @param price the price
	 * @return the number of matching sale products
	 */
	@Override
	public int countByPrice(double price) {
		FinderPath finderPath = _finderPathCountByPrice;

		Object[] finderArgs = new Object[] {price};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SALEPRODUCT_WHERE);

			sb.append(_FINDER_COLUMN_PRICE_PRICE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(price);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PRICE_PRICE_2 =
		"saleProduct.price = ?";

	public SaleProductPersistenceImpl() {
		setModelClass(SaleProduct.class);

		setModelImplClass(SaleProductImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the sale product in the entity cache if it is enabled.
	 *
	 * @param saleProduct the sale product
	 */
	@Override
	public void cacheResult(SaleProduct saleProduct) {
		entityCache.putResult(
			SaleProductImpl.class, saleProduct.getPrimaryKey(), saleProduct);

		finderCache.putResult(
			_finderPathFetchByName, new Object[] {saleProduct.getName()},
			saleProduct);
	}

	/**
	 * Caches the sale products in the entity cache if it is enabled.
	 *
	 * @param saleProducts the sale products
	 */
	@Override
	public void cacheResult(List<SaleProduct> saleProducts) {
		for (SaleProduct saleProduct : saleProducts) {
			if (entityCache.getResult(
					SaleProductImpl.class, saleProduct.getPrimaryKey()) ==
						null) {

				cacheResult(saleProduct);
			}
		}
	}

	/**
	 * Clears the cache for all sale products.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SaleProductImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sale product.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SaleProduct saleProduct) {
		entityCache.removeResult(SaleProductImpl.class, saleProduct);
	}

	@Override
	public void clearCache(List<SaleProduct> saleProducts) {
		for (SaleProduct saleProduct : saleProducts) {
			entityCache.removeResult(SaleProductImpl.class, saleProduct);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SaleProductImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		SaleProductModelImpl saleProductModelImpl) {

		Object[] args = new Object[] {saleProductModelImpl.getName()};

		finderCache.putResult(
			_finderPathCountByName, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByName, args, saleProductModelImpl, false);
	}

	/**
	 * Creates a new sale product with the primary key. Does not add the sale product to the database.
	 *
	 * @param productId the primary key for the new sale product
	 * @return the new sale product
	 */
	@Override
	public SaleProduct create(long productId) {
		SaleProduct saleProduct = new SaleProductImpl();

		saleProduct.setNew(true);
		saleProduct.setPrimaryKey(productId);

		return saleProduct;
	}

	/**
	 * Removes the sale product with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productId the primary key of the sale product
	 * @return the sale product that was removed
	 * @throws NoSuchSaleProductException if a sale product with the primary key could not be found
	 */
	@Override
	public SaleProduct remove(long productId)
		throws NoSuchSaleProductException {

		return remove((Serializable)productId);
	}

	/**
	 * Removes the sale product with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sale product
	 * @return the sale product that was removed
	 * @throws NoSuchSaleProductException if a sale product with the primary key could not be found
	 */
	@Override
	public SaleProduct remove(Serializable primaryKey)
		throws NoSuchSaleProductException {

		Session session = null;

		try {
			session = openSession();

			SaleProduct saleProduct = (SaleProduct)session.get(
				SaleProductImpl.class, primaryKey);

			if (saleProduct == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSaleProductException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(saleProduct);
		}
		catch (NoSuchSaleProductException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected SaleProduct removeImpl(SaleProduct saleProduct) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(saleProduct)) {
				saleProduct = (SaleProduct)session.get(
					SaleProductImpl.class, saleProduct.getPrimaryKeyObj());
			}

			if (saleProduct != null) {
				session.delete(saleProduct);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (saleProduct != null) {
			clearCache(saleProduct);
		}

		return saleProduct;
	}

	@Override
	public SaleProduct updateImpl(SaleProduct saleProduct) {
		boolean isNew = saleProduct.isNew();

		if (!(saleProduct instanceof SaleProductModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(saleProduct.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(saleProduct);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in saleProduct proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SaleProduct implementation " +
					saleProduct.getClass());
		}

		SaleProductModelImpl saleProductModelImpl =
			(SaleProductModelImpl)saleProduct;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(saleProduct);
			}
			else {
				saleProduct = (SaleProduct)session.merge(saleProduct);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SaleProductImpl.class, saleProductModelImpl, false, true);

		cacheUniqueFindersCache(saleProductModelImpl);

		if (isNew) {
			saleProduct.setNew(false);
		}

		saleProduct.resetOriginalValues();

		return saleProduct;
	}

	/**
	 * Returns the sale product with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sale product
	 * @return the sale product
	 * @throws NoSuchSaleProductException if a sale product with the primary key could not be found
	 */
	@Override
	public SaleProduct findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSaleProductException {

		SaleProduct saleProduct = fetchByPrimaryKey(primaryKey);

		if (saleProduct == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSaleProductException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return saleProduct;
	}

	/**
	 * Returns the sale product with the primary key or throws a <code>NoSuchSaleProductException</code> if it could not be found.
	 *
	 * @param productId the primary key of the sale product
	 * @return the sale product
	 * @throws NoSuchSaleProductException if a sale product with the primary key could not be found
	 */
	@Override
	public SaleProduct findByPrimaryKey(long productId)
		throws NoSuchSaleProductException {

		return findByPrimaryKey((Serializable)productId);
	}

	/**
	 * Returns the sale product with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productId the primary key of the sale product
	 * @return the sale product, or <code>null</code> if a sale product with the primary key could not be found
	 */
	@Override
	public SaleProduct fetchByPrimaryKey(long productId) {
		return fetchByPrimaryKey((Serializable)productId);
	}

	/**
	 * Returns all the sale products.
	 *
	 * @return the sale products
	 */
	@Override
	public List<SaleProduct> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sale products.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaleProductModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sale products
	 * @param end the upper bound of the range of sale products (not inclusive)
	 * @return the range of sale products
	 */
	@Override
	public List<SaleProduct> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the sale products.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaleProductModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sale products
	 * @param end the upper bound of the range of sale products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sale products
	 */
	@Override
	public List<SaleProduct> findAll(
		int start, int end, OrderByComparator<SaleProduct> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sale products.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaleProductModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sale products
	 * @param end the upper bound of the range of sale products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sale products
	 */
	@Override
	public List<SaleProduct> findAll(
		int start, int end, OrderByComparator<SaleProduct> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<SaleProduct> list = null;

		if (useFinderCache) {
			list = (List<SaleProduct>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SALEPRODUCT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SALEPRODUCT;

				sql = sql.concat(SaleProductModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SaleProduct>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the sale products from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SaleProduct saleProduct : findAll()) {
			remove(saleProduct);
		}
	}

	/**
	 * Returns the number of sale products.
	 *
	 * @return the number of sale products
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SALEPRODUCT);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "productId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SALEPRODUCT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SaleProductModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sale product persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new SaleProductModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", SaleProduct.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchByName = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByName",
			new String[] {String.class.getName()}, new String[] {"name"}, true);

		_finderPathCountByName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] {String.class.getName()}, new String[] {"name"},
			false);

		_finderPathWithPaginationFindByPrice = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPrice",
			new String[] {
				Double.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"price"}, true);

		_finderPathWithoutPaginationFindByPrice = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPrice",
			new String[] {Double.class.getName()}, new String[] {"price"},
			true);

		_finderPathCountByPrice = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPrice",
			new String[] {Double.class.getName()}, new String[] {"price"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(SaleProductImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = SalesTaxePersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = SalesTaxePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = SalesTaxePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_SALEPRODUCT =
		"SELECT saleProduct FROM SaleProduct saleProduct";

	private static final String _SQL_SELECT_SALEPRODUCT_WHERE =
		"SELECT saleProduct FROM SaleProduct saleProduct WHERE ";

	private static final String _SQL_COUNT_SALEPRODUCT =
		"SELECT COUNT(saleProduct) FROM SaleProduct saleProduct";

	private static final String _SQL_COUNT_SALEPRODUCT_WHERE =
		"SELECT COUNT(saleProduct) FROM SaleProduct saleProduct WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "saleProduct.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SaleProduct exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SaleProduct exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SaleProductPersistenceImpl.class);

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class SaleProductModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return FINDER_ARGS_EMPTY;
				}

				return null;
			}

			SaleProductModelImpl saleProductModelImpl =
				(SaleProductModelImpl)baseModel;

			long columnBitmask = saleProductModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(saleProductModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						saleProductModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(saleProductModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			SaleProductModelImpl saleProductModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = saleProductModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = saleProductModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}