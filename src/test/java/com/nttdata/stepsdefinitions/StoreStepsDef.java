package com.nttdata.stepsdefinitions;

import com.nttdata.steps.ProductDetailSteps;
import com.nttdata.steps.StoreSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;

public class StoreStepsDef {

    @Steps
    StoreSteps storeSteps;

    @Steps
    ProductDetailSteps productDetailSteps;

    int quantity;

    @Given("estoy en la aplicación de SauceLabs")
    public void estoy_en_la_aplicación_de_sauce_labs() {
        storeSteps.VerifyLogoDisplayed();
    }
    @And("valido que carguen correctamente los productos en la galeria")
    public void valido_que_carguen_correctamente_los_productos_en_la_galeria() {
        storeSteps.VerifyLoadProducts();
    }
    @When("agrego {int} del siguiente producto {string}")
    public void agrego_del_siguiente_producto(Integer quantity, String product) {
        this.quantity = quantity;
        storeSteps.AddProductToStore(product,quantity);
    }
    @Then("valido el carrito de compra actualice correctamente")
    public void valido_el_carrito_de_compra_actualice_correctamente() {
        productDetailSteps.VerifyQuantityItemInCart(this.quantity);
    }

}
