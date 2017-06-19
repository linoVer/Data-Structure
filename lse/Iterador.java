package lse;

import java.util.Iterator;

public class Iterador<T> implements Iterator<T> {
	
	private NoSimplesmenteEncadeado<T> no;
	
	public Iterador(NoSimplesmenteEncadeado<T> no) {
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
