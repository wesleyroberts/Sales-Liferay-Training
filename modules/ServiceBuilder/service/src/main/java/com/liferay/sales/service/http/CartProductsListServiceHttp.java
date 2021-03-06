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
import com.liferay.sales.service.CartProductsListServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>CartProductsListServiceUtil</code> service
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
 * @see CartProductsListServiceSoap
 * @generated
 */
public class CartProductsListServiceHttp {

	public static java.util.List<com.liferay.sales.model.SaleProduct>
		getAllProductsByCarID(HttpPrincipal httpPrincipal, long id) {

		try {
			MethodKey methodKey = new MethodKey(
				CartProductsListServiceUtil.class, "getAllProductsByCarID",
				_getAllProductsByCarIDParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, id);

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
		addProductToCartList(
			HttpPrincipal httpPrincipal, int quantity, long cartId,
			long stockId) {

		try {
			MethodKey methodKey = new MethodKey(
				CartProductsListServiceUtil.class, "addProductToCartList",
				_addProductToCartListParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, quantity, cartId, stockId);

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

	public static void removeProductToCartList(
		HttpPrincipal httpPrincipal, long cartId, long productId) {

		try {
			MethodKey methodKey = new MethodKey(
				CartProductsListServiceUtil.class, "removeProductToCartList",
				_removeProductToCartListParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, cartId, productId);

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

	public static java.util.List<com.liferay.sales.model.CartProductsList>
		getAllCartProductsList(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				CartProductsListServiceUtil.class, "getAllCartProductsList",
				_getAllCartProductsListParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.liferay.sales.model.CartProductsList>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void deleteCartProductsList(
			HttpPrincipal httpPrincipal, long productId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				CartProductsListServiceUtil.class, "deleteCartProductsList",
				_deleteCartProductsListParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, productId);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

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

	public static com.liferay.sales.model.SaleCart finishCart(
		HttpPrincipal httpPrincipal, long cartId) {

		try {
			MethodKey methodKey = new MethodKey(
				CartProductsListServiceUtil.class, "finishCart",
				_finishCartParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey, cartId);

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

	private static Log _log = LogFactoryUtil.getLog(
		CartProductsListServiceHttp.class);

	private static final Class<?>[] _getAllProductsByCarIDParameterTypes0 =
		new Class[] {long.class};
	private static final Class<?>[] _addProductToCartListParameterTypes1 =
		new Class[] {int.class, long.class, long.class};
	private static final Class<?>[] _removeProductToCartListParameterTypes2 =
		new Class[] {long.class, long.class};
	private static final Class<?>[] _getAllCartProductsListParameterTypes3 =
		new Class[] {};
	private static final Class<?>[] _deleteCartProductsListParameterTypes4 =
		new Class[] {long.class};
	private static final Class<?>[] _finishCartParameterTypes5 = new Class[] {
		long.class
	};

}