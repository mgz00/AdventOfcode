# DÍA 11: Reactor Network

## 1. Modelado del Problema

**Enfoque: Separación de Responsabilidades (SRP).**

La solución se divide en dos componentes principales:

* `Device`: representa un dispositivo y sus conexiones de salida.
* `ReactorNetwork`: almacena el grafo de dispositivos e implementa los algoritmos de búsqueda de caminos.

El solver únicamente se encarga de leer la entrada y coordinar la resolución.

---

## 2. Búsqueda de Caminos

**Enfoque: DFS con Memoización.**

La red de dispositivos se modela como un **grafo dirigido acíclico (DAG)**.

Para contar los caminos entre dos nodos se utiliza una búsqueda en profundidad (**Depth-First Search**) junto con **memoización**, evitando recalcular el número de caminos desde un mismo dispositivo.

En la segunda parte, el número de caminos que visitan ambos dispositivos obligatorios se obtiene componiendo los distintos tramos posibles del recorrido.

---

## 3. Uso de Streams

**Enfoque: Procesamiento Declarativo.**

Los Streams se utilizan para:

* Leer y parsear los dispositivos.
* Construir el mapa del grafo.
* Sumar recursivamente los caminos de los nodos sucesores.

Pipeline principal:

```java
device.outputs().stream()
        .mapToLong(next -> countPathsFrom(next, end))
        .sum();
```

---

## 4. Inyección de Dependencias

**Enfoque: Dependency Inversion Principle (DIP).**

El solver recibe una implementación de `InputSource` mediante constructor.

La lógica de búsqueda queda completamente desacoplada del origen de los datos, facilitando las pruebas unitarias y la reutilización del algoritmo.

---

## 5. Conclusiones

La solución prioriza:

* Separación de responsabilidades.
* Uso de DFS con memoización para evitar cálculos repetidos.
* Uso de Streams.
* Bajo acoplamiento entre componentes.

El resultado es un diseño modular, eficiente y fácilmente ampliable para otros problemas sobre grafos dirigidos.
