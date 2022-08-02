# Problemas Kotlin
### Pregunta 1.b
#### Pregunta 1.b.i

Defina un interfaz o clase abstracta Secuencia, que represente una colección ordenada de elementos. Debe tener los siguientes métodos:

    • agregar: Recibe un elemento y lo agrega a la secuencia.
    • remover: Devuelve un elemento de la secuencia y lo elimina de la misma.
    Arroja un error si está vacía.
    • vacio: Dice si la secuencia está vacía (no tiene elementos).
    
Defina dos clases concretas Pila y Cola que sean subtipo de Secuencia

    • Para Pila los elementos se manejan de tal forma que el último en ser agregado
    es el primero en ser removido.
    • Para Cola los elementos se manejan de tal forma que el primero en ser agregado es el primero en ser removido

##### Implementación
La implementación de este programa se encuentra en el archivo pilaCola.kt

#### Pregunta 1.b.ii
Defina un tipo de datos que represente grafos como listas de adyacencias y cada
nodo sea representado por un número entero (puede usar todas las librerías a su
disposición en el lenguaje).
Además, defina una clase abstracta Busqueda que debe tener un método buscar.
Este método debe recibir dos enteros: D y H, y debe devolver la cantidad de nodos
explorados, partiendo desde el nodo D hasta llegar al nodo H. En caso de que H no
sea alcanzable desde D, debe devolver el valor -1 (menos uno).
Esta clase debe estar parcialmente implementada, dejando solamente abstraído el
orden en el que se han de explorar los nodos.

Defina dos clases concretas DFS y BFS que sean subtipo de Busqueda.

    • Para DFS el orden de selección de nodos es a profundidad (usando un pila).
    • Para BFS el orden de selección de nodos es a amplitud (usando un cola)
##### Implementación
La implementación de este programa se encuentra en el archivo GrafoDFSBFS.kt

## Nota: Para hacer pruebas diferentes, modificar los valores de los ejemplos dados en la función main de cada archivo.
