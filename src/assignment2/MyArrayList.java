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

    private void increastBuffer() {
        int biggerSize = (int) (arr.length * 1.5);
        Object[] newArr = new Object[biggerSize];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    @Override
    public void add(Object item) {
        if (size == arr.length) {
            increastBuffer();
        }
        arr[size++] = item;
    }

    @Override
    public void addAtIndex(Object item, int index) {
        if (index >= size) throw new ArrayIndexOutOfBoundsException();
        increastBuffer();
        for (int i = size; i >= index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = item;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean remove(T item) {
        int index = indexOf(item);
        if(index >= 0){

            for (int i = 0; i < size; i++) {
                if(item == arr[i]){
                    arr[i] = arr[i+1];
                    break;
                }
            }

            size--;
            return true;
        }
        return false;

    }

    @Override
    public T removeAtIndex(int index) {

        if (index >= size) throw new ArrayIndexOutOfBoundsException();
        T removedItem = get(index);
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i+1];
        }
        arr[--size] = null;
        return removedItem;
    }

    @Override
    public void clear() {

        for (int i = 0; i < size; i++) {
            arr[i] = null;
        }
        size = 0;
    }





}
