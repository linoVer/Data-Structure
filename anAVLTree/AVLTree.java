package anAVLTree;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Stack;

public class AVLTree<Key extends Comparable<Key>, Value> implements IAVLTree<Key, Value> {

	private Node<Key, Value> root;
	private int size;
	private Node<Key, Value> current;

	public AVLTree() {
		this.root = null;
		this.size = 0;
	}

	@Override
	public boolean insert(Key key, Value value) {

		this.current = this.root;
		if (this.root == null) {
			this.root = new Node<Key, Value>(key, value, null);
		} else {
			while (!(key.compareTo(current.getKey()) == 0)) {

				if (key.compareTo(current.key) > 0 && current.getRightChild() == null) {
					current.setRigthChild(new Node<Key, Value>(key, value, current));
					break;
				} else if (key.compareTo(current.getKey()) > 0 && current.getRightChild() != null) {
					current = current.getRightChild();
				} else if (key.compareTo(current.getKey()) < 0 && current.getLeftChild() == null) {
					current.setLeftChild(new Node<Key, Value>(key, value, current));
					break;
				} else if (key.compareTo(current.getKey()) < 0&& current.getLeftChild() != null) {
					current = current.getLeftChild();
				}
			}
			if (key.compareTo(current.getKey()) == 0) {
				current.setValue(value);
				return true;
			}
		}
		this.size++;
		return true;
	}

	@Override
	public boolean remove(Key key) {

		current = search(key);
		if (current == null) {
			return false;
		} else if (current.isRoot()) {
			root = null;
		}
		// if it is a leaf node
		else if (current.isLeaf()) {
			if (current.isRightChild()) {
				current.getParent().setRigthChild(null);
			} else {
				current.getParent().setLeftChild(null);
			}
		} // if the node has one child
		else if (current.getRightChild() != null && current.getLeftChild() == null) {
			current.getRightChild().setParent(current.getParent());
			current = null;
		} else if (current.getLeftChild() != null && current.getRightChild() == null) {
			current.getLeftChild().setParent(current.getParent());
			current = null;
		}
		// if the node has two children
		else if (current.getRightChild() != null && current.getLeftChild() != null) {
			current = getSuccessor(key);
			getSuccessor(key).getParent().setLeftChild(null);
		}
		this.size--;
		return true;
	}

