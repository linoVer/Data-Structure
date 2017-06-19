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
public interface ILista<Tipo> {
    public boolean adicionar(Tipo valor);
    public boolean adicionar(int posicao, Tipo valor);
    public Tipo obter(int posicao);
    public Tipo remover(int posicao);
    public boolean removerContem(Tipo valor);
    public boolean contem(Tipo valor);
    public int tamanho();
    public void limpar();
    

}
