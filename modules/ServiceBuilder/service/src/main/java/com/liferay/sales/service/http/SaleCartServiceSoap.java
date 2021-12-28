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
import com.liferay.sales.service.SaleCartServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>SaleCartServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.liferay.sales.model.SaleCartSoap</code>. If the method in the
 * service utility returns a
 * <code>com.liferay.sales.model.SaleCart</code>, that is translated to a
 * <code>com.liferay.sales.model.SaleCartSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SaleCartServiceHttp
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class SaleCartServiceSoap {

	public static com.liferay.sales.model.SaleCartSoap[] getAllSaleCart()
		throws RemoteException {

		try {
			java.util.List<com.liferay.sales.model.SaleCart> returnValue =
				SaleCartServiceUtil.getAllSaleCart();

			return com.liferay.sales.model.SaleCartSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.sales.model.SaleCartSoap getSaleCartById(long id)
		throws RemoteException {

		try {
			com.liferay.sales.model.SaleCart returnValue =
				SaleCartServiceUtil.getSaleCartById(id);

			return com.liferay.sales.model.SaleCartSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.sales.model.SaleCartSoap
			addProductPriceToCartTotalValue(double price, long cartId)
		throws RemoteException {

		try {
			com.liferay.sales.model.SaleCart returnValue =
				SaleCartServiceUtil.addProductPriceToCartTotalValue(
					price, cartId);

			return com.liferay.sales.model.SaleCartSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.sales.model.SaleCartSoap
			removeProductPriceToCartTotalValue(double price, long cartId)
		throws RemoteException {

		try {
			com.liferay.sales.model.SaleCart returnValue =
				SaleCartServiceUtil.removeProductPriceToCartTotalValue(
					price, cartId);

			return com.liferay.sales.model.SaleCartSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static Double getFinalValueByCartId(long cartId)
		throws RemoteException {

		try {
			Double returnValue = SaleCartServiceUtil.getFinalValueByCartId(
				cartId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.sales.model.SaleCartSoap createSaleCartById()
		throws RemoteException {

		try {
			com.liferay.sales.model.SaleCart returnValue =
				SaleCartServiceUtil.createSaleCartById();

			return com.liferay.sales.model.SaleCartSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static void deleteSaleCartById(long id) throws RemoteException {
		try {
			SaleCartServiceUtil.deleteSaleCartById(id);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.sales.model.SaleCartSoap updateSaleCartById(
			com.liferay.sales.model.SaleCartSoap saleCart)
		throws RemoteException {

		try {
			com.liferay.sales.model.SaleCart returnValue =
				SaleCartServiceUtil.updateSaleCartById(
					com.liferay.sales.model.impl.SaleCartModelImpl.toModel(
						saleCart));

			return com.liferay.sales.model.SaleCartSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SaleCartServiceSoap.class);

}