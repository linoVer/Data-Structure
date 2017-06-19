
package tabelaHash;

import java.util.HashMap;



public class TesteTabelaHash {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {

		// ITabelaHash<Integer, String> tabela = null;

		// tabela.inserir(10, "Rafael");
		// tabela.inserir(5, "Roberta");
		//
		// tabela.buscar(15);

		TabelaHash<Integer, String> tabela = new TabelaHash<>();
		for (int i = 0; i < 20000; i++){
			tabela.inserir(i, "erw");
		}
		
		
		System.out.println(tabela.tamanho());
    	tabela.remover(0);
//		System.out.println(tabela.tamanho());
//		System.out.println("//");
		//System.out.println(tabela.remover(5));
		System.out.println(tabela.buscar(0));
//		tabela.limpar();
//		System.out.println(tabela.tamanho());
	

	}

}
