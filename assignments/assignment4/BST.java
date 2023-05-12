package org.example;
import java.util.ArrayList;
import java.util.List;

public class BST<K extends Comparable<K>, V> {

    private Node root;

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public Iterable<KeyValuePair<K, V>> iterator() {
        List<KeyValuePair<K, V>> pairs = new ArrayList<>();
        inOrderTraversal(root, pairs);
        return pairs;
    }

    private void inOrderTraversal(Node x, List<KeyValuePair<K, V>> pairs) {
        if (x == null) return;
        inOrderTraversal(x.left, pairs);
        pairs.add(new KeyValuePair<>(x.key, x.val));
        inOrderTraversal(x.right, pairs);
    }

    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private Node put(Node x, K key, V val) {
        if (x == null) return new Node(key, val);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        return x;
    }

    public V get(K key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.val;
        }
        return null;
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node x, K key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            // if node has 0 child
            if (x.left == null && x.right == null) return null;
            // if node has only one child
            if (x.left == null) return x.right; // replacing
            else if (x.right == null) return x.left; // replacing
            // if node has 2 child
            else {
                // we find min value in the right subtree
                x = min(x.right);
                // delete min value in the right subtree
                x.right = deleteMin(x.right);
            }
        }
        return x;
    }

    public int size() {
        return size(root);
    }
    public K min() {
        return min(root).key;
    }
     
    private Node min(Node x) {
        // just go to the left side of the BST while x.left not null
        if (x.left == null) return x;
        else return min(x.left);
    }

    public void deleteMin() {
        deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        return x;
    }
    private int size(Node x) {
        // it will give us size of left subtree + right subtree + root
        if (x == null) return 0;
        return size(x.left) + size(x.right) + 1;
    }

}
