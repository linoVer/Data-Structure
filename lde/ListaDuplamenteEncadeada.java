package lde;

import java.util.Iterator;

public class ListaDuplamenteEncadeada<T> implements IListaDuplamenteEncadeada<T> ,  Iterable<T>{

	private NoDuplamenteEncadeado<T> inicio;
	private NoDuplamenteEncadeado<T> fim;
	private int tamanho;
	

	public ListaDuplamenteEncadeada() {

		this.inicio = null;
		this.fim = null;
		this.tamanho = 0;
	}	

	@Override
	public boolean adicionarNoInicio(T valor) {

		NoDuplamenteEncadeado<T> no = new NoDuplamenteEncadeado<T>();
		no.setValor(valor);		
		if(this.tamanho == 0){
			this.inicio = this.fim = no;
			this.tamanho++;
		}else{
			no.setProximo(this.inicio);
			no.setAnterior(null);
			this.inicio.setAnterior(no);
			this.inicio = no;
			this.tamanho++;
		}		
		return true;
	}

	@Override
	public boolean adicionar(T valor) {

		NoDuplamenteEncadeado<T> no = new NoDuplamenteEncadeado<T>();
		no.setValor(valor);	
		if(this.inicio == null){
			this.inicio = this.fim = no;
			this.tamanho++;
		}else{
			this.fim.setProximo(no);
			no.setAnterior(this.fim);
			this.fim = no;
			this.fim.setProximo(null);
			this.tamanho++;
		}
		return true;
	}

	@Override
	public boolean adicionar(int posicao, T valor) {
		
		NoDuplamenteEncadeado<T> no, temp, novoNo = new NoDuplamenteEncadeado<>();
		novoNo.setValor(valor);
		double aux = this.tamanho/2;
		
		if(this.tamanho == 0 || posicao < 0){
			throw new IndexOutOfBoundsException();			
		}else if(posicao == this.tamanho){
			adicionar(valor);
		}else if(posicao == 0){
			adicionarNoInicio(valor);
		}else{
			if(aux >= posicao){
				no = this.inicio;
				for (int i = 0; i < posicao - 1; i++) {
					no = no.getProximo();
				}
				temp = no.getProximo();
				no.setProximo(novoNo);
				novoNo.setProximo(temp);
				novoNo.setAnterior(no);
				temp.setAnterior(novoNo);
				this.tamanho++;
				
			}else{
				no = this.fim;
				for (int i = this.tamanho-1; i > posicao; i--) {
					no = no.getAnterior();					
				}
				temp = no.getAnterior();
				temp.setProximo(novoNo);
				novoNo.setProximo(no);
				no.setAnterior(novoNo);
				novoNo.setAnterior(temp);
				this.tamanho++;				
			}		
		}
		return true;
	}

	@Override
	public boolean removerDoInicio() {
		
		if(this.tamanho == 0){
			throw new IndexOutOfBoundsException();
		}else if(this.tamanho == 1){
			this.inicio = this.fim = null;
		}else{
			this.inicio = this.inicio.getProximo();
			this.inicio.setAnterior(null);
		}
		this.tamanho--;
		return true;

//		NoDuplamenteEncadeado<T> aux;
//		if(this.tamanho == 0){
//			throw new IndexOutOfBoundsException();			
//		}else{
////			this.inicio = this.inicio.getProximo();
////			this.inicio.setAnterior(null);
//			aux = this.inicio.getProximo();
//			this.inicio = null;
//			this.inicio = aux;
//			this.tamanho--;			
//		}		
//		return null;
	}

	@Override
	public T removerDoFim() {

		NoDuplamenteEncadeado<T> no = new NoDuplamenteEncadeado<T>();

		if(this.tamanho == 0){
			throw new IndexOutOfBoundsException();			
		}else{
			no = this.fim.getAnterior();
			this.fim.setValor(null);
			//System.out.println(no);
			this.fim = no;
			this.fim.setProximo(null);
			this.tamanho--;
		}
		return null;
	}
	
	@Override
	public T remover(int posicao) {

		NoDuplamenteEncadeado<T> no, remove = new NoDuplamenteEncadeado<>();
		double aux = this.tamanho/2;

		if(this.tamanho == 0 || posicao < 0){
			throw new IndexOutOfBoundsException();			
		}else if(posicao == this.tamanho-1){
			removerDoFim();
		}else if(posicao == 0){
			removerDoInicio();
		}else{
			
			if(aux <= posicao){
				no = this.inicio;
				for (int i = 0; i < posicao; i++) {
					no = no.getProximo();
				}
				
			}else{
				no = this.fim;
				for (int i = this.tamanho-1; i > posicao; i--) {
					no = no.getAnterior();
				}
			}
			no.getAnterior().setProximo(no.getProximo());
			no.getProximo().setAnterior(no.getAnterior());
			
			this.tamanho--;			
		}		
		return null;
	}

	@Override
	public boolean removerContem(T valor) {	
		
		
		if(this.inicio.getValor().equals(valor)){
			return (boolean) removerDoInicio();
		}else if(this.fim.getValor().equals(valor)){
			return (boolean) this.removerDoFim();
		}
		NoDuplamenteEncadeado<T> aux = this.inicio;
		
		for (int i = 0; i < this.tamanho; i++) {
			if(aux.getValor().equals(valor)){
				aux.getProximo().setAnterior(aux.getAnterior());
				aux.getProximo().setProximo(aux.getProximo());
				this.tamanho--;
				return true;
			}else{
				aux = aux.getProximo();
			}
		}
		return false;
	
//		if(this.tamanho == 0){
//			throw new IndexOutOfBoundsException();			
//		}else{
//			for (int i = 0; i < this.tamanho; i++) {
//				if(obter(i).equals(valor)){
//					remover(i);
//					return true;
//				}
//			}
//		}	
//		return false;
	}

	@Override
	public boolean contem(T valor) {
		
		NoDuplamenteEncadeado<T> no = this.inicio;
	
		for (int i = 0; i < this.tamanho; i++) {
			if(no.getValor().equals(valor)){
				return true;
			}else{
				no = no.getProximo();
			}
		}
		
		return false;
	}

	@Override
	public int tamanho() {
		return this.tamanho;
	}

	@Override
	public void limpar() {
				
		while(this.tamanho > 1){
			removerDoInicio();
		}
		this.inicio = this.fim = null;
		this.tamanho = 0;
	}

	@Override
	public T obter(int indice) {
		
		NoDuplamenteEncadeado<T> no = new NoDuplamenteEncadeado<T>();

		if(this.tamanho == 0){
			throw new IndexOutOfBoundsException();			
		}else if(indice< 0 || indice > this.tamanho-1){
			throw new IndexOutOfBoundsException();
		}else if(indice == 0) {
			return this.inicio.getValor();
		}else if(indice == this.tamanho - 1) {
			return this.fim.getValor();
		}else{
			
			if(indice > this.tamanho/2){
				no = this.fim;
				for (int i = this.tamanho-1; i > indice; i--) {
					no = no.getAnterior();
				}	
				
			}else{
				
				no = this.inicio;				
				for (int i = 0; i < indice; i++) {
					no = no.getProximo();
				}	
			}		
		}			
		return no.getValor();
	}

	public NoDuplamenteEncadeado<T> getInicio() {
		return inicio;
	}

	public NoDuplamenteEncadeado<T> getFim() {
		return fim;
	}

	@Override
	public Iterator<T> iterator() {
		lde.Iterador<T> it = new lde.Iterador<>(inicio);
		return it;
	}

	






}
