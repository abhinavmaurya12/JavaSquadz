//25How do you find the sum of two linked list using Stack in Java?

//To find the sum of two linked lists using a Stack in Java, we push all digits of both linked
 //lists into separate stacks. Then we pop the digits one by one, add them along with carry, 
 //and construct the result linked list.
 
 
import java.util.Stack;

public class AddTwoLinkedLists25 {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // Add two linked lists using Stack
    public static Node addTwoLists(Node l1, Node l2) {

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        // Push first linked list into stack
        while (l1 != null) {
            s1.push(l1.data);
            l1 = l1.next;
        }

        // Push second linked list into stack
        while (l2 != null) {
            s2.push(l2.data);
            l2 = l2.next;
        }

        int carry = 0;
        Node result = null;

        // Add digits from right to left
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {

            int sum = carry;

            if (!s1.isEmpty()) {
                sum += s1.pop();
            }

            if (!s2.isEmpty()) {
                sum += s2.pop();
            }

            carry = sum / 10;
            int digit = sum % 10;

            // Insert new node at beginning
            Node newNode = new Node(digit);
            newNode.next = result;
            result = newNode;
        }

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

    // Main method
    public static void main(String[] args) {

        // First number: 7243
        Node l1 = new Node(7);
        l1.next = new Node(2);
        l1.next.next = new Node(4);
        l1.next.next.next = new Node(3);

        // Second number: 564
        Node l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(4);

        System.out.println("First Linked List:");
        display(l1);

        System.out.println("Second Linked List:");
        display(l2);

        Node result = addTwoLists(l1, l2);

        System.out.println("Sum Linked List:");
        display(result);
    }
}
