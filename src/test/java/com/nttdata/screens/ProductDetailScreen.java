package com.nttdata.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ProductDetailScreen extends PageObject {

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Displays selected product\"]")
    private  WebElement imageProductDetail;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").scrollable(true)).scrollIntoView(new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/plusIV\"))")
    private WebElement incrementaseQuantityBtn;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").scrollable(true)).scrollIntoView(new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/cartBt\"))")
    private WebElement AddProductToCartBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/cartTV\"]")
    private WebElement QuantityCart;

    public void checkVisibilityProduct(){
        try {
            waitFor(ExpectedConditions.visibilityOf(imageProductDetail));
        }catch (Exception e) {
            throw new RuntimeException("No se mostro la imagen del producto seleccionado");
        }
    }

    public void clickIncreaseQuantity(){
        try {
            incrementaseQuantityBtn.click();
        }catch (Exception e){
            throw  new RuntimeException("El boton de incremento no es visible o interactuable");
        }
    }

    public void clickBtnAddProductToCart(){
        try {
            AddProductToCartBtn.click();
        }catch (Exception e){
            throw  new RuntimeException("El boton de agregar producto no es visible o interactuable");
        }
    }

    public int getQuantityItems(){
        return Integer.parseInt(QuantityCart.getText());
    }

}
