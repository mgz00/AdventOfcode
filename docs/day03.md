# DÍA 03: Battery Banks

## 1. Diseño de la Solución

**Enfoque: Patrón Strategy y Responsabilidad Única (SRP).**

El problema se dividió en tres conceptos principales:

* `BatteryBank`: representa una línea de baterías.
* `JoltageStrategy`: define una estrategia para calcular el mayor número posible.
* `Day03Solver`: coordina la lectura de datos y la suma de resultados.

Esta separación evita mezclar la lógica de cálculo con la lógica de lectura y procesamiento.

---

## 2. Patrón Strategy

**Enfoque: Open/Closed Principle (OCP).**

Las reglas de la Parte 1 y la Parte 2 son diferentes, pero ambas siguen el mismo flujo de ejecución.

Para desacoplar ambas soluciones se utiliza la interfaz `JoltageStrategy`, permitiendo intercambiar algoritmos sin modificar el solver.

Estrategias implementadas:

* `MaxPairJoltageStrategy` → Parte 1.
* `MaxDozenJoltageStrategy` → Parte 2.

---

## 3. Uso de Streams

**Enfoque: Procesamiento Declarativo.**

La solución utiliza Streams para:

* Leer las líneas de entrada.
* Transformarlas en objetos de dominio.
* Aplicar la estrategia correspondiente.
* Obtener la suma final.

Pipeline principal:

```java
batteryBanks.stream()
        .mapToLong(strategy::calculate)
        .sum();
```

---

## 4. Inyección de Dependencias

**Enfoque: Dependency Inversion Principle (DIP).**

El solver recibe una implementación de `InputSource` mediante constructor.

Esto permite desacoplar la lógica del problema del origen concreto de los datos y facilita la realización de pruebas unitarias.

---

## 5. Conclusiones

La solución prioriza:

* Separación de responsabilidades.
* Reutilización mediante el patrón Strategy.
* Uso de Streams.
* Bajo acoplamiento entre componentes.

Esto permite añadir nuevas estrategias de cálculo sin modificar el flujo principal de resolución.
