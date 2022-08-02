import java.util.Queue
import java.util.LinkedList
import java.util.Stack
/*La clase abstracta secuencia abstrae los metodos agregar, remover y vacio que pueden ser utilizados por todas 
 * sus subclases.
 * */
abstract class Secuencia<T>() {
   abstract fun agregar(x : T) : Unit
   abstract fun remover() : Unit
   abstract fun vacio() : Unit
}
/*La clase Cola es una subclase de la clase abstracta Secuencia y sobreescribe los metodos de agregar, remover
 * y vacio para modificar la cola que define dentro de su estructura.
 * */
class Cola<T>(): Secuencia<T>() {
    var cola : Queue<T> = LinkedList<T>()
	override fun agregar(x : T){
		cola.add(x)
		println(cola)
	}
	override fun remover(){
		try{
			cola.remove()
			println(cola)
		}
		catch(e : NoSuchElementException){
			println("No hay mas elementos en la cola")
		}
	}
    override fun vacio(){
       var a = cola.isEmpty()
       println(a)
    }
}
/*La clase Pila es una subclase de la clase abstracta Secuencia. Reescribe los metodos de 
 * agregar, remover y vacio para poder operar con el stack que define en su estructura.
 * */
class Pila<T>(): Secuencia<T>() {
    var pila = Stack<T>()
	override fun agregar(x : T){
		pila.push(x)
		println(pila)
	}
	override fun remover(){
		try{
			pila.pop()
			println(pila)
		}
		catch(e : java.util.EmptyStackException){
			println("No hay mas elementos en la pila")
		}
	}
    override fun vacio(){
       var a = pila.isEmpty()
       println(a)
    }
}
/*La funcion main es la funcion principal que crea las instancias de Cola y Pila. 
 * En esta funcion se puede hacer modificaciones para probar los metodos de las clases
 * Cola y Pila.
 * Se imprime la pila o cola cada vez que se agrega o remueve un elemento para ver los cambios de esta.
 * */
fun main(){
    var cola = Cola<Int>()
    cola.agregar(3)
    cola.agregar(9)
    cola.agregar(4)
    cola.remover()
    cola.remover()
    cola.vacio()
    cola.remover()
    cola.remover()
    cola.vacio()
}
