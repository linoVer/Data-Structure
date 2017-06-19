package filaDupEnc;

import java.util.Iterator;

import lde.ListaDuplamenteEncadeada;

public class Fila<T> implements IFila<T> {
	
	private ListaDuplamenteEncadeada<T> fila = new ListaDuplamenteEncadeada<>();

	@Override
	public Iterator<T> iterator() {
		return fila.iterator();
	}

	@Override
	public void enfileirar(T elemento) {
		fila.adicionar(elemento);		
	}

	@Override
	public boolean desenfileirar() {
		return fila.removerDoInicio();
	}

	@Override
	public T first() {
		return fila.obter(0);
	}

	@Override
	public int tamanho() {
		return fila.tamanho();
	}

	@Override
	public boolean isEmpty() {
		return this.fila.tamanho() == 0;
	}

	@Override
	public void limpar() {
		fila.limpar();		
	}
	
public String toString() {
		
		int aux = this.fila.tamanho()-1;
		
		if (this.fila.tamanho() == 0) {
			return "[]";
		}

		StringBuilder builder = new StringBuilder();
		builder.append("[");

		for (int i = 0; i < aux; i++) {
			builder.append(this.fila.obter(i));
			builder.append(", ");
		}

		builder.append(this.fila.obter(aux));
		builder.append("]");

		return builder.toString();
	}

}