	@Override
	public boolean contains(Value value) {

		Stack<Node<Key, Value>> stack = new Stack<>();

		if (this.size == 0) {
			throw new NullPointerException("Empty Tree");
		} else {

			this.current = root;
			stack.push(current);
			while (!stack.isEmpty() && !current.getValue().equals(value)) {
				current = stack.pop();
				if (current.getLeftChild() != null) {
					stack.push(current.getLeftChild());
				}
				if (current.getRightChild() != null) {
					stack.push(current.getRightChild());
				}
			}
		}
		return current.getValue().equals(value);
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public void clear() {
		this.root = new Node<Key, Value>(null, null, null);
		this.size = 0;

	}

	@Override
	public Node<Key, Value> smallestNode() {
		if (this.root == null) {
			throw new NullPointerException("Empty Tree");
		} else {
			this.current = root;
			while (this.current.getLeftChild() != null) {
				this.current = this.current.getLeftChild();
			}
		}
		return this.current;
	}

	@Override
	public Node<Key, Value> biggestNode() {
		if (this.root == null) {
			throw new NullPointerException("Empty Tree");
		} else {
			this.current = root;
			while (this.current.getRightChild() != null) {
				this.current = this.current.getRightChild();
			}
		}
		return this.current;
	}

	public Node<Key, Value> search(Key key) {

		this.current = this.root;
		if (this.size == 0) {
			throw new NullPointerException("Empty Tree");
		} else {
			while (current != null && !(key.compareTo(current.getKey()) == 0)) {

				if (key.compareTo(current.getKey()) > 0) {
					current = current.getRightChild();
				} else {
					current = current.getLeftChild();
				}
			}
		}
		return current;
	}

	private Node<Key, Value> getSuccessor(Key key) {

		Node<Key, Value> successor = null;

		if (this.size == 0) {
			throw new NullPointerException("Empty Tree");
		} else {
			this.current = search(key);
			successor = this.current.getRightChild();
			while (this.current.getLeftChild() != null) {
				successor = successor.getLeftChild();
			}
			// this.current = successor;
			// successor.getParent().setLeftChild(null);
		}
		return successor;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Collection<Node> getAllPreorder() {

		LinkedList<Node> visited = new LinkedList<>();
		Stack<Node> stack = new Stack<>();
		Node<Key, Value> aux = null, aux2 = null;

		if (this.size == 0) {
			throw new NullPointerException("Empty Tree");
		} else {
			this.current = this.root;
			visited.add(this.current);
			stack.push(current);

			while (visited.size() != this.size) {

				while (current.getLeftChild() != null && current.getLeftChild() != aux
						&& current.getLeftChild() != aux2) {
					current = current.getLeftChild();
					visited.add(current);
					stack.push(current);
				}
				if (current.getRightChild() != null && current.getRightChild() != aux) {
					current = current.getRightChild();
					visited.add(current);
					stack.push(current);
				} else {
					aux = stack.pop();
					current = stack.peek();
					aux2 = current.getLeftChild();
				}
			}
		}
		return visited;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Collection<Node> getAllPostorder() {

		LinkedList<Node> visited = new LinkedList<>();
		Stack<Node> stack = new Stack<>();
		Node<?, ?> aux = null, aux2 = null;

		if (this.size == 0) {
			throw new NullPointerException("Empty Tree");
		} else {
			this.current = this.root;
			stack.push(current);
			while (visited.size() != this.size) {
				while (current.getLeftChild() != null && current.getLeftChild() != aux
						&& current.getLeftChild() != aux2) {
					current = current.getLeftChild();
					stack.push(current);
				}
				if (current.getRightChild() != null && current.getRightChild() != aux) {
					current = current.getRightChild();
					stack.push(current);
				} else if (current.getLeftChild() == null || current.getLeftChild() == aux2) {
					aux = stack.pop();
					visited.add(aux);
					if (this.root.equals(aux)) {
						break;
					} else {
						current = stack.peek();
						aux2 = current.getLeftChild();
					}
				}
			}
		}
		return visited;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Collection<Node> getAllInorder() {

		LinkedList<Node> visited = new LinkedList<>();
		Stack<Node> stack = new Stack<>();
		Node<Key, Value> aux = null, aux2 = null;

		if (this.size == 0) {
			throw new NullPointerException("Empty Tree");
		} else {
			this.current = this.root;
			stack.push(current);
			while (visited.size() != this.size) {

				while (current.getLeftChild() != null && current.getLeftChild() != aux2) {
					current = current.getLeftChild();
					stack.push(current);
				}
				if (current.getLeftChild() == null && current != aux2) {
					visited.add(current);
					aux2 = stack.pop();
				} else if (current.getLeftChild() != null && current.getRightChild() != null && current != aux) {
					visited.add(current);
					aux = stack.pop();
				} else if (current.getRightChild() != null) {
					current = current.getRightChild();
					stack.push(current);
				} else {
					if (current.equals(stack.peek())) {
						visited.add(stack.pop());
						current = current.getParent();
						aux2 = current.getLeftChild();
					} else {
						current = stack.peek();
						aux2 = current.getLeftChild();
					}
				}
			}
		}
		return visited;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Collection<Node> getlAllBreadth() {

		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Node> aux = new LinkedList<>();

		if (this.size == 0) {
			throw new NullPointerException("Empty Tree");
		} else {
			this.current = this.root;
			aux.add(current);
			while (queue.size() != this.size) {
				queue.add(this.current);
				if (current.getLeftChild() != null) {
					aux.add(current.getLeftChild());
				}
				if (current.getRightChild() != null) {
					aux.add(current.getRightChild());
				}
				aux.poll();
				this.current = aux.peek();
			}
		}
		return queue;
	}
	

	public Collection<Node<Key, Value>> preorderRecursive(){
		LinkedList<Node<Key, Value>> list = new LinkedList<>();
		preorderRecursive(root,list);
		return list;
	}
	
	private void preorderRecursive(Node<Key,Value> node, LinkedList<Node<Key, Value>> list){
		if (node != null) {
			list.add(node);
			preorderRecursive(node.getLeftChild(),list);
			preorderRecursive(node.getRightChild(),list);
		}
	}
	
	
	public Collection<Node<Key, Value>> inorderRecursive(){
		LinkedList<Node<Key, Value>> list = new LinkedList<>();
		inorderRecursive(root,list);
		return list;
	}
	
	private void inorderRecursive(Node<Key,Value> node, LinkedList<Node<Key, Value>> list){
		if (node != null) {
			inorderRecursive(node.getLeftChild(),list);
			list.add(node);
			inorderRecursive(node.getRightChild(),list);
		}
	}
	
	public Collection<Node<Key, Value>>postOrderRecursive() {
		LinkedList<Node<Key, Value>> list = new LinkedList<>();
		postOrderRecursive(root,list);
		return list;
	}
	
	private void postOrderRecursive(Node<Key,Value> node, LinkedList<Node<Key, Value>> list){
		if (node != null) {
			postOrderRecursive(node.getLeftChild(),list);
			postOrderRecursive(node.getRightChild(),list);
			list.add(node);
		}
	}

}
