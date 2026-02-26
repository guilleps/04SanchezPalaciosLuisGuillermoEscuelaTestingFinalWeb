package stepdefinitions.carrito;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Steps;
import steps.carrito.CarritoSteps;

public class CarritoStepDefinitions {

    @Steps
    CarritoSteps carritoSteps;

    @Cuando("accede al carrito")
    public void accederAlCarrito() {
        carritoSteps.accederAlCarrito();
    }

    @Cuando("agrega varios productos al carrito")
    public void agregarMultiplesProductos() {
        carritoSteps.agregarMultiplesProductos();
    }

    @Entonces("debería visualizar que el carrito está vacío")
    public void validarCarritoVacio() {
        carritoSteps.validarCarritoVacio();
    }

    @Entonces("debería visualizar la cantidad correcta en el icono del carrito")
    public void validarCantidadCorrecta() {
        carritoSteps.validarCantidadCorrecta(3);
    }

    @Dado("que agrega un producto al carrito")
    public void agregarUnProducto() {
        carritoSteps.agregarUnProducto();
    }

    @Cuando("elimina el producto del carrito")
    public void eliminarProducto() {
        carritoSteps.eliminarProducto();
    }

    @Entonces("el carrito debería quedar vacío")
    public void carritoVacio() {
        carritoSteps.validarIconoCarritoVacio();
    }

    @Cuando("presiona continuar comprando")
    public void continuarComprando() {
        carritoSteps.continuarComprando();
    }

    @Entonces("debería regresar a la lista de productos")
    public void regresarAProductos() {
        carritoSteps.validarRegresoAProductos();
    }
}
