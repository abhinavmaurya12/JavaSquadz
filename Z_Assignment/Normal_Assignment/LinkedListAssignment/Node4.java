//4.How to reverse a singly linked list without recursion in Java?



class Node4 {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {

    static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node next = current.next; // Save next node
            current.next = prev;      // Reverse the link
            prev = current;           // Move prev forward
            current = next;           // Move current forward
        }

        return prev;
    }

    static void display(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        System.out.println("Original Linked List:");
        display(head);

        head = reverseList(head);

        System.out.println("Reversed Linked List:");
        display(head);
    }
}
