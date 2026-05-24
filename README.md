# Algoritmos y Estructuras de Datos (AyED)

Laboratorio de estructuras de datos fundamentales, resolución de problemas y abstracciones matemáticas en Java. Sirve como registro del contenido de segundo año y base para lógica avanzada.

## Contenido actual
* **`utilidades_matdiscr`:** Encapsulamiento algebraico en POO pura (manejo de clases `Numero`, `ParOrdenado`, `Congruencia` y algoritmo de Euclides).
* **`estructuras.lineales`:** Pilas, colas y listas enlazadas implementadas tanto mediante arreglos estáticos como con nodos dinámicos.
* **`estructuras.no_lineales`:** Árboles binarios, árboles AVL y grafos (dirigidos y no dirigidos) utilizando matrices de adyacencia y conexiones dinámicas.

## Prioridades actuales y Roadmap
El objetivo inmediato es limpiar la deuda técnica del código antes de expandir el repositorio:
* [ ] **Refactorización de dependencias:** Eliminar las clases lineales duplicadas dentro del paquete de no lineales (`ColaSLinkedList`, etc.) e integrar imports limpios entre paquetes.
* [ ] **Estructuras avanzadas:** Agregar lógica de montículos (Heaps), árboles Segmentados (Segment Trees) y estructuras de conjuntos disjuntos (Union-Find).
* [ ] **Sección Competitiva:** Carpeta dedicada a la resolución de problemas de plataformas (Codeforces, LeetCode) utilizando las estructuras del repositorio como librerías base.

## Decisiones de diseño
* **Abstracción por Interfaces:** Separación mandatoria de contratos (`I_Conjunto`, `OperacionesCL`) de las clases concretas que los implementan.

## Estructura 
| Paquete                  |        Descripción      |               Componentes Clave        |
| :----------------------- | :---------------------- | :------------------------------------- |
| `utilidades_matdiscr`    | Matematica discreta     | `Numero`, `ParOrdenado`, `Congruencia` |
| `estructuras.lineales`   | Contenedores lineales   | `Pila`, `Cola`, `ListaEnlazada`        |
| `estructuras.no_lineales`| Contenedores no lineales| `ArbolBinario`, `ArbolAVL`, `GrafoDirigido`, `GrafoNoDirigido` |


## Entorno y ejecución

* **Lenguaje:** Java 17 (o superior)
* **Entorno:** WSL2 (Ubuntu) / Windows
* **IDE recomendado:** IntelliJ IDEA

El proyecto está estructurado con carpetas de código fuente nativo dentro de `src/`. Para compilar y ejecutar un archivo de prueba (testing) de forma manual por consola sin depender del IDE, parate en la raíz del proyecto (`/src`) y ejecutá:

```bash
# Compilar el archivo de testing (ejemplo)
javac estructuras/lineales/testing/Ejercicio9.java

# Ejecutar la clase compilada usando la ruta del paquete
java estructuras.lineales.testing.Ejercicio9

```

*Mantenido por [axelit-forge](https://github.com/axelit-forge)*
