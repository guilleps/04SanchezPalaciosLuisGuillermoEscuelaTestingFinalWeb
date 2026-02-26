package page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class CheckoutStepTwoPage extends PageObject {

    @FindBy(id = "finish")
    WebElementFacade btnFinish;

    @FindBy(id = "cancel")
    WebElementFacade btnCancel;

    @FindBy(css = "[data-test='inventory-item']")
    List<WebElementFacade> items;

    @FindBy(css = "[data-test='subtotal-label']")
    WebElementFacade subtotalLabel;

    @FindBy(css = "[data-test='tax-label']")
    WebElementFacade taxLabel;

    @FindBy(css = "[data-test='total-label']")
    WebElementFacade totalLabel;

    public void confirmarCompra() {
        btnFinish.click();
    }

    public void cancelarCompra() {
        btnCancel.click();
    }

    public double convertirPrecio(String texto) {
        return Double.parseDouble(texto.replace("$", "")
                .replace("Item total:", "")
                .replace("Tax:", "")
                .replace("Total:", "")
                .trim());
    }

    public double calcularSubtotalDesdeDOM() {

        double subtotal = 0.0;

        for (WebElementFacade item : items) {

            int cantidad = Integer.parseInt(
                    item.findBy("[data-test='item-quantity']").getText()
            );

            double precio = convertirPrecio(
                    item.findBy("[data-test='inventory-item-price']").getText()
            );

            subtotal += precio * cantidad;
        }

        return Math.round(subtotal * 100.0) / 100.0;
    }

    public double obtenerSubtotalMostrado() {
        return convertirPrecio(subtotalLabel.getText());
    }

    public double obtenerTaxMostrado() {
        return convertirPrecio(taxLabel.getText());
    }

    public double obtenerTotalMostrado() {
        return convertirPrecio(totalLabel.getText());
    }
}