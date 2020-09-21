package Grafo;
import java.util.ArrayList;
import java.util.logging.*;
import java.util.List;

public class Graph {
	
	protected List<Nodo<Integer>> listaNodos; //Lista de los nodos 
	protected List<Arco<Integer>> listaArcos;	//Lista de arcos
	protected static Logger loger;
	
	public Graph() {
		listaNodos= new ArrayList<Nodo<Integer>>();	//inicializacion de listas
		listaArcos=new ArrayList<Arco<Integer>>(); 	//
		if(loger == null) {							//inicializacion del logger si este no existe previamente
			
			loger=  Logger.getLogger(Graph.class.getName());
			Handler hand = new ConsoleHandler();
			hand.setLevel(Level.FINE);
			loger.addHandler(hand);
			
			loger.setLevel(Level.FINE);
		}
		
	}
	
	public void addNode(int node) {
		boolean repetido=false;
		for(Nodo<Integer> aux: listaNodos) {		//verificacion para no agregar mas de una vez el mismo nodo
			if(!repetido)							//
			repetido=aux.getEtiqueta()==node;		//
		}
		if(!repetido)				{				//si no se encuentra
			listaNodos.add(new Nodo<Integer>(node));//agregar
			loger.fine("el nodo" +node + "ha sido agregado correctamente");
		}else
			loger.warning("el nodo ya habia sido agregado");
	}
	
	public void addEdge(int node1,int node2) {
		Nodo<Integer> encontroA=null;				//para verificacion de existencia del nodo
		Nodo<Integer> encontroB=null;				//
		for (Nodo<Integer> aux: listaNodos) {		//Verificacion
			if(aux.getEtiqueta()==node1)			//
				encontroA=aux;						//
			else if(aux.getEtiqueta()==node2)		//
				encontroB=aux;						//
		}
		if (encontroA!=null && encontroB!=null) {//si los nodos existen, agrego arco
			boolean Existe=false;					//verificacion de repeticion de arco
			for(Arco<Integer>aux: listaArcos) {		//
				Existe=(aux.getNodo1().getEtiqueta()==encontroA.getEtiqueta() && aux.getNodo2().getEtiqueta()==encontroB.getEtiqueta()); //verificacion de igualdad de arcos
			}
			if(!Existe) {													//si no existe el arco
				Arco<Integer> a=new Arco<Integer>(encontroA,encontroB); 	//creo un arco nuevo
				listaArcos.add(a);											//agreagado a la lista
				loger.fine("el arco entre " + node1 + " y " + node2 + " se ha establecido");
			}else
				loger.warning("el arco ("+node1 + ","+ node2  +") ya existia");
		}else
			loger.warning("alguno de los nodos igresados no pertenece al grafo");
	}
	public void removeNode(int node) {
		Nodo<Integer> aRemover=null;
		for (Nodo<Integer> aux: listaNodos) {		//Busco el nodo a remover
			if(aux.getEtiqueta()==node)				//
				aRemover=aux;						//
		}
		if(aRemover!=null) {
			listaNodos.remove(aRemover);			//borrar
			loger.fine("el nodo " + node + " ha sido elimiando correctamente");
		}
		else
			loger.warning("el nodo " + node + " no se encontraba en el grafo");
	}
	
	public void RemoveEdge(int node1, int node2) {
		Arco<Integer> aRemover=null;																	//verificacion de la existencia del arco
		for(Arco<Integer>aux: listaArcos) {																//
			if((aux.getNodo1().getEtiqueta()==node1 && aux.getNodo2().getEtiqueta()==node2))			//
					aRemover=aux;																		//
		}if(aRemover!=null) {
			listaArcos.remove(aRemover);				//borrar
			loger.fine("el arco (" + node1+","+ node2 + ") ha sido elimiando correctamente");
		}else
			loger.warning("el arco (" + node1+","+ node2 + ") no existe");
	}
	
	public void listaNodosConsola() {										//coamando para revisar	los nodos acuales por consola
		String str ="";													
		for(Nodo<Integer> a: listaNodos) {
			int aux=a.getEtiqueta();
			str=str+(" "+ aux + ",");
		}
		loger.info("actualmente se encuentran los nodos"+str);
	}
	
	public void listaArcosConsola() {										//coamando para revisar	los arcos acuales por consola
		String str ="";													
		for(Arco<Integer> a: listaArcos) {
			int aux=a.getNodo1().getEtiqueta();
			int aux2=a.getNodo2().getEtiqueta();
			str=str+(" ("+ aux + " "+ aux2 + ")," );
		}
		loger.info("actualmente se encuentran los arcos"+str);
	}

}
