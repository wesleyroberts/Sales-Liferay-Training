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
 * Provides a wrapper for {@link SaleProductLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SaleProductLocalService
 * @generated
 */
public class SaleProductLocalServiceWrapper
	implements SaleProductLocalService,
			   ServiceWrapper<SaleProductLocalService> {

	public SaleProductLocalServiceWrapper(
		SaleProductLocalService saleProductLocalService) {

		_saleProductLocalService = saleProductLocalService;
	}

	/**
	 * Adds the sale product to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SaleProductLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param saleProduct the sale product
	 * @return the sale product that was added
	 */
	@Override
	public com.liferay.sales.model.SaleProduct addSaleProduct(
		com.liferay.sales.model.SaleProduct saleProduct) {

		return _saleProductLocalService.addSaleProduct(saleProduct);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _saleProductLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new sale product with the primary key. Does not add the sale product to the database.
	 *
	 * @param productId the primary key for the new sale product
	 * @return the new sale product
	 */
	@Override
	public com.liferay.sales.model.SaleProduct createSaleProduct(
		long productId) {

		return _saleProductLocalService.createSaleProduct(productId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _saleProductLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the sale product with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SaleProductLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productId the primary key of the sale product
	 * @return the sale product that was removed
	 * @throws PortalException if a sale product with the primary key could not be found
	 */
	@Override
	public com.liferay.sales.model.SaleProduct deleteSaleProduct(long productId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _saleProductLocalService.deleteSaleProduct(productId);
	}

	/**
	 * Deletes the sale product from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SaleProductLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param saleProduct the sale product
	 * @return the sale product that was removed
	 */
	@Override
	public com.liferay.sales.model.SaleProduct deleteSaleProduct(
		com.liferay.sales.model.SaleProduct saleProduct) {

		return _saleProductLocalService.deleteSaleProduct(saleProduct);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _saleProductLocalService.dynamicQuery();
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

		return _saleProductLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.sales.model.impl.SaleProductModelImpl</code>.
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

		return _saleProductLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.sales.model.impl.SaleProductModelImpl</code>.
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

		return _saleProductLocalService.dynamicQuery(
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

		return _saleProductLocalService.dynamicQueryCount(dynamicQuery);
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

		return _saleProductLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.sales.model.SaleProduct fetchSaleProduct(
		long productId) {

		return _saleProductLocalService.fetchSaleProduct(productId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _saleProductLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _saleProductLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _saleProductLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _saleProductLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the sale product with the primary key.
	 *
	 * @param productId the primary key of the sale product
	 * @return the sale product
	 * @throws PortalException if a sale product with the primary key could not be found
	 */
	@Override
	public com.liferay.sales.model.SaleProduct getSaleProduct(long productId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _saleProductLocalService.getSaleProduct(productId);
	}

	/**
	 * Returns a range of all the sale products.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.sales.model.impl.SaleProductModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sale products
	 * @param end the upper bound of the range of sale products (not inclusive)
	 * @return the range of sale products
	 */
	@Override
	public java.util.List<com.liferay.sales.model.SaleProduct> getSaleProducts(
		int start, int end) {

		return _saleProductLocalService.getSaleProducts(start, end);
	}

	/**
	 * Returns the number of sale products.
	 *
	 * @return the number of sale products
	 */
	@Override
	public int getSaleProductsCount() {
		return _saleProductLocalService.getSaleProductsCount();
	}

	/**
	 * Updates the sale product in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SaleProductLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param saleProduct the sale product
	 * @return the sale product that was updated
	 */
	@Override
	public com.liferay.sales.model.SaleProduct updateSaleProduct(
		com.liferay.sales.model.SaleProduct saleProduct) {

		return _saleProductLocalService.updateSaleProduct(saleProduct);
	}

	@Override
	public SaleProductLocalService getWrappedService() {
		return _saleProductLocalService;
	}

	@Override
	public void setWrappedService(
		SaleProductLocalService saleProductLocalService) {

		_saleProductLocalService = saleProductLocalService;
	}

	private SaleProductLocalService _saleProductLocalService;

}