package filaDupEnc;

import java.util.LinkedList;
import java.util.Queue;

public class TesteFilaDupEnc {

	public static void main(String[] args) {
		
		Queue<Integer> f = new LinkedList<>();
		
		f.add(5);
		f.add(7);
		f.add(9);
		
	//	System.out.println(f.peek());
		
		Fila<Integer> fila = new Fila<>();
		
		fila.enfileirar(5);
		fila.enfileirar(7);
		fila.enfileirar(9);
		
		for (Integer ok : fila) {
			System.out.println(ok);
		}
		
		//System.out.println(fila.first().toString());
		
		

	}

}
