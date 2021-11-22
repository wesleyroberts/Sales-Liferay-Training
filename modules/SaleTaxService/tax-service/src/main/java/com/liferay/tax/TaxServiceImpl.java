package com.liferay.tax;

import restbuilder.dto.v1_0.Product;

import java.util.Arrays;
import java.util.List;

public class TaxServiceImpl implements TaxService{

    @Override
    public Product applyTaxInProduct(Product product)
    {
        List<String> list = Arrays.asList("book","medical","food");

        double taxForType = product.getPrice() * product.getType().getTax();
        double taxForCategory = product.getPrice() * product.getCategory().getTax();

        if(!list.contains(product.getCategory().getName())) {
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

        return product;

    }
}
