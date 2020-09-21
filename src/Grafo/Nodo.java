package Grafo;

public class Nodo<A> {
	protected A etiqueta;
	
	public Nodo(A eti) {
		etiqueta=eti;
	}
	
	public void setEtiqueta(A eti) {
		etiqueta=eti;
	}
	public A getEtiqueta() {
		return etiqueta;
	}

}
