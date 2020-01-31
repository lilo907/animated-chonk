package trees;

public class TreeNode {
	
	public TreeNode left;
	public TreeNode right;
	public Object data;
	
	public TreeNode(Object data) {
		this.data = data;
		left = right = null;
	}

}
