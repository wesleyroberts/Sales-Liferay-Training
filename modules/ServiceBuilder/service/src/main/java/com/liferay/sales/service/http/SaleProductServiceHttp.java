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
import com.liferay.sales.service.SaleProductServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>SaleProductServiceUtil</code> service
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
 * @see SaleProductServiceSoap
 * @generated
 */
public class SaleProductServiceHttp {

	public static com.liferay.sales.model.SaleProduct createSaleProduct(
		HttpPrincipal httpPrincipal, String name, double price, long categoryId,
		long typeId, int quantity) {

		try {
			MethodKey methodKey = new MethodKey(
				SaleProductServiceUtil.class, "createSaleProduct",
				_createSaleProductParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, name, price, categoryId, typeId, quantity);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.sales.model.SaleProduct)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.sales.model.SaleProduct>
		getAllSaleProducts(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				SaleProductServiceUtil.class, "getAllSaleProducts",
				_getAllSaleProductsParameterTypes1);

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

	public static com.liferay.sales.model.SaleProduct updateSaleProduct(
		HttpPrincipal httpPrincipal, long productId, String name, double price,
		long categoryId, long typeId) {

		try {
			MethodKey methodKey = new MethodKey(
				SaleProductServiceUtil.class, "updateSaleProduct",
				_updateSaleProductParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, productId, name, price, categoryId, typeId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.sales.model.SaleProduct)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.sales.model.SaleProduct addSaleProductInStock(
		HttpPrincipal httpPrincipal, long porductId, int quantity) {

		try {
			MethodKey methodKey = new MethodKey(
				SaleProductServiceUtil.class, "addSaleProductInStock",
				_addSaleProductInStockParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, porductId, quantity);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.sales.model.SaleProduct)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.sales.model.SaleProduct removeSaleProductInStock(
		HttpPrincipal httpPrincipal, long porductId, int quantity) {

		try {
			MethodKey methodKey = new MethodKey(
				SaleProductServiceUtil.class, "removeSaleProductInStock",
				_removeSaleProductInStockParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, porductId, quantity);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.sales.model.SaleProduct)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.sales.model.SaleProduct getSaleProductById(
		HttpPrincipal httpPrincipal, long id) {

		try {
			MethodKey methodKey = new MethodKey(
				SaleProductServiceUtil.class, "getSaleProductById",
				_getSaleProductByIdParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey, id);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.sales.model.SaleProduct)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.sales.model.SaleProduct getSaleProductByName(
		HttpPrincipal httpPrincipal, String name) {

		try {
			MethodKey methodKey = new MethodKey(
				SaleProductServiceUtil.class, "getSaleProductByName",
				_getSaleProductByNameParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(methodKey, name);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.sales.model.SaleProduct)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.sales.model.SaleProduct deleteById(
		HttpPrincipal httpPrincipal, long id) {

		try {
			MethodKey methodKey = new MethodKey(
				SaleProductServiceUtil.class, "deleteById",
				_deleteByIdParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(methodKey, id);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.sales.model.SaleProduct)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		SaleProductServiceHttp.class);

	private static final Class<?>[] _createSaleProductParameterTypes0 =
		new Class[] {
			String.class, double.class, long.class, long.class, int.class
		};
	private static final Class<?>[] _getAllSaleProductsParameterTypes1 =
		new Class[] {};
	private static final Class<?>[] _updateSaleProductParameterTypes2 =
		new Class[] {
			long.class, String.class, double.class, long.class, long.class
		};
	private static final Class<?>[] _addSaleProductInStockParameterTypes3 =
		new Class[] {long.class, int.class};
	private static final Class<?>[] _removeSaleProductInStockParameterTypes4 =
		new Class[] {long.class, int.class};
	private static final Class<?>[] _getSaleProductByIdParameterTypes5 =
		new Class[] {long.class};
	private static final Class<?>[] _getSaleProductByNameParameterTypes6 =
		new Class[] {String.class};
	private static final Class<?>[] _deleteByIdParameterTypes7 = new Class[] {
		long.class
	};

}