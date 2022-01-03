/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.sales.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.sales.exception.NoSuchSaleCartException;
import com.liferay.sales.model.SaleCart;
import com.liferay.sales.model.SaleProduct;
import com.liferay.sales.service.CartProductsListService;
import com.liferay.sales.service.CartProductsListServiceUtil;
import com.liferay.sales.service.base.SaleCartLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

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
@Component(property = "model.class.name=com.liferay.sales.model.SaleCart", service = AopService.class)
public class SaleCartLocalServiceImpl extends SaleCartLocalServiceBaseImpl {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. Use <code>com.liferay.sales.service.SaleCartLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.sales.service.SaleCartLocalServiceUtil</code>.
     */
    public List<SaleCart> getAllSaleCart() {
        return saleCartPersistence.findAll();
    }

    public SaleCart addSaleCartById() {
        SaleCart saleCart = saleCartPersistence.create(counterLocalService.increment());
        saleCart.setAble(true);
        return saleCartPersistence.update(saleCart);
    }

    public SaleCart updateSaleCartById(SaleCart saleCart) {
        return saleCartPersistence.update(saleCart);
    }

    public SaleCart getSaleCartById(long id) {
        try {
            return saleCartPersistence.findByPrimaryKey(id);
        } catch (NoSuchSaleCartException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Double getFinalValueByCartId(long cartId) {
        try {
            return saleCartPersistence.findByPrimaryKey(cartId).getTotalPrice();
        } catch (NoSuchSaleCartException e) {
            e.printStackTrace();
            return null;
        }
    }

    public SaleCart addProductPriceToCartTotalValue(double price, long cartId) {
        SaleCart cart = saleCartPersistence.fetchByPrimaryKey(cartId);
        cart.setTotalPrice(cart.getTotalPrice() + price);
        return saleCartPersistence.update(cart);
    }

    public SaleCart removeProductPriceToCartTotalValue(double price, long cartId) {
        SaleCart cart = saleCartPersistence.fetchByPrimaryKey(cartId);
        cart.setTotalPrice(cart.getTotalPrice() - price);
        return saleCartPersistence.update(cart);
    }

    public void deleteSaleCartById(long cartId) {
        SaleCart saleCart = getSaleCartById(cartId);
        if (saleCart.getAble()) {
            try {
                for (SaleProduct product : CartProductsListServiceUtil.getAllProductsByCarID(cartId)) {
                    CartProductsListServiceUtil.removeProductToCartList(cartId, product.getProductId());
                }
                saleCartPersistence.remove(cartId);
            } catch (NoSuchSaleCartException e) {
                e.printStackTrace();

            }
        }
    }
}