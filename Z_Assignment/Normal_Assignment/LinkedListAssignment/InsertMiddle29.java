//29.How to add an element in the middle of a linked list in Java?
//To add an element in the middle of a linked list in Java, we first find the middle 
//position and then insert a new node by adjusting the next pointers.


public class InsertMiddle29 {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Insert element in the middle
    static Node insertMiddle(Node head, int value) {

        Node newNode = new Node(value);

        // Empty linked list
        if (head == null) {
            return newNode;
        }

        Node slow = head;
        Node fast = head;

        // Find middle node
        while (fast.next != null &&
               fast.next.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        // Insert after middle node
        newNode.next = slow.next;
        slow.next = newNode;

        return head;
    }

    // Display linked list
    static void display(Node head) {

        Node current = head;

        while (current != null) {
            System.out.print(current.data);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // Create linked list
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        System.out.println("Original Linked List:");
        display(head);

        // Insert 25 in middle
        head = insertMiddle(head, 25);

        System.out.println("After Insertion:");
        display(head);
    }
}
