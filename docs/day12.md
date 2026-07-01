# Día 12: Christmas Tree Farm

## Enunciado

El duodécimo problema trabaja con formas de regalos y regiones rectangulares bajo los árboles de Navidad.

La entrada contiene dos partes:

1. Un catálogo de formas de regalos, representadas con `#` y `.`.
2. Una lista de regiones, indicando sus dimensiones y cuántos regalos de cada tipo deben colocarse.

Los regalos pueden rotarse y reflejarse, pero deben colocarse sobre una cuadrícula sin solaparse.

- **Parte 1:** contar cuántas regiones pueden contener todos los regalos indicados.
- **Parte 2:** este día no incluye segunda parte en el proyecto.

---

## Algoritmos y técnicas

- **Backtracking:** se prueban distintas posiciones y orientaciones para cada regalo.
- **Rotaciones y simetrías:** cada forma genera sus variantes únicas para considerar todas las colocaciones válidas.
- **Poda por área:** antes de iniciar la búsqueda se descartan regiones cuya superficie no puede contener todas las piezas.
- **Ordenación por tamaño:** las piezas se intentan colocar de mayor a menor área para reducir el espacio de búsqueda.
- **Streams:** utilizados para expandir cantidades, calcular áreas y contar regiones válidas.

---

## Modelado en clases

| Clase | Responsabilidad |
|--------|-----------------|
| `GiftShape` | Representa una forma de regalo, calcula su área y genera sus variantes por rotación o simetría. |
| `RegionRequest` | Representa una región y las cantidades requeridas de cada tipo de regalo. |
| `FarmParser` | Interpreta la entrada, separando las formas de regalo y las regiones. |
| `PackingEngine` | Implementa el algoritmo de colocación mediante backtracking. |
| `Day12Solver` | Expande los regalos requeridos y coordina la resolución del día. |

---

## Diseño y principios aplicados

### Single Responsibility Principle (SRP)

Cada clase mantiene una responsabilidad clara:

- `GiftShape` gestiona la geometría de una pieza.
- `RegionRequest` modela la petición de una región.
- `FarmParser` se encarga exclusivamente del parseo.
- `PackingEngine` encapsula el algoritmo de búsqueda.
- `Day12Solver` coordina el proceso.

### Encapsulación

La lógica de colocación queda oculta dentro de `PackingEngine`.

El solver no manipula directamente el tablero, sino que delega en:

```java
engine.canFit(requiredPieces)
```

### DRY

La generación de variantes de una forma se concentra en `GiftShape`, y el motor de colocación se reutiliza para todas las regiones.

### Dependency Inversion Principle (DIP)

`Day12Solver` recibe un `InputSource` mediante constructor, manteniendo la lógica del problema desacoplada del origen de los datos.

### Inmutabilidad

`RegionRequest` se implementa como `record`, y protege la lista de cantidades mediante `List.copyOf`.

`GiftShape` realiza copia defensiva del array de celdas para evitar modificaciones externas.

### Streams

Los Streams se utilizan para calcular áreas, generar variantes, expandir regalos y contar las regiones que pueden resolverse.

---

## Resultados

| Parte | Respuesta |
|--------|-----------|
| 1 | **454** |
| 2 | **—** |