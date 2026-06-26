# DÍA 07: Tachyon Manifold

## 1. Modelado del Problema

**Enfoque: Separación de Responsabilidades (SRP).**

La solución se divide en dos componentes principales:

* `TachyonManifold`: representa el mapa del problema y encapsula el acceso a la cuadrícula.
* `BeamSimulation`: implementa la lógica de propagación de los haces.

De esta forma el solver únicamente coordina la ejecución.

---

## 2. Simulación de los Haces

**Enfoque: Reutilización de Lógica.**

La simulación avanza fila a fila manteniendo el estado actual de los haces.

* **Parte 1:** se almacena el conjunto de columnas activas (`Set<Integer>`), ya que solo interesa saber si existe un haz en una posición.
* **Parte 2:** se utiliza un `Map<Integer, Long>` para contabilizar cuántas líneas temporales llegan a cada columna.

Ambas partes reutilizan la misma lógica de propagación.

---

## 3. Uso de Streams

**Enfoque: Procesamiento Declarativo.**

Los Streams se emplean para:

* Localizar el punto de inicio.
* Contar divisiones de los haces.
* Generar las nuevas posiciones activas.
* Calcular el número total de líneas temporales.

Pipeline principal:

```java
activeColumns.stream()
        .flatMap(column -> nextColumns(column, row).stream())
        .filter(manifold::isInsideColumn)
        .collect(Collectors.toSet());
```

---

## 4. Inyección de Dependencias

**Enfoque: Dependency Inversion Principle (DIP).**

El solver recibe una implementación de `InputSource` mediante constructor.

La simulación recibe un `TachyonManifold`, desacoplando completamente la lógica de propagación del origen de los datos.

---

## 5. Conclusiones

La solución prioriza:

* Separación de responsabilidades.
* Reutilización de la lógica entre ambas partes.
* Uso de Streams.
* Bajo acoplamiento entre componentes.

El resultado es un diseño modular y fácilmente ampliable para futuras variantes de la simulación.
