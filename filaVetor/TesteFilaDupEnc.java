package filaVetor;

public class TesteFilaDupEnc {

	public static void main(String[] args) {
		

		
	//	System.out.println(f.peek());
		
		Fila<Integer> fila = new Fila<>();
		
		fila.enfileirar(5);
		fila.enfileirar(7);
		fila.enfileirar(9);
		fila.desenfileirar();
		
		for (Integer ok : fila) {
			System.out.println(ok);
		}
		
		//System.out.println(fila.first().toString());
		
		

	}

}
