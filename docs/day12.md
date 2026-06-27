# DÍA 12: Christmas Tree Farm

## 1. Modelado del Problema

**Enfoque: Separación de Responsabilidades (SRP).**

La solución se divide en varios componentes:

* `GiftShape`: representa una forma de regalo y genera todas sus rotaciones y simetrías válidas.
* `RegionRequest`: representa una región y las cantidades de cada tipo de regalo.
* `FarmParser`: interpreta el fichero de entrada y construye las formas y las regiones.
* `PackingEngine`: implementa el algoritmo de colocación mediante backtracking.
* `Day12Solver`: coordina la resolución del problema.

Cada clase tiene una única responsabilidad, facilitando el mantenimiento y la reutilización del código.

---

## 2. Algoritmo de Colocación

**Enfoque: Backtracking.**

Para cada región se genera la lista de regalos necesarios y se intenta colocarlos sobre el tablero.

El algoritmo:

* Genera todas las rotaciones y simetrías únicas de cada pieza.
* Coloca recursivamente cada regalo.
* Si una colocación impide completar la solución, realiza **backtracking** y prueba otra alternativa.

Además, antes de comenzar se verifica que el área total de las piezas no supere el área disponible de la región.

---

## 3. Uso de Streams

**Enfoque: Procesamiento Declarativo.**

Los Streams se utilizan para:

* Leer y parsear las figuras.
* Expandir las cantidades de regalos requeridos.
* Generar las variantes de cada pieza.
* Contar cuántas regiones admiten todas las piezas.

Pipeline principal:

```java
regions.stream()
        .filter(this::canFitRegion)
        .count();
```

---

## 4. Inyección de Dependencias

**Enfoque: Dependency Inversion Principle (DIP).**

El solver recibe una implementación de `InputSource` mediante constructor.

La lectura de la entrada queda desacoplada del algoritmo de empaquetado, facilitando las pruebas unitarias y la reutilización del motor de búsqueda.

---

## 5. Conclusiones

La solución prioriza:

* Separación de responsabilidades.
* Uso de backtracking para explorar las posibles colocaciones.
* Uso de Streams.
* Bajo acoplamiento entre componentes.

El resultado es un diseño modular, reutilizable y fácilmente ampliable para otros problemas de búsqueda y empaquetado.
