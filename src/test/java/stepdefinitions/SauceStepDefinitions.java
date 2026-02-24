package stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import net.serenitybdd.annotations.Steps;
import steps.SauceSteps;

public class SauceStepDefinitions {

    @Steps
    SauceSteps sauceSteps;

    @Dado("que el usuario abre la pagina de SauceDemo")
    public void queElUsuarioAbreLaPaginaDeSauceDemo() {
        sauceSteps.abrirSauceDemo();
    }

    @Dado("que el usuario inicia sesión con usuario {string} y contraseña {string}")
    public void escribirUsernameYPassword(String user, String password) {
        sauceSteps.escribirUsernameYPassword(user, password);
    }

    @Dado("el usuario añade un producto al carrito")
    public void elUsuarioAñadaUnProductoAlCarrito() {
        sauceSteps.agregarUnProductoAlCarrito();
    }

    @Dado("ingresa al carrito")
    public void queElUsuarioIngreseAlCarrito() {
        sauceSteps.ingresarAlCarritoDeCompras();
    }

    @Dado("el usuario continúa al checkout de la compra")
    public void elUsuarioContinuaAlCheckoutDeLaCompra() {
        sauceSteps.ingresarAlCheckout();
    }

    @Cuando("el usuario completa el checkout con nombre {string} apellido {string} y código postal {string}")
    public void elUsuarioCompletaElCheckoutConNombreApellidoYCodigoPostal(String firstName, String lastName, String postalCode) {
        sauceSteps.elUsuarioCompletaElCheckoutConNombreApellidoYCodigoPostal(firstName, lastName, postalCode);
    }
}
