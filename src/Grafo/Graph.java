package Grafo;
import java.util.ArrayList;

import java.util.List;

public class Graph {
	
	protected List<Nodo<Integer>> listaNodos; //Lista de los nodos 
	protected List<Arco<Integer>> listaArcos;	//Lista de arcos
	
	public Graph() {
		listaNodos= new ArrayList<Nodo<Integer>>();	//inicializacion de listas
		listaArcos=new ArrayList<Arco<Integer>>(); 	//
	}
	
	public void addNode(int node) {
		boolean repetido=false;
		for(Nodo<Integer> aux: listaNodos) {		//verificacion para no agregar mas de una vez el mismo nodo
			repetido=aux.getEtiqueta()==node;		//
		}
		if(!repetido)								//si no se encuentra
			listaNodos.add(new Nodo<Integer>(node));//agregar
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
			}
		}
	}
	public void removeNode(int node) {
		Nodo<Integer> aRemover=null;
		for (Nodo<Integer> aux: listaNodos) {	//Busco el nodo a remover
			if(aux.getEtiqueta()==node)			//
				aRemover=aux;					//
		}
		listaNodos.remove(aRemover);			//borrar
	}
	
	public void RemoveEdge(int node1, int node2) {
		Arco<Integer> aRemover=null;																	//verificacion de la existencia del arco
		for(Arco<Integer>aux: listaArcos) {																//
			if((aux.getNodo1().getEtiqueta()==node1 && aux.getNodo2().getEtiqueta()==node2))			//
					aRemover=aux;																		//
		}
		listaArcos.remove(aRemover);																	//borrar
			
			
	}

}
