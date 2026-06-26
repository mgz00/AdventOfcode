# DÍA 06: Math Worksheet

## 1. Modelado del Problema

**Enfoque: Separación de Responsabilidades (SRP).**

La solución se divide en varios componentes:

* `MathProblem`: representa una operación matemática y calcula su resultado.
* `Worksheet`: agrupa todos los problemas de la hoja y calcula el total.
* `WorksheetParser`: identifica los bloques de la hoja de cálculo.
* `RowProblemParser` y `ColumnProblemParser`: implementan distintas estrategias de lectura.

Cada clase tiene una única responsabilidad, facilitando el mantenimiento y la reutilización del código.

---

## 2. Estrategias de Lectura

**Enfoque: Open/Closed Principle (OCP).**

Las dos partes del ejercicio únicamente cambian la forma de interpretar cada bloque.

Para desacoplar ambas soluciones se utiliza la interfaz `ProblemParser`, con dos implementaciones:

* `RowProblemParser` → lectura por filas (Parte 1).
* `ColumnProblemParser` → lectura por columnas (Parte 2).

De esta forma el parser principal permanece inalterado.

---

## 3. Uso de Streams

**Enfoque: Procesamiento Declarativo.**

Los Streams se utilizan para:

* Detectar columnas vacías.
* Calcular el resultado de cada problema.
* Obtener el total de la hoja.

Pipeline principal:

```java
worksheet.problems().stream()
        .mapToLong(MathProblem::compute)
        .sum();
```

---

## 4. Inyección de Dependencias

**Enfoque: Dependency Inversion Principle (DIP).**

El solver recibe una implementación de `InputSource` mediante constructor.

Además, `WorksheetParser` depende de la abstracción `ProblemParser`, permitiendo cambiar la estrategia de lectura sin modificar su funcionamiento.

---

## 5. Conclusiones

La solución prioriza:

* Separación de responsabilidades.
* Uso del patrón Strategy para soportar distintos modos de lectura.
* Uso de Streams.
* Bajo acoplamiento entre componentes.

El resultado es un diseño modular y fácilmente ampliable para nuevas formas de interpretar la hoja de cálculo.
