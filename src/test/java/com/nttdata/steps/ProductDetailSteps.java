package com.nttdata.steps;

import com.nttdata.screens.ProductDetailScreen;
import org.junit.Assert;

public class ProductDetailSteps {

    ProductDetailScreen productDetailScreen;

    public void VerifyQuantityItemInCart(int Quantity){
        Assert.assertEquals(Quantity,productDetailScreen.getQuantityItems());
    }

}
