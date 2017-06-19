package pilhaEncadeada;

import java.util.Iterator;

import lde.ListaDuplamenteEncadeada;

public class Pilha<T> implements IPilha<T> {

	private ListaDuplamenteEncadeada<T> pilha = new ListaDuplamenteEncadeada<>();

	@Override
	public Iterator<T> iterator() {
		return this.pilha.iterator();
	}

	@Override
	public void empilhar(T elemento) {
		this.pilha.adicionarNoInicio(elemento);
	}

	@Override
	public boolean desempilhar() {
		return this.pilha.removerDoInicio();
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
