package com.platform.exchange.validator.product;

import com.platform.exchange.model.product.ProductType;

public final class ProductValidatorFactory {

    public static ProductValidator getValidator(ProductType productType) {
         switch (productType) {
             case REGULAR:
                 return new ProductValidator();
             case AUTO:
                 return new AutoValidator();
             case REAL_ESTATE:
                 return new RealEstateValidator();
             default:
                 return null;
        }
    }
}
