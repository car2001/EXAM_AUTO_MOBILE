package com.nttdata.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.util.List;

public class StoreScreen extends PageObject {

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"App logo and name\"]")
    private WebElement logoElement;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView//android.widget.ImageView[@content-desc]")
    private List<WebElement> productListElements;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Sauce Labs Backpack\"]")
    private WebElement productElement;

    public boolean isLogoDisplayed(){
        try {
            waitFor(ExpectedConditions.visibilityOf(logoElement));
            return logoElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public int getProductListSize() {
        return productListElements.size();
    }
    public void clickProductElement(String nameProduct){
        String dynamicXpathProduct = String.format("//android.widget.ImageView[@content-desc=\"%s\"]", nameProduct);
        try {
            WebElement dynamicProductElement = waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicXpathProduct)));
            dynamicProductElement.click();
        } catch (Exception e) {
            throw new RuntimeException("El producto con el nombre " + nameProduct + " no está disponible o no se pudo encontrar.");
        }
    }
}
