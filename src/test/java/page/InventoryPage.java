package page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class InventoryPage extends PageObject {

    @FindBy(css = ".inventory_list")
    WebElementFacade productList;

    @FindBy(css = "[data-test='shopping-cart-link']")
    WebElementFacade btnCart;

    @FindBy(css = ".shopping_cart_badge")
    WebElementFacade cartBadge;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElementFacade btnAddBackpack;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElementFacade btnAddBikeLight;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElementFacade btnAddBlackTShirt;

    public boolean estaEnPaginaDeProductos() {
        return productList.isVisible();
    }

    public void agregarMultiplesProductos() {
        btnAddBackpack.click();
        btnAddBikeLight.click();
        btnAddBlackTShirt.click();
    }

    public void agregarUnProducto() {
        btnAddBackpack.click();
    }

    public void irAlCarrito() {
        btnCart.click();
    }

    public int obtenerCantidadCarrito() {
        return Integer.parseInt(cartBadge.getText());
    }
}
