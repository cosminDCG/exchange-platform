package com.platform.exchange.validator.product;

import com.platform.exchange.exception.ErrorMessage;
import com.platform.exchange.exception.product.NegativePriceException;
import com.platform.exchange.model.product.Product;

public class ProductValidator extends ValidatorBase {

    @Override
    public void validate(Product product) {
        validatePrice(product);
    }

    protected void validatePrice(Product product) {
        if (product.getPrice() < 0) {
            throw new NegativePriceException(ErrorMessage.NEGATIVE_PRICE);
        }
    }
}
