package anAVLTree;


import java.util.TreeMap;


public class Test {

	public static void main(String[] args) {

		AVLTree<String, Integer> b = new AVLTree<>();

//		b.insert(50, 2);
//		b.insert(25, 3);
//		b.insert(75, 4);
//		b.insert(12, 5);
//		b.insert(37, 6);
//		b.insert(30, 7);
//		b.insert(33, 8);
//		b.insert(48, 9);
//		b.insert(87, 10);
//		b.insert(93, 11);
//		b.insert(97, 12);
		
		b.insert("A", 2);
		b.insert("G", 3);
		b.insert("T", 4);
		b.insert("Q", 5);
		b.insert("V", 6);
		b.insert("B", 7);
		b.insert("E", 8);
		b.insert("P", 9);
		b.insert("W", 10);
		b.insert("L", 11);
		b.insert("H", 12);
	

		//b.printTree();
		
//		b.printAllPostorder();
//		b.printAllBreadth();
		//System.out.println(b.contains(8));
//		b.printAllPreorder();
		for (Node<?, ?> aux : b.postOrderRecursive()) {
			System.out.print(aux.getKey() +" ");
		}
		System.out.println();
		System.out.println();
		
		for (Node<?, ?> aux : b.getlAllBreadth()) {
			System.out.print(aux.getKey() + " ");
		}
		System.out.println();
		for (Node<?, ?> aux : b.getAllPostorder()) {
			System.out.print(aux.getKey() + " ");
		}
		System.out.println();
		for (Node<?, ?> aux : b.getAllPreorder()) {
			System.out.print(aux.getKey() + " ");
		}
		System.out.println();
		for (Node<?, ?> aux : b.getAllInorder()) {
			System.out.print(aux.getKey() + " ");
		}
	
		
		//System.out.println(b.getAllPreorder());
		

		TreeMap<Integer, Integer> tree = new TreeMap<>();
		tree.put(40, 2);
		tree.put(50, 2);
	
	

		//System.out.println(tree);

	}

}
