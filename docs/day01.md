# Día 1: Dial Circular

## Enunciado

El primer problema consiste en simular el movimiento de un dial circular formado por 100 posiciones (0–99), que inicialmente se encuentra en la posición 50.

La entrada está formada por una secuencia de rotaciones, indicando el sentido (`L` o `R`) y el número de posiciones que debe girar el dial.

- **Parte 1:** calcular la posición final tras aplicar todas las rotaciones.
- **Parte 2:** contar cuántas veces el dial pasa por la posición 0 durante todo el recorrido.

---

## Algoritmos y técnicas

- **Aritmética modular:** permite simular un dial circular sin necesidad de recorrer cada posición individualmente.
- **Cálculo matemático de cruces:** en la segunda parte se calcula directamente cuántas veces una rotación atraviesa la posición 0, evitando simular paso a paso el movimiento.
- **Streams:** utilizados para leer y transformar la entrada en una colección de rotaciones.

---

## Modelado en clases

| Clase | Responsabilidad |
|--------|-----------------|
| `Rotation` | Representa una rotación (dirección y distancia). |
| `Dial` | Modela el estado del dial y encapsula toda la lógica del movimiento y del conteo de pasos por la posición 0. |
| `Day01Solver` | Lee la entrada, construye las rotaciones y coordina la resolución de ambas partes. |

---

## Diseño y principios aplicados

### Single Responsibility Principle (SRP)

Cada clase tiene una responsabilidad claramente definida:

- `Rotation` representa un movimiento.
- `Dial` implementa toda la lógica del dominio.
- `Day01Solver` únicamente coordina la ejecución.

### Dependency Inversion Principle (DIP)

El solver recibe una implementación de `InputSource` mediante el constructor, desacoplando completamente la lógica del origen de los datos.

### Inmutabilidad

`Rotation` se implementa como un `record`, proporcionando un objeto de dominio inmutable y seguro.

### Encapsulación

Toda la lógica relacionada con el movimiento del dial permanece dentro de `Dial`. El solver nunca manipula directamente la posición interna del objeto.

### Streams

Los Streams permiten construir la lista de rotaciones de forma declarativa:

```java
inputSource.readAsStream()
        .map(Rotation::from)
        .toList();
```

---

## Resultados

| Parte | Respuesta |
|--------|-----------|
| 1 | **992** |
| 2 | **6133** |