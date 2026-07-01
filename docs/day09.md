# Día 9: Theater Floor

## Enunciado

El noveno problema trabaja con una lista de baldosas rojas colocadas sobre una cuadrícula. Cada baldosa se representa mediante sus coordenadas `x,y`.

El objetivo es formar rectángulos usando dos baldosas rojas como esquinas opuestas.

- **Parte 1:** encontrar el rectángulo de mayor área posible usando cualquier par de baldosas rojas.
- **Parte 2:** el rectángulo debe estar formado únicamente por baldosas rojas o verdes. Las verdes son las que pertenecen al contorno formado por las baldosas rojas o al interior de dicho contorno.

---

## Algoritmos y técnicas

- **Generación de pares:** se prueban todas las parejas posibles de baldosas rojas.
- **Cálculo de área:** el área se obtiene a partir de la anchura y altura del rectángulo definido por dos esquinas.
- **Geometría computacional:** en la segunda parte se valida que el rectángulo esté dentro del polígono formado por las baldosas.
- **Ray Casting:** se aplica la regla par-impar para determinar si un punto está dentro del polígono.
- **Detección de intersecciones:** se comprueba que ninguna arista del contorno atraviese el interior del rectángulo.

---

## Modelado en clases

| Clase | Responsabilidad |
|--------|-----------------|
| `Tile` | Representa una baldosa roja y calcula el área del rectángulo con otra baldosa. |
| `TilePair` | Representa una pareja de baldosas candidatas como esquinas opuestas. |
| `Edge` | Representa una arista del contorno del polígono. |
| `TheaterFloor` | Genera rectángulos candidatos y contiene la lógica geométrica de validación. |
| `Day09Solver` | Lee la entrada y coordina la resolución de ambas partes. |

---

## Diseño y principios aplicados

### Single Responsibility Principle (SRP)

Cada clase tiene una función concreta dentro del modelo geométrico:

- `Tile` representa puntos de la cuadrícula.
- `Edge` encapsula operaciones sobre segmentos.
- `TilePair` modela una pareja candidata.
- `TheaterFloor` coordina la búsqueda geométrica.

### Encapsulación

La lógica geométrica queda centralizada en las clases del dominio.

El solver no calcula áreas, intersecciones ni pertenencia al polígono; únicamente delega en `TheaterFloor`.

### Tell, Don't Ask

Las operaciones se delegan a los objetos que poseen la información:

```java
tile.rectangleAreaWith(other)
edge.contains(tile)
```

en lugar de extraer coordenadas y repetir cálculos en el solver.

### Dependency Inversion Principle (DIP)

El solver recibe un `InputSource` mediante constructor, desacoplando la lógica del origen de datos.

### Streams

Los Streams se utilizan para generar parejas de baldosas, recorrer aristas y calcular el máximo de forma declarativa:

```java
tilePairs()
        .filter(this::isValidRectangle)
        .mapToLong(TilePair::area)
        .max();
```

---

## Resultados

| Parte | Respuesta |
|--------|-----------|
| 1 | **4754955192** |
| 2 | **1568849600** |