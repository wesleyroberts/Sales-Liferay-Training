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
 * Provides a wrapper for {@link SaleTypeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SaleTypeLocalService
 * @generated
 */
public class SaleTypeLocalServiceWrapper
	implements SaleTypeLocalService, ServiceWrapper<SaleTypeLocalService> {

	public SaleTypeLocalServiceWrapper(
		SaleTypeLocalService saleTypeLocalService) {

		_saleTypeLocalService = saleTypeLocalService;
	}

	/**
	 * Adds the sale type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SaleTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param saleType the sale type
	 * @return the sale type that was added
	 */
	@Override
	public com.liferay.sales.model.SaleType addSaleType(
		com.liferay.sales.model.SaleType saleType) {

		return _saleTypeLocalService.addSaleType(saleType);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _saleTypeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new sale type with the primary key. Does not add the sale type to the database.
	 *
	 * @param typeId the primary key for the new sale type
	 * @return the new sale type
	 */
	@Override
	public com.liferay.sales.model.SaleType createSaleType(long typeId) {
		return _saleTypeLocalService.createSaleType(typeId);
	}

	@Override
	public com.liferay.sales.model.SaleType createSaleType(
		long id, String name, double tax) {

		return _saleTypeLocalService.createSaleType(id, name, tax);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _saleTypeLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the sale type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SaleTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param typeId the primary key of the sale type
	 * @return the sale type that was removed
	 * @throws PortalException if a sale type with the primary key could not be found
	 */
	@Override
	public com.liferay.sales.model.SaleType deleteSaleType(long typeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _saleTypeLocalService.deleteSaleType(typeId);
	}

	/**
	 * Deletes the sale type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SaleTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param saleType the sale type
	 * @return the sale type that was removed
	 */
	@Override
	public com.liferay.sales.model.SaleType deleteSaleType(
		com.liferay.sales.model.SaleType saleType) {

		return _saleTypeLocalService.deleteSaleType(saleType);
	}

	@Override
	public void deleteTypeById(long id) {
		_saleTypeLocalService.deleteTypeById(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _saleTypeLocalService.dynamicQuery();
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

		return _saleTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.sales.model.impl.SaleTypeModelImpl</code>.
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

		return _saleTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.sales.model.impl.SaleTypeModelImpl</code>.
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

		return _saleTypeLocalService.dynamicQuery(
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

		return _saleTypeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _saleTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.sales.model.SaleType fetchSaleType(long typeId) {
		return _saleTypeLocalService.fetchSaleType(typeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _saleTypeLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.liferay.sales.model.SaleType> getAll() {
		return _saleTypeLocalService.getAll();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _saleTypeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _saleTypeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _saleTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the sale type with the primary key.
	 *
	 * @param typeId the primary key of the sale type
	 * @return the sale type
	 * @throws PortalException if a sale type with the primary key could not be found
	 */
	@Override
	public com.liferay.sales.model.SaleType getSaleType(long typeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _saleTypeLocalService.getSaleType(typeId);
	}

	@Override
	public com.liferay.sales.model.SaleType getSaleTypeById(long id) {
		return _saleTypeLocalService.getSaleTypeById(id);
	}

	/**
	 * Returns a range of all the sale types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.sales.model.impl.SaleTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sale types
	 * @param end the upper bound of the range of sale types (not inclusive)
	 * @return the range of sale types
	 */
	@Override
	public java.util.List<com.liferay.sales.model.SaleType> getSaleTypes(
		int start, int end) {

		return _saleTypeLocalService.getSaleTypes(start, end);
	}

	/**
	 * Returns the number of sale types.
	 *
	 * @return the number of sale types
	 */
	@Override
	public int getSaleTypesCount() {
		return _saleTypeLocalService.getSaleTypesCount();
	}

	/**
	 * Updates the sale type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SaleTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param saleType the sale type
	 * @return the sale type that was updated
	 */
	@Override
	public com.liferay.sales.model.SaleType updateSaleType(
		com.liferay.sales.model.SaleType saleType) {

		return _saleTypeLocalService.updateSaleType(saleType);
	}

	@Override
	public SaleTypeLocalService getWrappedService() {
		return _saleTypeLocalService;
	}

	@Override
	public void setWrappedService(SaleTypeLocalService saleTypeLocalService) {
		_saleTypeLocalService = saleTypeLocalService;
	}

	private SaleTypeLocalService _saleTypeLocalService;

}