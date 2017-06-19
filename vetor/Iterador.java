package vetor;

import java.util.Iterator;

public class Iterador<T> implements Iterator<T> {

	private int posicao = -1;
	private Vetor<T> vetor;

	public Iterador(Vetor<T> vetor) {
		this.vetor = vetor;
	}

	@Override
	public boolean hasNext() {
		return posicao + 1 <= vetor.tamanho()-1;
		// if (this.vetor.obter(posicao) != null && this.posicao <
		// this.vetor.tamanho()) {
		// return true;
		// } else {
		// return false;
		// }
		
	}

	@Override
	public T next() {
		return this.vetor.obter(++posicao);

	}

}
