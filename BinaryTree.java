//import libs
import java.util.*;
import javax.swing.tree.TreeNode;

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
    root = deleteRecursive(root, data);
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
    return searchRecursive(root, data);
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
  
  //traverse algorithm by Rohan Patel
  public void traverse() {
    preOrderTraversal(root);
    System.out.println();
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
    System.out.println("Creating new empty BinaryTree \"bt\"");
    BinaryTree bt = new BinaryTree();
    
    //insert test
    System.out.println("Inserting values to bt:");
    System.out.println("\t5 7 0 -3 9 15 45 -27");
    bt.insert(5);
    bt.insert(7);
    bt.insert(0);
    bt.insert(-3);
    bt.insert(9);
    bt.insert(15);
    bt.insert(45);
    bt.insert(-27);

    //traverse test
    System.out.println("Traversing bt...");
    bt.traverse();
    
    //search test
    System.out.println("Searching if 1 exists in bt");
    System.out.println("\t" + bt.search(1));
    System.out.println("Searching if 15 exists in bt");
    System.out.println("\t" + bt.search(15));
    
    //delete test
    System.out.println("Deleting 15 from bt");
    bt.delete(15);
    System.out.println("Searching if 15 exists in bt");
    System.out.println("\t" + bt.search(15));

    System.out.println("Traversing bt");
    bt.traverse();
  }
}
