public class Classroom {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;

        }
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;

        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;

    }

    public static int count(Node root) {
        if (root == null) {
            return 0;
        }
        int lc = count(root.left);
        int rc = count(root.right);
        return lc + rc + 1;
    }

    public static int sum(Node root) {
        if (root == null) {
            return 0;
        }
        int rs = sum(root.left);
        int ls = sum(root.right);
        return rs + ls + root.data;
    }

    // kth level sum of a tree
    public static void kLevelSum(Node root, int level, int k) {
        if (root == null)
            return;
        if (level == k) {
            System.out.println(root.data);
            return;
        }

        kLevelSum(root.left, level + 1, k);
        kLevelSum(root.right, level + 1, k);
    }

    // kth ancestor of a node

    public static int KAncestor(Node root, int n, int k) {
        if (root == null)
            return -1;
        if (root.data == n) {
            return 0;
        }
        int leftDist = KAncestor(root.left, n, k);
        int rightDist = KAncestor(root.right, n, k);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }

        int max = Math.max(leftDist, rightDist);
        if (max + 1 == k) {
            System.out.println(root.data);
        }
        return max + 1;
    }

    //sum Tree
    public static int transform(Node root){
        if(root == null)return 0;
        int leftChild =  transform(root.left);
        int rightChild =  transform(root.right);

        int data = root.data;
        int newLeft = root.left == null ? 0:root.left.data;
        int newRight = root.left == null ? 0:root.left.data;

        root.data = newLeft+leftChild+newRight+rightChild;
        return data;

    }

    public static void preorder(Node root){
        if(root==null)return;
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {

        /*
         * 1
         * / \
         * 2 3
         * / \ / \
         * 4 5 6 7
         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // System.out.println(height(root));
        // System.out.println(count(root));
        // System.out.println(sum(root));
        // kLevelSum(root,0,2);
        int n = 5, k = 1;
        KAncestor(root, n, k);

    }

}
