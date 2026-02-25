package steps;

import net.serenitybdd.annotations.Step;
import page.SaucePage;

public class SauceSteps {

    SaucePage saucePage;

    @Step
    public void abrirPagina() {
        saucePage.open();
    }

    @Step
    public void iniciarSesion(String username, String password) {
        saucePage.escribirUsername(username);
        saucePage.escribirPassword(password);
        saucePage.loguearse();
    }

    @Step
    public void realizarCompra(String firstname, String lastname, String postalcode) {
        saucePage.agregarBackpackAlCarrito();
        saucePage.clickCart();
        saucePage.clickCheckout();

        saucePage.escribiFirstname(firstname);
        saucePage.escribirLastname(lastname);
        saucePage.escribirPostalcode(postalcode);

        saucePage.clickContinue();
        saucePage.clickFinish();
    }

    @Step
    public void iniciarSesionCorrectamente(String username, String password) {
        saucePage.open();
        saucePage.escribirUsername(username);
        saucePage.escribirPassword(password);
        saucePage.loguearse();
        validarLoginExitoso();
    }

    @Step
    public void validarLoginExitoso() {
        saucePage.validarUrl("inventory.html");
        saucePage.visualizarListaDeProductos();
    }

    @Step
    public void visualizarListaDeProductos() {
        saucePage.visualizarListaDeProductos();
    }

    @Step
    public void visualizarMensajeDeConfirmacion() {
        saucePage.validarCompraExitosa();
    }

    @Step
    public void cerrarSesion() {
        saucePage.clickToggleMenu();
        saucePage.clickLogout();
    }

    @Step
    public void visualizarPantallaDeLogin() {
        saucePage.validarPantallaLogin();
    }
}