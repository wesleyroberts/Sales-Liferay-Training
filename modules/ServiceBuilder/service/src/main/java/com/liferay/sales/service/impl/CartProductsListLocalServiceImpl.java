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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.sales.exception.NoSuchCartProductsListException;
import com.liferay.sales.model.CartProductsList;
import com.liferay.sales.model.SaleCart;
import com.liferay.sales.model.SaleProduct;
import com.liferay.sales.model.SaleStock;
import com.liferay.sales.service.*;
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

	public List<SaleProduct> addProductToCartList(int quantity,long cartId, long stockId){

		if(checkIfCanAddProductInCart(cartId,stockId,quantity)){
			try{
				List<SaleProduct> productListInput = new ArrayList<SaleProduct>(StockProductsListServiceUtil.getAllProductInStockByStockId(stockId));
				List<SaleProduct> productListOutput = new ArrayList<SaleProduct>();
					for (int i = 0; i < quantity; i++) {
						if(!checkIfExistProduct(cartId,productListInput.get(i))){
							createCartProductList(productListInput.get(i).getProductId(),cartId);
							saleCartService.addProductPriceToCartTotalValue(productListInput.get(i).getPrice(),cartId);
							productListOutput.add(productListInput.get(i));
						}
				}
						return productListOutput;
				} catch (Exception e) {
					e.printStackTrace();
					return  null;
				}
		}else{
			return null;
		}
	}

	public List<CartProductsList> getAllCartProductsList(){
		return cartProductsListPersistence.findAll();
	}

	public void removeProductToCartList(long cartId, long productId){
		try {
			SaleProduct saleProduct = saleProductService.getSaleProductById(productId);
			saleCartService.removeProductPriceToCartTotalValue(saleProduct.getPrice(), cartId);
			cartProductsListPersistence.remove(saleProduct.getProductId());
		} catch (NoSuchModelException e) {
			e.printStackTrace();
		}
	}

	public SaleCart FinishCart(long cartId){
		try{
		for (SaleProduct product:getAllProductsByCartID(cartId)) {
			StockProductsListServiceUtil.removeProductFromStock(product.getProductId());
		}
		SaleCart saleCart = saleCartService.getSaleCartById(cartId);
		saleCart.setAble(false);
		return  saleCartService.updateSaleCartById(saleCart);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void deleteCartList(long productId)  {
		try {
			cartProductsListPersistence.remove(productId);
		} catch (NoSuchCartProductsListException e) {
			e.printStackTrace();
		}
	}

	private  boolean checkIfCanAddProductInCart(long cartId,long stockId, int quantity){
		return (StockProductsListServiceUtil.checkQuantityInStockByStockId(stockId) >= quantity)
				&& (getAllProductsByCartID(cartId).toArray().length + quantity <= StockProductsListServiceUtil.checkQuantityInStockByStockId(stockId));
	}
	private boolean checkIfExistProduct(long cartId, SaleProduct saleProduct){
		boolean exist = false;
		for (SaleProduct product:getAllProductsByCartID(cartId)) {
			if(product.getProductId()==saleProduct.getProductId()){
				exist = true;
			}
		}
		return exist;
	}

	public CartProductsList createCartProductList(long porductId, long cartId){
		try{
			CartProductsList cartProductList = cartProductsListPersistence.create(porductId);
			cartProductList.setCartId(cartId);
			return cartProductsListPersistence.update(cartProductList);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Reference
	SaleProductService saleProductService;
	@Reference
	SaleCartService saleCartService;


}