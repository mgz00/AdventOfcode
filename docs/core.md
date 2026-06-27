# Package `core`

## Objetivo

El paquete `core` agrupa los componentes comunes utilizados por todas las soluciones del proyecto. Su finalidad es proporcionar una infraestructura reutilizable e independiente de cada reto, evitando duplicación de código y favoreciendo un diseño modular.

---

## Componentes

### `Solver`

Define la interfaz común que deben implementar todos los días del proyecto.

Cada solución proporciona dos métodos:

* `solvePartOne()`
* `solvePartTwo()`

Esto permite ejecutar cualquier día de forma uniforme, independientemente de su implementación interna.

---

### `InputSource`

Abstracción responsable del acceso a los datos de entrada.

Al desacoplar la lectura del origen de datos, las soluciones no dependen de archivos concretos y pueden reutilizarse fácilmente con otras fuentes de información (por ejemplo, pruebas unitarias).

---

### `FileInputSource`

Implementación de `InputSource` encargada de leer la entrada desde un archivo del proyecto.

Centralizar esta funcionalidad evita repetir código de lectura en cada uno de los ejercicios.

---

### `Reporter`

Responsable de mostrar los resultados obtenidos por cada solución.

Su única responsabilidad es presentar la salida con un formato uniforme, manteniendo separada la lógica de presentación de la lógica de resolución.

---

## Principios de Diseño Aplicados

El paquete `core` sigue varios principios de diseño orientado a objetos:

* **Single Responsibility Principle (SRP):** cada clase tiene una única responsabilidad.
* **Dependency Inversion Principle (DIP):** los solvers dependen de la abstracción `InputSource`, no de una implementación concreta.
* **Reutilización:** los componentes comunes se comparten entre todos los días del proyecto.
* **Bajo acoplamiento:** las soluciones permanecen independientes de la infraestructura.

---

## Conclusiones

El paquete `core` constituye la base de la arquitectura del proyecto, proporcionando una infraestructura común para la lectura de datos, la ejecución de las soluciones y la presentación de resultados.

Este diseño facilita el mantenimiento, mejora la reutilización del código y permite incorporar nuevos ejercicios siguiendo siempre la misma estructura.
