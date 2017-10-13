package anAVLTree;

public class Node<Key extends Comparable<Key>, Value> {

	private Node<Key, Value> parent;
	private Node<Key, Value> leftChild;
	private Node<Key, Value> rightChild;

	public Key key;
	public Value value;

	public Node(Key key, Value value, Node<Key, Value> parent) {
		this.key = key;
		this.value = value;
		this.parent = parent;
		rightChild = leftChild = null;
	}
	
	
	public boolean isRightChild(){
		return parent.getRightChild().getKey().compareTo(parent.getKey()) == 1;
	}
	
	public boolean isLeftChild(){
		return parent.getLeftChild().getKey().compareTo(parent.getKey()) == -1;
	}

	public boolean isRoot() {
		return parent == null;
	}

	public boolean isLeaf() {
		return rightChild == null && leftChild == null;
	}

	public Node<Key, Value> getParent() {
		return parent;
	}

	public Node<Key, Value> getLeftChild() {
		return leftChild;
	}

	public Node<Key, Value> getRightChild() {
		return rightChild;
	}

	public Key getKey() {
		return key;
	}

	public Value getValue() {
		return value;
	}

	public void setParent(Node<Key, Value> parent) {
		this.parent = parent;
	}

	public void setLeftChild(Node<Key, Value> leftChild) {
		this.leftChild = leftChild;
	}

	public void setRigthChild(Node<Key, Value> rigthChild) {
		this.rightChild = rigthChild;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public void setValue(Value value) {
		this.value = value;
	}
	

}
