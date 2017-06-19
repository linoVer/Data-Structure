package pilhaEncadeada;

import java.util.Stack;

public class TestePilhaListaDupEncadeada {
	
	public static void main(String args[]){
		
		Stack<Integer> p = new Stack<>();
		
		p.push(1);
		p.push(4);
		p.push(6);
		//p.clear();
		
		
		
		//System.out.println(p.pop());
		
		Pilha<Integer> pilha = new Pilha<>();
		
		pilha.empilhar(1);
		pilha.empilhar(4);
		pilha.empilhar(6);
		//pilha.limpar();
		
		System.out.println("Tamanho " + pilha.tamanho());
		//System.out.println(pilha.topo().toString());
		
		for (Integer ok : pilha) {
			System.out.println(ok);
		}
		
		
//		for (int i = 0; i < pilha.tamanho(); i++) {
//			System.out.println(pilha.topo().toString());
//			pilha.desempilhar();
//		}
//		System.out.println(pilha.topo().toString());
		
		

		
		
		
		
	}
}
