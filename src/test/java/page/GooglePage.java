package page;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

@DefaultUrl("https://www.google.com")
public class GooglePage extends PageObject {

    @FindBy(name = "q")
    WebElement txtBusqueda;

    public void buscar(String texto) {
        txtBusqueda.sendKeys(texto);
        txtBusqueda.sendKeys(Keys.ENTER);
    }
}
