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

package com.liferay.sales.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.sales.service.SaleStockServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>SaleStockServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SaleStockServiceSoap
 * @generated
 */
public class SaleStockServiceHttp {

	public static java.util.List<com.liferay.sales.model.SaleStock>
		getAllSaleStock(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				SaleStockServiceUtil.class, "getAllSaleStock",
				_getAllSaleStockParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.liferay.sales.model.SaleStock>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.sales.model.SaleStock updateStock(
		HttpPrincipal httpPrincipal, long stockId, int quantity, String name,
		long typeId, long categoryId, double price) {

		try {
			MethodKey methodKey = new MethodKey(
				SaleStockServiceUtil.class, "updateStock",
				_updateStockParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, stockId, quantity, name, typeId, categoryId, price);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.sales.model.SaleStock)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.sales.model.SaleStock createSaleStock(
		HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				SaleStockServiceUtil.class, "createSaleStock",
				_createSaleStockParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.sales.model.SaleStock)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.sales.model.SaleStock getSaleStockById(
		HttpPrincipal httpPrincipal, long id) {

		try {
			MethodKey methodKey = new MethodKey(
				SaleStockServiceUtil.class, "getSaleStockById",
				_getSaleStockByIdParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, id);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.sales.model.SaleStock)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void deletesaleStockById(
		HttpPrincipal httpPrincipal, long id) {

		try {
			MethodKey methodKey = new MethodKey(
				SaleStockServiceUtil.class, "deletesaleStockById",
				_deletesaleStockByIdParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey, id);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.sales.model.SaleStock getSaleStockByProduct(
		HttpPrincipal httpPrincipal,
		com.liferay.sales.model.SaleProduct product) {

		try {
			MethodKey methodKey = new MethodKey(
				SaleStockServiceUtil.class, "getSaleStockByProduct",
				_getSaleStockByProductParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey, product);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.sales.model.SaleStock)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SaleStockServiceHttp.class);

	private static final Class<?>[] _getAllSaleStockParameterTypes0 =
		new Class[] {};
	private static final Class<?>[] _updateStockParameterTypes1 = new Class[] {
		long.class, int.class, String.class, long.class, long.class,
		double.class
	};
	private static final Class<?>[] _createSaleStockParameterTypes2 =
		new Class[] {};
	private static final Class<?>[] _getSaleStockByIdParameterTypes3 =
		new Class[] {long.class};
	private static final Class<?>[] _deletesaleStockByIdParameterTypes4 =
		new Class[] {long.class};
	private static final Class<?>[] _getSaleStockByProductParameterTypes5 =
		new Class[] {com.liferay.sales.model.SaleProduct.class};

}