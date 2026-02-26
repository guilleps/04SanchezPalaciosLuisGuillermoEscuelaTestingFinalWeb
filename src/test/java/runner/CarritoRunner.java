package runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/carrito.feature",
        glue = "stepdefinitions",
        tags = "@CARRITO",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CarritoRunner {
}
