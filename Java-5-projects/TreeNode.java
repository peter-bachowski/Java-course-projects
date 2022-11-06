public class TreeNode<T>{ //inner node class for the binary search tree
    private T data;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(){
        this(null, null, null);
    }
    public TreeNode(T data){
        this(data, null, null);
    }
    public TreeNode(T data, TreeNode<T> left, TreeNode<T> right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
    public T getData(){return data;}
    public void setData(T newData){data = newData;}
    public TreeNode<T> getLeft(){return left;}
    public void setLeft(TreeNode<T> newLeft){left = newLeft;}
    public TreeNode<T> getRight(){return right;}
    public void setRight(TreeNode<T> newRight){right = newRight;}
}
