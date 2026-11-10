//18. How to swap every two nodes in a linked list? (solution)

//Concept: Iterative Approach using Pointers

//We need to swap every two adjacent nodes in a singly linked list without swapping their data. Instead, we change the links between nodes.

//For example:

//Before swapping:

//10 → 20 → 30 → 40 → 50 → 60

//After swapping:

//20 → 10 → 40 → 30 → 60 → 50
//Logic
//1. Create a dummy node pointing to the head.
//2. Maintain a pointer called current at the dummy node.
//3. Identify the first and second nodes.
//4. Change their links to swap their positions.
//5. Move current two nodes forward.
//6. Repeat until fewer than two nodes remain.


class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SwapPairs18 {

    static Node swapPairs(Node head) {

        Node dummy = new Node(0);
        dummy.next = head;

        Node current = dummy;

        while (current.next != null &&
               current.next.next != null) {

            // First node
            Node first = current.next;

            // Second node
            Node second = first.next;

            // Swap links
            first.next = second.next;
            second.next = first;
            current.next = second;

            // Move to next pair
            current = first;
        }

        return dummy.next;
    }

    // Display linked list
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
        head.next.next.next.next.next = new Node(60);

        System.out.println("Before Swapping:");
        display(head);

        head = swapPairs(head);

        System.out.println("After Swapping:");
        display(head);
    }
}
