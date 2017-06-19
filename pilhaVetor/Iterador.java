package pilhaVetor;

import java.util.Iterator;

public class Iterador<T> implements Iterator<T> {

	private Pilha<T> pilha;
	private int posicao;


	public Iterador(Pilha<T> pilha) {
		this.pilha = pilha;
		this.posicao = pilha.tamanho()-1;
	}

	@Override
	public boolean hasNext() {
		return posicao >= 0 && pilha.topo() != null;
		
	}

	@Override
	public T next() {
		return this.pilha.getPilha().obter(posicao--);
	}

}
