package org.example;

public class MyTestingClass {
    private int key;
    private String value;

    public MyTestingClass(int key, String value) {
        this.key = key;
        this.value = value;
    }

    //  Tune your hashCode method in MyTestingClass so that it does not violate the uniform distribution
    @Override
    public int hashCode() {


        int hash = 17;
        hash = 31 * hash + key;
        hash = 31 * hash +value.hashCode();
        return hash;
    }

    @Override
    public String toString() {
        return "MyTestingClass{" + "key=" + key + ", value='" + value + '\'' + '}';
    }
}
