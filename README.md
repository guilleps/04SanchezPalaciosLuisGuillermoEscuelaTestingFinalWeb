# Prueba final web - Serenity - Escuela Testing

---

# Módulos Automatizados

## 1. Login

Archivo: `login.feature`

Incluye:

* Login exitoso (standard_user)
* Usuario bloqueado
* Campos obligatorios vacíos
* Credenciales inválidas

Las credenciales no están en el feature, se obtienen desde `serenity.conf`.

---

## 2. Carrito

Archivo: `carrito.feature`

Se valida:

* Carrito vacío
* Agregar múltiples productos
* Eliminar producto
* Navegar de carrito a productos

---

## 3. Checkout

Archivo: `checkout.feature`

Incluye:

* Validaciones de campos obligatorios
* Flujo válido hasta resumen
* Validación matemática de:

    * Subtotal
    * Tax
    * Total final

---

## 4. Compra (End-to-End)

Archivo: `compra.feature`

Escenarios:

* Compra exitosa completa
* Cancelar desde resumen
* Intentar comprar con sesión cerrada

---

# Regression Runner

El proyecto incluye `RegressionRunner`, que ejecuta todos los escenarios con el tag:

```gherkin
@REGRESSION
```

Este runner permite ejecutar toda la suite en una sola ejecución.

---

# Configuración

## URL Base (enlace a usar = https://www.saucedemo.com)

Configurada en `serenity.conf`:

```
environments {
    default {
        webdriver.base.url = ""
    }
}
```

## Credenciales
(usar password por defecto mostrado en el home de la web saucedemo)

```
credentials {
  username = "standard_user"
  password = ""
}
```
