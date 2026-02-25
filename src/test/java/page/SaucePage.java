package page;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import static org.assertj.core.api.Assertions.assertThat;

@DefaultUrl("https://www.saucedemo.com")
public class SaucePage extends PageObject {

    // LOGIN
    @FindBy(id = "user-name")
    private WebElementFacade inputUsername;

    @FindBy(id = "password")
    private WebElementFacade inputPassword;

    @FindBy(id = "login-button")
    private WebElementFacade btnLogin;

    // PRODUCTOS
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElementFacade btnAddBackpack;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElementFacade btnAddBikeLightProduct;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElementFacade btnAddBlackTShirtProduct;

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    WebElementFacade btnAddJacketProduct;

    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    WebElementFacade btnAddOnesieProduct;

    @FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)")
    WebElementFacade btnAddOrangeTShirtProduct;

    @FindBy(css = "[data-test='shopping-cart-link']")
    private WebElementFacade btnCart;

    // CHECKOUT
    @FindBy(id = "checkout")
    private WebElementFacade btnCheckout;

    @FindBy(id = "first-name")
    private WebElementFacade inputFirstName;

    @FindBy(id = "last-name")
    private WebElementFacade inputLastName;

    @FindBy(id = "postal-code")
    private WebElementFacade inputPostalCode;

    @FindBy(id = "continue")
    private WebElementFacade btnContinue;

    @FindBy(id = "finish")
    private WebElementFacade btnFinish;

    @FindBy(id = "react-burger-menu-btn")
    WebElementFacade btnToggleMenu;

    @FindBy(id = "logout_sidebar_link")
    WebElementFacade btnLogout;

    @FindBy(css = ".inventory_list")
    private WebElementFacade productList;

    @FindBy(css = ".title")
    private WebElementFacade checkoutCompleteTitle;

    @FindBy(id = "back-to-products")
    WebElementFacade btnBackToProducts;

    @FindBy(css = ".complete-header")
    private WebElementFacade mensajeConfirmacion;

    public void validarCompraExitosa() {
        checkoutCompleteTitle.shouldBeVisible();
        checkoutCompleteTitle.shouldContainText("Checkout: Complete!");

        mensajeConfirmacion.shouldBeVisible();
        mensajeConfirmacion.shouldContainText("Thank you for your order!");

        btnBackToProducts.shouldBeVisible();
    }

    public void validarUrl(String url) {
        assertThat(getDriver().getCurrentUrl())
                .contains(url);
    }

    public void visualizarListaDeProductos() {
        productList.shouldBeVisible();
    }

    public void escribirUsername(String username) {
        inputUsername.sendKeys(username);
    }

    public void escribirPassword(String password) {
        inputPassword.sendKeys(password);
    }

    public void loguearse() {
        btnLogin.waitUntilClickable().click();
    }

    public void agregarBackpackAlCarrito() {
        btnAddBackpack.click();
    }

    public void escribiFirstname(String firstname) {
        inputFirstName.sendKeys(firstname);
    }

    public void escribirLastname(String lastname) {
        inputLastName.sendKeys(lastname);
    }

    public void escribirPostalcode(String postalcode) {
        inputPostalCode.sendKeys(postalcode);
    }

    public void clickCart() {
        btnCart.waitUntilClickable().click();
    }

    public void clickCheckout() {
        btnCheckout.waitUntilClickable().click();
    }

    public void clickContinue() {
        btnContinue.waitUntilClickable().click();
    }

    public void clickFinish() {
        btnFinish.waitUntilClickable().click();
    }

    public void clickToggleMenu() {
        btnToggleMenu.waitUntilClickable().click();
    }

    public void clickLogout() {
        btnLogout.waitUntilClickable().click();
    }

    public void validarPantallaLogin() {

        inputUsername.shouldBeVisible();
        inputPassword.shouldBeVisible();
        btnLogin.shouldBeVisible();

        assertThat(getDriver().getCurrentUrl())
                .contains("saucedemo.com");
    }
}