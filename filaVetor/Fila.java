package filaVetor;

import java.util.Iterator;
import vetor.Vetor;

public class Fila<T> implements IFila<T> {
	
	private Vetor<T> fila = new Vetor<>();

	@Override
	public Iterator<T> iterator() {
		return fila.iterator();
	}

	@Override
	public void enfileirar(T elemento) {
		fila.adicionar(elemento);		
	}

	@Override
	public T desenfileirar() {
		return fila.remover(fila.tamanho()-1);
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
