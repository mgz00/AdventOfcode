# Día 4: Paper Rolls

## Enunciado

El cuarto problema trabaja con una cuadrícula que representa rollos de papel. Cada posición puede estar vacía (`.`) o contener un rollo (`@`).

Un rollo puede ser retirado por una carretilla si tiene menos de cuatro rollos en sus ocho posiciones adyacentes.

- **Parte 1:** contar cuántos rollos son accesibles inicialmente.
- **Parte 2:** retirar por rondas todos los rollos accesibles. Tras cada retirada pueden aparecer nuevos rollos accesibles. El objetivo es contar cuántos rollos se pueden retirar en total.

---

## Algoritmos y técnicas

- **Recorrido de cuadrícula:** se generan todas las posiciones posibles del tablero.
- **Conteo de vecinos:** para cada rollo se revisan sus ocho posiciones adyacentes.
- **Simulación iterativa:** en la segunda parte se repite el proceso de búsqueda y eliminación hasta que no quedan candidatos.
- **Eliminación por rondas:** los rollos accesibles se detectan primero y se eliminan después, evitando alterar el estado durante la misma ronda.

---

## Modelado en clases

| Clase | Responsabilidad |
|--------|-----------------|
| `Position` | Representa una coordenada de la cuadrícula. |
| `Grid` | Encapsula el tablero, el acceso a sus posiciones, el conteo de vecinos y la eliminación de rollos. |
| `Day04Solver` | Lee la entrada, crea el grid y coordina la resolución de ambas partes. |

---

## Diseño y principios aplicados

### Single Responsibility Principle (SRP)

Cada clase tiene una responsabilidad concreta:

- `Position` representa una coordenada.
- `Grid` gestiona el estado y las operaciones sobre la cuadrícula.
- `Day04Solver` coordina el flujo de resolución.

### Encapsulación

El acceso al array interno queda oculto dentro de `Grid`.

El solver no manipula directamente la matriz, sino que utiliza métodos del dominio como:

```java
grid.hasPaperRollAt(position)
grid.countAdjacentPaperRolls(position)
grid.removePaperRollAt(position)
```

### Dependency Inversion Principle (DIP)

El solver recibe un `InputSource` por constructor, por lo que no depende de archivos concretos.

### Streams

`Grid` expone sus posiciones mediante un stream, lo que permite expresar la búsqueda de rollos accesibles de forma declarativa:

```java
grid.positions()
        .filter(grid::hasPaperRollAt)
        .filter(position -> grid.countAdjacentPaperRolls(position) <= 3)
        .toList();
```

### Mutabilidad controlada

A diferencia de otros días, `Grid` necesita mantener estado mutable para la simulación de la segunda parte.

La mutabilidad queda encapsulada dentro de la propia clase y solo se modifica mediante `removePaperRollAt`.

---

## Resultados

| Parte | Respuesta |
|--------|-----------|
| 1 | **1349** |
| 2 | **8277** |