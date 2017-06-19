package pilhaVetor;

import java.util.Stack;

public class TestePilhaVetor {
	
	public static void main(String args[]){
		
		Stack<Integer> p = new Stack<>();
		
		p.push(1);
		p.push(4);
		p.push(6);
	
		
		
		//System.out.println(p);
		
		Pilha<Integer> pilha = new Pilha<>();
	
		
		pilha.empilhar(1);
		pilha.empilhar(4);
		pilha.empilhar(6);
		
		for (Integer ok : pilha) {
			System.out.println(ok);
		}

		
		//System.out.println(pilha.toString());
		
		
		
		
	}
}
