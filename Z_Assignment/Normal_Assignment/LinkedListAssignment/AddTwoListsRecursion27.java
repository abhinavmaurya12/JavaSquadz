//27. How do you calculate the sum of two linked list using recursion in Java?

//To calculate the sum of two linked lists using recursion in Java, 
//we recursively add corresponding digits of both linked lists along with the carry.

//There are two common approaches:
//1. Reverse-order linked lists: Add digits directly using recursion.
//2. Forward-order linked lists: Align the lists by length and use recursion to add 
//digits from right to left.


public class AddTwoListsRecursion27 {

    // Linked List Node
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // Recursive method to add two linked lists
    static Node addTwoLists(Node l1, Node l2, int carry) {

        // Base condition
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

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

        // Calculate digit and carry
        int digit = sum % 10;
        carry = sum / 10;

        // Create result node
        Node result = new Node(digit);

        // Recursive call
        result.next = addTwoLists(l1, l2, carry);

        return result;
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

        System.out.println("First Linked List:");
        display(l1);

        System.out.println("Second Linked List:");
        display(l2);

        // Add using recursion
        Node result = addTwoLists(l1, l2, 0);

        System.out.println("Sum Linked List:");
        display(result);
    }
}
