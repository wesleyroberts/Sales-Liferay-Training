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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.sales.model.SaleProduct;
import com.liferay.sales.service.SaleProductService;
import com.liferay.sales.service.SaleProductServiceUtil;
import com.liferay.sales.service.persistence.CartProductsListPersistence;
import com.liferay.sales.service.persistence.SaleCartPersistence;
import com.liferay.sales.service.persistence.SaleCategoryPersistence;
import com.liferay.sales.service.persistence.SaleProductPersistence;
import com.liferay.sales.service.persistence.SaleStockPersistence;
import com.liferay.sales.service.persistence.SaleTypePersistence;
import com.liferay.sales.service.persistence.StockProductsListPersistence;

import java.lang.reflect.Field;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the sale product remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.sales.service.impl.SaleProductServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.sales.service.impl.SaleProductServiceImpl
 * @generated
 */
public abstract class SaleProductServiceBaseImpl
	extends BaseServiceImpl
	implements AopService, IdentifiableOSGiService, SaleProductService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>SaleProductService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>SaleProductServiceUtil</code>.
	 */
	@Deactivate
	protected void deactivate() {
		_setServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			SaleProductService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		saleProductService = (SaleProductService)aopProxy;

		_setServiceUtilService(saleProductService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return SaleProductService.class.getName();
	}

	protected Class<?> getModelClass() {
		return SaleProduct.class;
	}

	protected String getModelClassName() {
		return SaleProduct.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = saleProductPersistence.getDataSource();

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

	private void _setServiceUtilService(SaleProductService saleProductService) {
		try {
			Field field = SaleProductServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, saleProductService);
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
	protected com.liferay.sales.service.SaleProductLocalService
		saleProductLocalService;

	protected SaleProductService saleProductService;

	@Reference
	protected SaleProductPersistence saleProductPersistence;

	@Reference
	protected SaleStockPersistence saleStockPersistence;

	@Reference
	protected SaleTypePersistence saleTypePersistence;

	@Reference
	protected StockProductsListPersistence stockProductsListPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserService userService;

}