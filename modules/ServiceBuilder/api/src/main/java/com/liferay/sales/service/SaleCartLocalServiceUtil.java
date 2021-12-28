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

package com.liferay.sales.service;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.sales.model.SaleCart;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for SaleCart. This utility wraps
 * <code>com.liferay.sales.service.impl.SaleCartLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SaleCartLocalService
 * @generated
 */
public class SaleCartLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.sales.service.impl.SaleCartLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static SaleCart addProductPriceToCartTotalValue(
		double price, long cartId) {

		return getService().addProductPriceToCartTotalValue(price, cartId);
	}

	/**
	 * Adds the sale cart to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SaleCartLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param saleCart the sale cart
	 * @return the sale cart that was added
	 */
	public static SaleCart addSaleCart(SaleCart saleCart) {
		return getService().addSaleCart(saleCart);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new sale cart with the primary key. Does not add the sale cart to the database.
	 *
	 * @param cartId the primary key for the new sale cart
	 * @return the new sale cart
	 */
	public static SaleCart createSaleCart(long cartId) {
		return getService().createSaleCart(cartId);
	}

	public static SaleCart createSaleCartById() {
		return getService().createSaleCartById();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the sale cart with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SaleCartLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cartId the primary key of the sale cart
	 * @return the sale cart that was removed
	 * @throws PortalException if a sale cart with the primary key could not be found
	 */
	public static SaleCart deleteSaleCart(long cartId) throws PortalException {
		return getService().deleteSaleCart(cartId);
	}

	/**
	 * Deletes the sale cart from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SaleCartLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param saleCart the sale cart
	 * @return the sale cart that was removed
	 */
	public static SaleCart deleteSaleCart(SaleCart saleCart) {
		return getService().deleteSaleCart(saleCart);
	}

	public static void deleteSaleCartById(long cartId) {
		getService().deleteSaleCartById(cartId);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.sales.model.impl.SaleCartModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.sales.model.impl.SaleCartModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static SaleCart fetchSaleCart(long cartId) {
		return getService().fetchSaleCart(cartId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<SaleCart> getAllSaleCart() {
		return getService().getAllSaleCart();
	}

	public static Double getFinalValueByCartId(long cartId) {
		return getService().getFinalValueByCartId(cartId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the sale cart with the primary key.
	 *
	 * @param cartId the primary key of the sale cart
	 * @return the sale cart
	 * @throws PortalException if a sale cart with the primary key could not be found
	 */
	public static SaleCart getSaleCart(long cartId) throws PortalException {
		return getService().getSaleCart(cartId);
	}

	public static SaleCart getSaleCartById(long id) {
		return getService().getSaleCartById(id);
	}

	/**
	 * Returns a range of all the sale carts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.sales.model.impl.SaleCartModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sale carts
	 * @param end the upper bound of the range of sale carts (not inclusive)
	 * @return the range of sale carts
	 */
	public static List<SaleCart> getSaleCarts(int start, int end) {
		return getService().getSaleCarts(start, end);
	}

	/**
	 * Returns the number of sale carts.
	 *
	 * @return the number of sale carts
	 */
	public static int getSaleCartsCount() {
		return getService().getSaleCartsCount();
	}

	public static SaleCart removeProductPriceToCartTotalValue(
		double price, long cartId) {

		return getService().removeProductPriceToCartTotalValue(price, cartId);
	}

	/**
	 * Updates the sale cart in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SaleCartLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param saleCart the sale cart
	 * @return the sale cart that was updated
	 */
	public static SaleCart updateSaleCart(SaleCart saleCart) {
		return getService().updateSaleCart(saleCart);
	}

	public static SaleCart updateSaleCartById(SaleCart saleCart) {
		return getService().updateSaleCartById(saleCart);
	}

	public static SaleCartLocalService getService() {
		return _service;
	}

	private static volatile SaleCartLocalService _service;

}