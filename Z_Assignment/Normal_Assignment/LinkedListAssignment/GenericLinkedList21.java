//21. How to implement a linked list using Generics in Java?

//Concept: Java Generics (Type Parameter <T>)
//Generics allow us to create a linked list that can store different types of data, such as Integer,
 //String, Double, and custom objects, without writing separate linked-list classes for each data 
 //type.
//Instead of using a fixed data type like int or String, we use a generic type parameter <T>.
//Logic
//1. Create a generic Node<T> class.
//2. Declare the data variable using type T.
//3. Create a generic LinkedList<T> class.
//4. Implement methods such as add(), display(), and size().
//5. Create linked-list objects with different data types.


class Node<T> {

    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class MyLinkedList<T> {

    Node<T> head;

    // Add element at the end
    public void add(T data) {

        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node<T> temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // Display linked list
    public void display() {

        Node<T> temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // Find size of linked list
    public int size() {

        int count = 0;
        Node<T> temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }
}

public class GenericLinkedList21 {

    public static void main(String[] args) {

        // Integer Linked List
        MyLinkedList<Integer> list1 = new MyLinkedList<>();

        list1.add(10);
        list1.add(20);
        list1.add(30);

        System.out.println("Integer Linked List:");
        list1.display();

        // String Linked List
        MyLinkedList<String> list2 = new MyLinkedList<>();

        list2.add("Java");
        list2.add("Python");
        list2.add("C++");

        System.out.println("String Linked List:");
        list2.display();

        // Double Linked List
        MyLinkedList<Double> list3 = new MyLinkedList<>();

        list3.add(10.5);
        list3.add(20.5);
        list3.add(30.5);

        System.out.println("Double Linked List:");
        list3.display();

        System.out.println("Integer List Size: " + list1.size());
    }
}

