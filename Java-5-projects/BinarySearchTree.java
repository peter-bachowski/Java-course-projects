public class BinarySearchTree<T extends Comparable<T>>{

    private TreeNode<T> root;
    private int size;

    //constructors
    public BinarySearchTree(){
        root = null;
    }
    //setters and getters here
    public TreeNode<T> getRoot(){return root;}
    public int getSize(){return size;}


    //methods
    public void add(T newData){
        if(newData == null){
            throw new NullPointerException("You cannot add null data. Please try again.");
        }
        else{
            size++;
            root = insertRecursive(root, newData);
        }
    }
    private TreeNode<T> insertRecursive(TreeNode<T> current, T data){
        if(current == null){ // if root is null case
            return new TreeNode<T>(data);
        }
        if (data.compareTo(current.getData()) < 0) { /*if the data being added is less than the current node's data, traverse left*/
            current.setLeft(insertRecursive(current.getLeft(), data));
        } else if (data.compareTo(current.getData()) > 0) {/*if the data being added is more than the current node's data, traverse right*/
            current.setRight(insertRecursive(current.getRight(), data));
        } else {
            // data already exists
            return current;
        }
        return current;
    }


    public void preOrderTraversal(){
        root = preOrderTraversalAlgorithm(root);
        System.out.println();
    }
    private TreeNode<T> preOrderTraversalAlgorithm(TreeNode<T> current){
        if(current.getLeft() == null && current.getRight() == null){
            System.out.print(current.getData() + " ");
            return current;
        }
        else{
            System.out.print(current.getData() + " ");
            if(current.getLeft() != null){
                current.setLeft(preOrderTraversalAlgorithm(current.getLeft()));
            }
            if(current.getRight() != null){
                current.setRight(preOrderTraversalAlgorithm(current.getRight()));
            }
        }
        return current;
    }


    public void inOrderTraversal(){
        root = inOrderTraversalAlgorithm(root);
        System.out.println();
    }
    private TreeNode<T> inOrderTraversalAlgorithm(TreeNode<T> current){
        if(current.getLeft() == null && current.getRight() == null){
            System.out.print(current.getData() + " ");
            return current;
        }
        else{
            if(current.getLeft() != null){
                current.setLeft(inOrderTraversalAlgorithm(current.getLeft()));
            }

            System.out.print(current.getData() + " ");

            if(current.getRight() != null){
                current.setRight(inOrderTraversalAlgorithm(current.getRight()));
            }
        }
        return current;
    }

    public void postOrderTraversal(){
        root = postOrderTraversalAlgorithm(root);
        System.out.println();
    }
    private TreeNode<T> postOrderTraversalAlgorithm(TreeNode<T> current){
        if(current.getLeft() == null && current.getRight() == null){
            System.out.print(current.getData() + " ");
            return current;
        }
        else{
            if(current.getLeft() != null){
                current.setLeft(postOrderTraversalAlgorithm(current.getLeft()));
            }
            if(current.getRight() != null){
                current.setRight(postOrderTraversalAlgorithm(current.getRight()));
            }
            System.out.print(current.getData() + " ");
        }
        return current;
    }

    public T remove(T data){
        if(data == null){
            throw new NullPointerException("You cannot remove null data. Please try again."); 
        }
        TreeNode<T> dummy = new TreeNode<T>();
        root = removeAlgorithm(root, data, dummy);
        return dummy.getData();
    }
    private TreeNode<T> removeAlgorithm(TreeNode<T> current, T data, TreeNode<T> dummy){
        if(current == null){
            System.out.println("The data you are trying to remove does not exist!");
            return current;
        }
        else if(data.compareTo(current.getData()) < 0){
            current.setLeft(removeAlgorithm(current.getLeft(), data, dummy));
        }
        else if(data.compareTo(current.getData()) > 0){
            current.setRight(removeAlgorithm(current.getRight(), data, dummy));
        }
        else{
            dummy.setData(data);
            size--;
            if(current.getLeft() == null && current.getRight() == null){
                return null;
            }
            else if(current.getLeft() != null && current.getRight() == null){
                return current.getLeft();
            }
            else if(current.getRight() != null && current.getLeft() == null){
                return current.getRight();
            }
            else{
                TreeNode<T> dummy2 = new TreeNode<>();
                current.setRight(removeSuccessor(current.getRight(), dummy2));
                current.setData(dummy2.getData());
            }
            return current;
        }
        return current;
    }
    private TreeNode<T> removeSuccessor(TreeNode<T> current, TreeNode<T> dummy){
        if(current.getLeft() == null){
            dummy.setData(current.getData());
            return current.getRight();
        }
        else{
            current.setLeft(removeSuccessor(current.getLeft(), dummy));
        }
        return current;
    }
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree1 = new BinarySearchTree<>();
        tree1.add(50);
        tree1.add(15);
        tree1.add(5);
        tree1.add(25);
        tree1.add(20);
        tree1.add(75);
        tree1.add(100);
        tree1.remove(15);
        tree1.preOrderTraversal();
        tree1.inOrderTraversal();
        tree1.postOrderTraversal();
    }
}

