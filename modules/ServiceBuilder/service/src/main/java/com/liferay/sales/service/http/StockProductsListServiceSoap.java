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
import com.liferay.sales.service.StockProductsListServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>StockProductsListServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.liferay.sales.model.StockProductsListSoap</code>. If the method in the
 * service utility returns a
 * <code>com.liferay.sales.model.StockProductsList</code>, that is translated to a
 * <code>com.liferay.sales.model.StockProductsListSoap</code>. Methods that SOAP
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
 * @see StockProductsListServiceHttp
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class StockProductsListServiceSoap {

	public static com.liferay.sales.model.SaleStockSoap addProductToStock(
			com.liferay.sales.model.SaleProductSoap product)
		throws RemoteException {

		try {
			com.liferay.sales.model.SaleStock returnValue =
				StockProductsListServiceUtil.addProductToStock(
					com.liferay.sales.model.impl.SaleProductModelImpl.toModel(
						product));

			return com.liferay.sales.model.SaleStockSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.sales.model.SaleProductSoap[]
			getAllProductInStock()
		throws RemoteException {

		try {
			java.util.List<com.liferay.sales.model.SaleProduct> returnValue =
				StockProductsListServiceUtil.getAllProductInStock();

			return com.liferay.sales.model.SaleProductSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.sales.model.SaleProductSoap[]
			getAllProductInStockByProductName(String name)
		throws RemoteException {

		try {
			java.util.List<com.liferay.sales.model.SaleProduct> returnValue =
				StockProductsListServiceUtil.getAllProductInStockByProductName(
					name);

			return com.liferay.sales.model.SaleProductSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.sales.model.SaleProductSoap[]
			getAllProductInStockByStockId(long stockId)
		throws RemoteException {

		try {
			java.util.List<com.liferay.sales.model.SaleProduct> returnValue =
				StockProductsListServiceUtil.getAllProductInStockByStockId(
					stockId);

			return com.liferay.sales.model.SaleProductSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static void deleteStockProductListByID(long id)
		throws RemoteException {

		try {
			StockProductsListServiceUtil.deleteStockProductListByID(id);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static void removeProductFromStock(long productID)
		throws RemoteException {

		try {
			StockProductsListServiceUtil.removeProductFromStock(productID);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static int checkQuantityInStockByStockId(long stockId)
		throws RemoteException {

		try {
			int returnValue =
				StockProductsListServiceUtil.checkQuantityInStockByStockId(
					stockId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		StockProductsListServiceSoap.class);

}