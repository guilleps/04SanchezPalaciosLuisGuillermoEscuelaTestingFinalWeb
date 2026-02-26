package steps.login;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;
import page.InventoryPage;
import page.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps {

    LoginPage loginPage;
    InventoryPage inventoryPage;

    EnvironmentVariables environmentVariables;

    @Step
    public void abrirSauceDemo() {
        loginPage.open();
    }

    @Step
    public void iniciarSesion(String username) {
        String password = EnvironmentSpecificConfiguration
                .from(environmentVariables)
                .getProperty("credentials.password");

        loginPage.ingresarUsername(username);
        loginPage.ingresarPassword(password);
        loginPage.clickLogin();
    }

    @Step
    public void iniciarSesionConUsuarioYContraseña(String username, String password) {

        if (password.startsWith("#{")) {
            password = EnvironmentSpecificConfiguration
                    .from(environmentVariables)
                    .getProperty("credentials.password");
        }

        loginPage.ingresarUsername(username);
        loginPage.ingresarPassword(password);
        loginPage.clickLogin();
    }

    @Step
    public void validarResultadoLogin(String resultado) {

        switch (resultado) {
            case "EXITO":
                assertThat(inventoryPage.estaEnPaginaDeProductos())
                        .as("No se mostró la lista de productos")
                        .isTrue();
                break;

            case "BLOQUEADO":
                assertThat(loginPage.mensajeErrorVisible())
                        .isTrue();

                assertThat(loginPage.obtenerMensajeError())
                        .contains("locked out");
                break;

            default:
                throw new IllegalArgumentException("Resultado no soportado: " + resultado);
        }
    }

    @Step
    public void validarMensajeError(String mensajeEsperado) {

        assertThat(loginPage.mensajeErrorVisible())
                .isTrue();

        assertThat(loginPage.obtenerMensajeError())
                .contains(mensajeEsperado);
    }

    @Step
    public void validarLoginExitoso() {
        loginPage.validarUrl("inventory.html");
    }

    @Step
    public void iniciarSesionCorrectamente(String username) {
        abrirSauceDemo();
        iniciarSesion(username);
        validarLoginExitoso();
    }
}
