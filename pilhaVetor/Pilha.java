package pilhaVetor;

import java.util.Iterator;

import vetor.Vetor;

public class Pilha<T> implements IPilha<T>, Iterable<T> {

	private Vetor<T> pilha = new Vetor<>();
	
	

	public Vetor<T> getPilha() {
		return pilha;
	}

	@Override
	public Iterator<T> iterator() {
		pilhaVetor.Iterador<T> it = new Iterador<>(this);
		return it;
		//return this.pilha.iterator();
	}

	@Override
	public void empilhar(T elemento) {
		this.pilha.adicionar(elemento);
	}

	@Override
	public T desempilhar() {
		return this.pilha.remover(this.pilha.tamanho() - 1);
	}

	@Override
	public T topo() {
		return this.pilha.obter(this.pilha.tamanho() - 1);
	}

	@Override
	public int tamanho() {
		return this.pilha.tamanho();
	}

	@Override
	public boolean vazia() {
		return this.pilha.tamanho() == 0;
	}

	@Override
	public void limpar() {
		this.pilha.limpar();
	}

	public String toString() {
		
		int aux = this.pilha.tamanho()-1;
		
		if (this.pilha.tamanho() == 0) {
			return "[]";
		}

		StringBuilder builder = new StringBuilder();
		builder.append("[");

		for (int i = 0; i < aux; i++) {
			builder.append(this.pilha.obter(i));
			builder.append(", ");
		}

		builder.append(this.pilha.obter(aux));
		builder.append("]");

		return builder.toString();
	}


}
