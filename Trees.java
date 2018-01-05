// NodeTree
public class Trees{
	public static void main(String[]args){
		NodeTree tree = new NodeTree(1);
		tree.left = new NodeTree(1);
		tree.right = new NodeTree(1);
		tree.left.right = new NodeTree(1);
		System.out.println(tree.height(tree));
	}
}
class NodeTree{
	int value;
	NodeTree left;
	NodeTree right;
	public NodeTree(int value){
		this.value = value;
	}
	int height(NodeTree node){
		if(node == null)
			return -1;
		int left = height(node.left);
		int right = height(node.right);

		return (left>right)? left+1 :right+1;
	}
}