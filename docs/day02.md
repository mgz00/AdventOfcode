# DÍA 02: Invalid Product IDs

## 1. Modelado del Dominio

**Enfoque: Separación de Responsabilidades (SRP).**

El problema se dividió en dos conceptos principales:

* `ProductId`: representa un identificador y contiene las reglas de validación.
* `ProductIdRange`: representa un rango de IDs y encapsula la generación de valores.

De esta forma se evita concentrar toda la lógica en el solver.

---

## 2. Reutilización de la Lógica de Validación

**Enfoque: Evitar Duplicación (DRY).**

Las dos partes del ejercicio comparten la misma idea: comprobar si un ID está formado por repeticiones de un patrón.

Para evitar duplicar código, ambas validaciones reutilizan el método privado `isRepeatedPattern`.

La diferencia entre las partes se reduce únicamente al tamaño del patrón que se permite comprobar.

---

## 3. Uso de Streams

**Enfoque: Procesamiento Declarativo.**

La solución utiliza Streams para:

* Transformar la entrada en objetos de dominio.
* Expandir los rangos de IDs.
* Filtrar los identificadores inválidos.
* Calcular la suma final.

Pipeline principal:

```java
ranges.stream()
      .flatMapToLong(ProductIdRange::values)
      .mapToObj(ProductId::new)
      .filter(...)
      .mapToLong(ProductId::value)
      .sum();
```

Esto permite expresar claramente el flujo de datos sin estructuras de control complejas.

---

## 4. Inyección de Dependencias

**Enfoque: Dependency Inversion Principle (DIP).**

El solver recibe una implementación de `InputSource` mediante constructor.

De esta forma la lógica de resolución no depende de archivos concretos y puede reutilizarse con cualquier origen de datos.

---

## 5. Conclusiones

La solución prioriza:

* Separación de responsabilidades.
* Reutilización de código.
* Uso de Streams.
* Bajo acoplamiento mediante abstracciones.

El resultado es un código sencillo de mantener y fácil de extender para futuras variantes del problema.
