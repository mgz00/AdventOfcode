# Día 2: Invalid Product IDs

## Enunciado

El segundo problema trabaja con un catálogo de rangos de IDs de producto. La entrada contiene intervalos cerrados separados por comas, como `100-200,500-600`.

Cada rango se expande conceptualmente en todos sus IDs y se comprueba si cada número cumple un patrón de repetición en sus dígitos.

- **Parte 1:** un ID es inválido si tiene longitud par y está formado por dos mitades idénticas, por ejemplo `1212` o `6464`.
- **Parte 2:** un ID es inválido si está formado por la repetición de cualquier subpatrón, por ejemplo `1111`, `123123` o `121212`.

El resultado de cada parte es la suma de todos los IDs inválidos encontrados.

---

## Algoritmos y técnicas

- **Expansión de rangos:** cada `ProductIdRange` genera sus valores mediante `LongStream.rangeClosed`.
- **Detección de patrones repetidos:** se comprueba si una cadena puede dividirse en fragmentos iguales.
- **Reutilización de lógica:** la parte 1 es un caso concreto de la lógica de patrones de la parte 2.
- **Higher-order programming:** el método común `sumMatching(...)` recibe un `Predicate<ProductId>` para reutilizar el flujo de cálculo.

---

## Modelado en clases

| Clase | Responsabilidad |
|--------|-----------------|
| `ProductId` | Representa un ID de producto y contiene la lógica para detectar patrones inválidos. |
| `ProductIdRange` | Representa un rango cerrado de IDs y permite expandirlo a un `LongStream`. |
| `Day02Solver` | Lee los rangos, coordina ambas partes y suma los IDs que cumplen cada condición. |

---

## Diseño y principios aplicados

### Single Responsibility Principle (SRP)

Cada clase tiene una única responsabilidad:

- `ProductId` valida el patrón del ID.
- `ProductIdRange` modela y expande rangos.
- `Day02Solver` coordina la resolución.

### DRY

La lógica común de suma se centraliza en `sumMatching(...)`, evitando duplicar el recorrido de los rangos en ambas partes.

```java
private long sumMatching(Predicate<ProductId> validator) {
    return ranges.stream()
            .flatMapToLong(ProductIdRange::values)
            .mapToObj(ProductId::new)
            .filter(validator)
            .mapToLong(ProductId::value)
            .sum();
}
```

### Dependency Inversion Principle (DIP)

El solver recibe un `InputSource` por constructor, por lo que no depende directamente de archivos ni de una implementación concreta de entrada.

### Inmutabilidad

`ProductId` y `ProductIdRange` se implementan como `record`, representando datos de dominio inmutables.

### Streams

Los Streams se utilizan para procesar la entrada, expandir rangos, filtrar IDs inválidos y calcular la suma final de forma declarativa.

---

## Resultados

| Parte | Respuesta |
|--------|-----------|
| 1 | **19219508902** |
| 2 | **27180728081** |