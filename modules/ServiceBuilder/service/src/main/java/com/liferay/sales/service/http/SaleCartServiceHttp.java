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
import com.liferay.sales.service.SaleCartServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>SaleCartServiceUtil</code> service
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
 * @see SaleCartServiceSoap
 * @generated
 */
public class SaleCartServiceHttp {

	public static java.util.List<com.liferay.sales.model.SaleCart>
		getAllSaleCart(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				SaleCartServiceUtil.class, "getAllSaleCart",
				_getAllSaleCartParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.liferay.sales.model.SaleCart>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.sales.model.SaleCart getSaleCartById(
		HttpPrincipal httpPrincipal, long id) {

		try {
			MethodKey methodKey = new MethodKey(
				SaleCartServiceUtil.class, "getSaleCartById",
				_getSaleCartByIdParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, id);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.sales.model.SaleCart)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.sales.model.SaleCart
		addProductPriceToCartTotalValue(
			HttpPrincipal httpPrincipal, double price, long cartId) {

		try {
			MethodKey methodKey = new MethodKey(
				SaleCartServiceUtil.class, "addProductPriceToCartTotalValue",
				_addProductPriceToCartTotalValueParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, price, cartId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.sales.model.SaleCart)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.sales.model.SaleCart
		removeProductPriceToCartTotalValue(
			HttpPrincipal httpPrincipal, double price, long cartId) {

		try {
			MethodKey methodKey = new MethodKey(
				SaleCartServiceUtil.class, "removeProductPriceToCartTotalValue",
				_removeProductPriceToCartTotalValueParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, price, cartId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.sales.model.SaleCart)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static Double getFinalValueByCartId(
		HttpPrincipal httpPrincipal, long cartId) {

		try {
			MethodKey methodKey = new MethodKey(
				SaleCartServiceUtil.class, "getFinalValueByCartId",
				_getFinalValueByCartIdParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey, cartId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (Double)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.sales.model.SaleCart createSaleCartById(
		HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				SaleCartServiceUtil.class, "createSaleCartById",
				_createSaleCartByIdParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.sales.model.SaleCart)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void deleteSaleCartById(
		HttpPrincipal httpPrincipal, long cartId) {

		try {
			MethodKey methodKey = new MethodKey(
				SaleCartServiceUtil.class, "deleteSaleCartById",
				_deleteSaleCartByIdParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(methodKey, cartId);

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

	public static com.liferay.sales.model.SaleCart updateSaleCartById(
		HttpPrincipal httpPrincipal,
		com.liferay.sales.model.SaleCart saleCart) {

		try {
			MethodKey methodKey = new MethodKey(
				SaleCartServiceUtil.class, "updateSaleCartById",
				_updateSaleCartByIdParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, saleCart);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.sales.model.SaleCart)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SaleCartServiceHttp.class);

	private static final Class<?>[] _getAllSaleCartParameterTypes0 =
		new Class[] {};
	private static final Class<?>[] _getSaleCartByIdParameterTypes1 =
		new Class[] {long.class};
	private static final Class<?>[]
		_addProductPriceToCartTotalValueParameterTypes2 = new Class[] {
			double.class, long.class
		};
	private static final Class<?>[]
		_removeProductPriceToCartTotalValueParameterTypes3 = new Class[] {
			double.class, long.class
		};
	private static final Class<?>[] _getFinalValueByCartIdParameterTypes4 =
		new Class[] {long.class};
	private static final Class<?>[] _createSaleCartByIdParameterTypes5 =
		new Class[] {};
	private static final Class<?>[] _deleteSaleCartByIdParameterTypes6 =
		new Class[] {long.class};
	private static final Class<?>[] _updateSaleCartByIdParameterTypes7 =
		new Class[] {com.liferay.sales.model.SaleCart.class};

}