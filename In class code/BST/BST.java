import java.util.Deque;
import java.util.LinkedList;

public class BST <K extends Comparable<K>> {
    private TreeNode<K> root;
    private int size;
    
    public BST() {
        this.root = null;
        this.size = 0;
    }
    
    public int size() {
        return this.size;
    }
    
    public boolean insert(K key) {
        if (this.root == null) {
            this.root = new TreeNode<K>(key);
            this.size++;
            return true;
        }
        
        TreeNode<K> currentNode = this.root;
        
        while (true) {
            if (key.equals(currentNode.getKey())) {
                return false;
            }
            
            if (key.compareTo(currentNode.getKey()) < 0) {
                if (currentNode.left == null) {
                    currentNode.left = new TreeNode<K>(key);
                    break;
                }
                
                currentNode = currentNode.left;
            }
            else {
                if (currentNode.right == null) {
                    currentNode.right = new TreeNode<K>(key);
                    break;
                }
                
                currentNode = currentNode.right;
            }
        }
        
        this.size++;
        return true;
    }
    
    public void inOrder() {
        TreeNode<K> currentNode = this.root;
        Deque<TreeNode<K>> stack = new LinkedList<>();
        
        while(stack.size() > 0 || currentNode != null) {
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            else {
                currentNode = stack.pop();
                System.out.print(currentNode.getKey() + " ");
                currentNode = currentNode.right;
            }
        }
        
    }
    
    
    public boolean contains(K key) {
        TreeNode<K> currentNode = this.root;
        
        while (currentNode != null) {
            if (key.equals(currentNode.getKey())) {
                return true;
            }
            
            if (key.compareTo(currentNode.getKey()) < 0) {
                currentNode = currentNode.left;
            }
            else {
                currentNode = currentNode.right;
            }
        }
        
        return false;
    }
}