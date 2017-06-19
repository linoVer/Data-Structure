package lde;

public class LDE {

	public static void main(String[] args) {

		ListaDuplamenteEncadeada<Integer> nums = new ListaDuplamenteEncadeada<>();

		nums.adicionarNoInicio(2);		
		nums.adicionarNoInicio(6);
		nums.adicionarNoInicio(8);

		nums.adicionar(10);
		nums.adicionar(20);
		nums.adicionar(15);
		nums.removerDoInicio();
		
		for (Integer num : nums) {
			System.out.println(num);
		}
		

//		for(int i = 0; i < num.tamanho() ; i++){
//			System.out.print(num.obter(i) + " ");
//		}
//		System.out.println();
//		num.adicionar(2, 50);
//		for(int i = 0; i < num.tamanho() ; i++){
//			System.out.print(num.obter(i) + " ");
//		}
//		num.remover(5);
//		num.removerDoFim();
//		num.removerDoInicio();
//		System.out.println(num.contem(34));
//		for(int i = 0; i < num.tamanho() ; i++){
//			System.out.print(num.obter(i) + " ");
//		}
//		System.out.println();
//		System.out.println("Aqui");
//		num.removerContem(20);
//		for(int i = 0; i < num.tamanho() ; i++){
//			System.out.print(num.obter(i) + " ");
//		}

//		System.out.println();
//		System.out.print("Remove do inicio: ");		
//		num.removerDoInicio();
//		for(int i = 0; i < num.tamanho() ; i++){
//			System.out.print(num.obter(i) + " ");
//		}
//
//		System.out.println();
//		System.out.print("Remove do fim: ");
//		num.removerDoFim();
//		for(int i = 0; i < num.tamanho() ; i++){
//			System.out.print(num.obter(i) + " ");		
//		}
//		
//		System.out.println();
//		System.out.print("Remove: ");
//		num.remover(2);
//		for(int i = 0; i < num.tamanho() ; i++){
//			System.out.print(num.obter(i) + " ");		
//		}
//		num.limpar();
//		System.out.println();
//		System.out.println("Tamanho: " + num.tamanho());
//		System.out.println(num.getInicio());
//		System.out.println(num.getFim());
//		System.out.println(num.contem(2));
		
	}
}
