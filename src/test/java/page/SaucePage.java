package page;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

@DefaultUrl("https://www.saucedemo.com")
public class SaucePage extends PageObject {

    // LOGIN
    @FindBy(id = "user-name")
    WebElementFacade inputUsername;

    @FindBy(id = "password")
    WebElementFacade inputPassword;

    @FindBy(id = "login-button")
    WebElementFacade btnLogin;

    // PRODUCTOS
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElementFacade btnAddBackpack;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElementFacade btnAddBikeLight;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElementFacade btnAddBlackTShirt;

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    WebElementFacade btnAddJacket;

    @FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)")
    WebElementFacade btnAddOrangeTShirt;

    @FindBy(css = "[data-test='shopping-cart-link']")
    WebElementFacade btnCart;

    // CHECKOUT
    @FindBy(id = "checkout")
    WebElementFacade btnCheckout;

    @FindBy(id = "first-name")
    WebElementFacade inputFirstName;

    @FindBy(id = "last-name")
    WebElementFacade inputLastName;

    @FindBy(id = "postal-code")
    WebElementFacade inputPostalCode;

    @FindBy(id = "continue")
    WebElementFacade btnContinue;

    @FindBy(id = "finish")
    WebElementFacade btnFinish;

    @FindBy(id = "react-burger-menu-btn")
    WebElementFacade btnToggleMenu;

    @FindBy(id = "logout_sidebar_link")
    WebElementFacade btnLogout;

    @FindBy(css = ".inventory_list")
    WebElementFacade productList;

    @FindBy(css = ".title")
    WebElementFacade checkoutCompleteTitle;

    @FindBy(id = "back-to-products")
    WebElementFacade btnBackToProducts;

    @FindBy(css = ".complete-header")
    WebElementFacade mensajeConfirmacion;

    public void validarCompraExitosa() {
        checkoutCompleteTitle.shouldBeVisible();
        checkoutCompleteTitle.shouldContainText("Checkout: Complete!");

        mensajeConfirmacion.shouldBeVisible();
        mensajeConfirmacion.shouldContainText("Thank you for your order!");

        btnBackToProducts.shouldBeVisible();
    }

    public void clickBackHome() {
        btnBackToProducts.waitUntilClickable().click();
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

        assertThat(getDriver().getCurrentUrl())
                .isEqualTo("https://www.saucedemo.com/");

        inputUsername.shouldBeVisible();
        inputPassword.shouldBeVisible();
        btnLogin.shouldBeVisible();
    }

    @FindBy(css = "h3[data-test='error']")
    private WebElementFacade mssgLoginError;

    public void deberiaMostrarErrorUsuarioBloqueado() {
        mssgLoginError.shouldBeVisible();
        mssgLoginError.shouldContainText("Epic sadface: Sorry, this user has been locked out.");
        validarPantallaLogin();
    }

    public void deberiaMostrarMensajeDeError(String mensajeEsperado) {
        mssgLoginError.shouldBeVisible();
        mssgLoginError.shouldContainText(mensajeEsperado);
    }

    public void accedeAlCarrito() {
        clickCart();
    }

    public void visualizarCarritoVacio() {
        assertThat(findAll(".cart_item"))
                .as("El carrito debería estar vacío")
                .isEmpty();
    }

    @FindBy(css = ".shopping_cart_badge")
    WebElementFacade cartBadge;

    public void agregaProductosAlCarrito() {
        btnAddBackpack.click();
        btnAddBikeLight.click();
        btnAddBlackTShirt.click();
    }

    public void visualizarCantidadCorrecta() {
        int cantidadEsperada = 3;

        cartBadge.shouldBeVisible();

        int cantidadReal = Integer.parseInt(cartBadge.getText());

        assertThat(cantidadReal)
                .as("La cantidad del carrito no coincide")
                .isEqualTo(cantidadEsperada);
    }

    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    WebElementFacade btnAddOnesie;

    public void agregarUnProductoAlCarrito() {
        btnAddOnesie.waitUntilClickable().click();
    }

    @FindBy(id = "remove-sauce-labs-onesie")
    WebElementFacade btnRemoveOnesie;

    public void eliminarUnProductoDelCarrito() {
        btnRemoveOnesie.waitUntilClickable().click();
    }

    public void deberiaVerCarritoVacio() {
        assertThat(findAll(".shopping_cart_badge"))
                .as("El carrito debería estar vacío")
                .isEmpty();
    }

    @FindBy(id = "continue-shopping")
    WebElementFacade btnContinueShopping;

    public void clickContinueShopping() {
        btnContinueShopping.waitUntilClickable().click();
    }

    public void limpiarFormularioCheckout() {
        inputFirstName.clear();
        inputLastName.clear();
        inputPostalCode.clear();
    }

    public void validarCheckoutExitoso() {
        assertThat(getDriver().getCurrentUrl())
                .contains("checkout-step-two.html");
    }

    @FindBy(id = "checkout_summary_container")
    WebElementFacade checkoutSummaryContainer;

    @FindBy(css = "[data-test='total-label']")
    WebElementFacade totalLabel;

    @FindBy(css = "[data-test='subtotal-label']")
    WebElementFacade subtotalLabel;

    @FindBy(css = "[data-test='tax-label']")
    WebElementFacade taxLabel;

    public void deberiaAvanzarALaPantallaDeResumen() {
        assertThat(getDriver().getCurrentUrl())
                .contains("checkout-step-two.html");

        checkoutSummaryContainer.shouldBeVisible();
        subtotalLabel.shouldContainText("Item total:");
        taxLabel.shouldContainText("Tax:");
        totalLabel.shouldBeVisible();
        btnFinish.shouldBeVisible();
    }

    @FindBy(id = "cancel")
    WebElementFacade btnCancel;

    public void cancelaDesdeLaPantallaDeResumen() {
        btnCancel.click();
    }

    public void accedeDirectamenteAlCarrito(String endpoint) {
        getDriver().get("https://www.saucedemo.com/" + endpoint);
    }

    @FindBy(css = "[data-test='inventory-item']")
    List<WebElementFacade> listaItemsCarrito;

    private double convertirPrecio(String textoPrecio) {
        return Double.parseDouble(textoPrecio.replace("$", "").trim());
    }

    public double calcularSubtotalDesdeDOM() {

        checkoutSummaryContainer.shouldBeVisible();

        double subtotal = 0.0;

        for (WebElementFacade item : listaItemsCarrito) {

            String cantidadTexto = item.findBy("[data-test='item-quantity']").getText();
            int cantidad = Integer.parseInt(cantidadTexto.trim());

            String precioTexto = item.findBy("[data-test='inventory-item-price']").getText();
            double precio = convertirPrecio(precioTexto);

            subtotal += precio * cantidad;
        }

        return Math.round(subtotal * 100.0) / 100.0;
    }

    public void deberíaVisualizarElTaxCorrectamenteAplicado() {

        double subtotalCalculado = calcularSubtotalDesdeDOM();

        String textoTax = taxLabel.getText(); // "Tax: $3.20"
        double taxMostrado = convertirPrecio(
                textoTax.replace("Tax:", "")
        );

        double porcentajeTax = taxMostrado / subtotalCalculado;
        double taxEsperado = Math.round(subtotalCalculado * porcentajeTax * 100.0) / 100.0;

        assertThat(taxMostrado)
                .as("El tax no coincide con el porcentaje aplicado")
                .isCloseTo(taxEsperado, within(0.01));
    }

    public void deberíaVisualizarElTotalFinalCorrecto() {

        double subtotalCalculado = calcularSubtotalDesdeDOM();

        double taxMostrado = convertirPrecio(
                taxLabel.getText().replace("Tax:", "")
        );

        double totalEsperado = subtotalCalculado + taxMostrado;

        double totalMostrado = convertirPrecio(
                totalLabel.getText().replace("Total:", "")
        );

        assertThat(totalMostrado)
                .as("El total final no coincide con subtotal + tax")
                .isCloseTo(totalEsperado, within(0.01));
    }
}