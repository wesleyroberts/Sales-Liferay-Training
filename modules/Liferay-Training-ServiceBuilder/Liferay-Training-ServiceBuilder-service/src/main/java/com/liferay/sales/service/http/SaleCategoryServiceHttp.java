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
import com.liferay.sales.service.SaleCategoryServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>SaleCategoryServiceUtil</code> service
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
 * @see SaleCategoryServiceSoap
 * @generated
 */
public class SaleCategoryServiceHttp {

	public static com.liferay.sales.model.SaleCategory createSaleCategory(
		HttpPrincipal httpPrincipal, long id, String name, double tax) {

		try {
			MethodKey methodKey = new MethodKey(
				SaleCategoryServiceUtil.class, "createSaleCategory",
				_createSaleCategoryParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, id, name, tax);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.sales.model.SaleCategory)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.sales.model.SaleCategory> getAll(
		HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				SaleCategoryServiceUtil.class, "getAll",
				_getAllParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.liferay.sales.model.SaleCategory>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.sales.model.SaleCategory getSaleCategoryById(
		HttpPrincipal httpPrincipal, long id) {

		try {
			MethodKey methodKey = new MethodKey(
				SaleCategoryServiceUtil.class, "getSaleCategoryById",
				_getSaleCategoryByIdParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, id);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.sales.model.SaleCategory)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void deleCategoryById(HttpPrincipal httpPrincipal, long id) {
		try {
			MethodKey methodKey = new MethodKey(
				SaleCategoryServiceUtil.class, "deleCategoryById",
				_deleCategoryByIdParameterTypes3);

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

	public static com.liferay.sales.model.SaleCategory getCategoryByName(
		HttpPrincipal httpPrincipal, String name) {

		try {
			MethodKey methodKey = new MethodKey(
				SaleCategoryServiceUtil.class, "getCategoryByName",
				_getCategoryByNameParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey, name);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.sales.model.SaleCategory)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		SaleCategoryServiceHttp.class);

	private static final Class<?>[] _createSaleCategoryParameterTypes0 =
		new Class[] {long.class, String.class, double.class};
	private static final Class<?>[] _getAllParameterTypes1 = new Class[] {};
	private static final Class<?>[] _getSaleCategoryByIdParameterTypes2 =
		new Class[] {long.class};
	private static final Class<?>[] _deleCategoryByIdParameterTypes3 =
		new Class[] {long.class};
	private static final Class<?>[] _getCategoryByNameParameterTypes4 =
		new Class[] {String.class};

}