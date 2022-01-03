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
import com.liferay.sales.model.SaleProduct;
import com.liferay.sales.model.SaleStock;
import com.liferay.sales.service.base.SaleStockServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * The implementation of the sale stock remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.sales.service.SaleStockService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SaleStockServiceBaseImpl
 */
@Component(
        property = {
                "json.web.service.context.name=salestaxe",
                "json.web.service.context.path=SaleStock"
        },
        service = AopService.class
)
public class SaleStockServiceImpl extends SaleStockServiceBaseImpl {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. Always use <code>com.liferay.sales.service.SaleStockServiceUtil</code> to access the sale stock remote service.
     */
    public SaleStock addSaleStock() {
        return saleStockLocalService.addSaleStock();
    }

    public List<SaleStock> getAllSaleStock() {
        return saleStockLocalService.getAllSaleStock();
    }

    public SaleStock updateStock(long stockId, int quantity, String name, long typeId, long categoryId, double price) {
        return saleStockLocalService.updateStock(stockId, quantity, name, typeId, categoryId, price);
    }

    public SaleStock getSaleStockById(long id) {
        return saleStockLocalService.getSaleStockById(id);
    }

    public void deletesaleStockById(long id) {
        saleStockLocalService.deletesaleStockById(id);
    }

    public SaleStock getSaleStockByProduct(SaleProduct product) {
        return saleStockLocalService.getSaleStockByProduct(product);
    }
}