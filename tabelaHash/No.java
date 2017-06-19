package tabelaHash;

public class No<K, V> {
	
	private K chave;
	private V valor;
	
	public No(K chave, V valor){
		this.chave = chave;
		this.valor = valor;
	}

	public K getChave() {
		return chave;
	}

	public V getValor() {
		return valor;
	}

}
