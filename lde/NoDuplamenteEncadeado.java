package lde;

public class NoDuplamenteEncadeado<T> {
	
	private NoDuplamenteEncadeado<T> proximo;
	private NoDuplamenteEncadeado<T> anterior;
    private T valor;
    
    
	public NoDuplamenteEncadeado() {
		
		this.proximo = proximo;
		this.anterior = anterior;
		this.valor = valor;
	}


	public NoDuplamenteEncadeado<T> getProximo() {
		return proximo;
	}


	public void setProximo(NoDuplamenteEncadeado<T> proximo) {
		this.proximo = proximo;
	}


	public NoDuplamenteEncadeado<T> getAnterior() {
		return anterior;
	}


	public void setAnterior(NoDuplamenteEncadeado<T> anterior) {
		this.anterior = anterior;
	}


	public T getValor() {
		return valor;
	}


	public void setValor(T valor) {
		this.valor = valor;
	}   

}
