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

package com.liferay.sales.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.NoSuchModelException;
import com.liferay.sales.exception.NoSuchCartProductsListException;
import com.liferay.sales.model.CartProductsList;
import com.liferay.sales.model.SaleProduct;
import com.liferay.sales.service.SaleCartService;
import com.liferay.sales.service.SaleProductService;
import com.liferay.sales.service.StockProductsListLocalServiceUtil;
import com.liferay.sales.service.StockProductsListServiceUtil;
import com.liferay.sales.service.base.CartProductsListLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.List;

/**
 * The implementation of the cart products list local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.sales.service.CartProductsListLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CartProductsListLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.sales.model.CartProductsList",
	service = AopService.class
)
public class CartProductsListLocalServiceImpl
	extends CartProductsListLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.liferay.sales.service.CartProductsListLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.sales.service.CartProductsListLocalServiceUtil</code>.
	 */

	public List<SaleProduct> getAllProductsByCartID(long id){
		List<SaleProduct> listSaleProduct = new ArrayList<>();
		for (CartProductsList e:cartProductsListPersistence.findAll()) {
			if(e.getCartId() == id){
				listSaleProduct.add(saleProductService.getSaleProductById(e.getProductId()));
			}
		}
		return listSaleProduct;

	}

	public List<CartProductsList> addProductToCartList(List<Long> productsIdList, long cartId){
		List<CartProductsList> list = new ArrayList<CartProductsList>();

		for (long productId: productsIdList ) {
			CartProductsList cartProductsList = cartProductsListPersistence.create(productId);
			cartProductsList.setCartId(cartId);
			SaleProduct product = saleProductService.getSaleProductById(productId);
			saleCartService.addProductPriceToCartTotalValue(product.getPrice(),cartId);
			StockProductsListServiceUtil.removeProductFromStock(product);
			list.add(cartProductsListPersistence.update(cartProductsList));

		}

		return list;
	}

	public void removeProductToCartList(List<Long> productsIdList,long cartId){

		try {
			for (Long productId: productsIdList ) {
				saleCartService.removeProductPriceToCartTotalValue(saleProductService.getSaleProductById(productId).getPrice(), cartId);
				cartProductsListPersistence.remove(productId);
				StockProductsListLocalServiceUtil.addProductToStock(saleProductService.getSaleProductById(productId));
			}
		} catch (NoSuchModelException e) {
			e.printStackTrace();
		}
	}

	@Reference
	SaleProductService saleProductService;
	@Reference
	SaleCartService saleCartService;
}