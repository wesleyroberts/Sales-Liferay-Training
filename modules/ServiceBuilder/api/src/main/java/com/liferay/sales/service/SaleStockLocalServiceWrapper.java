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
 * Provides a wrapper for {@link SaleStockLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SaleStockLocalService
 * @generated
 */
public class SaleStockLocalServiceWrapper
	implements SaleStockLocalService, ServiceWrapper<SaleStockLocalService> {

	public SaleStockLocalServiceWrapper(
		SaleStockLocalService saleStockLocalService) {

		_saleStockLocalService = saleStockLocalService;
	}

	/**
	 * Adds the sale stock to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SaleStockLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param saleStock the sale stock
	 * @return the sale stock that was added
	 */
	@Override
	public com.liferay.sales.model.SaleStock addSaleStock(
		com.liferay.sales.model.SaleStock saleStock) {

		return _saleStockLocalService.addSaleStock(saleStock);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _saleStockLocalService.createPersistedModel(primaryKeyObj);
	}

	@Override
	public com.liferay.sales.model.SaleStock createSaleStock() {
		return _saleStockLocalService.createSaleStock();
	}

	/**
	 * Creates a new sale stock with the primary key. Does not add the sale stock to the database.
	 *
	 * @param StockId the primary key for the new sale stock
	 * @return the new sale stock
	 */
	@Override
	public com.liferay.sales.model.SaleStock createSaleStock(long StockId) {
		return _saleStockLocalService.createSaleStock(StockId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _saleStockLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public void deletesaleCartById(long id) {
		_saleStockLocalService.deletesaleCartById(id);
	}

	/**
	 * Deletes the sale stock with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SaleStockLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param StockId the primary key of the sale stock
	 * @return the sale stock that was removed
	 * @throws PortalException if a sale stock with the primary key could not be found
	 */
	@Override
	public com.liferay.sales.model.SaleStock deleteSaleStock(long StockId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _saleStockLocalService.deleteSaleStock(StockId);
	}

	/**
	 * Deletes the sale stock from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SaleStockLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param saleStock the sale stock
	 * @return the sale stock that was removed
	 */
	@Override
	public com.liferay.sales.model.SaleStock deleteSaleStock(
		com.liferay.sales.model.SaleStock saleStock) {

		return _saleStockLocalService.deleteSaleStock(saleStock);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _saleStockLocalService.dynamicQuery();
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

		return _saleStockLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.sales.model.impl.SaleStockModelImpl</code>.
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

		return _saleStockLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.sales.model.impl.SaleStockModelImpl</code>.
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

		return _saleStockLocalService.dynamicQuery(
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

		return _saleStockLocalService.dynamicQueryCount(dynamicQuery);
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

		return _saleStockLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.sales.model.SaleStock fetchSaleStock(long StockId) {
		return _saleStockLocalService.fetchSaleStock(StockId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _saleStockLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.liferay.sales.model.SaleStock> getAllSaleStock() {
		return _saleStockLocalService.getAllSaleStock();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _saleStockLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _saleStockLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _saleStockLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the sale stock with the primary key.
	 *
	 * @param StockId the primary key of the sale stock
	 * @return the sale stock
	 * @throws PortalException if a sale stock with the primary key could not be found
	 */
	@Override
	public com.liferay.sales.model.SaleStock getSaleStock(long StockId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _saleStockLocalService.getSaleStock(StockId);
	}

	@Override
	public com.liferay.sales.model.SaleStock getSaleStockById(long id) {
		return _saleStockLocalService.getSaleStockById(id);
	}

	/**
	 * Returns a range of all the sale stocks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.sales.model.impl.SaleStockModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sale stocks
	 * @param end the upper bound of the range of sale stocks (not inclusive)
	 * @return the range of sale stocks
	 */
	@Override
	public java.util.List<com.liferay.sales.model.SaleStock> getSaleStocks(
		int start, int end) {

		return _saleStockLocalService.getSaleStocks(start, end);
	}

	/**
	 * Returns the number of sale stocks.
	 *
	 * @return the number of sale stocks
	 */
	@Override
	public int getSaleStocksCount() {
		return _saleStockLocalService.getSaleStocksCount();
	}

	/**
	 * Updates the sale stock in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SaleStockLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param saleStock the sale stock
	 * @return the sale stock that was updated
	 */
	@Override
	public com.liferay.sales.model.SaleStock updateSaleStock(
		com.liferay.sales.model.SaleStock saleStock) {

		return _saleStockLocalService.updateSaleStock(saleStock);
	}

	@Override
	public com.liferay.sales.model.SaleStock updateStock(
		long stockId, int quantity) {

		return _saleStockLocalService.updateStock(stockId, quantity);
	}

	@Override
	public SaleStockLocalService getWrappedService() {
		return _saleStockLocalService;
	}

	@Override
	public void setWrappedService(SaleStockLocalService saleStockLocalService) {
		_saleStockLocalService = saleStockLocalService;
	}

	private SaleStockLocalService _saleStockLocalService;

}