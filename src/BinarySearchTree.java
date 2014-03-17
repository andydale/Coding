
/**  
 * First Take :
 * 		You returned Node from each insert operation in first attempt.
 * 		Need to work on how to remove that one.
 *
 */

public class BinarySearchTree {
	
	public static void main(String args[]){
		Node root=null;
		root=insert(root,10);
		insert(root,100);
		insert(root,101);
		insert(root,120);
		insert(root,130);
		insert(root,160);
		insert(root,170);
		insert(root,180);
//		delete();
//		printTree(root);
	}
	
	private static boolean search(Node root,int i) {
		if(root==null)
			return false;
		if(root.value==i){
			return true;
		}
		else if(root.value > i){
			return search(root.left,i);
		}else{
			return search(root.right,i);
		}
	}

	public static Node insert(Node root,int var){
		if(root==null){
			root=new Node();
			root.value=var;
		}else if(root.value>=var){
			root.left=insert(root.left,var);
		}else{
			root.right=insert(root.right,var);
		}
		return root;
	}
	
	public static class Head{
		Node root; 
	}
	
	public static class Node{
		int value;
		Node left;
		Node right;
	}
}
