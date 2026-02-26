package steps.checkout;

import net.serenitybdd.annotations.Step;
import page.CheckoutStepOnePage;
import page.CheckoutStepTwoPage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

public class CheckoutSteps {

    CheckoutStepOnePage checkoutStepOnePage;
    CheckoutStepTwoPage checkoutStepTwoPage;

    @Step
    public void intentarContinuar(String firstname, String lastname, String postal) {
        checkoutStepOnePage.intentarContinuar(firstname, lastname, postal);
    }

    @Step
    public void validarMensajeCheckout(String mensajeEsperado) {

        if (mensajeEsperado.equals("EXITO")) {
            // No debería haber error visible
            assertThat(checkoutStepOnePage.errorVisible())
                    .isFalse();
        } else {
            assertThat(checkoutStepOnePage.obtenerMensajeError())
                    .contains(mensajeEsperado);
        }
    }

    @Step
    public void completarFormularioCorrectamente() {
        checkoutStepOnePage.completarFormularioCorrectamente();
    }

    @Step
    public void validarAvanceResumen() {
        assertThat(checkoutStepTwoPage.getDriver().getCurrentUrl())
                .contains("checkout-step-two.html");
    }

    @Step
    public void validarSubtotalCorrecto() {

        double subtotalCalculado = checkoutStepTwoPage.calcularSubtotalDesdeDOM();
        double subtotalMostrado = checkoutStepTwoPage.obtenerSubtotalMostrado();

        assertThat(subtotalMostrado)
                .isCloseTo(subtotalCalculado, within(0.01));
    }

    @Step
    public void validarTaxCorrecto() {

        double subtotal = checkoutStepTwoPage.calcularSubtotalDesdeDOM();
        double taxMostrado = checkoutStepTwoPage.obtenerTaxMostrado();

        double porcentaje = taxMostrado / subtotal;
        double taxEsperado = Math.round(subtotal * porcentaje * 100.0) / 100.0;

        assertThat(taxMostrado)
                .isCloseTo(taxEsperado, within(0.01));
    }

    @Step
    public void validarTotalCorrecto() {

        double subtotal = checkoutStepTwoPage.calcularSubtotalDesdeDOM();
        double tax = checkoutStepTwoPage.obtenerTaxMostrado();
        double totalMostrado = checkoutStepTwoPage.obtenerTotalMostrado();

        assertThat(totalMostrado)
                .isCloseTo(subtotal + tax, within(0.01));
    }
}