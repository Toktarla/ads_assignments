package assignment2;

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



}
