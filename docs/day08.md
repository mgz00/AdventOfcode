# DÍA 08: Junction Box Network

## 1. Modelado del Problema

**Enfoque: Objetos de Dominio y SRP.**

La solución se divide en cuatro componentes principales:

* `JunctionBox`: representa una caja de conexiones y calcula la distancia a otra.
* `Connection`: representa una conexión entre dos cajas.
* `DisjointSet`: gestiona los circuitos mediante la estructura Union-Find.
* `CircuitNetwork`: genera las conexiones y ejecuta el algoritmo de unión.

Cada clase tiene una única responsabilidad, facilitando el mantenimiento y la reutilización del código.

---

## 2. Algoritmo Union-Find

**Enfoque: Gestión eficiente de componentes conexas.**

Para conocer qué cajas pertenecen al mismo circuito se utiliza la estructura **Disjoint Set Union (Union-Find)**.

Las uniones se realizan mediante:

* **Path Compression** para acelerar las búsquedas.
* **Union by Size** para mantener árboles equilibrados.

Esto permite procesar miles de conexiones de forma eficiente.

---

## 3. Uso de Streams

**Enfoque: Procesamiento Declarativo.**

Los Streams se utilizan para:

* Leer las cajas de conexiones.
* Generar todas las conexiones posibles.
* Ordenarlas por distancia.
* Calcular el producto de los circuitos más grandes.

Pipeline principal:

```java
connections.stream()
        .limit(connectionLimit)
        .forEach(connection ->
                disjointSet.union(
                        connection.firstIndex(),
                        connection.secondIndex()
                )
        );
```

---

## 4. Inyección de Dependencias

**Enfoque: Dependency Inversion Principle (DIP).**

El solver recibe una implementación de `InputSource` mediante constructor.

La lógica del algoritmo queda desacoplada del origen de los datos, facilitando las pruebas unitarias.

---

## 5. Conclusiones

La solución prioriza:

* Separación de responsabilidades.
* Uso de la estructura Union-Find para gestionar circuitos.
* Uso de Streams.
* Bajo acoplamiento entre componentes.

El resultado es un diseño modular, eficiente y fácilmente ampliable.
