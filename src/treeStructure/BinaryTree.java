package treeStructure;

public class BinaryTree {
	private Object root;
	private BinaryTree left, right;
	BinaryTree(Object r){this.root = r;}
	BinaryTree(Object r, BinaryTree l, BinaryTree ri){this.root = r; this.left = l; this.right = ri;}
	
	// getters
	public Object getRoot() {return this.root;}
	public BinaryTree getLeft() {return this.left;}
	public BinaryTree getRight() {return this.right;}
	
	//setters
	public void setRoot(Object x) {this.root = x;}
	public void setLeft(BinaryTree l) {this.left = l;}
	public void setRight(BinaryTree r) {this.right = r;}
	
	// toString methods
	public String PreOrder() {
		StringBuffer t = new StringBuffer("");
		t.append(root+" ");
		if(left!=null) t.append(left.PreOrder());
		if(right!=null) t.append(right.PreOrder());
		return t+"";
	}
	public String PostOrder() {
		StringBuffer t = new StringBuffer("");
		if(left!=null) t.append(left.PostOrder());
		if(right!=null) t.append(right.PostOrder());
		t.append(root+" ");
		return t+"";
	}
	public String InOrder() {
		StringBuffer t = new StringBuffer("");
		if(left!=null) t.append(left.InOrder());
		t.append(root+" ");
		if(right!=null) t.append(right.InOrder());
		return t+"";
	}
	
//	methods
	public boolean isLeaf() {
		if(this.left == null && this.right == null) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		BinaryTree BT1 = new BinaryTree("A", new BinaryTree("B"), 								
							new BinaryTree("C", new BinaryTree("D"), new BinaryTree("E")));
//			A
//		   / \
//		  B	  C
//			 / \
//			D	E
		
		BinaryTree BT2 = new BinaryTree("A", 
							new BinaryTree("B", new BinaryTree("D"), new BinaryTree("E")),
							new BinaryTree("C", null, 
									new BinaryTree("F", 
											null, new BinaryTree("G"))
									)
							);
		
		System.out.println("\t Tree BT1");
		System.out.println(BT1.PreOrder());
		System.out.println(BT1.PostOrder());
		System.out.println(BT1.InOrder());
		
		System.out.println("\t Tree BT2");
		System.out.println(BT2.PreOrder());
		System.out.println(BT2.PostOrder());
		System.out.println(BT2.InOrder());
		
		System.out.println(BT1.isLeaf()); 
		System.out.println(BT1.left.isLeaf()); 
		System.out.println(BT1.right.right.isLeaf()); 
	}
}