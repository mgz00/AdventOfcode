# Día 7: Tachyon Manifold

## Enunciado

El séptimo problema simula la propagación de un haz de taquiones a través de un entramado formado por divisores (`^`).

El haz comienza en la posición marcada con `S` y siempre avanza hacia abajo. Cuando encuentra un divisor, el haz desaparece y genera dos nuevos haces que continúan desde las posiciones inmediatamente izquierda y derecha.

- **Parte 1:** calcular cuántas veces un haz se divide.
- **Parte 2:** calcular el número total de líneas temporales posibles, considerando que en cada divisor la partícula puede continuar únicamente hacia la izquierda o hacia la derecha.

---

## Algoritmos y técnicas

- **BFS (Breadth-First Search):** la propagación de los haces se realiza mediante una cola de estados pendientes.
- **Simulación de estados:** cada haz se representa como una posición independiente que evoluciona hasta abandonar el tablero o encontrar un divisor.
- **Programación dinámica:** la segunda parte reutiliza resultados almacenados para evitar recalcular el número de líneas temporales desde una misma posición.
- **Streams:** utilizados para localizar la posición inicial y procesar la entrada.

---

## Modelado en clases

| Clase | Responsabilidad |
|--------|-----------------|
| `TachyonManifold` | Representa el mapa y proporciona operaciones sobre sus posiciones. |
| `BeamSimulation` | Implementa los algoritmos de propagación para ambas partes del problema. |
| `Day07Solver` | Lee la entrada, crea el modelo y coordina la resolución. |

---

## Diseño y principios aplicados

### Single Responsibility Principle (SRP)

Cada componente tiene una responsabilidad claramente definida:

- `TachyonManifold` modela el tablero.
- `BeamSimulation` implementa la simulación.
- `Day07Solver` coordina la ejecución.

### Encapsulación

Toda la lógica relacionada con el recorrido del tablero permanece dentro de `TachyonManifold` y `BeamSimulation`.

El solver nunca accede directamente a la representación interna del mapa.

### DRY

La lógica de exploración del tablero se reutiliza entre ambas partes.

La diferencia reside únicamente en la información que se acumula durante la exploración (divisiones o número de líneas temporales).

### Dependency Inversion Principle (DIP)

El solver recibe un `InputSource` mediante el constructor, desacoplando completamente el algoritmo del mecanismo de lectura.

### Streams

Los Streams se utilizan durante la construcción del modelo y para localizar elementos relevantes del mapa, manteniendo un procesamiento declarativo de la entrada.

---

## Resultados

| Parte | Respuesta |
|--------|-----------|
| 1 | **1649** |
| 2 | **16937871060075** |