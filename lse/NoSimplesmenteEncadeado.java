/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lse;

/**
 *
 * @author 11645
 */
public class NoSimplesmenteEncadeado<T> {

	private NoSimplesmenteEncadeado<T> proximo;
	private T valor;

	public NoSimplesmenteEncadeado() {

		this.proximo = proximo;
		this.valor = valor;
	}

	public NoSimplesmenteEncadeado<T> getProximo() {
		return proximo;
	}

	public void setProximo(NoSimplesmenteEncadeado<T> proximo) {
		this.proximo = proximo;
	}

	public T getValor() {
		return valor;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}

}
