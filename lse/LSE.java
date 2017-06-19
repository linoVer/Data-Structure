/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lse;

/**
 *
 * 
 */
public class LSE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


    	ListaSimplesmenteEncadeada<Integer> num = new ListaSimplesmenteEncadeada<Integer>();
    	
    	num.adicionarNoInicio(1);
    	num.adicionarNoInicio(4);
    	num.adicionarNoInicio(8);
    	num.adicionarNoInicio(7);
    	
    	for (int i = 0; i < num.tamanho(); i++) {
			System.out.print(num.obter(i) + " ");
		}
    	System.out.println();
    	
    	num.removerContem(7);
    	for (int i = 0; i < num.tamanho(); i++) {
			System.out.print(num.obter(i) + " ");
		}
    	
    	
    	
    }
    
}
