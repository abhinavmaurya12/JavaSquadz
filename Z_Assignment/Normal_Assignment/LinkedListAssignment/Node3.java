//3.How to reverse a linked list in Java?


class Node3 {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {

    static Node reverse(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node next = current.next; // Save next node
            current.next = prev;      // Reverse pointer
            prev = current;           // Move prev forward
            current = next;           // Move current forward
        }

        return prev;
    }

    static void display(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        System.out.println("Original list:");
        display(head);

        head = reverse(head);

        System.out.println("Reversed list:");
        display(head);
    }
}
