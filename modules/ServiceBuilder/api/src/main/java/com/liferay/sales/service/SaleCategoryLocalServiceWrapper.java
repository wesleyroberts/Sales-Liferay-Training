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
 * Provides a wrapper for {@link SaleCategoryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SaleCategoryLocalService
 * @generated
 */
public class SaleCategoryLocalServiceWrapper
	implements SaleCategoryLocalService,
			   ServiceWrapper<SaleCategoryLocalService> {

	public SaleCategoryLocalServiceWrapper(
		SaleCategoryLocalService saleCategoryLocalService) {

		_saleCategoryLocalService = saleCategoryLocalService;
	}

	/**
	 * Adds the sale category to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SaleCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param saleCategory the sale category
	 * @return the sale category that was added
	 */
	@Override
	public com.liferay.sales.model.SaleCategory addSaleCategory(
		com.liferay.sales.model.SaleCategory saleCategory) {

		return _saleCategoryLocalService.addSaleCategory(saleCategory);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _saleCategoryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new sale category with the primary key. Does not add the sale category to the database.
	 *
	 * @param categoryId the primary key for the new sale category
	 * @return the new sale category
	 */
	@Override
	public com.liferay.sales.model.SaleCategory createSaleCategory(
		long categoryId) {

		return _saleCategoryLocalService.createSaleCategory(categoryId);
	}

	@Override
	public com.liferay.sales.model.SaleCategory createSaleCategory(
		String name, double tax) {

		return _saleCategoryLocalService.createSaleCategory(name, tax);
	}

	@Override
	public void deleteCategoryById(long id) {
		_saleCategoryLocalService.deleteCategoryById(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _saleCategoryLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the sale category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SaleCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param categoryId the primary key of the sale category
	 * @return the sale category that was removed
	 * @throws PortalException if a sale category with the primary key could not be found
	 */
	@Override
	public com.liferay.sales.model.SaleCategory deleteSaleCategory(
			long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _saleCategoryLocalService.deleteSaleCategory(categoryId);
	}

	/**
	 * Deletes the sale category from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SaleCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param saleCategory the sale category
	 * @return the sale category that was removed
	 */
	@Override
	public com.liferay.sales.model.SaleCategory deleteSaleCategory(
		com.liferay.sales.model.SaleCategory saleCategory) {

		return _saleCategoryLocalService.deleteSaleCategory(saleCategory);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _saleCategoryLocalService.dynamicQuery();
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

		return _saleCategoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.sales.model.impl.SaleCategoryModelImpl</code>.
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

		return _saleCategoryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.sales.model.impl.SaleCategoryModelImpl</code>.
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

		return _saleCategoryLocalService.dynamicQuery(
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

		return _saleCategoryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _saleCategoryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.sales.model.SaleCategory fetchSaleCategory(
		long categoryId) {

		return _saleCategoryLocalService.fetchSaleCategory(categoryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _saleCategoryLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.liferay.sales.model.SaleCategory> getAll() {
		return _saleCategoryLocalService.getAll();
	}

	@Override
	public com.liferay.sales.model.SaleCategory getByCategoryName(String name) {
		return _saleCategoryLocalService.getByCategoryName(name);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _saleCategoryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _saleCategoryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _saleCategoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns a range of all the sale categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.sales.model.impl.SaleCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sale categories
	 * @param end the upper bound of the range of sale categories (not inclusive)
	 * @return the range of sale categories
	 */
	@Override
	public java.util.List<com.liferay.sales.model.SaleCategory>
		getSaleCategories(int start, int end) {

		return _saleCategoryLocalService.getSaleCategories(start, end);
	}

	/**
	 * Returns the number of sale categories.
	 *
	 * @return the number of sale categories
	 */
	@Override
	public int getSaleCategoriesCount() {
		return _saleCategoryLocalService.getSaleCategoriesCount();
	}

	/**
	 * Returns the sale category with the primary key.
	 *
	 * @param categoryId the primary key of the sale category
	 * @return the sale category
	 * @throws PortalException if a sale category with the primary key could not be found
	 */
	@Override
	public com.liferay.sales.model.SaleCategory getSaleCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _saleCategoryLocalService.getSaleCategory(categoryId);
	}

	@Override
	public com.liferay.sales.model.SaleCategory getSaleCategoryById(long id) {
		return _saleCategoryLocalService.getSaleCategoryById(id);
	}

	/**
	 * Updates the sale category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SaleCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param saleCategory the sale category
	 * @return the sale category that was updated
	 */
	@Override
	public com.liferay.sales.model.SaleCategory updateSaleCategory(
		com.liferay.sales.model.SaleCategory saleCategory) {

		return _saleCategoryLocalService.updateSaleCategory(saleCategory);
	}

	@Override
	public SaleCategoryLocalService getWrappedService() {
		return _saleCategoryLocalService;
	}

	@Override
	public void setWrappedService(
		SaleCategoryLocalService saleCategoryLocalService) {

		_saleCategoryLocalService = saleCategoryLocalService;
	}

	private SaleCategoryLocalService _saleCategoryLocalService;

}