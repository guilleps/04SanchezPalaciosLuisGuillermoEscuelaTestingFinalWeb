package stepdefinitions.checkout;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Steps;
import steps.checkout.CheckoutSteps;

public class CheckoutStepDefinitions {

    @Steps
    CheckoutSteps checkoutSteps;

    @Cuando("intenta continuar con first name {string}, last name {string} y postal code {string}")
    public void intentarContinuar(String firstname, String lastname, String postal) {
        checkoutSteps.intentarContinuar(firstname, lastname, postal);
    }

    @Entonces("debería visualizar el mensaje de checkout {string}")
    public void validarMensaje(String mensaje) {
        checkoutSteps.validarMensajeCheckout(mensaje);
    }

    @Cuando("completa el formulario con nombre {string}, apellido {string} y código postal {string}")
    public void completarFormulario(String nombre, String apellido, String codigo) {
        checkoutSteps.intentarContinuar(nombre, apellido, codigo);
    }

    @Entonces("debería avanzar a la pantalla de resumen")
    public void validarAvance() {
        checkoutSteps.validarAvanceResumen();
    }

    @Cuando("completa el formulario correctamente")
    public void completarFormularioCorrectamente() {
        checkoutSteps.completarFormularioCorrectamente();
    }

    @Entonces("debería visualizar el subtotal correcto")
    public void validarSubtotal() {
        checkoutSteps.validarSubtotalCorrecto();
    }

    @Entonces("debería visualizar el tax correctamente aplicado")
    public void validarTax() {
        checkoutSteps.validarTaxCorrecto();
    }

    @Entonces("debería visualizar el total final correcto")
    public void validarTotal() {
        checkoutSteps.validarTotalCorrecto();
    }
}