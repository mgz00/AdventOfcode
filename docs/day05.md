# Día 5: Ingredient Inventory

## Enunciado

El quinto problema trabaja con una base de datos de ingredientes. La entrada contiene dos secciones:

1. Una lista de rangos de IDs que representan ingredientes frescos.
2. Una lista de IDs disponibles que deben comprobarse.

Un ingrediente se considera fresco si su ID pertenece al menos a uno de los rangos indicados.

- **Parte 1:** contar cuántos de los IDs disponibles son frescos.
- **Parte 2:** calcular cuántos IDs frescos existen en total teniendo en cuenta todos los rangos, evitando contar dos veces las zonas solapadas.

---

## Algoritmos y técnicas

- **Comprobación de pertenencia a rangos:** cada ID disponible se compara contra los rangos frescos.
- **Fusión de rangos:** los rangos solapados o adyacentes se combinan para evitar duplicados.
- **Ordenación + barrido lineal:** la parte 2 ordena los rangos y los recorre una sola vez para fusionarlos.
- **Streams:** utilizados para contar IDs frescos y sumar la longitud de los rangos fusionados.

---

## Modelado en clases

| Clase | Responsabilidad |
|--------|-----------------|
| `IngredientRange` | Representa un rango cerrado de IDs frescos, permite comprobar pertenencia y calcular su longitud. |
| `InventoryDatabase` | Interpreta la entrada y separa los rangos frescos de los IDs disponibles. |
| `RangeMerger` | Fusiona rangos solapados o adyacentes. |
| `Day05Solver` | Coordina la resolución de ambas partes. |

---

## Diseño y principios aplicados

### Single Responsibility Principle (SRP)

Cada clase tiene una única razón para cambiar:

- `IngredientRange` cambia si cambia la representación de un rango.
- `InventoryDatabase` cambia si cambia el formato de entrada.
- `RangeMerger` cambia si cambia la lógica de fusión.
- `Day05Solver` solo coordina el flujo de resolución.

### DRY

La lógica de fusión de rangos se extrae a `RangeMerger`, evitando mezclarla con el solver y permitiendo reutilizarla de forma independiente.

### Tell, Don't Ask

El solver no extrae manualmente los límites de un rango para decidir si un ID pertenece a él. En su lugar delega en el propio objeto:

```java
range.contains(ingredientId)
```

### Dependency Inversion Principle (DIP)

El solver recibe un `InputSource` por constructor, por lo que no depende directamente de archivos.

### Inmutabilidad

`IngredientRange` se modela como `record`, y `InventoryDatabase` devuelve copias inmutables mediante `List.copyOf`, protegiendo su estado interno.

### Streams

La parte 1 utiliza Streams para contar IDs frescos:

```java
database.availableIds().stream()
        .filter(this::isFresh)
        .count();
```

La parte 2 utiliza Streams para sumar la longitud de los rangos fusionados.

---

## Resultados

| Parte | Respuesta |
|--------|-----------|
| 1 | **643** |
| 2 | **342018167474526** |