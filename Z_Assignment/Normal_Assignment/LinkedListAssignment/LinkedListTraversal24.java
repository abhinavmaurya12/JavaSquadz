//24.How do you traverse a linked list in Java?

//Traversing a linked list means visiting each node one by one, starting from the head node
 //and continuing until the last node (null).
//In Java, we generally use a while loop and a temporary reference (current) to traverse a
// singly linked list.


class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListTraversal24 {

    public static void main(String[] args) {

        // Creating nodes
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        // Traversing the linked list
        Node current = head;

        System.out.println("Linked List Elements:");

        while (current != null) {

            System.out.print(current.data + " ");

            current = current.next;
        }
    }
}
