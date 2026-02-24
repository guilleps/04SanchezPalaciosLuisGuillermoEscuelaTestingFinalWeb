package page;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

@DefaultUrl("https://www.saucedemo.com")
public class SaucePage extends PageObject {

    @FindBy(id = "user-name")
    WebElementFacade inputUsername;

    @FindBy(id = "password")
    WebElementFacade inputPassword;

    @FindBy(id = "login-button")
    WebElementFacade btnLogin;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElementFacade productoMochila;

    @FindBy(css = "[data-test='shopping-cart-link']")
    WebElementFacade carritoDeCompras;

    @FindBy(id = "checkout")
    WebElementFacade btnCheckout;

    @FindBy(id = "first-name")
    WebElementFacade inputFirstName;

    @FindBy(id = "last-name")
    WebElementFacade inputLastName;

    @FindBy(id = "postal-code")
    WebElementFacade inputPostalCode;

    public void escribirUsernameYPassword(String username, String password) {
        inputUsername.type(username);
        inputPassword.type(password);
        btnLogin.click();
    }

    public void agregarUnProductoAlCarrito() {
        productoMochila.click();
    }

    public void ingresarAlCarritoDeCompras() {
        carritoDeCompras.click();
    }

    public void ingresarAlCheckout() {
        btnCheckout.click();
    }

    public void completarFormularioCheckout(String firstName, String lastName, String postalCode) {
        inputFirstName.type(firstName);
        inputLastName.type(lastName);
        inputPostalCode.type(postalCode);
    }
}
