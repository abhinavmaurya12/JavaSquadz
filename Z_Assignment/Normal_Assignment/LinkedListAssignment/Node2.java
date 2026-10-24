//2.How to check if linked list contains loop in Java? How to find the starting node of 
the loop

class Node2 {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {

    // Find the starting node of a loop.
    // Returns null if no loop exists.
    static Node detectLoopStart(Node head) {

        Node slow = head;
        Node fast = head;

        // Phase 1: Detect the loop
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Phase 2: Find loop starting node
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null; // No loop
    }

    public static void main(String[] args) {

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        // Create a loop: 50 -> 30
        head.next.next.next.next.next = head.next.next;

        Node start = detectLoopStart(head);

        if (start != null) {
            System.out.println("Loop detected!");
            System.out.println("Loop starts at node: " + start.data);
        } else {
            System.out.println("No loop found.");
        }
    }
}