package anAVLTree;

import java.util.Collection;

public interface IAVLTree<Key, Value>{

	public boolean insert(Key key, Value value);

	public boolean remove(Key key);

	public boolean contains(Value value);

	public int size();

	public boolean isEmpty();

	public void clear();
	
	public Node<?, ?> smallestNode();
	
	public Node<?, ?> biggestNode();
	
	@SuppressWarnings("rawtypes")
	public Collection<Node> getAllPreorder();
	
	@SuppressWarnings("rawtypes")
	public Collection<Node> getAllPostorder();
	
	@SuppressWarnings("rawtypes")
	public Collection<Node> getAllInorder();

	@SuppressWarnings("rawtypes")
	public Collection<Node> getlAllBreadth();
	

	
	

}
