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
    public void llenarFormularioLogin(String username, String password) {
        saucePage.escribirUsername(username);
        saucePage.escribirPassword(password);
        saucePage.loguearse();
    }

    @Step
    public void iniciarSesion(String username, String password) {
        llenarFormularioLogin(username, password);
    }

    @Step
    public void llenarFormularioCheckout(String firstname, String lastname, String postalcode) {
        saucePage.escribiFirstname(firstname);
        saucePage.escribirLastname(lastname);
        saucePage.escribirPostalcode(postalcode);
    }

    @Step
    public void realizarCompra(String firstname, String lastname, String postalcode) {
        saucePage.visualizarListaDeProductos(); // validamos antes la lista de productos

        saucePage.agregarBackpackAlCarrito();
        saucePage.clickCart();
        saucePage.clickCheckout();

        llenarFormularioCheckout(firstname, lastname, postalcode);

        saucePage.clickContinue();
        saucePage.clickFinish();
    }

    @Step
    public void validarLoginExitoso() {
        saucePage.validarUrl("inventory.html");
        saucePage.visualizarListaDeProductos();
    }

    @Step
    public void iniciarSesionCorrectamente(String username, String password) {
        abrirPagina();
        llenarFormularioLogin(username, password);
        validarLoginExitoso();
    }

    @Step
    public void deberiaVerListaDeProductos() {
        saucePage.visualizarListaDeProductos();
    }

    @Step
    public void deberiaVerMensajeDeConfirmacion() {
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

    @Step
    public void deberiaVerResultadoDeLogin(String resultado) {
        switch (resultado) {
            case "EXITO" -> validarLoginExitoso();
            case "BLOQUEADO" -> saucePage.deberiaMostrarErrorUsuarioBloqueado();
            default -> throw new IllegalArgumentException("Resultado no soportado: " + resultado);
        }
    }

    @Step
    public void deberiaVerMensajeDeError(String mensaje) {
        saucePage.deberiaMostrarMensajeDeError(mensaje);
    }

    @Step
    public void accedeAlCarrito() {
        saucePage.accedeAlCarrito();
    }

    @Step
    public void visualizarCarritoVacio() {
        saucePage.visualizarCarritoVacio();
    }

    @Step
    public void agregaProductosAlCarrito() {
        saucePage.agregaProductosAlCarrito();
    }

    @Step
    public void visualizarCantidadCorrecta() {
        saucePage.visualizarCantidadCorrecta();
    }

    @Step
    public void agregarUnProductoAlCarrito() {
        saucePage.agregarUnProductoAlCarrito();
    }

    @Step
    public void eliminarUnProductoDelCarrito() {
        saucePage.eliminarUnProductoDelCarrito();
    }

    @Step
    public void deberiaVerCarritoVacio() {
        saucePage.deberiaVerCarritoVacio();
    }

    @Step
    public void presionaContinuarComprando() {
        saucePage.clickContinueShopping();
    }

    @Step
    public void accedeAlCheckout() {
        saucePage.accedeAlCarrito();
        saucePage.clickCheckout();
    }

    @Step
    public void intentaContinuarCheckout(String firstname, String lastname, String postalcode) {
        saucePage.limpiarFormularioCheckout();
        saucePage.escribiFirstname(firstname);
        saucePage.escribirLastname(lastname);
        saucePage.escribirPostalcode(postalcode);
        saucePage.clickContinue();
    }

    @Step
    public void validarResultadoCheckout(String mensaje) {
        if ("EXITO".equals(mensaje)) {
            saucePage.validarCheckoutExitoso();
        } else {
            saucePage.deberiaMostrarMensajeDeError(mensaje);
        }
    }

    @Step
    public void completaElFormularioDeCheckout(String firstname, String lastname, String postalcode) {
        llenarFormularioCheckout(firstname, lastname, postalcode);
        saucePage.clickContinue();
        saucePage.clickFinish();
    }

    @Step
    public void deberiaAvanzarALaPantallaDeResumen() {
        saucePage.deberiaAvanzarALaPantallaDeResumen();
    }

    @Step
    public void confirmaLaCompra() {
        saucePage.clickFinish();
    }

    @Step
    public void cancelaDesdeLaPantallaDeResumen() {
        saucePage.cancelaDesdeLaPantallaDeResumen();
        completaElFormularioDeCheckout("Juanita", "Milanesa", "14017");
    }

    @Step
    public void accedeDirectamenteAlCheckout() {
        saucePage.accedeDirectamenteAlCarrito("checkout-step-one.html");
    }

    @Step
    public void deberíaVisualizarElSubtotalCorrecto() {
        saucePage.calcularSubtotalDesdeDOM();
    }

    @Step
    public void deberíaVisualizarElTaxCorrectamenteAplicado() {
        saucePage.deberíaVisualizarElTaxCorrectamenteAplicado();
    }

    @Step
    public void deberíaVisualizarElTotalFinalCorrecto() {
        saucePage.deberíaVisualizarElTotalFinalCorrecto();
    }
}