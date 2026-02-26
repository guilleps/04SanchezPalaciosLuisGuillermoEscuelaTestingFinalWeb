package page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPage extends PageObject {

    @FindBy(id = "user-name")
    WebElementFacade inputUsername;

    @FindBy(id = "password")
    WebElementFacade inputPassword;

    @FindBy(id = "login-button")
    WebElementFacade btnLogin;

    @FindBy(css = "h3[data-test='error']")
    WebElementFacade mssgLoginError;

    public void ingresarUsername(String username) {
        inputUsername.sendKeys(username);
    }

    public void ingresarPassword(String password) {
        inputPassword.sendKeys(password);
    }

    public void clickLogin() {
        btnLogin.waitUntilClickable().click();
    }

    public String obtenerMensajeError() {
        return mssgLoginError.getText();
    }

    public boolean mensajeErrorVisible() {
        return mssgLoginError.isVisible();
    }

    public void validarUrl(String url) {
        assertThat(getDriver().getCurrentUrl())
                .contains(url);
    }

    public boolean estaEnLogin() {
        return getDriver().getCurrentUrl().endsWith("/");
    }
}
