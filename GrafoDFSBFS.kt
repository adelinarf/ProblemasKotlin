import java.util.Stack
import java.util.LinkedList
import java.util.Queue

/*La clase Grafo define un grafo implementado como lista de adyacencias.
 * Se inicializa con el tamano del grafo.
 * */
public class Grafo {
    public var adj : HashMap<Int,MutableList<Int>>  //La lista de adyacencias de x contiene los vertices y que forman el lado (x,y)
    var num : Int = 0 
    
    constructor(numDeVertices: Int) {
        this.num = numDeVertices
        adj = this.inicializaTablaHash(this.num)
    }
    /*La funcion inicializaTablaHash crea los componentes de la tabla de hash 
     * que mapean cada uno de los vertices a una lista mutable que contendra los 
     * vertices a los que llega el lado
     * */
    fun inicializaTablaHash(numDeVertices : Int): HashMap<Int,MutableList<Int>>{
    var adj : HashMap<Int,MutableList<Int>> = hashMapOf<Int,MutableList<Int>>()
    for (x in 0..numDeVertices-1){
        adj[x] = mutableListOf<Int>()
    }
    return adj
    }
    /*La funcion crearLado agrega un entero y al la lista de adyacencias de x
     * */    
    fun crearLado(x : Int, y: Int){
		this.adj[x]!!.add(y)
	}
	/*La funcion adyacentes retorna la lista de adyacencias de un vertice x
	 */
    fun adyacentes(x : Int) : MutableList<Int>? {
		return adj[x]
	}
	/*La funcion numeroVertices retorna el numero de vertices del grafo
	 * */
    fun numeroVertices() : Int{
      return adj.size
    }
}
/*La clase abstracta Busqueda define un orden que se encuentra en una lista mutable
 * y define una funcion buscar que imprime ese orden, si el vertice no se encuentra 
 * en el orden, no es alcanzable desde el valor dado y si se encuentra se calculan
 * los nodos explorados desde un valor D hasta un valor H.
 * La variable orden sera modificada al llamar a las subclases de Busqueda, por lo que luego
 * se puede llamar al metodo buscar sin ningun problema, debido a que orden estara definida.
 * */
abstract class Busqueda(){
	abstract var orden : MutableList<Int>
	fun buscar(D:Int,H:Int){
		//nodos explorados de D a H
		//si H no es alcanzable desde D devolver -1
        var indiceH = orden.indexOf(H)
        var indiceD = orden.indexOf(D)
        if (indiceH == -1){
			println("El vertice "+H.toString()+" no es alcanzable")
		}
		else{
			print("El numero de nodos explorados es: ")
      println(indiceH-indiceD)
		}
	}
}
/*La clase DFS es una subclase de Busqueda y reescribe la variable orden.
 * Implementa DFS iterativo con ayuda de una pila y solo considera a los 
 * nodos que son alcanzables desde el vertice de inicio. En orden se guarda 
 * orden de aplicacion de DFS iterativo sobre los nodos.
 * */
class DFS(val inicio : Int, val g : Grafo) : Busqueda() {
	override var orden : MutableList<Int> = mutableListOf()
	var visitados : MutableList<Boolean> = mutableListOf()
	init{
		for (i in 0.. g.numeroVertices()-1) {
			visitados.add(false)
		}
		DFSM(inicio) //DFSFinal para tomar los que no son alcanzables
	}
	fun DFSFinal(){ //Este metodo solo se debe utilizar si se desean utilizar los alcanzables, en este problema no
		for (i in 0.. g.numeroVertices()-1){
			if (this.visitados[i]==false){
				this.DFSM(i)
			}
		}
	}
	/*La funcion DFSM implementa el DFS iterativo basado en una pila y cada vez que saca
	 * un elemento de la pila lo anade al orden para obtener asi los elementos en el
	 * orden que se han visitado en DFS.
	 * */
	fun DFSM(inicio : Int){
		var pila = Stack<Int>()
		pila.push(inicio)
		while (pila.isEmpty() == false){
			var elem = pila.pop()
			orden.add(elem)
			if (this.visitados[elem] == false){
				this.visitados[elem] = true
			}
			var adyacentes = g.adyacentes(elem) ?: mutableListOf()
			for (nodo in adyacentes){
				if (this.visitados[nodo] == false){
					pila.push(nodo)
				}
			}
		}
	}
}
/*La clase BFS es una subclase de Busqueda. Reescribe a la variable orden
 * Durante su inicializacion ejecuta el BFS iterativo basado en una cola. 
 * Al momento de sacar un elemento de la cola lo guarda en el orden para que
 * al culminar el algoritmo se tiene en orden a todos los nodos en el orden en
 * que ha buscado BFS.
 * */
class BFS(val inicio : Int, val g : Grafo) : Busqueda() {
	override var orden : MutableList<Int> = mutableListOf()
	var visitados : MutableList<Boolean> = mutableListOf()
	init{
		for (i in 0.. g.numeroVertices()-1) {
			visitados.add(false)
		}
		var cola : Queue<Int> = LinkedList<Int>()
		cola.add(inicio)
		this.visitados[inicio] = true
		while (cola.isEmpty() == false){
			var elem = cola.poll()
			orden.add(elem)
			var adyacentes = g.adyacentes(elem) ?: mutableListOf()
			for (i in adyacentes){
				if (this.visitados[i] == false){
					cola.add(i)
					this.visitados[i] = true
				}
			}
		}
	}
}
/*La funcion main contiene un ejemplo del uso del programa. Se crea el grafo con el numero de vertices del mismo,
 * luego se agregar los lados del grafo. Para conocer cuantos nodos han sido explorados en DFS o BFS, se debe hacer
 * una instancia de cada una de estas clases.
 * Luego para llamar a buscar de la clase abstracta Busqueda, es necesario que el valor inicial sea el mismo que se ha
 * colocado como valor inicial es DFS o BFS o los resultados seran incorrectos, ya que, el metodo buscar se basa en estos
 * algoritmos para conseguir el orden.
 * */
fun main(){
    var g = Grafo(5)
    g.crearLado(1, 0)
	g.crearLado(0, 2)
	g.crearLado(2, 1)
	g.crearLado(0, 3)
	//g.crearLado(1, 4)
	var dfs = DFS(0,g)
	dfs.buscar(0,4)
	dfs.buscar(0,1)
	var bfs = BFS(0,g)
	bfs.buscar(0,3)
	bfs.buscar(0,1)
}
