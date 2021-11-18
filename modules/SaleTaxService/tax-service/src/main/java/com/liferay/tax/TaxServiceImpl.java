package com.liferay.tax;

import com.liferay.sales.model.SaleCategory;
import com.liferay.sales.model.SaleProduct;
import com.liferay.sales.model.SaleType;
import com.liferay.sales.service.SaleCategoryService;
import com.liferay.sales.service.SaleProductLocalService;
import com.liferay.sales.service.SaleTypeService;
import org.osgi.service.component.annotations.Reference;

import java.util.Arrays;
import java.util.List;

public class TaxServiceImpl implements TaxService{

    @Override
    public SaleProduct applyTaxInProduct(SaleProduct product)
    {
        SaleCategory saleCategory =  _saleCategoryService.getSaleCategoryById(product.getCategoryId());
        SaleType saleType =  _saleTypeService.getSaleTypeByID(product.getTypeId());
        List<String> list = Arrays.asList("book","medical","food");

        double taxForType = product.getPrice() * saleType.getTax();
        double taxForCategory = product.getPrice() * saleCategory.getTax();

        if(!list.contains(saleCategory.getName())) {
            product.
                    setPrice(
                            product.getPrice() + taxForType + taxForCategory
                    );
        }else{
            product.
                    setPrice(
                            product.getPrice() + taxForType
                    );
        }

        _saleProductLocalService.updateSaleProduct(product);

        return product;

    }
    @Reference
    SaleCategoryService _saleCategoryService;
    @Reference
    SaleTypeService _saleTypeService;

    @Reference
    SaleProductLocalService _saleProductLocalService;
}
