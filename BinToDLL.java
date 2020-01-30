package amazon;

public class BinToDLL {
	
	class Node{
		int data;
		Node left, right;
		
		public Node(int data){
			this.data = data;
			left = right = null;
		}
	}
	
	class Tree{
		Node root;
		
		Node head;
		
		void convertTree(Node root){
			if(root == null){
				return;
			}
			
			convertTree(root.right);
			root.right = head;
			
			
			if(head != null){
				head.left = root;
			}
			head = root;
			convertTree(root.left);
			}
		
		void printList(Node head){
			System.out.println("list: ");
			while(head != null){
				System.out.println(head.data + " ");
				head = head.right;
			}
		}
	}
	
	public static void main(String[] args){
		
	}

}
