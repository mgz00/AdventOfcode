# DÍA 01: The Dial

## 1. Diseño General de la Solución

La solución se ha desarrollado siguiendo principios de programación orientada a objetos y buenas prácticas de diseño software.

El problema se ha dividido en tres conceptos principales:

* **Rotation**: representa una instrucción de movimiento del dial.
* **Dial**: encapsula el comportamiento y estado del dial.
* **Day01Solver**: coordina la resolución del ejercicio.

Esta separación permite que cada componente tenga una responsabilidad claramente definida, facilitando el mantenimiento y la evolución futura del código.

---

## 2. Clase `Rotation`

La clase `Rotation` representa una orden de giro del dial.

Cada rotación está formada por:

* Una dirección (`L` o `R`).
* Una distancia de desplazamiento.

Se ha implementado mediante un `record` de Java, lo que proporciona inmutabilidad de forma natural.

### Ventajas de la Inmutabilidad

* Los objetos no pueden modificarse una vez creados.
* Se evitan efectos secundarios inesperados.
* Se simplifica el razonamiento sobre el comportamiento del programa.
* Se mejora la seguridad durante el procesamiento de datos.

Además, la clase incorpora un método estático encargado de construir una instancia a partir de una línea de entrada.

De esta forma toda la lógica relacionada con la interpretación de una rotación queda centralizada dentro de la propia clase.

---

## 3. Clase `Dial`

La clase `Dial` representa el mecanismo circular descrito en el enunciado.

### Encapsulación

La posición actual se mantiene en un atributo privado.

Ninguna clase externa puede modificar directamente este valor, garantizando que el estado interno permanezca siempre consistente.

### Aritmética Modular

El comportamiento circular del dial se implementa mediante aritmética modular.

Esto permite gestionar correctamente situaciones como:

* Pasar de 99 a 0.
* Pasar de 0 a 99.
* Realizar desplazamientos superiores al tamaño completo del dial.

Toda esta lógica queda encapsulada dentro de la clase, evitando que otras partes del sistema tengan que preocuparse por estos detalles.

### Cohesión

Toda la funcionalidad relacionada con el dial se encuentra agrupada en una única clase:

* Actualización de la posición.
* Comprobación de la posición actual.
* Cálculo de los pasos por la posición cero.

Esto favorece una alta cohesión y reduce el acoplamiento con el resto del sistema.

---

## 4. Clase `Day01Solver`

La responsabilidad de esta clase es resolver el problema utilizando los objetos de dominio definidos previamente.

### Procesamiento de la Entrada

Durante la construcción del solver, las líneas del fichero se transforman en objetos `Rotation`.

De esta forma:

* El parseo se realiza una única vez.
* Las operaciones posteriores trabajan sobre objetos de dominio ya preparados.
* Se evita repetir transformaciones innecesarias.

### Resolución de la Parte 1

Para la primera parte se recorre la colección de rotaciones actualizando la posición del dial.

Tras cada movimiento se comprueba si el dial termina apuntando a la posición 0.

El resultado final corresponde al número de veces que esta situación ocurre.

### Resolución de la Parte 2

La segunda parte requiere determinar cuántas veces se atraviesa la posición 0 durante una rotación completa.

Esta lógica se delega completamente en la clase `Dial`, manteniendo el solver libre de detalles de implementación.

---

## 5. Resolución Matemática de la Parte 2

Para resolver la segunda parte se ha utilizado una formulación basada en aritmética modular.

La estrategia consiste en determinar:

1. La primera posición en la que la trayectoria alcanza el valor 0.
2. Cuántas veces vuelve a alcanzarse dicha posición dentro de la distancia total recorrida.

Este enfoque permite obtener el resultado mediante operaciones aritméticas simples.

### Ventajas

* El número de operaciones no depende de la distancia recorrida.
* El tiempo de ejecución permanece constante.
* La solución es fácilmente verificable desde un punto de vista matemático.
* El algoritmo mantiene una complejidad temporal O(1).

La naturaleza circular del problema hace que la aritmética modular sea especialmente adecuada para modelar el comportamiento del dial.

---

## 6. Aplicación de Principios SOLID

### Single Responsibility Principle (SRP)

Cada clase tiene una única responsabilidad:

* `Rotation`: representar una instrucción de giro.
* `Dial`: gestionar el estado y comportamiento del dial.
* `Day01Solver`: resolver el problema.

### Open/Closed Principle (OCP)

La arquitectura permite extender el comportamiento mediante nuevas implementaciones sin modificar las clases existentes.

### Dependency Inversion Principle (DIP)

El solver depende de la abstracción `InputSource` definida en el núcleo de la aplicación y no de una implementación concreta.

Esto permite sustituir el origen de los datos sin afectar a la lógica de resolución.

---

## 7. Conclusiones

La solución desarrollada prioriza:

* Simplicidad.
* Encapsulación.
* Inmutabilidad.
* Bajo acoplamiento.
* Alta cohesión.
* Eficiencia computacional.

La separación de responsabilidades facilita el mantenimiento del código y permite reutilizar la infraestructura creada en futuros ejercicios del proyecto Advent of Code.
