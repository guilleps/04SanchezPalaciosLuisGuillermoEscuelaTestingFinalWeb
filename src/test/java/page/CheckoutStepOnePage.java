package page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CheckoutStepOnePage extends PageObject {

    @FindBy(id = "first-name")
    WebElementFacade inputFirstName;

    @FindBy(id = "last-name")
    WebElementFacade inputLastName;

    @FindBy(id = "postal-code")
    WebElementFacade inputPostalCode;

    @FindBy(id = "continue")
    WebElementFacade btnContinue;

    @FindBy(css = "h3[data-test='error']")
    WebElementFacade errorMessage;

    public void intentarContinuar(String firstname, String lastname, String postal) {
        inputFirstName.type(firstname);
        inputLastName.type(lastname);
        inputPostalCode.type(postal);
        btnContinue.click();
    }

    public String obtenerMensajeError() {
        return errorMessage.getText();
    }

    public boolean errorVisible() {
        return errorMessage.isVisible();
    }

    public void completarFormularioCorrectamente() {
        inputFirstName.type("Memo");
        inputLastName.type("Vasques");
        inputPostalCode.type("13009");
        btnContinue.click();
    }

    public void abrirDirectamente() {
        openAt("/checkout-step-one.html");
    }
}