import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreesB {
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

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public static int height(Node root) {
            if (root == null)
                return 0;
            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(lh, rh) + 1;
        }

        public static void preorder(Node root) {

            if (root == null) {
                return;
            }
            System.out.println(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        public static void inorder(Node root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }

        public static void postorder(Node root) {
            if (root == null) {
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.data);
        }

        // Level order traversal
        public static void levelOrder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }

        }

        public static int count(Node root) {
            if (root == null)
                return 0;
            int lc = count(root.left);
            int rc = count(root.right);
            return lc + rc + 1;

        }

        public static int sum(Node root) {
            if (root == null)
                return 0;
            int ls = sum(root.left);
            int rs = sum(root.right);
            return ls + rs + root.data;
        }

        // O(n*2) time complexity
        public static int diameter2(Node root) {
    if (root == null)
        return 0;
    int leftDia = diameter2(root.left);
    int leftHt = height(root.left);
    int rightDia = diameter2(root.right);
    int rightHt = height(root.right);

    int selfDia = leftHt + rightHt + 1;
    return Math.max(selfDia, Math.max(leftDia, rightDia));
}


        // O(n)
        static class Info {
            int diam;
            int ht;

            public Info(int diam, int ht) {
                this.diam = diam;
                this.ht = ht;
            }
        }

        public static Info diameter(Node root) {
            if (root == null) {
                return new Info(0, 0);
            }
            Info leftInfo = diameter(root.left);
            Info rightInfo = diameter(root.right);

            int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
            int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

            return new Info(diam, ht);

        }
    


    //         public Info1(Node node,int hd){
    //             this.node = node;
    //             this.hd = hd;
    //         }
    //     }
    //     public static void topView(Node root){
    //         // level order traversal
    //         Queue<Info> q = new LinkedList<>();
    //         HashMap<Integer,Node> map = new HashMap<>();

    //         int min = 0,max = 0;
    //         q.add(new Info1(root,0));
    //         q.add(null);
             
    //     }

    // }

    // given arrays of preorder and inorder traversal return tree
    

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        // System.out.println(root.data);

        // tree.preorder(root);
        // tree.inorder(root);
        // tree.postorder(root);

        // tree.levelOrder(root);

        // System.out.println(tree.count(root));

        System.out.println(tree.sum(root));
        System.out.println(tree.diameter2(root));
        System.out.println(tree.diameter(root).diam);

    }

}
}
