# language: es
Característica: Quiero automatizar la web de SauceDemo

  @SAUCE-1 @SAUCEDEMO
  Escenario: Abrir la página principal de SauceDemo
    Dado que el usuario abre la pagina de SauceDemo

  @SAUCE-2 @SAUCEDEMO
  Escenario: Escribir username y password en SauceDemo
    Dado que el usuario abre la pagina de SauceDemo
    Y que el usuario inicia sesión con usuario "standard_user" y contraseña "secret_sauce"

  @SAUCE-3 @SAUCEDEMO
  Escenario: Añadir un producto al carrito y verificarlo en SauceDemo
    Dado que el usuario abre la pagina de SauceDemo
    Y que el usuario inicia sesión con usuario "standard_user" y contraseña "secret_sauce"
    Y el usuario añade un producto al carrito
    Y ingresa al carrito
    Y el usuario continúa al checkout de la compra

    Cuando el usuario completa el checkout con nombre "Memo" apellido "Palacios" y código postal "13001"
