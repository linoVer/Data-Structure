package vetor;

public class Principal {
	
	public static void main(String[] args) throws InterruptedException {
		
         Vetor<Integer> vet = new Vetor<>();
       Thread.sleep(500);
         vet.adicionar(2);
         vet.adicionar(4);
         vet.adicionar(45);
         vet.adicionar(2);
         vet.adicionar(4);
         vet.adicionar(45);
         vet.adicionar(2);
         vet.adicionar(4);
         vet.adicionar(45);
         vet.adicionar(2);
         vet.adicionar(4);
         vet.adicionar(45);
         vet.adicionar(2);
         vet.adicionar(4);
         vet.adicionar(45);
         vet.adicionar(2);
         vet.adicionar(4);
         vet.adicionar(45);
         vet.adicionar(2);
         vet.adicionar(4);
         vet.adicionar(45);
        
         

//        vet.obter(0);
//        //vet.remover(0);
//        System.out.println(vet.obter(0));
	
		//vet.removerValor(4);
		
		for (Integer bbb : vet) {
			System.out.println(bbb);
		}
         //System.out.println(vet.tamanho());
		
		
                
    }

}
