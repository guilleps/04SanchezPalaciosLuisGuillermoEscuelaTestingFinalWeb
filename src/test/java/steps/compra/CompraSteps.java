package steps.compra;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;
import page.*;

import static net.serenitybdd.core.Serenity.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class CompraSteps {

    InventoryPage inventoryPage;
    CheckoutStepOnePage checkoutStepOnePage;
    CheckoutStepTwoPage checkoutStepTwoPage;
    CheckoutCompletePage checkoutCompletePage;
    LoginPage loginPage;

    @Step
    public void agregarProducto() {
        inventoryPage.agregarUnProducto();
    }

    @Step
    public void accederAlCheckout() {
        inventoryPage.irAlCarrito();
        getDriver().getCurrentUrl().contains("cart");
        getDriver().findElement(org.openqa.selenium.By.id("checkout")).click();
    }

    @Step
    public void confirmarCompra() {
        checkoutStepTwoPage.confirmarCompra();
    }

    @Step
    public void validarCompraExitosa() {
        assertThat(checkoutCompletePage.compraExitosa())
                .isTrue();
    }

    @Step
    public void cancelarCompra() {
        checkoutStepTwoPage.cancelarCompra();
    }

    @Step
    public void cerrarSesion() {
        getDriver().findElement(org.openqa.selenium.By.id("react-burger-menu-btn")).click();
        getDriver().findElement(org.openqa.selenium.By.id("logout_sidebar_link")).click();
    }

    @Step
    public void accederDirectamenteCheckout() {
        checkoutStepOnePage.abrirDirectamente();
    }

    @Step
    public void validarRedireccionLogin() {
        assertThat(loginPage.estaEnLogin()).isTrue();
    }
}
