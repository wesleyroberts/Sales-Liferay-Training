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

package com.liferay.sales.service.base;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.sales.model.StockProductsList;
import com.liferay.sales.service.StockProductsListLocalService;
import com.liferay.sales.service.StockProductsListLocalServiceUtil;
import com.liferay.sales.service.persistence.CartProductsListPersistence;
import com.liferay.sales.service.persistence.SaleCartPersistence;
import com.liferay.sales.service.persistence.SaleCategoryPersistence;
import com.liferay.sales.service.persistence.SaleProductPersistence;
import com.liferay.sales.service.persistence.SaleStockPersistence;
import com.liferay.sales.service.persistence.SaleTypePersistence;
import com.liferay.sales.service.persistence.StockProductsListPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the stock products list local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.sales.service.impl.StockProductsListLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.sales.service.impl.StockProductsListLocalServiceImpl
 * @generated
 */
public abstract class StockProductsListLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService,
			   StockProductsListLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>StockProductsListLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>StockProductsListLocalServiceUtil</code>.
	 */

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
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public StockProductsList addStockProductsList(
		StockProductsList stockProductsList) {

		stockProductsList.setNew(true);

		return stockProductsListPersistence.update(stockProductsList);
	}

	/**
	 * Creates a new stock products list with the primary key. Does not add the stock products list to the database.
	 *
	 * @param productId the primary key for the new stock products list
	 * @return the new stock products list
	 */
	@Override
	@Transactional(enabled = false)
	public StockProductsList createStockProductsList(long productId) {
		return stockProductsListPersistence.create(productId);
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
	@Indexable(type = IndexableType.DELETE)
	@Override
	public StockProductsList deleteStockProductsList(long productId)
		throws PortalException {

		return stockProductsListPersistence.remove(productId);
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
	@Indexable(type = IndexableType.DELETE)
	@Override
	public StockProductsList deleteStockProductsList(
		StockProductsList stockProductsList) {

		return stockProductsListPersistence.remove(stockProductsList);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			StockProductsList.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return stockProductsListPersistence.findWithDynamicQuery(dynamicQuery);
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
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return stockProductsListPersistence.findWithDynamicQuery(
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
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return stockProductsListPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return stockProductsListPersistence.countWithDynamicQuery(dynamicQuery);
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
		DynamicQuery dynamicQuery, Projection projection) {

		return stockProductsListPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public StockProductsList fetchStockProductsList(long productId) {
		return stockProductsListPersistence.fetchByPrimaryKey(productId);
	}

	/**
	 * Returns the stock products list with the primary key.
	 *
	 * @param productId the primary key of the stock products list
	 * @return the stock products list
	 * @throws PortalException if a stock products list with the primary key could not be found
	 */
	@Override
	public StockProductsList getStockProductsList(long productId)
		throws PortalException {

		return stockProductsListPersistence.findByPrimaryKey(productId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			stockProductsListLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(StockProductsList.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("productId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			stockProductsListLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(StockProductsList.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("productId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			stockProductsListLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(StockProductsList.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("productId");
	}

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return stockProductsListPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return stockProductsListLocalService.deleteStockProductsList(
			(StockProductsList)persistedModel);
	}

	public BasePersistence<StockProductsList> getBasePersistence() {
		return stockProductsListPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return stockProductsListPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<StockProductsList> getStockProductsLists(int start, int end) {
		return stockProductsListPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of stock products lists.
	 *
	 * @return the number of stock products lists
	 */
	@Override
	public int getStockProductsListsCount() {
		return stockProductsListPersistence.countAll();
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
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public StockProductsList updateStockProductsList(
		StockProductsList stockProductsList) {

		return stockProductsListPersistence.update(stockProductsList);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			StockProductsListLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		stockProductsListLocalService = (StockProductsListLocalService)aopProxy;

		_setLocalServiceUtilService(stockProductsListLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return StockProductsListLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return StockProductsList.class;
	}

	protected String getModelClassName() {
		return StockProductsList.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				stockProductsListPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setLocalServiceUtilService(
		StockProductsListLocalService stockProductsListLocalService) {

		try {
			Field field =
				StockProductsListLocalServiceUtil.class.getDeclaredField(
					"_service");

			field.setAccessible(true);

			field.set(null, stockProductsListLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected CartProductsListPersistence cartProductsListPersistence;

	@Reference
	protected SaleCartPersistence saleCartPersistence;

	@Reference
	protected SaleCategoryPersistence saleCategoryPersistence;

	@Reference
	protected SaleProductPersistence saleProductPersistence;

	@Reference
	protected SaleStockPersistence saleStockPersistence;

	@Reference
	protected SaleTypePersistence saleTypePersistence;

	protected StockProductsListLocalService stockProductsListLocalService;

	@Reference
	protected StockProductsListPersistence stockProductsListPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}