# Día 3: Battery Banks

## Enunciado

El tercer problema trabaja con bancos de baterías representados como líneas de dígitos. Cada dígito indica la potencia de una batería, y el orden de los dígitos no puede modificarse.

En cada banco se deben seleccionar ciertos dígitos para formar el mayor número posible respetando el orden original.

- **Parte 1:** se seleccionan 2 baterías para formar el mayor número de dos cifras posible.
- **Parte 2:** se seleccionan 12 baterías para formar el mayor número posible de doce cifras.

El resultado final es la suma de los máximos obtenidos para todos los bancos.

---

## Algoritmos y técnicas

- **Greedy:** en cada posición del resultado se selecciona el mayor dígito posible dejando suficientes dígitos restantes para completar el número.
- **Búsqueda acotada:** el algoritmo no revisa posiciones que impedirían completar el número final.
- **Strategy configurable:** se utiliza una estrategia parametrizada por el número de baterías requeridas.
- **Streams:** se utilizan para transformar las líneas de entrada en bancos de baterías y sumar los resultados.

---

## Modelado en clases

| Clase | Responsabilidad |
|--------|-----------------|
| `BatteryBank` | Representa una línea de baterías y sus valores. |
| `JoltageStrategy` | Define la abstracción común para calcular la máxima joltage de un banco. |
| `MaxJoltageStrategy` | Implementa el algoritmo greedy parametrizado por el número de baterías a seleccionar. |
| `Day03Solver` | Lee la entrada, aplica la estrategia correspondiente a cada parte y suma los resultados. |

---

## Diseño y principios aplicados

### Single Responsibility Principle (SRP)

Cada clase tiene una responsabilidad clara:

- `BatteryBank` representa el dato de entrada.
- `MaxJoltageStrategy` contiene el algoritmo de selección.
- `Day03Solver` coordina la ejecución.

### Open/Closed Principle (OCP)

El solver trabaja contra la abstracción `JoltageStrategy`. Esto permite cambiar o añadir nuevas estrategias sin modificar la lógica principal del solver.

### DRY

Inicialmente las partes 1 y 2 podían modelarse como clases distintas, pero al detectar que solo cambiaba el número de baterías requeridas, se refactorizó a una única clase `MaxJoltageStrategy` parametrizable.

Esto evita duplicar el algoritmo y facilita el mantenimiento.

### Dependency Inversion Principle (DIP)

El solver recibe un `InputSource` por constructor, por lo que la lógica de resolución queda desacoplada del origen concreto de los datos.

### Streams

El flujo principal de resolución se expresa mediante Streams:

```java
batteryBanks.stream()
        .mapToLong(strategy::calculate)
        .sum();
```

---

## Resultados

| Parte | Respuesta |
|--------|-----------|
| 1 | **17034** |
| 2 | **168798209663590** |