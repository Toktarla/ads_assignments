import org.example.BST;

public class Main {

    public static void main(String[] args) {

        BST<Integer,String> bst = new BST<>();

        bst.put(1,"A");
        bst.put(3,"C");
        bst.put(5,"B");
        bst.put(2,"E");

        for (var elem : bst.iterator()) {
            System.out.println(elem.key + "->" + elem.value);
        }

        bst.delete(1);
        bst.delete(2);
        System.out.println("-------------------------------");
        for (var elem : bst.iterator()) {
            System.out.println(elem.key + "->" + elem.value);
        }


    }

}
