# Advent of Code 2025 – Ingeniería del Software II

Este repositorio contiene una propuesta de resolución para los problemas del **Advent of Code 2025**, desarrollada como práctica de la asignatura **Ingeniería del Software II**.

El objetivo del proyecto no es únicamente resolver los retos, sino aplicar principios de diseño orientado a objetos, buenas prácticas de programación y una arquitectura modular basada en los contenidos vistos durante el curso.

---

# Documentación por día

Cada día incluye un documento explicativo donde se describe el problema, el diseño adoptado, los algoritmos utilizados y los principios de Ingeniería del Software aplicados.

| Día | Problema | Técnica principal |
|------|----------|-------------------|
| 1 | Dial circular | Aritmética modular |
| 2 | Validación de IDs | Streams + Predicates |
| 3 | Máxima Joltage | Greedy |
| 4 | Acceso a rollos de papel | Simulación iterativa |
| 5 | Base de datos de ingredientes | Fusión de rangos |
| 6 | Hoja de operaciones matemáticas | Parsing + Strategy |
| 7 | Haz tachiónico | BFS |
| 8 | Circuitos eléctricos | Union-Find |
| 9 | Geometría de rectángulos | Ray Casting |
| 10 | Configuración de máquinas | Fuerza bruta + Divide y vencerás |
| 11 | Reactor | DFS con memoización |
| 12 | Empaquetado de regalos | Backtracking |

---

# Arquitectura del proyecto

Todas las soluciones siguen una estructura común basada en la separación de responsabilidades.

```text
core
 ├── Solver
 ├── InputSource
 ├── FileInputSource
 └── Reporter

dayXX
 ├── Clases de dominio
 ├── Parser
 ├── Algoritmos
 └── DayXXSolver
```

El paquete **core** contiene la infraestructura común del proyecto, mientras que cada paquete `dayXX` encapsula la lógica específica de cada problema.

---

# Principios de Ingeniería del Software aplicados

Durante el desarrollo del proyecto se han aplicado de forma consistente los siguientes principios:

- **Single Responsibility Principle (SRP):** cada clase tiene una única responsabilidad.
- **Open/Closed Principle (OCP):** el comportamiento se amplía mediante nuevas implementaciones sin modificar la lógica existente.
- **Dependency Inversion Principle (DIP):** los solvers dependen de la abstracción `InputSource`, facilitando la reutilización y las pruebas.
- **DRY (Don't Repeat Yourself):** eliminación de código duplicado mediante refactorización y reutilización de componentes.
- **Inmutabilidad:** uso de `record` y colecciones inmutables (`List.copyOf`) para representar los objetos de dominio siempre que es posible.
- **Bajo acoplamiento y alta cohesión:** separación entre modelos, parsers y algoritmos para facilitar el mantenimiento.

---

# Características del proyecto

- Arquitectura modular.
- Uso de Streams para procesamiento declarativo.
- Inyección de dependencias mediante constructor.
- Clases de dominio independientes de la lógica de negocio.
- Parsers desacoplados de los algoritmos.
- Algoritmos reutilizables y fácilmente testeables.
- Tests unitarios para todos los ejercicios.

---

# Resultados

| Día | Parte 1 | Parte 2 |
|------|---------|---------|
| 1 | 992 | 6133 |
| 2 | 19219508902 | 27180728081 |
| 3 | 17034 | 168798209663590 |
| 4 | 1349 | 8277 |
| 5 | 643 | 342018167474526 |
| 6 | 5316572080628 | 11299263623062 |
| 7 | 1649 | 16937871060075 |
| 8 | 50568 | 36045012 |
| 9 | 4754955192 | 1568849600 |
| 10 | 545 | 22430 |
| 11 | 613 | 372918445876116 |
| 12 | 454 | — |

---

# Tecnologías utilizadas

- Java 25
- Maven
- JUnit 5
- IntelliJ IDEA

---

