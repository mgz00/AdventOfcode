# DÍA 04: Paper Rolls

## 1. Modelado del Problema

**Enfoque: Objetos de Dominio y SRP.**

La solución se divide en dos conceptos principales:

* `Position`: representa una coordenada dentro de la cuadrícula.
* `Grid`: encapsula el estado de la matriz y las operaciones sobre ella.

De esta forma se evita trabajar directamente con arrays bidimensionales desde el solver.

---

## 2. Encapsulación de la Cuadrícula

**Enfoque: Responsabilidad Única.**

La clase `Grid` es responsable de:

* Comprobar si existe un rollo de papel en una posición.
* Contar los vecinos adyacentes.
* Eliminar rollos de papel.
* Gestionar los límites de la cuadrícula.

Esto evita duplicar comprobaciones de índices en el resto de la aplicación.

---

## 3. Uso de Streams

**Enfoque: Procesamiento Declarativo.**

La cuadrícula expone todas sus posiciones mediante un Stream.

Pipeline principal:

```java
grid.positions()
    .filter(grid::hasPaperRollAt)
    .filter(...)
    .toList();
```

Esto permite localizar los rollos accesibles de forma clara y reutilizable.

---

## 4. Simulación Iterativa

**Parte 1**

Se cuentan los rollos de papel que tienen menos de cuatro vecinos adyacentes.

**Parte 2**

Se realiza una simulación por rondas:

1. Identificar todos los rollos accesibles.
2. Eliminarlos simultáneamente.
3. Repetir hasta que no existan más candidatos.

La lógica de búsqueda se reutiliza en ambas partes mediante un método común.

---

## 5. Inyección de Dependencias

**Enfoque: Dependency Inversion Principle (DIP).**

El solver recibe una implementación de `InputSource` mediante constructor.

Esto desacopla la resolución del problema del origen concreto de los datos y facilita las pruebas unitarias.

---

## 6. Conclusiones

La solución prioriza:

* Encapsulación de la matriz.
* Separación de responsabilidades.
* Uso de Streams.
* Reutilización de lógica entre ambas partes.

El resultado es un diseño sencillo, mantenible y fácil de extender.
