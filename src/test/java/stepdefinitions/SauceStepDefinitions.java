package stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.annotations.Steps;
import steps.SauceSteps;

public class SauceStepDefinitions {

    @Steps
    SauceSteps sauceSteps;

    @Dado("que el usuario accede a SauceDemo")
    public void abrirPagina() {
        sauceSteps.abrirPagina();
    }

    @Cuando("el usuario inicia sesión con usuario {string} y contraseña {string}")
    public void elUsuarioIniciaSesiónConUsuarioYContraseña(String username, String password) {
        sauceSteps.iniciarSesion(username, password);
    }

    @Cuando("realiza una compra con nombre {string}, apellido {string} y código postal {string}")
    public void realizarCompra(String firstname, String lastname, String postalcode) {
        sauceSteps.realizarCompra(firstname, lastname, postalcode);
    }

    @Dado("que el usuario ha iniciado sesión correctamente")
    public void iniciarSesionCorrectamente() {
        sauceSteps.iniciarSesionCorrectamente("standard_user", "secret_sauce");
    }

    @Entonces("debería visualizar la página de productos")
    public void deberíaVisualizarLaPáginaDeProductos() {
        sauceSteps.deberiaVerListaDeProductos();
    }

    @Entonces("debería visualizar el mensaje de confirmación")
    public void deberíaVisualizarElMensajeDeConfirmación() {
        sauceSteps.deberiaVerMensajeDeConfirmacion();
    }

    @Cuando("cierra sesión")
    public void cierraSesión() {
        sauceSteps.cerrarSesion();
    }

    @Entonces("debería visualizar la pantalla de login")
    public void deberíaVisualizarLaPantallaDeLogin() {
        sauceSteps.visualizarPantallaDeLogin();
    }

    @Entonces("debería ver el resultado de login {string}")
    public void deberíaVerElResultadoDeLogin(String resultado) {
        sauceSteps.deberiaVerResultadoDeLogin(resultado);
    }

    @Entonces("debería ver el mensaje de error {string}")
    public void deberíaVerElMensajeDeError(String mensaje) {
        sauceSteps.deberiaVerMensajeDeError(mensaje);
    }

    @Cuando("accede al carrito")
    public void accedeAlCarrito() {
        sauceSteps.accedeAlCarrito();
    }

    @Entonces("debería visualizar que el carrito está vacío")
    public void deberíaVisualizarQueElCarritoEstáVacío() {
        sauceSteps.visualizarCarritoVacio();
    }

    @Cuando("agrega varios productos al carrito")
    public void agregaVariosProductosAlCarrito() {
        sauceSteps.agregaProductosAlCarrito();
    }

    @Entonces("debería visualizar la cantidad correcta en el icono del carrito")
    public void deberíaVisualizarLaCantidadCorrectaEnElIconoDelCarrito() {
        sauceSteps.visualizarCantidadCorrecta();
    }

    @Dado("que agrega un producto al carrito")
    public void queAgregaUnProductoAlCarrito() {
        sauceSteps.agregarUnProductoAlCarrito();
    }

    @Cuando("elimina el producto del carrito")
    public void eliminaElProductoDelCarrito() {
        sauceSteps.eliminarUnProductoDelCarrito();
    }

    @Entonces("el carrito debería quedar vacío")
    public void elCarritoDeberíaQuedarVacío() {
        sauceSteps.deberiaVerCarritoVacio();
    }

    @Y("presiona continuar comprando")
    public void presionaContinuarComprando() {
        sauceSteps.presionaContinuarComprando();
    }

    @Entonces("debería regresar a la lista de productos")
    public void deberíaRegresarALaListaDeProductos() {
        sauceSteps.deberiaVerListaDeProductos();
    }

    @Y("agrega un producto al carrito")
    public void agregaUnProductoAlCarrito() {
        sauceSteps.agregarUnProductoAlCarrito();
    }

    @Y("accede al checkout")
    public void accedeAlCheckout() {
        sauceSteps.accedeAlCheckout();
    }

    @Cuando("intenta continuar con first name {string}, last name {string} y postal code {string}")
    public void intentaContinuarConDatos(String firstname, String lastname, String postalcode) {
        sauceSteps.intentaContinuarCheckout(firstname, lastname, postalcode);
    }

    @Entonces("debería visualizar el mensaje de checkout {string}")
    public void deberiaVisualizarMensajeCheckout(String mensaje) {
        sauceSteps.validarResultadoCheckout(mensaje);
    }

    @Cuando("completa el formulario con nombre {string}, apellido {string} y código postal {string}")
    public void completaElFormularioConNombreApellidoYCódigoPostal(String firstname, String lastname, String postalcode) {
        sauceSteps.completaElFormularioDeCheckout(firstname, lastname, postalcode);
    }

    @Entonces("debería avanzar a la pantalla de resumen")
    public void deberíaAvanzarALaPantallaDeResumen() {
        sauceSteps.deberiaAvanzarALaPantallaDeResumen();
    }

    @Y("confirma la compra")
    public void confirmaLaCompra() {
        sauceSteps.confirmaLaCompra();
    }

    @Y("cancela desde la pantalla de resumen")
    public void cancelaDesdeLaPantallaDeResumen() {
        sauceSteps.cancelaDesdeLaPantallaDeResumen();
    }

    @Y("que el usuario ha cerrado sesión")
    public void queElUsuarioHaCerradoSesión() {
        sauceSteps.cerrarSesion();
    }

    @Cuando("intenta acceder directamente al checkout")
    public void intentaAccederDirectamenteAlCheckout() {
        sauceSteps.accedeDirectamenteAlCheckout();
    }

    @Entonces("debería ser redirigido al login")
    public void deberíaSerRedirigidoAlLogin() {
        sauceSteps.visualizarPantallaDeLogin();
    }

    @Cuando("completa el formulario correctamente")
    public void completaElFormularioCorrectamente() {
        sauceSteps.intentaContinuarCheckout("Manu", "Rojas", "15007");
    }

    @Entonces("debería visualizar el subtotal correcto")
    public void deberíaVisualizarElSubtotalCorrecto() {
        sauceSteps.deberíaVisualizarElSubtotalCorrecto();
    }

    @Y("debería visualizar el tax correctamente aplicado")
    public void deberíaVisualizarElTaxCorrectamenteAplicado() {
        sauceSteps.deberíaVisualizarElTaxCorrectamenteAplicado();
    }

    @Y("debería visualizar el total final correcto")
    public void deberíaVisualizarElTotalFinalCorrecto() {
        sauceSteps.deberíaVisualizarElTotalFinalCorrecto();
    }
}
