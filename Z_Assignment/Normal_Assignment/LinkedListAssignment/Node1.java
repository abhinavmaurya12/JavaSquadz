//1.How to find middle element of a singly linked list in one pass?


class Node1 {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {

    static void findMiddle(Node head) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;       // Move one step
            fast = fast.next.next;  // Move two steps
        }

        System.out.println("Middle element: " + slow.data);
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        findMiddle(head);
    }
}