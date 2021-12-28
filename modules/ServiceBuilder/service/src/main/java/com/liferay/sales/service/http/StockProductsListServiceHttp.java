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
import com.liferay.sales.service.StockProductsListServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>StockProductsListServiceUtil</code> service
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
 * @see StockProductsListServiceSoap
 * @generated
 */
public class StockProductsListServiceHttp {

	public static com.liferay.sales.model.SaleStock addProductToStock(
		HttpPrincipal httpPrincipal,
		com.liferay.sales.model.SaleProduct product) {

		try {
			MethodKey methodKey = new MethodKey(
				StockProductsListServiceUtil.class, "addProductToStock",
				_addProductToStockParameterTypes0);

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

	public static java.util.List<com.liferay.sales.model.SaleProduct>
		getAllProductInStock(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				StockProductsListServiceUtil.class, "getAllProductInStock",
				_getAllProductInStockParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.liferay.sales.model.SaleProduct>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.sales.model.SaleProduct>
		getAllProductInStockByProductName(
			HttpPrincipal httpPrincipal, String name) {

		try {
			MethodKey methodKey = new MethodKey(
				StockProductsListServiceUtil.class,
				"getAllProductInStockByProductName",
				_getAllProductInStockByProductNameParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, name);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.liferay.sales.model.SaleProduct>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.sales.model.SaleProduct>
		getAllProductInStockByStockId(
			HttpPrincipal httpPrincipal, long stockId) {

		try {
			MethodKey methodKey = new MethodKey(
				StockProductsListServiceUtil.class,
				"getAllProductInStockByStockId",
				_getAllProductInStockByStockIdParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, stockId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.liferay.sales.model.SaleProduct>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void deleteStockProductListByID(
		HttpPrincipal httpPrincipal, long id) {

		try {
			MethodKey methodKey = new MethodKey(
				StockProductsListServiceUtil.class,
				"deleteStockProductListByID",
				_deleteStockProductListByIDParameterTypes4);

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

	public static void removeProductFromStock(
		HttpPrincipal httpPrincipal, long productID) {

		try {
			MethodKey methodKey = new MethodKey(
				StockProductsListServiceUtil.class, "removeProductFromStock",
				_removeProductFromStockParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, productID);

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

	public static int checkQuantityInStockByStockId(
		HttpPrincipal httpPrincipal, long stcokId) {

		try {
			MethodKey methodKey = new MethodKey(
				StockProductsListServiceUtil.class,
				"checkQuantityInStockByStockId",
				_checkQuantityInStockByStockIdParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(methodKey, stcokId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		StockProductsListServiceHttp.class);

	private static final Class<?>[] _addProductToStockParameterTypes0 =
		new Class[] {com.liferay.sales.model.SaleProduct.class};
	private static final Class<?>[] _getAllProductInStockParameterTypes1 =
		new Class[] {};
	private static final Class<?>[]
		_getAllProductInStockByProductNameParameterTypes2 = new Class[] {
			String.class
		};
	private static final Class<?>[]
		_getAllProductInStockByStockIdParameterTypes3 = new Class[] {
			long.class
		};
	private static final Class<?>[] _deleteStockProductListByIDParameterTypes4 =
		new Class[] {long.class};
	private static final Class<?>[] _removeProductFromStockParameterTypes5 =
		new Class[] {long.class};
	private static final Class<?>[]
		_checkQuantityInStockByStockIdParameterTypes6 = new Class[] {
			long.class
		};

}