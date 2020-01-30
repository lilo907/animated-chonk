package gs
public class BinTree {
	
	
	
	BinTree(int key){
		root = new TreeNode(key);
	}
	
	BinTree(){
		root = null;
	}
	
	public static void main(String[] args){
		BinTree bt = new BinTree();
		
		bt.root = new TreeNode(1);
		
	}
	
	
	

}
