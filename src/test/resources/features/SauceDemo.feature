# language: es
@HAPPYPATH
Característica: Proceso de compra en SauceDemo

  Antecedentes:
    Dado que el usuario accede a SauceDemo

  @SAUCE-1 @LOGIN
  Escenario: Login exitoso
    Cuando el usuario inicia sesión con usuario "standard_user" y contraseña "secret_sauce"
    Entonces debería visualizar la página de productos

  @SAUCE-2 @COMPRA
  Escenario: Compra exitosa
    Dado que el usuario ha iniciado sesión correctamente
    Cuando realiza una compra con nombre "Memo", apellido "Palacios" y código postal "13001"
    Entonces debería visualizar el mensaje de confirmación

  @SAUCE-3 @LOGOUT
  Escenario: Cierre de sesión exitoso
    Dado que el usuario ha iniciado sesión correctamente
    Cuando cierra sesión
    Entonces debería visualizar la pantalla de login