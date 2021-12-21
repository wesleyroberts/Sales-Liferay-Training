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
 * Provides a wrapper for {@link StockProductsListLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StockProductsListLocalService
 * @generated
 */
public class StockProductsListLocalServiceWrapper
	implements ServiceWrapper<StockProductsListLocalService>,
			   StockProductsListLocalService {

	public StockProductsListLocalServiceWrapper(
		StockProductsListLocalService stockProductsListLocalService) {

		_stockProductsListLocalService = stockProductsListLocalService;
	}

	@Override
	public com.liferay.sales.model.SaleStock addProductToStock(
		com.liferay.sales.model.SaleProduct product) {

		return _stockProductsListLocalService.addProductToStock(product);
	}

	/**
	 * Adds the stock products list to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StockProductsListLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stockProductsList the stock products list
	 * @return the stock products list that was added
	 */
	@Override
	public com.liferay.sales.model.StockProductsList addStockProductsList(
		com.liferay.sales.model.StockProductsList stockProductsList) {

		return _stockProductsListLocalService.addStockProductsList(
			stockProductsList);
	}

	@Override
	public Boolean checkIfExistStock(
		com.liferay.sales.model.SaleProduct product) {

		return _stockProductsListLocalService.checkIfExistStock(product);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stockProductsListLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new stock products list with the primary key. Does not add the stock products list to the database.
	 *
	 * @param productId the primary key for the new stock products list
	 * @return the new stock products list
	 */
	@Override
	public com.liferay.sales.model.StockProductsList createStockProductsList(
		long productId) {

		return _stockProductsListLocalService.createStockProductsList(
			productId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stockProductsListLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public void deleteStockProductListByID(long id) {
		_stockProductsListLocalService.deleteStockProductListByID(id);
	}

	/**
	 * Deletes the stock products list with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StockProductsListLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productId the primary key of the stock products list
	 * @return the stock products list that was removed
	 * @throws PortalException if a stock products list with the primary key could not be found
	 */
	@Override
	public com.liferay.sales.model.StockProductsList deleteStockProductsList(
			long productId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stockProductsListLocalService.deleteStockProductsList(
			productId);
	}

	/**
	 * Deletes the stock products list from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StockProductsListLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stockProductsList the stock products list
	 * @return the stock products list that was removed
	 */
	@Override
	public com.liferay.sales.model.StockProductsList deleteStockProductsList(
		com.liferay.sales.model.StockProductsList stockProductsList) {

		return _stockProductsListLocalService.deleteStockProductsList(
			stockProductsList);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _stockProductsListLocalService.dynamicQuery();
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

		return _stockProductsListLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.sales.model.impl.StockProductsListModelImpl</code>.
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

		return _stockProductsListLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.sales.model.impl.StockProductsListModelImpl</code>.
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

		return _stockProductsListLocalService.dynamicQuery(
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

		return _stockProductsListLocalService.dynamicQueryCount(dynamicQuery);
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

		return _stockProductsListLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.sales.model.StockProductsList fetchStockProductsList(
		long productId) {

		return _stockProductsListLocalService.fetchStockProductsList(productId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _stockProductsListLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.liferay.sales.model.SaleProduct>
		getAllProductInStock() {

		return _stockProductsListLocalService.getAllProductInStock();
	}

	@Override
	public java.util.List<com.liferay.sales.model.SaleProduct>
		getAllProductInStockByProductName(String name) {

		return _stockProductsListLocalService.getAllProductInStockByProductName(
			name);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _stockProductsListLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _stockProductsListLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stockProductsListLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the stock products list with the primary key.
	 *
	 * @param productId the primary key of the stock products list
	 * @return the stock products list
	 * @throws PortalException if a stock products list with the primary key could not be found
	 */
	@Override
	public com.liferay.sales.model.StockProductsList getStockProductsList(
			long productId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stockProductsListLocalService.getStockProductsList(productId);
	}

	/**
	 * Returns a range of all the stock products lists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.sales.model.impl.StockProductsListModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of stock products lists
	 * @param end the upper bound of the range of stock products lists (not inclusive)
	 * @return the range of stock products lists
	 */
	@Override
	public java.util.List<com.liferay.sales.model.StockProductsList>
		getStockProductsLists(int start, int end) {

		return _stockProductsListLocalService.getStockProductsLists(start, end);
	}

	/**
	 * Returns the number of stock products lists.
	 *
	 * @return the number of stock products lists
	 */
	@Override
	public int getStockProductsListsCount() {
		return _stockProductsListLocalService.getStockProductsListsCount();
	}

	@Override
	public void removeProductFromStock(
		com.liferay.sales.model.SaleProduct product) {

		_stockProductsListLocalService.removeProductFromStock(product);
	}

	/**
	 * Updates the stock products list in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StockProductsListLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stockProductsList the stock products list
	 * @return the stock products list that was updated
	 */
	@Override
	public com.liferay.sales.model.StockProductsList updateStockProductsList(
		com.liferay.sales.model.StockProductsList stockProductsList) {

		return _stockProductsListLocalService.updateStockProductsList(
			stockProductsList);
	}

	@Override
	public StockProductsListLocalService getWrappedService() {
		return _stockProductsListLocalService;
	}

	@Override
	public void setWrappedService(
		StockProductsListLocalService stockProductsListLocalService) {

		_stockProductsListLocalService = stockProductsListLocalService;
	}

	private StockProductsListLocalService _stockProductsListLocalService;

}