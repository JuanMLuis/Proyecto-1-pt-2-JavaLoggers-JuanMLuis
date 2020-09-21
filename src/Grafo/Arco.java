package Grafo;

public class Arco<A> {
	
	protected Nodo<A> nodo1;
	protected Nodo<A> nodo2;
	
	public Arco(Nodo<A> n1,Nodo<A> n2) {
		nodo1=n1;
		nodo2=n2;
	}
	
	public void setNodo1(Nodo<A> n1) {
		nodo1=n1;
	}
	public void setNodo2(Nodo<A> n2) {
		nodo1=n2;
	}
	
	public Nodo<A> getNodo1(){
		return nodo1;
	}
	
	public Nodo<A> getNodo2(){
		return nodo2;
	}
	
}
