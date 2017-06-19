package lde;

import java.util.Iterator;

public class Iterador<T> implements Iterator<T> {
	
	private NoDuplamenteEncadeado<T> no;
	
	public Iterador(NoDuplamenteEncadeado<T> no) {
		this.no = no;	
	}
	
	@Override
	public boolean hasNext() {		
		return no != null;
	}

	@Override
	public T next() {
		T valor =(T) no.getValor();
		no = no.getProximo();
		return valor;
	}

}
