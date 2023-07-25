//import libs
import java.util.*;

/*BinaryTree class
  Implementation of BinaryTree
*/

import javax.swing.tree.TreeNode;

public class BinaryTree{
  //fields
  Node current;

  //constructors
	BinaryTree(){
		current = null;
	}
	
  //methods
  /*insert method that recursively adds data to the binary tree
		written by Henry Kim
  */
	public void insert(int data){
		current = insertRecursive(current, data);
	}
	
	/*recursive portion of insert method
		starting from current, check if current node is null
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
	
    //remove method that deletes given data in a binary tree
    //written by Adrian Egasan
    public void delete(int data){
		current = deleteRecursive(current, data);
	}

    //checks if current node is null which means we reached a leaf node or empty tree
    //if the delete's data is less than node's data go left, if greater go right
    //checks if only one child then returns that, if both available find inorder successor
    //once found the data is deleted from the binary tree
    //written by Adrian Egasan
	public static Node deleteRecursive(Node current, int data) {

        if (current == null)
            return current;

        if (data < (int) current.data) {
            current.left = deleteRecursive(current.left, data);

        } else if (data > (int) current.data) {
                        current.right = deleteRecursive(current.right, data); 

        } else {
            if (current.left == null) {
                return current.right;
            } else if (current.right == null)
                return current.left;

            current.data = getSuccessor(current.right);
            current.right = deleteRecursive(current.right, (int) current.data);
        }

        return current;

    }

    public static int getSuccessor(Node current) {
        int min = (int) current.data;
        while (current.left != null) {
            min = (int) current.left.data;
            current = current.left;
        }
        return min;
    }

  /*search method that recursively searches for data in binary tree
		written by Henry Kim
  */
	public boolean search(int data){
		return searchRecursive(current, data);
	}
	
	/*recursive portion of search method
		starting from current, check if current node is null
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
  //traverse

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
		
		System.out.println(bt.current.data);
		System.out.println(bt.current.left.data);
		System.out.println(bt.current.right.data);
		
		//search test
		System.out.println(bt.search(3));
		System.out.println(bt.search(4));

        //delete test
        bt.delete(4);
        System.out.println(bt.search(4));
      }
}