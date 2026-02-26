package steps.carrito;

import net.serenitybdd.annotations.Step;
import page.CartPage;
import page.InventoryPage;

import static org.assertj.core.api.Assertions.assertThat;

public class CarritoSteps {

    InventoryPage inventoryPage;
    CartPage cartPage;

    @Step
    public void accederAlCarrito() {
        inventoryPage.irAlCarrito();
    }

    @Step
    public void agregarMultiplesProductos() {
        inventoryPage.agregarMultiplesProductos();
    }

    @Step
    public void agregarUnProducto() {
        inventoryPage.agregarUnProducto();
    }

    @Step
    public void eliminarProducto() {
        cartPage.eliminarProducto();
    }

    @Step
    public void validarCarritoVacio() {
        assertThat(cartPage.carritoEstaVacio())
                .as("El carrito debería estar vacío")
                .isTrue();
    }

    @Step
    public void validarCantidadCorrecta(int cantidadEsperada) {
        int cantidadReal = inventoryPage.obtenerCantidadCarrito();

        assertThat(cantidadReal)
                .as("Cantidad incorrecta en el icono del carrito")
                .isEqualTo(cantidadEsperada);
    }

    @Step
    public void validarIconoCarritoVacio() {
        assertThat(cartPage.iconoCarritoVacio())
                .isTrue();
    }

    @Step
    public void continuarComprando() {
        cartPage.continuarComprando();
    }

    @Step
    public void validarRegresoAProductos() {
        assertThat(inventoryPage.estaEnPaginaDeProductos())
                .isTrue();
    }
}