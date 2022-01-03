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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SaleCartLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SaleCartLocalService
 * @generated
 */
public class SaleCartLocalServiceWrapper
	implements SaleCartLocalService, ServiceWrapper<SaleCartLocalService> {

	public SaleCartLocalServiceWrapper(
		SaleCartLocalService saleCartLocalService) {

		_saleCartLocalService = saleCartLocalService;
	}

	@Override
	public com.liferay.sales.model.SaleCart addProductPriceToCartTotalValue(
		double price, long cartId) {

		return _saleCartLocalService.addProductPriceToCartTotalValue(
			price, cartId);
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
	@Override
	public com.liferay.sales.model.SaleCart addSaleCart(
		com.liferay.sales.model.SaleCart saleCart) {

		return _saleCartLocalService.addSaleCart(saleCart);
	}

	@Override
	public com.liferay.sales.model.SaleCart addSaleCartById() {
		return _saleCartLocalService.addSaleCartById();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _saleCartLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new sale cart with the primary key. Does not add the sale cart to the database.
	 *
	 * @param cartId the primary key for the new sale cart
	 * @return the new sale cart
	 */
	@Override
	public com.liferay.sales.model.SaleCart createSaleCart(long cartId) {
		return _saleCartLocalService.createSaleCart(cartId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _saleCartLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public com.liferay.sales.model.SaleCart deleteSaleCart(long cartId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _saleCartLocalService.deleteSaleCart(cartId);
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
	@Override
	public com.liferay.sales.model.SaleCart deleteSaleCart(
		com.liferay.sales.model.SaleCart saleCart) {

		return _saleCartLocalService.deleteSaleCart(saleCart);
	}

	@Override
	public void deleteSaleCartById(long cartId) {
		_saleCartLocalService.deleteSaleCartById(cartId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _saleCartLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _saleCartLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _saleCartLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _saleCartLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _saleCartLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _saleCartLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.sales.model.SaleCart fetchSaleCart(long cartId) {
		return _saleCartLocalService.fetchSaleCart(cartId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _saleCartLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.liferay.sales.model.SaleCart> getAllSaleCart() {
		return _saleCartLocalService.getAllSaleCart();
	}

	@Override
	public Double getFinalValueByCartId(long cartId) {
		return _saleCartLocalService.getFinalValueByCartId(cartId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _saleCartLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _saleCartLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _saleCartLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the sale cart with the primary key.
	 *
	 * @param cartId the primary key of the sale cart
	 * @return the sale cart
	 * @throws PortalException if a sale cart with the primary key could not be found
	 */
	@Override
	public com.liferay.sales.model.SaleCart getSaleCart(long cartId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _saleCartLocalService.getSaleCart(cartId);
	}

	@Override
	public com.liferay.sales.model.SaleCart getSaleCartById(long id) {
		return _saleCartLocalService.getSaleCartById(id);
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
	@Override
	public java.util.List<com.liferay.sales.model.SaleCart> getSaleCarts(
		int start, int end) {

		return _saleCartLocalService.getSaleCarts(start, end);
	}

	/**
	 * Returns the number of sale carts.
	 *
	 * @return the number of sale carts
	 */
	@Override
	public int getSaleCartsCount() {
		return _saleCartLocalService.getSaleCartsCount();
	}

	@Override
	public com.liferay.sales.model.SaleCart removeProductPriceToCartTotalValue(
		double price, long cartId) {

		return _saleCartLocalService.removeProductPriceToCartTotalValue(
			price, cartId);
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
	@Override
	public com.liferay.sales.model.SaleCart updateSaleCart(
		com.liferay.sales.model.SaleCart saleCart) {

		return _saleCartLocalService.updateSaleCart(saleCart);
	}

	@Override
	public com.liferay.sales.model.SaleCart updateSaleCartById(
		com.liferay.sales.model.SaleCart saleCart) {

		return _saleCartLocalService.updateSaleCartById(saleCart);
	}

	@Override
	public SaleCartLocalService getWrappedService() {
		return _saleCartLocalService;
	}

	@Override
	public void setWrappedService(SaleCartLocalService saleCartLocalService) {
		_saleCartLocalService = saleCartLocalService;
	}

	private SaleCartLocalService _saleCartLocalService;

}