package tabelaHash;

import java.util.Iterator;
import lde.ListaDuplamenteEncadeada;
import vetor.Vetor;

public class TabelaHash<K, V> implements ITabelaHash<K, V>, Iterable<V> {

	private Vetor<ListaDuplamenteEncadeada<No>> map;
	private int tamanho;
	private static final int capacidadeInicial = 16;
	private int rehashSize;
	private static final float cargaMaxima = 0.75f;
	
	
	
	public TabelaHash() {
		map = new Vetor<>(rehashSize = capacidadeInicial);
		this.tamanho = 0;
	}
	
	public TabelaHash(int tamanho){
		map = new Vetor<>(rehashSize = tamanho);
		this.tamanho = 0;
	}
	
	private void rehash(){
		
		rehashSize = rehashSize*2;
		this.tamanho = 0;
		
		Vetor<ListaDuplamenteEncadeada<No>> auxMap = map;
		map = new Vetor<>(rehashSize);
		
		for(ListaDuplamenteEncadeada<No> lista:auxMap){
			if(lista != null){
				for(No no : lista){
					inserir((K)no.getChave(), (V)no.getValor());
				}
			}
		}
	}
	
	public void verificarCarga() {
		if(map.tamanho() > 0){
			float carga = this.tamanho / rehashSize;
			if (carga >= cargaMaxima) {
				rehash();
			}
		}
	}
	
	private int hash(K key) {
		return Math.abs(key.hashCode() % this.rehashSize);
	}
	
	
	
	@Override
	public Iterator<V> iterator() {
		return new Iterador<>(this.map);
	}
	
	
	@Override
	public void inserir(K chave, V valor) {
		
//		No hashNo = new No<K, V>(chave, valor);
//		
//		verificarCarga();
//		int posicao = hash(chave);
//		
//		if(posicao >= map.tamanho()){
//			//throw new IndexOutOfBoundsException();
//		}else if(posicao < map.tamanho()-1 && map.obter(posicao)==null){
//			ListaDuplamenteEncadeada<No> lista = new ListaDuplamenteEncadeada<>();
//			lista.adicionar(hashNo);
//			map.adicionar(posicao, lista);
//			
//		}else{
//			map.obter(posicao).adicionar(hashNo);
//		}
//		this.tamanho++;
		No hashNo = new No<K, V>(chave, valor);

		verificarCarga();

		int posicao = hash(chave);

		if (posicao < map.tamanho() - 1 || map.obter(posicao) == null) {

			ListaDuplamenteEncadeada<No> lista = new ListaDuplamenteEncadeada<>();
			lista.adicionar(hashNo);
			map.adicionar(posicao, lista);

		} else{
			map.obter(posicao).adicionar(hashNo);
		}

		this.tamanho++;
		
	}
	@Override
	public boolean remover(K chave) {
		
		int posicao = hash(chave);
		if(posicao >= this.tamanho || this.tamanho == 0){
			return false;
		}else if(map.obter(posicao) == null){
			return false;
		}else{
			for(No hashNo : map.obter(posicao)){
				if(hashNo.getChave().equals(chave)){
					this.tamanho--;
					return map.obter(posicao).removerContem(hashNo);
				}
			}
		}
		return false;
	}
	
	
	@Override
	public V buscar(K chave) {
		
		int posicao = hash(chave);
		if(posicao >= this.tamanho || this.tamanho ==0){
			return null;
		}else if(this.map.obter(posicao) == null){
			return null;
		}else{
			for(No hashNo : this.map.obter(posicao)){
				if(hashNo.getChave().equals(chave)){
					return (V)hashNo.getValor();
				}
			}
		}
		return null;
	}
	@Override
	public boolean contem(V valor) {
		if(this.tamanho == 0){
			return false;
		}else{
			for(ListaDuplamenteEncadeada<No> lista : this.map){
				for(No hashNo : lista){
					if(hashNo.getValor().equals(valor)){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	@Override
	public int tamanho() {
		return this.tamanho;
	}
	@Override
	public boolean vazio() {
		return this.tamanho == 0;
	}
	
	public int hashSize(){
		return this.rehashSize;
	}
	
	
	@Override
	public void limpar() {
		this.tamanho = 0;
		this.map = new Vetor<>(capacidadeInicial);
		
	}

		
	public String toString() {
		return map.toString();
	}
	

	

}
