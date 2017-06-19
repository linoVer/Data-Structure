
package lse;

import java.rmi.NotBoundException;
import java.util.Iterator;

import lde.Iterador;


public class ListaSimplesmenteEncadeada<T> implements IListaSimplesmenteEncadeada<T>, Iterable<T> {

	private NoSimplesmenteEncadeado<T> inicio, fim;
	private int tamanho;

	public ListaSimplesmenteEncadeada() {
		this.inicio = null;
		this.fim = null;
		this.tamanho = 0;
	}

	@Override
	public boolean adicionarNoInicio(T valor) {

		NoSimplesmenteEncadeado<T> no = new NoSimplesmenteEncadeado<T>();

		no.setValor(valor);
		if (this.tamanho == 0) {
			this.inicio = this.fim = no;
			this.tamanho++;
		} else {
			no.setProximo(this.inicio);
			this.inicio = no;
			this.tamanho++;
		}

		return true;
	}

	@Override
	public boolean adicionar(T valor) {

		NoSimplesmenteEncadeado<T> no = new NoSimplesmenteEncadeado<T>();
		no.setValor(valor);

		if (this.inicio == null) {
			this.inicio = this.fim = no;
			this.tamanho++;
		} else {
			this.fim.setProximo(no);
			this.fim = no;
			no.setProximo(null);
			tamanho++;
		}
		return true;
	}

	@Override
	public boolean adicionar(int posicao, T valor) {

		NoSimplesmenteEncadeado<T> no, temp, novoNo = new NoSimplesmenteEncadeado();
		novoNo.setValor(valor);

		if (this.tamanho == 0 || posicao < 0) {
			throw new IndexOutOfBoundsException();
		} else if (posicao == this.tamanho) {
			adicionar(valor);
		} else if (posicao == 0) {
			adicionarNoInicio(valor);
		} else {

			no = this.inicio;
			for (int i = 0; i < posicao - 1; i++) {
				no = no.getProximo();
			}
			temp = no.getProximo();
			no.setProximo(novoNo);
			novoNo.setProximo(temp);

			this.tamanho++;
		}
		return true;
	}

	@Override
	public T obter(int posicao) {

		NoSimplesmenteEncadeado<T> no = new NoSimplesmenteEncadeado<T>();

		if (this.tamanho == 0) {
			throw new IndexOutOfBoundsException();
		} else if (posicao < 0 || posicao > this.tamanho - 1) {
			throw new IndexOutOfBoundsException();
		} else if (posicao == 0) {
			return this.inicio.getValor();
		} else if (posicao == this.tamanho - 1) {
			return this.fim.getValor();
		} else {
			no = this.inicio;
			for (int i = 0; i < posicao; i++) {
				no = no.getProximo();
			}
		}
		return no.getValor();
	}

	@Override
	public T removerDoInicio() {

		if (this.tamanho == 0) {
			throw new IndexOutOfBoundsException();
		} else {
			this.inicio = this.inicio.getProximo();
			this.tamanho--;
		}
		return null;
	}

	@Override
	public T removerDoFim() {

		NoSimplesmenteEncadeado<T> no = new NoSimplesmenteEncadeado<T>();

		if (this.tamanho == 0) {
			throw new IndexOutOfBoundsException();
		} else {
			no = this.inicio;
			for (int i = 0; i < this.tamanho - 2; i++) {
				no = no.getProximo();
			}
			no.setProximo(null);
			this.fim = no;
			this.tamanho--;
		}
		return null;
	}

	@Override
	public T remover(int posicao) {

		NoSimplesmenteEncadeado<T> no, temp = new NoSimplesmenteEncadeado<T>();

		if (this.tamanho == 0 || posicao < 0) {
			throw new IndexOutOfBoundsException();
		} else if (posicao == this.tamanho - 1) {
			removerDoFim();
		} else if (posicao == 0) {
			removerDoInicio();
		} else {
			no = this.inicio;
			for (int i = 0; i < posicao; i++) {
				temp = no;
				no = no.getProximo();
			}
			temp.setProximo(no.getProximo());
			this.tamanho--;
		}
		return null;
	}

	@Override
	public boolean removerContem(T valor) {

		if (this.tamanho == 0) {
			throw new IndexOutOfBoundsException();
		} else {
			for (int i = 0; i < this.tamanho; i++) {
				if (obter(i).equals(valor)) {
					remover(i);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean contem(T valor) {

		NoSimplesmenteEncadeado<T> no = this.inicio;

		for (int i = 0; i < this.tamanho; i++) {
			if (no.getValor().equals(valor)) {
				return true;
			} else {
				no = no.getProximo();
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
		while (this.tamanho > 1) {
			removerDoInicio();
		}
		this.inicio = this.fim = null;
		this.tamanho = 0;
	}

	@Override
	public Iterator<T> iterator() {
		lse.Iterador<T> it = new lse.Iterador<>(inicio);
		return it;
	}
}
