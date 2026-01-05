// conditions of bst
// 1 left subtree nodes < root
// 2 right subtree nodes > root
// 3 left & right subtrees are also BST with no duplicates

// inorder traversal for bst is always sorted


class BST{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    public static Node insert(Node root,int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(val < root.data){
            root.left =  insert(root.left,val);
        }else{
            root.right = insert(root.right,val);
        }
        return root;
    }
    
    public static void inorder(Node root){
        if(root == null)return ;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    
    }


    // size of largest bst
    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST,int size,int min,int max){
            this.isBST=isBST;
            this.size=size;
            this.min=min;
            this.max=max;

        }
    }

    public static int maxBST = 0;
    public static Info largestBST(Node root){
        if(root==null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer
            .MIN_VALUE);
        }

        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);

        int size = leftInfo.size+rightInfo.size+1;
        int min = Math.min(root.data,Math.min(leftInfo.min,rightInfo.min));
        int max = Math.min(root.data,Math.max(leftInfo.max,rightInfo.max));

        if(root.data <= leftInfo.max || root.data >= rightInfo.min){
            return new Info(false, size, min, max);
        }
        if(leftInfo.isBST && rightInfo.isBST){
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }
        return new Info(false, size, min, max);

    }

   


    public static void main(String[] args) {
        int values[] = {5,1,3,4,2,7};
        Node root = null;

        for(int i=0;i<values.length;i++){
            root = insert(root,values[i]);
        }

        inorder(root);

        Info info = largestBST(root);
        System.out.println("largest BST size = "+ maxBST);
         
    }
}