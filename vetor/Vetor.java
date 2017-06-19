package vetor;

import java.util.Iterator;


public class Vetor<Tipo> implements IVetor<Tipo>, Iterable<Tipo>{

	private Object[] vetor;
	private int tamanho = 0;

	public Vetor() {
		this.vetor = new Object[10];
	}

	public Vetor(int tamInicial) {
		if (tamInicial < 0){
            throw new IllegalArgumentException("Illegal Capacity: "+ tamInicial);
		}
		this.vetor = new Object[tamInicial];
	}

	@Override
	public boolean adicionar(Tipo valor) {
		this.aumentaTamanhoVetor();
		this.vetor[this.tamanho] = valor;
		this.tamanho++;
		return true;
	}

	@Override
	public boolean adicionar(int posicao, Tipo valor) {
		this.aumentaTamanhoVetor();
		if (!this.posicaoValida(posicao)) {
			throw new UnsupportedOperationException("Posição Inválida!");
		} else {

			for (int i = this.tamanho - 1; i >= posicao; i--) {
				this.vetor[i + 1] = this.vetor[i];
			}
			this.vetor[posicao] = valor;
			this.tamanho++;
		}
		return true;
	}

	@Override
	public Tipo remover(int posicao) {
		if (!this.posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posição inválida!");
		}
		for (int i = posicao; i < this.tamanho - 1; i++) {
			this.vetor[i] = this.vetor[i + 1];
		}
		this.tamanho--;
		return null;
	}

	@Override
	public boolean removerValor(Tipo valor) {
		for (int i = 0; i < this.tamanho; i++) {
			if (this.vetor[i].equals(valor)) {
				for (int j = i; j < this.tamanho -1; j++) {
					this.vetor[j] = this.vetor[j + 1];
				}
				this.tamanho--;
			}
		}
		return true;
	}

	@Override
	public boolean contem(Tipo valor) {
		for (int i = 0; i < this.tamanho; i++) {
			if (valor.equals(this.vetor[i])) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int tamanho() {
		return this.tamanho;
	}

	@Override
	public void limpar() {
		for (int i = this.tamanho-1; i >= 0; i--) {
			this.remover(i);
		}
	}

	@Override
	public Tipo obter(int posicao) {
		return (Tipo) this.vetor[posicao];
	}

	private void aumentaTamanhoVetor() {
		if (this.tamanho == this.vetor.length) {
			Object[] novoVetor = new Object[this.vetor.length *2];
			for (int i = 0; i < this.vetor.length; i++) {
				novoVetor[i] = this.vetor[i];
			}
			this.vetor = novoVetor;
		}
	}

	private boolean posicaoValida(int posicao) {
		return posicao >= 0 && posicao <= this.tamanho;
	}

	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < this.tamanho;
	}

	public Iterator<Tipo> iterator() {
		vetor.Iterador<Tipo> it = new Iterador<>(this);
		return it;
	}

}