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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.sales.exception.NoSuchSaleCartException;
import com.liferay.sales.model.SaleCart;
import com.liferay.sales.service.base.SaleCartLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * The implementation of the sale cart local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.sales.service.SaleCartLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SaleCartLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.sales.model.SaleCart",
	service = AopService.class
)
public class SaleCartLocalServiceImpl extends SaleCartLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.liferay.sales.service.SaleCartLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.sales.service.SaleCartLocalServiceUtil</code>.
	 */
	public List<SaleCart> getAllSaleCart() {
		return saleCartPersistence.findAll();
	}

	public SaleCart getSaleCartById(long id){
		try {
			return saleCartPersistence.findByPrimaryKey(id);
		} catch (NoSuchSaleCartException e) {
			e.printStackTrace();
			return null;
		}
	}
	public SaleCart addProductPriceToCartTotalValue(double price, long cartId,int quantity){
		SaleCart cart = saleCartPersistence.fetchByPrimaryKey(cartId);
		cart.setTotalPrice(cart.getTotalPrice()+(price*quantity));
		return saleCartPersistence.update(cart);
	}
	public SaleCart removeProductPriceToCartTotalValue(double price,long cartId , int quantity){
		SaleCart cart = saleCartPersistence.fetchByPrimaryKey(cartId);
		cart.setTotalPrice(cart.getTotalPrice()-(price*quantity));
		return saleCartPersistence.update(cart);
	}

	public Double getFinalValue(long cartId){
		try {
			return saleCartPersistence.findByPrimaryKey(cartId).getTotalPrice();
		} catch (NoSuchSaleCartException e) {
			e.printStackTrace();
			return null;
		}
	}

	public SaleCart createSaleCartById(){
		return saleCartPersistence.update(saleCartPersistence.create(counterLocalService.increment()));
	}

	public void deleteSaleCartById(long id){
		try {
			saleCartPersistence.remove(id);
		} catch (NoSuchSaleCartException e) {
			e.printStackTrace();

		}
	}
}