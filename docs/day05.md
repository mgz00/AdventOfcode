# DÍA 05: Ingredient Inventory

## 1. Modelado del Problema

**Enfoque: Objetos de Dominio y SRP.**

La solución se divide en tres componentes principales:

* `IngredientRange`: representa un rango de IDs frescos.
* `InventoryDatabase`: interpreta el fichero de entrada y separa rangos e IDs disponibles.
* `RangeMerger`: fusiona rangos solapados o adyacentes.

Cada clase tiene una única responsabilidad, facilitando el mantenimiento y la reutilización del código.

---

## 2. Fusión de Rangos

**Enfoque: Evitar Duplicidad de Información.**

Para la segunda parte, los rangos se ordenan y se recorren una única vez, fusionando aquellos que se solapan o son consecutivos.

Esto simplifica el cálculo del número total de IDs frescos y evita contar valores repetidos.

---

## 3. Uso de Streams

**Enfoque: Procesamiento Declarativo.**

Los Streams se utilizan para:

* Contar los IDs disponibles que pertenecen a algún rango.
* Calcular la longitud total de los rangos fusionados.

Pipeline principal:

```java
database.availableIds().stream()
        .filter(this::isFresh)
        .count();
```

---

## 4. Inyección de Dependencias

**Enfoque: Dependency Inversion Principle (DIP).**

El solver recibe una implementación de `InputSource` mediante constructor.

Esto desacopla la lógica del problema del origen de los datos y facilita la realización de pruebas unitarias.

---

## 5. Conclusiones

La solución prioriza:

* Separación de responsabilidades.
* Reutilización mediante una clase específica para fusionar rangos.
* Uso de Streams.
* Bajo acoplamiento entre componentes.

El resultado es un diseño sencillo, modular y fácilmente extensible.
