package tabelaHash;

import java.util.Iterator;

import lde.ListaDuplamenteEncadeada;
import vetor.Vetor;

public class Iterador<V> implements Iterator<V> {
	
	private Vetor<ListaDuplamenteEncadeada<No>> no;
	private int cont = 0;
	private int posicaoLista = 0;
	private int posicaoNo = 0;
	
	
	

	public Iterador(Vetor<ListaDuplamenteEncadeada<No>> no) {
		this.no = no;
	}

	@Override
	public boolean hasNext() {
		return cont < no.tamanho();
	}

	@Override
	public V next() {
		
		V valor = null;
		
		while(no.obter(posicaoLista) == null || posicaoNo >= no.obter(posicaoLista).tamanho()){
			posicaoLista += 1;
			posicaoNo = 0;
		}
		if(posicaoNo < no.obter(posicaoLista).tamanho()){
			valor = (V)no.obter(posicaoLista).obter(posicaoNo).getValor();
			posicaoNo++;
			cont++;
		}
		return valor;
	}

}
