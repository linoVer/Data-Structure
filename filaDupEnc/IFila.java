package filaDupEnc;

public interface IFila<T> extends Iterable<T>{
	
	public void enfileirar(T elemento);
	public boolean desenfileirar();
	public T first();
	public int tamanho();
	public boolean isEmpty();
	public void limpar();
	
}
