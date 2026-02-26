# language: es
@CHECKOUT
Característica: Validaciones del formulario de checkout

  Antecedentes:
    Dado que el usuario ha iniciado sesión correctamente
    Y agrega un producto al carrito
    Y accede al checkout

  @CHECKOUT-01
  Esquema del escenario: Validaciones obligatorias del formulario
    Cuando intenta continuar con first name "<firstname>", last name "<lastname>" y postal code "<postalcode>"
    Entonces debería visualizar el mensaje de checkout "<mensaje>"

    Ejemplos:
      | firstname | lastname | postalcode | mensaje                        |
      |           | Palacios | 14560      | Error: First Name is required  |
      | Memo      |          | 14560      | Error: Last Name is required   |
      | Memo      | Palacios |            | Error: Postal Code is required |
      | Memo      | Palacios | 14560      | EXITO                          |

  @CHECKOUT-02
  Escenario: Checkout con datos válidos
    Cuando completa el formulario con nombre "Memo", apellido "Palacios" y código postal "13001"
    Entonces debería avanzar a la pantalla de resumen

  @CHECKOUT-03
  Escenario: Validar cálculo correcto de subtotal, tax y total
    Cuando completa el formulario correctamente
    Entonces debería visualizar el subtotal correcto
    Y debería visualizar el tax correctamente aplicado
    Y debería visualizar el total final correcto