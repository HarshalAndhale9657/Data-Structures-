public class BinaryTreeQuestions {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // check if a tree is univalued 
    public static Boolean univalued(Node root){
        if(root==null) return true;
        if(root.left!=null && root.data!=root.left.data)return false;
        if(root.right!=null && root.data!=root.right.data)return false;

        return univalued(root.left) && univalued(root.right);

    }

    // delete x leaf node
    public static void delete(Node root,int n){
        if(root == null) return;
        
         // Check left child
    if (root.left != null) {
        if (root.left.data == n && root.left.left == null && root.left.right == null) {
            root.left = null;
            return;
        }
    }

     if (root.right != null) {
        if (root.right.data == n && root.right.left == null && root.right.right == null) {
            root.right = null;
            return;
        }
    }

    delete(root.left, n);
    delete(root.right, n);

    }





    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(univalued(root));
        
    }
}
