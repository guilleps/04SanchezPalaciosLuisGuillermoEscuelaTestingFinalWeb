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
        sauceSteps.visualizarListaDeProductos();
    }

    @Entonces("debería visualizar el mensaje de confirmación")
    public void deberíaVisualizarElMensajeDeConfirmación() {
        sauceSteps.visualizarMensajeDeConfirmacion();
    }

    @Cuando("cierra sesión")
    public void cierraSesión() {
        sauceSteps.cerrarSesion();
    }

    @Entonces("debería visualizar la pantalla de login")
    public void deberíaVisualizarLaPantallaDeLogin() {
        sauceSteps.visualizarPantallaDeLogin();
    }
}
