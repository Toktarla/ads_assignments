package assignment2;

import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {

    private class Node {
        T data;
        Node next;
        Node prev;
        public Node(T data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    // These variables represent the first and last nodes of the linked list
    private Node head;
    private Node tail;

    // This variable represent size of the linked list
    private int size;

    public MyLinkedList(){}

    // Prints each Node of linked list
    public void traverse() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }


    // Replaces the data at a specified index with a new data
    public T set(int index, T item) {

        Node current = head;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }

        T oldValue = current.data;
        current.data = item;

        return oldValue;
    }

    // Returns the number of nodes in the linked list
    @Override
    public int size() {
        return size;
    }

    // Adds a new node to the end of the linked list
    @Override
    public void add(T item) {

        Node newNode = new Node(item,null,tail);
        size++;
        if(head == null){
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;

    }

    // Adds a new node at a specified index
    @Override
    public void addAtIndex(T item, int index) {
        if(index == size){
            add(item);
            return;
        }

        Node newNode = new Node(item,null,null);
        if(index == 0){
            newNode.next = head;
            head.prev = newNode;
            head = newNode;

        } else{

            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;


        }
        size++;
    }

    // Returns the data at a specified index
    @Override
    public T get(int index) {
        Node current = head;
        if (index == 0){
            return current.data;
        }

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    // Returns true if the linked list contains a specified data
    @Override
    public boolean contains(T o) {
        return indexOf(o) != -1;
    }

    // Returns the index of the first occurrence of a specified data
    @Override
    public int indexOf(T o) {
        Node current = head;
        int index = 0;
        while (current != null){
            if (current.data.equals(o)){
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    // Returns the index of the last occurrence of a specified data
    @Override
    public int lastIndexOf(T o) {
        Node current = tail;
        int index = size - 1;
        while (current != null){
            if (current.data.equals(o)){
                return index;
            }
            current = current.prev;
            index--;
        }
        return -1;
    }

    // Removes the first occurrence of a specified data from the linked list
    @Override
    public boolean remove(T obj) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(obj)) {
                if (current.prev == null) { // removing head
                    head = current.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else if (current.next == null) { // removing tail
                    tail = current.prev;
                    tail.next = null;
                } else { // removing from middle
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Removes the node at a specified index
    @Override
    public T removeAtIndex(int index) {

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        if (current.prev == null) { // removing head
            head = current.next;
            if (head != null) {
                head.prev = null;
            }
        } else if (current.next == null) { // removing tail
            tail = current.prev;
            tail.next = null;
        } else { // removing from middle
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
        return current.data;
    }

    // Removes all nodes from the linked list
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    // Sorts the linked list in ascending order using the compareTo() method
    @Override
    public void sort() {

        if (size <= 1){
            return;
        }
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i -1; j++) {
                Comparable<T> item1 = (Comparable<T>) get(j);
                Comparable<T> item2 = (Comparable<T>) get(j+1);


                if (item1.compareTo((T) item2) > 0) {
                    T temp = get(j);
                    set(j, get(j + 1));
                    set(j + 1, temp);
                }
            }

        }

    }

    // Returns an iterator object that can be used to traverse the linked list
    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T>{
        Node cursor = head;

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public T next() {
            T data = cursor.data;
            cursor = cursor.next;
            return data;
        }
    }







}
