# DÍA 10: Factory Machines

## 1. Modelado del Problema

**Enfoque: Separación de Responsabilidades (SRP).**

La solución se divide en varios componentes:

* `Button`: representa un botón y los elementos que modifica.
* `Machine`: almacena el estado objetivo de una máquina y sus botones.
* `MachineParser`: interpreta cada línea del fichero de entrada.
* `IndicatorSolver`: resuelve la configuración de las luces (Parte 1).
* `JoltageSolver`: resuelve la configuración de los contadores de voltaje (Parte 2).

Cada clase tiene una única responsabilidad, facilitando el mantenimiento y la reutilización del código.

---

## 2. Estrategias de Resolución

**Enfoque: Algoritmos independientes.**

Las dos partes del problema requieren técnicas diferentes:

* **Parte 1:** se prueban todas las combinaciones posibles de botones utilizando máscaras de bits para encontrar el menor número de pulsaciones.
* **Parte 2:** se aplica un algoritmo recursivo con memoización sobre vectores de voltaje para minimizar el número total de pulsaciones.

Ambos algoritmos permanecen completamente desacoplados.

---

## 3. Uso de Streams

**Enfoque: Procesamiento Declarativo.**

Los Streams se utilizan para:

* Leer y parsear las máquinas.
* Generar las combinaciones de botones.
* Construir máscaras binarias.
* Calcular el resultado total de todas las máquinas.

Pipeline principal:

```java
machines.stream()
        .mapToLong(indicatorSolver::minimumPresses)
        .sum();
```

---

## 4. Inyección de Dependencias

**Enfoque: Dependency Inversion Principle (DIP).**

El solver recibe una implementación de `InputSource` mediante constructor.

Además, la lógica de resolución se delega en `IndicatorSolver` y `JoltageSolver`, manteniendo desacoplado el procesamiento de la entrada de los algoritmos utilizados.

---

## 5. Conclusiones

La solución prioriza:

* Separación de responsabilidades.
* Algoritmos independientes para cada parte del problema.
* Uso de Streams.
* Bajo acoplamiento entre componentes.

El resultado es un diseño modular, reutilizable y fácilmente ampliable.
