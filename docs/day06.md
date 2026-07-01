# Día 6: Cephalopod Math Worksheet

## Enunciado

El sexto problema consiste en interpretar una hoja de operaciones matemáticas escrita en un formato poco habitual. Cada operación está representada mediante columnas de números y un operador (`+` o `*`) situado en la parte inferior.

- **Parte 1:** los números se leen de forma convencional, de arriba hacia abajo.
- **Parte 2:** los números deben reconstruirse leyendo las columnas de derecha a izquierda, siguiendo las reglas de la numeración cefalópoda.

Una vez reconstruidas todas las operaciones, se evalúan y se obtiene la suma de sus resultados.

---

## Algoritmos y técnicas

- **Parsing estructurado:** la hoja se divide en problemas independientes a partir de las columnas vacías.
- **Strategy Pattern:** cada parte utiliza una estrategia distinta para interpretar los números.
- **Reutilización del modelo:** ambas partes comparten las clases de dominio, cambiando únicamente el parser empleado.
- **Streams:** utilizados para procesar las operaciones y calcular la suma final.

---

## Modelado en clases

| Clase | Responsabilidad |
|--------|-----------------|
| `MathProblem` | Representa una operación matemática y conoce cómo evaluarla. |
| `Worksheet` | Agrupa todos los problemas de la hoja y calcula el resultado total. |
| `WorksheetParser` | Coordina el proceso de lectura de la hoja utilizando un parser especializado. |
| `RowProblemParser` | Reconstruye los números siguiendo la lectura de la parte 1. |
| `ColumnProblemParser` | Reconstruye los números siguiendo la lectura de la parte 2. |
| `ColumnRange` | Representa los límites de una operación dentro de la hoja. |
| `ProblemParser` | Abstracción común para las distintas estrategias de lectura. |
| `Day06Solver` | Coordina ambas partes del ejercicio. |

---

## Diseño y principios aplicados

### Single Responsibility Principle (SRP)

Cada clase desempeña una función concreta:

- `MathProblem` representa una operación.
- `Worksheet` gestiona el conjunto de problemas.
- `WorksheetParser` organiza el proceso de lectura.
- Cada implementación de `ProblemParser` interpreta un formato distinto.

### Open/Closed Principle (OCP)

El parser principal trabaja contra la abstracción `ProblemParser`.

Esto permite incorporar nuevas formas de interpretar la hoja sin modificar `WorksheetParser`, únicamente añadiendo una nueva implementación.

### Strategy Pattern

La diferencia entre ambas partes se implementa mediante dos estrategias independientes:

- `RowProblemParser`
- `ColumnProblemParser`

Ambas comparten la misma interfaz y pueden intercambiarse de forma transparente.

### Dependency Inversion Principle (DIP)

`WorksheetParser` depende de la abstracción `ProblemParser` en lugar de depender directamente de una implementación concreta.

Además, `Day06Solver` recibe el `InputSource` mediante inyección por constructor.

### DRY

Toda la lógica común de lectura de la hoja se concentra en `WorksheetParser`.

Las diferencias entre ambas partes quedan aisladas en las implementaciones de `ProblemParser`, evitando duplicación de código.

### Streams

Los Streams permiten expresar el cálculo del resultado de forma declarativa:

```java
worksheet.problems().stream()
        .mapToLong(MathProblem::solve)
        .sum();
```

---

## Resultados

| Parte | Respuesta |
|--------|-----------|
| 1 | **5316572080628** |
| 2 | **11299263623062** |