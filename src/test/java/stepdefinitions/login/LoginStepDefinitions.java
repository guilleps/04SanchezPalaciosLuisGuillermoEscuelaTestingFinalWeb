package stepdefinitions.login;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Steps;
import steps.login.LoginSteps;

public class LoginStepDefinitions {

    @Steps
    LoginSteps loginSteps;

    @Dado("que el usuario accede a SauceDemo")
    public void accederASauceDemo() {
        loginSteps.abrirSauceDemo();
    }

    @Cuando("el usuario inicia sesión con usuario {string}")
    public void iniciarSesion(String username) {
        loginSteps.iniciarSesion(username);
    }

    @Cuando("el usuario inicia sesión con usuario {string} y contraseña {string}")
    public void iniciarSesionConUsuarioYContraseña(String username, String password) {
        loginSteps.iniciarSesionConUsuarioYContraseña(username, password);
    }

    @Entonces("debería ver el resultado de login {string}")
    public void validarResultadoLogin(String resultado) {
        loginSteps.validarResultadoLogin(resultado);
    }

    @Entonces("debería ver el mensaje de error {string}")
    public void validarMensajeError(String mensaje) {
        loginSteps.validarMensajeError(mensaje);
    }

    @Dado("que el usuario ha iniciado sesión correctamente")
    public void iniciarSesionCorrectamente() {
        loginSteps.iniciarSesionCorrectamente("standard_user");
    }
}

