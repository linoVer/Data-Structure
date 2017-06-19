package lde;

public interface IListaDuplamenteEncadeada<T> extends ILista<T> {
	
	public boolean adicionarNoInicio(T valor);
	public boolean removerDoInicio();
	public T removerDoFim();

}
