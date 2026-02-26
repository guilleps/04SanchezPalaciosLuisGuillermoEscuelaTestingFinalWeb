package stepdefinitions.compra;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Steps;
import steps.compra.CompraSteps;

public class CompraStepDefinitions {

    @Steps
    CompraSteps compraSteps;

    @Cuando("agrega un producto al carrito")
    public void agregarProducto() {
        compraSteps.agregarProducto();
    }

    @Cuando("accede al checkout")
    public void accederCheckout() {
        compraSteps.accederAlCheckout();
    }

    @Cuando("confirma la compra")
    public void confirmarCompra() {
        compraSteps.confirmarCompra();
    }

    @Entonces("debería visualizar el mensaje de confirmación")
    public void validarCompraExitosa() {
        compraSteps.validarCompraExitosa();
    }

    @Cuando("cancela desde la pantalla de resumen")
    public void cancelarCompra() {
        compraSteps.cancelarCompra();
    }

    @Dado("que el usuario ha cerrado sesión")
    public void cerrarSesion() {
        compraSteps.cerrarSesion();
    }

    @Cuando("intenta acceder directamente al checkout")
    public void accederDirectamente() {
        compraSteps.accederDirectamenteCheckout();
    }

    @Entonces("debería ser redirigido al login")
    public void validarRedireccion() {
        compraSteps.validarRedireccionLogin();
    }
}