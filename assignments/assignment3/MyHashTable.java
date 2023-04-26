package org.example;

public class MyHashTable<K, V> {
    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;

    public MyHashTable() {
        chainArray = new HashNode[M];
    }

    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M];
    }

    public int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(K key, V value) {

        int bucketIndex = hash(key);
        HashNode<K, V> head = chainArray[bucketIndex];

        // If key is already present
        while (head != null) {
            // If keys are equal
            if (head.getKey().equals(key)) {
                head.setValue(value);
                return;
            }
            // If hashcodes are equal
            head = head.getNext();
        }

        // Adding new key to chain
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.setNext(chainArray[bucketIndex]);
        chainArray[bucketIndex] = newNode;
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];
        while (node != null) {
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
            node = node.getNext();
        }
        return null;
    }

    public K getKey(V value) {
        for (HashNode<K, V> node : chainArray) {
            while (node != null) {
                if (node.getValue().equals(value)) {
                    return node.getKey();
                }
                // keep moving in the chain
                node = node.getNext();
            }
        }
        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];
        HashNode<K, V> prev = null; // to search in chain
        while (node != null) {
            if (node.getKey().equals(key)) {
                if (prev == null) {
                    // it shows that there is no next pointer node , it means that in the chain was only one node
                     chainArray[index] = node.getNext();
                } else {
                    prev.setNext(node.getNext());
                }
                size--;
                return node.getValue();
            }
            // if there is keys which have same hashcodes , keep moving in chain
            prev = node;
            node = node.getNext();
        }
        return null;
    }

    public boolean contains(V value) {
        for (HashNode<K, V> node : chainArray) {
            while (node != null) {
                if (node.getValue().equals(value)) {
                    return true;
                }
                node = node.getNext();
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public String toString() {
        // I watched video , where using string builder is faster than string+="char" , so i tried to use string builder which is faster
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {

            sb.append("Chain ").append(i).append(": ");
            HashNode<K, V> node = chainArray[i];
            while (node != null) {
                sb.append(node).append(", ");
                node = node.getNext();
            }
            sb.append("\n");
        }

        return sb.toString();
    }

}

