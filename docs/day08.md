# Día 8: Junction Box Network

## Enunciado

El octavo problema trabaja con una lista de cajas de conexión situadas en un espacio tridimensional. Cada caja tiene coordenadas `x,y,z`.

Los Elfos quieren conectar las cajas que están más cerca entre sí para formar circuitos eléctricos.

- **Parte 1:** conectar las 1000 parejas de cajas más cercanas y calcular el producto de los tamaños de los tres circuitos más grandes.
- **Parte 2:** seguir conectando parejas por orden de distancia hasta que todas las cajas formen un único circuito. El resultado es el producto de las coordenadas `x` de las dos cajas de la última conexión necesaria.

---

## Algoritmos y técnicas

- **Generación de pares:** se generan todas las conexiones posibles entre cajas.
- **Distancia euclídea al cuadrado:** se usa la distancia al cuadrado para comparar cercanía sin calcular raíces cuadradas.
- **Ordenación por distancia:** las conexiones se procesan de menor a mayor distancia.
- **Union-Find:** se utiliza una estructura de conjuntos disjuntos para mantener los circuitos conectados de forma eficiente.
- **Path Compression y Union by Size:** optimizaciones aplicadas dentro de `DisjointSet`.

---

## Modelado en clases

| Clase | Responsabilidad |
|--------|-----------------|
| `JunctionBox` | Representa una caja de conexión y calcula la distancia a otra caja. |
| `Connection` | Representa una posible conexión entre dos cajas y su distancia. |
| `DisjointSet` | Gestiona los componentes conexos mediante Union-Find. |
| `CircuitNetwork` | Genera conexiones, las ordena y aplica las uniones necesarias. |
| `Day08Solver` | Lee la entrada y coordina la resolución de ambas partes. |

---

## Diseño y principios aplicados

### Single Responsibility Principle (SRP)

Cada clase encapsula una parte concreta del problema:

- `JunctionBox` modela el punto 3D.
- `Connection` modela una arista potencial.
- `DisjointSet` gestiona la conectividad.
- `CircuitNetwork` aplica el algoritmo sobre la red.

### Encapsulación

La estructura Union-Find queda completamente encapsulada dentro de `DisjointSet`.

El resto del código no manipula directamente arrays de padres o tamaños, sino que usa operaciones de dominio como:

```java
disjointSet.union(first, second)
disjointSet.productOfLargestComponents(3)
```

### Tell, Don't Ask

La distancia entre dos cajas se calcula preguntando al propio objeto:

```java
firstBox.squaredDistanceTo(secondBox)
```

en lugar de extraer manualmente sus coordenadas fuera de la clase.

### Dependency Inversion Principle (DIP)

El solver recibe un `InputSource` mediante constructor, por lo que la lógica de red no depende del origen concreto de los datos.

### Streams

Los Streams se utilizan para generar combinaciones de cajas, ordenar conexiones y calcular el producto de los componentes principales.

---

## Resultados

| Parte | Respuesta |
|--------|-----------|
| 1 | **50568** |
| 2 | **36045012** |