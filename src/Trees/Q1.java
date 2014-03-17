package Trees;

//TODO

/**
 * Tree to linklist conversion.
 * @author ydalal
 *
 */

public class Q1 {
	static Node top=null;
	
	public static void main(String args[]){

		//Create a BST
		Node root=null;
		
		root=insert(root,78);
		insert(root,33);
		insert(root,33);
		insert(root,44);
		
//		for(int i=0;i<=5;i++){
//			int val=(int)(Math.random()*100);
//			System.out.println(val);
//			root=insert(root,val);
//		}
		
		
		printTree(root);
		System.out.println("");
		
		Node curr=null;
		getList(root,curr);
		printList(top);
	}
	
	private static void printList(Node head){
		if(head==null)
			return;
		System.out.print(head.data+" ");
		printList(head.right);
	}
	
	private static void getList(Node root, Node curr) {
		if(root==null)
			return;
//		System.out.println(root.data);
		getList(root.left,curr);		
		if(top==null){		
			top=curr=root;
		}else{
			if(curr==null){
				curr=top;
			}
			curr.right=root;
			curr=curr.right;
		}
		getList(root.right,curr);
		
	}

	private static void printTree(Node root) {
		if(root==null)
			return;
		printTree(root.left);
		System.out.print(root.data+" ");
		printTree(root.right);
		
	}

	public static Node insert(Node root,int value){
		
		if(root==null){
			return new Node(value);
		}
		if(value >= root.data){
			root.right=insert(root.right,value);
		}else{
			root.left=insert(root.left,value);
		}
		return root;
	}
	
	static class Node{
		Node left;
		Node right;
		int data;
		public Node(int value){
			left=null;
			right=null;
			data=value;
		}
	}
	
}
