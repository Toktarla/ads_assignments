package assignment2;

public interface MyList<T> extends Iterable<T>{
    int size();

    boolean contains(T o);

    void add(T item);

    void addAtIndex(T item, int index);

    boolean remove(T item);

    T removeAtIndex(int index);

    void clear();

    T get(int index);

    abstract int indexOf(T o);

    int lastIndexOf(T o);

    void sort();
}