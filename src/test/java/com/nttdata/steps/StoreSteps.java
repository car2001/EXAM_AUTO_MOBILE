package com.nttdata.steps;

import com.nttdata.screens.ProductDetailScreen;
import com.nttdata.screens.StoreScreen;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.sql.DriverManager;


public class StoreSteps {

    StoreScreen storeScreen;
    ProductDetailScreen productDetailScreen;
    public void VerifyLogoDisplayed(){
        Assert.assertTrue("El logo de la aplicación no está visible", storeScreen.isLogoDisplayed());
    }
    public void AddProductToStore(String nameProduct, int quantity){
        storeScreen.clickProductElement(nameProduct);
        productDetailScreen.checkVisibilityProduct();
        for (int i = 1; i < quantity; i++) {
            productDetailScreen.clickIncreaseQuantity();
        }
        productDetailScreen.clickBtnAddProductToCart();
    }
    public void VerifyLoadProducts() {
        Assert.assertTrue("La galería de productos está vacía", storeScreen.getProductListSize() > 0);
    }
}
