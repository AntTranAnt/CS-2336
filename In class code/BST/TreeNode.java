

public class TreeNode <K extends Comparable<K>> {
    public TreeNode<K> left;
    public TreeNode<K> right;
    private K key;
    
    public TreeNode(K key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }
    
    public K getKey() {
        return this.key;
    }
}