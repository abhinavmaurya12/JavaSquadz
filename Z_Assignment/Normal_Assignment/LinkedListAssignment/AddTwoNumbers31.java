//31.How do add two numbers represented using linked list in Java?

//To add two numbers represented using linked lists in Java, we traverse both linked lists 
//simultaneously, add their corresponding digits, calculate the carry, and create a new linked
// list containing the result.


public class AddTwoNumbers31 {

    // Linked List Node
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Add two numbers represented by linked lists
    static Node addTwoNumbers(Node l1, Node l2) {

        Node dummy = new Node(0);
        Node current = dummy;

        int carry = 0;

        // Traverse both linked lists
        while (l1 != null || l2 != null || carry != 0) {

            int sum = carry;

            // Add first list digit
            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }

            // Add second list digit
            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }

            // Calculate carry
            carry = sum / 10;

            // Calculate digit
            int digit = sum % 10;

            // Create new node
            current.next = new Node(digit);

            current = current.next;
        }

        return dummy.next;
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

        // First number: 342
        Node l1 = new Node(2);
        l1.next = new Node(4);
        l1.next.next = new Node(3);

        // Second number: 465
        Node l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(4);

        System.out.println("First Number:");
        display(l1);

        System.out.println("Second Number:");
        display(l2);

        // Add two numbers
        Node result = addTwoNumbers(l1, l2);

        System.out.println("Sum:");
        display(result);
    }
}
