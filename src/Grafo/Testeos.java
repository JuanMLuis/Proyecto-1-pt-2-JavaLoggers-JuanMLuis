package Grafo;

public class Testeos {

	public static void main(String[] args) {
		Graph grafo = new Graph();
		grafo.addNode(1);
		grafo.addNode(2);
		grafo.addNode(6);
		grafo.addNode(7);
		grafo.addNode(9);
		
		grafo.addNode(1);				//Warning
			
		grafo.listaNodosConsola();  	//INFO
					
		grafo.removeNode(2);			//Fine
		grafo.removeNode(-3);			//Warning
		
		grafo.addEdge(1, 6);			//Fine
		grafo.addEdge(7,9);				//Fine
		
		grafo.addEdge(7,9);				//Warning
		grafo.addEdge(2,1);				//Warning
		
		
		grafo.listaNodosConsola();				//INFO
		grafo.listaArcosConsola();				//INFO
		
		grafo.RemoveEdge(1,6);			//Fine
		grafo.RemoveEdge(1,4);			//Warning
		
		grafo.listaArcosConsola();
	}

}
