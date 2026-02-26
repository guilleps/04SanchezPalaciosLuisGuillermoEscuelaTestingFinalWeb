# language: es
@COMPRA
Característica: Flujo completo de compra en SauceDemo

  @COMPRA-01
  Escenario: Compra exitosa end-to-end
    Dado que el usuario ha iniciado sesión correctamente
    Cuando agrega un producto al carrito
    Y accede al checkout
    Y completa el formulario con nombre "Memo", apellido "Palacios" y código postal "13001"
    Y confirma la compra
    Entonces debería visualizar el mensaje de confirmación

  @COMPRA-02
  Escenario: Cancelar compra desde el resumen
    Dado que el usuario ha iniciado sesión correctamente
    Cuando agrega un producto al carrito
    Y accede al checkout
    Y completa el formulario con nombre "Memo", apellido "Palacios" y código postal "13001"
    Y cancela desde la pantalla de resumen
    Entonces debería regresar a la lista de productos

  @COMPRA-03
  Escenario: Intentar comprar con sesión cerrada
    Dado que el usuario ha iniciado sesión correctamente
    Y que el usuario ha cerrado sesión
    Cuando intenta acceder directamente al checkout
    Entonces debería ser redirigido al login