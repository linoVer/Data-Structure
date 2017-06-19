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
public interface IListaSimplesmenteEncadeada<T> extends ILista<T>{
    public boolean adicionarNoInicio(T valor);
    public T removerDoInicio();
    public T removerDoFim();
}
