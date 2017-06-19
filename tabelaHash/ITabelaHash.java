/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelaHash;

/**
 *
 * @author 11645
 */
public interface ITabelaHash<K, V> extends Iterable<V>{
	
    public void inserir(K chave, V valor);
    public boolean remover(K chave);
    public V buscar(K chave);
    public boolean contem(V valor);
    public int tamanho();
    public boolean vazio();
    public void limpar();
}
