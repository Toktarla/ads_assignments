package org.example;
public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, String> table = new MyHashTable<>(100);
        for (int i = 0; i < 10000; i++) {

            MyTestingClass key = new MyTestingClass(i, "Key" + i);
            table.put(key, "Value"+ i);
        }

        System.out.println(table);
    }
}