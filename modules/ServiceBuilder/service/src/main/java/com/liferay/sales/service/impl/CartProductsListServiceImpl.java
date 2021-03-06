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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.sales.model.CartProductsList;
import com.liferay.sales.model.SaleCart;
import com.liferay.sales.model.SaleProduct;
import com.liferay.sales.service.base.CartProductsListServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * The implementation of the cart products list remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.sales.service.CartProductsListService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CartProductsListServiceBaseImpl
 */
@Component(
        property = {
                "json.web.service.context.name=salestaxe",
                "json.web.service.context.path=CartProductsList"
        },
        service = AopService.class
)
public class CartProductsListServiceImpl
        extends CartProductsListServiceBaseImpl {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. Always use <code>com.liferay.sales.service.CartProductsListServiceUtil</code> to access the cart products list remote service.
     */
    public List<SaleProduct> getAllProductsByCarID(long id) {
        return cartProductsListLocalService.getAllProductsByCartID(id);
    }

    public List<SaleProduct> addProductToCartList(int quantity, long cartId, long stockId) {
        return cartProductsListLocalService.addProductToCartList(quantity, cartId, stockId);
    }

    public void removeProductToCartList(long cartId, long productId) {
        cartProductsListLocalService.removeProductToCartList(cartId, productId);
    }

    public List<CartProductsList> getAllCartProductsList() {
        return cartProductsListLocalService.getAllCartProductsList();
    }

    public void deleteCartProductsList(long productId) throws PortalException {
        cartProductsListLocalService.deleteCartList(productId);
    }

    public SaleCart finishCart(long cartId) {
        return cartProductsListLocalService.finishCart(cartId);
    }
}