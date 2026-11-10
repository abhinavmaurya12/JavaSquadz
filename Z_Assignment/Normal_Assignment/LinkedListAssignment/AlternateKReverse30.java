//30.How do you reverse every alternate k nodes of a Linked List in Java?
//To reverse every alternate K nodes of a linked list, we reverse the first K nodes, 
//skip the next K nodes without reversing them, and repeat this process until the linked list ends.


public class AlternateKReverse30 {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Reverse alternate K nodes
    static Node reverseAlternateK(Node head, int k) {

        if (head == null || k <= 0) {
            return head;
        }

        Node current = head;
        Node previous = null;
        Node next = null;

        boolean reverse = true;

        while (current != null) {

            // Reverse K nodes
            if (reverse) {

                Node last = current;
                previous = null;

                int count = 0;

                while (current != null && count < k) {

                    next = current.next;

                    current.next = previous;

                    previous = current;
                    current = next;

                    count++;
                }

                // Connect reversed group
                last.next = current;

                // Update head
                if (head == last) {
                    head = previous;
                }

                reverse = false;
            }

            // Skip next K nodes
            else {

                int count = 0;

                while (current != null && count < k) {

                    previous = current;
                    current = current.next;

                    count++;
                }

                reverse = true;
            }
        }

        return head;
    }

    // Display linked list
    static void display(Node head) {

        while (head != null) {

            System.out.print(head.data);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // Create linked list
        Node head = new Node(1);

        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next.next.next.next = new Node(10);

        System.out.println("Original Linked List:");
        display(head);

        int k = 3;

        head = reverseAlternateK(head, k);

        System.out.println("After Reversing Alternate K Nodes:");
        display(head);
    }
}
