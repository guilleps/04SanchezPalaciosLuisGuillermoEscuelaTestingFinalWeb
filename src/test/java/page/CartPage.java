package page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class CartPage extends PageObject {

    @FindBy(css = ".cart_item")
    List<WebElementFacade> itemsCarrito;

    @FindBy(id = "continue-shopping")
    WebElementFacade btnContinueShopping;

    @FindBy(css = ".shopping_cart_badge")
    List<WebElementFacade> cartBadge;

    @FindBy(css = "button[id^='remove']")
    WebElementFacade btnRemove;

    public boolean carritoEstaVacio() {
        return itemsCarrito.isEmpty();
    }

    public void eliminarProducto() {
        btnRemove.click();
    }

    public void continuarComprando() {
        btnContinueShopping.click();
    }

    public boolean iconoCarritoVacio() {
        return cartBadge.isEmpty();
    }
}