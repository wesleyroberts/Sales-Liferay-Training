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
import com.liferay.sales.exception.NoSuchStockProductsListException;
import com.liferay.sales.model.SaleCart;
import com.liferay.sales.model.SaleProduct;
import com.liferay.sales.model.SaleStock;
import com.liferay.sales.model.StockProductsList;
import com.liferay.sales.service.SaleProductService;
import com.liferay.sales.service.SaleStockService;
import com.liferay.sales.service.base.StockProductsListLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.List;

/**
 * The implementation of the stock products list local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.sales.service.StockProductsListLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StockProductsListLocalServiceBaseImpl
 */
@Component(
        property = "model.class.name=com.liferay.sales.model.StockProductsList",
        service = AopService.class
)
public class StockProductsListLocalServiceImpl
        extends StockProductsListLocalServiceBaseImpl {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. Use <code>com.liferay.sales.service.StockProductsListLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.sales.service.StockProductsListLocalServiceUtil</code>.
     */
    public List<SaleProduct> getAllProductInStock() {
        List<SaleProduct> saleProductList = new ArrayList<SaleProduct>();
        try {
            for (StockProductsList e : stockProductsListPersistence.findAll()) {
                saleProductList.add(saleProductService.getSaleProductById(e.getProductId()));
            }
            return saleProductList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<SaleProduct> getAllProductInStockByStockId(long stockId) {
        List<SaleProduct> saleProductList = new ArrayList<SaleProduct>();
        try {
            for (StockProductsList e : stockProductsListPersistence.findAll()) {
                if (e.getStockId() == stockId) {
                    saleProductList.add(saleProductService.getSaleProductById(e.getProductId()));
                }
            }
            return saleProductList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<SaleProduct> getAllProductInStockByProductName(String name) {
        List<SaleProduct> saleProductList = new ArrayList<SaleProduct>();
        try {
            for (StockProductsList e : stockProductsListPersistence.findAll()) {
                if (saleProductService.getSaleProductById(e.getProductId()).getName().equals(name)) {
                    saleProductList.add(saleProductService.getSaleProductById(e.getProductId()));
                }
            }
            return saleProductList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public void deleteStockProductListByID(long id) {
        try {
            stockProductsListPersistence.remove(id);
        } catch (NoSuchStockProductsListException e) {
            e.printStackTrace();
        }
    }

    public SaleStock addProductToStock(SaleProduct product) {

        if (!existStock(product)) {
            try {
                SaleStock stock = saleStockService.addSaleStock();
                StockProductsList stockProductsList = stockProductsListPersistence.create(product.getProductId());
                stockProductsList.setStockId(stock.getStockId());
                stockProductsListPersistence.update(stockProductsList);
                return saleStockService.updateStock(stock.getStockId(), stock.getQuantity() + 1, product.getName(), product.getTypeId(), product.getCategoryId(), product.getPrice());

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            try {
                SaleStock stock = saleStockService.getSaleStockByProduct(product);
                StockProductsList stockProductsList = stockProductsListPersistence.create(product.getProductId());
                stockProductsList.setStockId(stock.getStockId());
                stockProductsListPersistence.update(stockProductsList);
                return saleStockService.updateStock(stock.getStockId(), stock.getQuantity() + 1, product.getName(), product.getTypeId(), product.getCategoryId(), product.getPrice());
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public void removeProductFromStock(long productID) {
        SaleProduct product = saleProductService.getSaleProductById(productID);
        if (existStock(product)) {
            try {
                SaleStock stock = saleStockService.getSaleStockByProduct(product);
                if (stock.getQuantity() == 1) {
                    stockProductsListPersistence.remove(product.getProductId());
                    saleStockService.deletesaleStockById(stock.getStockId());
                } else {
                    stockProductsListPersistence.remove(product.getProductId());
                    saleStockService.updateStock(stock.getStockId(), stock.getQuantity() - 1, product.getName(), product.getTypeId(), product.getCategoryId(), product.getPrice());
                }

            } catch (Exception e) {
                System.out.println("não Entrou");
                e.printStackTrace();

            }
        }
    }

    public int quantityInStockByStockId(long stockId) {
        return stockProductsListLocalService.getAllProductInStockByStockId(stockId).toArray().length;
    }


    public Boolean existStock(SaleProduct product) {
        boolean exist = false;
        try {
            for (SaleStock stock : saleStockService.getAllSaleStock()) {
                if (stock.getCategoryId() == product.getCategoryId() && stock.getName().equals(product.getName())) {
                    if (stock.getTypeId() == product.getTypeId() && stock.getPrice() == product.getPrice()) {
                        exist = true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return exist;
        }
        return exist;

    }

    @Reference
    SaleStockService saleStockService;
    @Reference
    SaleProductService saleProductService;
}