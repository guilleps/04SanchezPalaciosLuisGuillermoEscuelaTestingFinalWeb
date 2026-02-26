# language: es
@CARRITO
Característica: Gestión del carrito en SauceDemo

  Antecedentes:
    Dado que el usuario ha iniciado sesión correctamente

  @CARRITO-01
  Escenario: Visualizar carrito vacío
    Cuando accede al carrito
    Entonces debería visualizar que el carrito está vacío

  @CARRITO-02
  Escenario: Agregar múltiples productos al carrito
    Cuando agrega varios productos al carrito
    Entonces debería visualizar la cantidad correcta en el icono del carrito

  @CARRITO-03
  Escenario: Remover producto del carrito
    Dado que agrega un producto al carrito
    Cuando elimina el producto del carrito
    Entonces el carrito debería quedar vacío

  @CARRITO-04
  Escenario: Navegar desde carrito a productos
    Cuando accede al carrito
    Y presiona continuar comprando
    Entonces debería regresar a la lista de productos