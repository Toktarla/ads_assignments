package assignment2;

public class MyArrayList<T> implements MyList<T>{

    private static Object[] arr;
    private int size;
    public MyArrayList() {
        this(5);
    }

    public MyArrayList(int initialCapacity) {
        arr = new Object[initialCapacity];
    }


}
