# DÍA 09: Theater Floor

## 1. Modelado del Problema

**Enfoque: Objetos de Dominio y SRP.**

La solución se divide en varios componentes:

* `Tile`: representa una baldosa roja y calcula el área de un rectángulo con otra baldosa.
* `Edge`: representa un lado del contorno formado por las baldosas.
* `TilePair`: representa un posible par de esquinas del rectángulo.
* `TheaterFloor`: implementa toda la lógica geométrica.

Cada clase mantiene una única responsabilidad, facilitando el mantenimiento y la reutilización del código.

---

## 2. Validación Geométrica

**Enfoque: Reutilización de Lógica.**

La primera parte busca simplemente el rectángulo de mayor área.

En la segunda parte, además de calcular el área, se comprueba que:

* Las cuatro esquinas pertenezcan al interior o al borde del polígono.
* Ninguna arista del contorno atraviese el interior del rectángulo.

Así, la lógica de generación de rectángulos se reutiliza y solo cambia el criterio de validación.

---

## 3. Uso de Streams

**Enfoque: Procesamiento Declarativo.**

Los Streams se utilizan para:

* Generar todas las parejas posibles de baldosas.
* Recorrer las aristas del polígono.
* Buscar el rectángulo de mayor área.
* Validar las condiciones geométricas.

Pipeline principal:

```java
tilePairs()
        .filter(this::isValidRectangle)
        .mapToLong(TilePair::area)
        .max();
```

---

## 4. Inyección de Dependencias

**Enfoque: Dependency Inversion Principle (DIP).**

El solver recibe una implementación de `InputSource` mediante constructor.

La lógica geométrica queda completamente desacoplada del origen de los datos, facilitando las pruebas unitarias.

---

## 5. Conclusiones

La solución prioriza:

* Separación de responsabilidades.
* Reutilización de la lógica entre ambas partes.
* Uso de Streams.
* Bajo acoplamiento entre componentes.

El resultado es un diseño modular y fácilmente ampliable para futuros problemas geométricos.
