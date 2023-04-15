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





}
