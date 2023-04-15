package assignment2;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList();
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();

        myArrayList.add(5);
        myArrayList.add(6);
        myArrayList.add(7);
        myArrayList.add(9);
        myArrayList.add(9);
        myArrayList.add(9);
        myArrayList.sort();
        myArrayList.remove(2);
        myArrayList.remove((Integer) 9);
        System.out.println("Size of Array: " + myArrayList.size());
        System.out.println("Get index of Array: " + myArrayList.get(2));
        System.out.println("Contains item: " + myArrayList.contains(5));
        System.out.println("Index of item: " + myArrayList.indexOf(9));

        System.out.println("Last Index of item: " + myArrayList.lastIndexOf(8));
        for(Object item : myArrayList){
            System.out.print(item + " ");
        }

        myLinkedList.add(5);
        myLinkedList.add(8);
        myLinkedList.add(10);
        myLinkedList.add(1);
        myLinkedList.add(555);
        System.out.println(myLinkedList.get(1));
        myLinkedList.removeAtIndex(1);
        myLinkedList.remove(555);
        System.out.println(myLinkedList.indexOf(5));
        System.out.println(myLinkedList.lastIndexOf(1));
        myLinkedList.addAtIndex(100,0);
        myLinkedList.sort();
        myLinkedList.traverse();






    }


}