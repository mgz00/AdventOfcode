# Día 10: Factory Machines

## Enunciado

El décimo problema trabaja con máquinas que tienen luces indicadoras, botones y requisitos de voltaje.

Cada línea de entrada describe una máquina:

- Un patrón objetivo de luces entre corchetes.
- Una serie de botones entre paréntesis.
- Una lista de requisitos de voltaje entre llaves.

- **Parte 1:** ignorando los voltajes, calcular el número mínimo de pulsaciones necesarias para conseguir el patrón objetivo de luces.
- **Parte 2:** ignorando las luces, calcular el número mínimo de pulsaciones necesarias para alcanzar exactamente los valores de voltaje requeridos.

---

## Algoritmos y técnicas

- **Máscaras de bits:** en la parte 1 cada botón se representa como una máscara binaria de luces afectadas.
- **Fuerza bruta acotada:** se prueban todas las combinaciones de botones para encontrar la de menor número de pulsaciones.
- **Vectores de voltaje:** en la parte 2 los requisitos se modelan como vectores de enteros grandes.
- **Recursión con memoización:** se evita recalcular subproblemas ya resueltos durante la búsqueda de la mínima cantidad de pulsaciones.
- **Agrupación por paridad:** se precomputan patrones de botones agrupados según la paridad de sus vectores para reducir candidatos.

---

## Modelado en clases

| Clase | Responsabilidad |
|--------|-----------------|
| `Button` | Representa los índices afectados por un botón. |
| `Machine` | Agrupa el patrón objetivo, los botones y el vector objetivo de voltaje. |
| `MachineParser` | Interpreta cada línea de entrada y construye máquinas. |
| `IndicatorSolver` | Resuelve la parte de luces mediante máscaras de bits. |
| `JoltageVector` | Encapsula operaciones vectoriales necesarias para la parte 2. |
| `JoltageSolver` | Resuelve la parte de voltajes mediante recursión y memoización. |
| `Day10Solver` | Lee la entrada y coordina ambas partes. |

---

## Diseño y principios aplicados

### Single Responsibility Principle (SRP)

Cada clase tiene una función específica:

- `MachineParser` solo parsea.
- `IndicatorSolver` solo resuelve luces.
- `JoltageSolver` solo resuelve voltajes.
- `JoltageVector` encapsula operaciones matemáticas sobre vectores.

### Open/Closed Principle (OCP)

Las dos partes se resuelven mediante algoritmos independientes (`IndicatorSolver` y `JoltageSolver`).

Esto permite modificar o sustituir una estrategia de resolución sin afectar a la otra ni al solver principal.

### DRY

La lectura de máquinas se realiza una sola vez en `Day10Solver`.

Además, las operaciones vectoriales comunes se concentran en `JoltageVector`, evitando repetir lógica matemática dentro del algoritmo principal.

### Dependency Inversion Principle (DIP)

`Day10Solver` recibe un `InputSource` por constructor, desacoplando la resolución del origen concreto de los datos.

### Inmutabilidad

`Machine`, `Button` y `JoltageVector` se modelan como objetos de dominio inmutables.

Las listas internas se protegen mediante `List.copyOf`, evitando modificaciones externas no controladas.

### Streams

Los Streams se utilizan para parsear las máquinas, generar combinaciones, transformar botones en máscaras o vectores y sumar los resultados de todas las máquinas.

---

## Resultados

| Parte | Respuesta |
|--------|-----------|
| 1 | **545** |
| 2 | **22430** |