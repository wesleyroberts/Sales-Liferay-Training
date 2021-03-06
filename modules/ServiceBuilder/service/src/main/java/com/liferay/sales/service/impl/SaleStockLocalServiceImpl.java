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
import com.liferay.sales.exception.NoSuchSaleStockException;
import com.liferay.sales.model.SaleProduct;
import com.liferay.sales.model.SaleStock;
import com.liferay.sales.service.StockProductsListServiceUtil;
import com.liferay.sales.service.base.SaleStockLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * The implementation of the sale stock local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.sales.service.SaleStockLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SaleStockLocalServiceBaseImpl
 */
@Component(
        property = "model.class.name=com.liferay.sales.model.SaleStock",
        service = AopService.class
)
public class SaleStockLocalServiceImpl extends SaleStockLocalServiceBaseImpl {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. Use <code>com.liferay.sales.service.SaleStockLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.sales.service.SaleStockLocalServiceUtil</code>.
     */
    public List<SaleStock> getAllSaleStock() {
        return saleStockPersistence.findAll();
    }

    public SaleStock addSaleStock() {
        try {
            SaleStock saleStock = saleStockPersistence.create(counterLocalService.increment());
            return saleStockPersistence.update(saleStock);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public SaleStock updateStock(long stockId, int quantity, String name, long typeId, long categoryId, double price) {
        try {
            SaleStock saleStock = saleStockPersistence.findByPrimaryKey(stockId);
            saleStock.setQuantity(quantity);
            saleStock.setName(name);
            saleStock.setTypeId(typeId);
            saleStock.setCategoryId(categoryId);
            saleStock.setPrice(price);
            return saleStockPersistence.update(saleStock);
        } catch (NoSuchSaleStockException e) {
            e.printStackTrace();
            return null;
        }

    }

    public SaleStock getSaleStockById(long id) {
        try {
            return saleStockPersistence.findByPrimaryKey(id);
        } catch (NoSuchSaleStockException e) {
            e.printStackTrace();
            return null;
        }
    }

    public SaleStock getSaleStockByProduct(SaleProduct product) {
        try {
            return saleStockPersistence.findByName_Type_Category(product.getName(), product.getTypeId(), product.getCategoryId());
        } catch (NoSuchSaleStockException e) {
            e.printStackTrace();
            return null;
        }
    }


    public void deletesaleStockById(long id) {
        try {
            for (SaleProduct product : StockProductsListServiceUtil.getAllProductInStockByStockId(id)) {
                StockProductsListServiceUtil.removeProductFromStock(product.getProductId());
            }
            saleStockPersistence.remove(id);
        } catch (NoSuchSaleStockException e) {
            e.printStackTrace();
        }
    }

}