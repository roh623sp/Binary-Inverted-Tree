//import libs
import java.util.*;

/*BinaryTree class
  Implementation of BinaryTree
*/
public class BinaryTree{
  //fields
  Node root;

  //constructors
	BinaryTree(){
		root = null;
	}
	
  //methods
  /*insert method that recursively adds data to the binary tree
		written by Henry Kim
  */
	public void insert(int data){
		root = insertRecursive(root, data);
	}
	
	/*recursive portion of insert method
		starting from root, check if current node is null
		if null add new node with data
		otherwise check if data goes to left or right of current node
		written by Henry Kim
  */
	private Node insertRecursive(Node current, int data){
		if (current == null){
			return new Node(data);
		}
		
		if (data < current.data){
			current.left = insertRecursive(current.left, data);
		}
		else if(data > current.data){
			current.right = insertRecursive(current.right, data);
		}
		else{
			return current;
		}
		
		return current;
	}
	
  //remove
	
	
  /*search method that recursively searches for data in binary tree
		written by Henry Kim
  */
	public boolean search(int data){
		return searchRecursive(root, data);
	}
	
	/*recursive portion of search method
		starting from root, check if current node is null
		if null return false
		otherwise check if data may exist left or right of current node
		if data exists return true
		written by Henry Kim
  */
	private boolean searchRecursive(Node current, int data){
		if (current == null){
			return false;
		}
		
		if (data == current.data){
			return true;
		}
		
		if (data < current.data){
			return searchRecursive(current.left, data);
		}
		else{
			return searchRecursive(current.right, data);
		}
	}
  //traverse algorithm by Rohan Patel
	  public void traverse() {
    preOrderTraversal(root);
  }

  private void preOrderTraversal(Node node) {
    if (node == null) {
      return;
    }

    System.out.print(node.data + " ");
    preOrderTraversal(node.left);
    preOrderTraversal(node.right);
  }

  /*Node class containing int for data, as well as pointers to left and right Nodes
		written by Henry Kim
  */
	public class Node{
		int data;
		Node left, right;
		
		public Node(){
			this(0);
		}
		
		public Node(int data){
			this.data = data;
			left = right = null;
		}
	}
  
  //driver func/test script
  public static void main(String[] args){
    //vars
		BinaryTree bt = new BinaryTree();
		
		//test methods
		
		//insert test
		bt.insert(5);
		bt.insert(6);
		bt.insert(4);
		
		System.out.println(bt.root.data);
		System.out.println(bt.root.left.data);
		System.out.println(bt.root.right.data);
		
		//search test
		System.out.println(bt.search(3));
		System.out.println(bt.search(4));
  }
}
