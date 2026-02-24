package stepdefinitions;

import io.cucumber.java.es.Dado;
import net.serenitybdd.annotations.Steps;
import steps.GoogleSteps;

public class GoogleStepDefinitions {

    @Steps
    GoogleSteps googleSteps;

    @Dado("que el usuario abre la página de Google")
    public void queElUsuarioAbreLaPaginaDeGoogle() {
        googleSteps.abrirGoogle();
    }

    @Dado("que el usuario busque {string} en Google")
    public void queElUsuarioBusqueEnGoogle(String texto) {
        googleSteps.buscarEnGoogle(texto);
    }
}
