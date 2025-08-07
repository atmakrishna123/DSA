public class BST {
    static class TreeNode{
        int data;
        TreeNode left,right;
        TreeNode(int data){
            this.data=data;
            left=right=null;
        }
    }
    TreeNode root;
    void insert(int data){
        root=insertRec(root,data);
    }
    TreeNode insertRec(TreeNode root,int data){
        if (root==null){
            return new TreeNode(data);
        }else if (data<root.data){
            root.left=insertRec(root.left,data);
        }else if (data>root.data){
            root.right=insertRec(root.right,data);
        }else{
            return(root);
        }
        return(root);
    }
    boolean search(int data){
        return searchRec(root,data);
    }
    boolean searchRec(TreeNode root,int data){
        if (root==null){
            return(false);
        }
        if (root.data==data){
            return(true);
        }else if (data<root.data){
            return(searchRec(root.left,data));
        }else{
            return(searchRec(root.right,data));
        }
    }
    void delete(int data){
        root=deleteRec(root,data);
    }
    TreeNode deleteRec(TreeNode root,int data){
        if (root==null){
            return(root);
        }
        if (data<root.data){
            root.left=deleteRec(root.left,data);
        }else if (data>root.data){
            root.right=deleteRec(root.right,data);
        }else{
            if (root.left==null){
                return(root.right);
            }
            if (root.right==null){
                return(root.left);
            }
            root.data=minValue(root.right);
            root.right=deleteRec(root.right,root.data);
        }
        return(root);
    }
    int minValue(TreeNode root){
        while (root.left!=null){
            root=root.left;
        }
        return(root.data);
    }
    void preorder(){
        preorderTraversal(root);
        System.out.println();
    }
    void preorderTraversal(TreeNode root){
        if (root!=null){
            System.out.print(root.data+" ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }
    void postorder(){
        postOrderTraversal(root);
        System.out.println();
    }
    void postOrderTraversal(TreeNode root){
        if (root!=null){
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data+" ");
        }
    }
    void inorder(){
        inOrderTraversal(root);
        System.out.println();
    }
    void inOrderTraversal(TreeNode root){
        if (root!=null){
            inOrderTraversal(root.left);
            System.out.print(root.data+" ");
            inOrderTraversal(root.right);
        }
    }
    int findMinValue(){
        if (root==null){
            System.out.println("Minimum operation failed. Binary Tree is Empty");
            return(-1);
        }
        return(minValue(root));
    }
    int findMaxValue(){
        if (root==null){
            System.out.println("Maximum operation failed. Binary Tree is empty");
            return(-1);
        }
        TreeNode current=root;
        while (current.right!=null){
            current=current.right;
        }
        return(current.data);
    }
    public static void main(String[] args) {
        BST bst = new BST();
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int val : values) {
            bst.insert(val);
        }
        System.out.println("Inorder traversal: ");
        bst.inorder();
        System.out.println("Preorder traversal: ");
        bst.preorder();
        System.out.println("Postorder traversal: ");
        bst.postorder();
        System.out.println("Search 40: " + bst.search(40));
        System.out.println("Search 90: " + bst.search(90));
        System.out.println("Min value: " + bst.findMinValue());
        System.out.println("Max value: " + bst.findMaxValue());
        bst.delete(30);
        System.out.println("After deleting 30: ");
        bst.inorder();
    }
}
