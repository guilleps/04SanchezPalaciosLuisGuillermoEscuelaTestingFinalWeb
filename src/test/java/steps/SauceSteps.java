package steps;

import net.serenitybdd.annotations.Step;
import page.SaucePage;

public class SauceSteps {

    SaucePage saucePage;

    @Step
    public void abrirSauceDemo() {
        saucePage.open();
    }

    @Step
    public void escribirUsernameYPassword(String username, String password) {
        saucePage.escribirUsernameYPassword(username, password);
    }

    @Step
    public void agregarUnProductoAlCarrito() {
        saucePage.agregarUnProductoAlCarrito();
    }

    @Step
    public void ingresarAlCarritoDeCompras() {
        saucePage.ingresarAlCarritoDeCompras();
    }

    @Step
    public void ingresarAlCheckout() {
        saucePage.ingresarAlCheckout();
    }

    @Step
    public void elUsuarioCompletaElCheckoutConNombreApellidoYCodigoPostal(String firstName, String lastName, String postalCode) {
        saucePage.completarFormularioCheckout(firstName, lastName, postalCode);
    }
}
