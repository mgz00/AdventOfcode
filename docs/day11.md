# Día 11: Reactor Network

## Enunciado

El undécimo problema trabaja con una red de dispositivos conectados entre sí. Cada línea de entrada indica un dispositivo y la lista de dispositivos a los que puede enviar su salida.

El flujo de datos siempre avanza en la dirección de las conexiones, por lo que la red puede modelarse como un grafo dirigido.

- **Parte 1:** contar todos los caminos posibles desde `you` hasta `out`.
- **Parte 2:** contar los caminos desde `svr` hasta `out` que pasan obligatoriamente por `dac` y `fft`, en cualquier orden.

---

## Algoritmos y técnicas

- **Grafo dirigido:** cada dispositivo es un nodo y cada salida es una arista.
- **DFS:** se utiliza una búsqueda en profundidad para contar caminos.
- **Memoización:** se almacena el número de caminos desde cada nodo para evitar recalcular subproblemas.
- **Composición de caminos:** en la segunda parte se multiplican los caminos de los tramos obligatorios y se consideran los dos órdenes posibles (`dac → fft` y `fft → dac`).

---

## Modelado en clases

| Clase | Responsabilidad |
|--------|-----------------|
| `Device` | Representa un dispositivo y sus conexiones de salida. |
| `ReactorNetwork` | Modela el grafo y contiene la lógica de conteo de caminos. |
| `Day11Solver` | Lee la entrada, construye la red y coordina ambas partes. |

---

## Diseño y principios aplicados

### Single Responsibility Principle (SRP)

Cada clase tiene una función concreta:

- `Device` representa un nodo del grafo.
- `ReactorNetwork` implementa la lógica sobre el grafo.
- `Day11Solver` coordina la lectura y la ejecución.

### Encapsulación

La estructura interna del grafo queda oculta dentro de `ReactorNetwork`.

El solver no recorre manualmente las conexiones, sino que delega en métodos de dominio como:

```java
network.countPaths("you", "out")
network.countPathsVisitingBoth("svr", "out", "dac", "fft")
```

### DRY

La función general de conteo de caminos se reutiliza en ambas partes.

La parte 2 no implementa un nuevo DFS, sino que reutiliza `countPaths(...)` para componer los tramos necesarios.

### Dependency Inversion Principle (DIP)

`Day11Solver` recibe un `InputSource` mediante constructor, quedando desacoplado del origen concreto de los datos.

### Inmutabilidad

`Device` se modela como `record`, y sus salidas se protegen mediante `List.copyOf`, evitando modificaciones externas.

### Streams

Los Streams se utilizan para construir el grafo y sumar los caminos de los dispositivos sucesores:

```java
device.outputs().stream()
        .mapToLong(next -> countPathsFrom(next, end))
        .sum();
```

---

## Resultados

| Parte | Respuesta |
|--------|-----------|
| 1 | **613** |
| 2 | **372918445876116** |