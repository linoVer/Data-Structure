
package pilhaEncadeada;

public interface IPilha<T> extends Iterable<T> {
	
    public void empilhar(T elemento);
    public boolean desempilhar();
    public T topo();
    public int tamanho();
    public boolean vazia();
    public void limpar();
}
