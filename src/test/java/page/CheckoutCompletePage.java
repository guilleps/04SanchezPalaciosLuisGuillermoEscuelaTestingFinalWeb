package page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CheckoutCompletePage extends PageObject {

    @FindBy(css = ".complete-header")
    WebElementFacade mensajeConfirmacion;

    public boolean compraExitosa() {
        return mensajeConfirmacion.isVisible();
    }
}