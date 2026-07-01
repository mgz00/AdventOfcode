# Package `core`

## Objetivo

El paquete **core** contiene la infraestructura común utilizada por todas las soluciones del proyecto. Su finalidad es proporcionar una arquitectura reutilizable para que cada día se centre exclusivamente en resolver el problema planteado, evitando duplicación de código y favoreciendo un diseño modular.

---

## Componentes

| Clase | Responsabilidad |
|--------|-----------------|
| `Solver` | Define el contrato común que deben implementar todos los días (`solvePartOne()` y `solvePartTwo()`). |
| `InputSource` | Abstracción del origen de datos, desacoplando la lectura de la lógica de resolución. |
| `FileInputSource` | Implementación de `InputSource` que obtiene la entrada desde los archivos del proyecto. |
| `Reporter` | Muestra los resultados de cada solución con un formato uniforme. |

---

## Diseño y principios aplicados

### Dependency Inversion Principle (DIP)

Los solvers no dependen de archivos ni de mecanismos concretos de lectura, sino de la abstracción `InputSource`.

Gracias a ello, la misma solución puede ejecutarse utilizando un fichero, una entrada simulada en los tests o cualquier otra fuente de datos sin modificar el código del solver.

### Single Responsibility Principle (SRP)

Cada clase posee una única responsabilidad:

- `Solver` define el contrato.
- `InputSource` abstrae la lectura de datos.
- `FileInputSource` implementa esa lectura.
- `Reporter` se ocupa únicamente de presentar los resultados.

### Bajo acoplamiento

La infraestructura queda completamente separada de la lógica de cada ejercicio.

Los paquetes `dayXX` solo utilizan las abstracciones del paquete `core`, permitiendo que cada solución sea independiente del mecanismo de entrada o de presentación de resultados.

### Reutilización

Toda la funcionalidad común se implementa una única vez y es reutilizada por los doce ejercicios, evitando duplicación de código y manteniendo una estructura homogénea durante todo el proyecto.

---

## Arquitectura

Todos los días siguen la misma estructura:

```text
InputSource
      │
      ▼
DayXXSolver
      │
      ▼
Clases de dominio / Parsers / Algoritmos
      │
      ▼
Resultado
      │
      ▼
Reporter
```

Esta organización permite mantener una clara separación entre infraestructura, lógica de negocio y presentación.

---

## Conclusiones

El paquete **core** constituye la base de la arquitectura del proyecto. Gracias al uso de abstracciones, responsabilidades bien definidas y componentes reutilizables, proporciona una infraestructura sencilla, mantenible y fácilmente extensible para todas las soluciones del Advent of Code.