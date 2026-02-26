# language: es
@REGRESSION @LOGIN
Característica: Login en SauceDemo

  Antecedentes:
    Dado que el usuario accede a SauceDemo

  @LOGIN-01
  Esquema del escenario: Login según tipo de usuario
    Cuando el usuario inicia sesión con usuario "<username>"
    Entonces debería ver el resultado de login "<resultado>"

    Ejemplos:
      | username                | resultado |
      | standard_user           | EXITO     |
      | locked_out_user         | BLOQUEADO |
      | problem_user            | EXITO     |
      | performance_glitch_user | EXITO     |
      | error_user              | EXITO     |
      | visual_user             | EXITO     |

  @LOGIN-02
  Esquema del escenario: Login con campos obligatorios vacíos
    Cuando el usuario inicia sesión con usuario "<username>" y contraseña "<password>"
    Entonces debería ver el mensaje de error "<mensaje>"

    Ejemplos:
      | username      | password                | mensaje              |
      |               | #{credentials.password} | Username is required |
      | standard_user |                         | Password is required |

  @LOGIN-03
  Esquema del escenario: Login con credenciales inválidas
    Cuando el usuario inicia sesión con usuario "<username>" y contraseña "<password>"
    Entonces debería ver el mensaje de error "<mensaje>"

    Ejemplos:
      | username      | password                | mensaje                                                     |
      | standard_user | wrong_password          | Username and password do not match any user in this service |
      | usuario_falso | #{credentials.password} | Username and password do not match any user in this service |
      | usuario_falso | wrong_password          | Username and password do not match any user in this service |