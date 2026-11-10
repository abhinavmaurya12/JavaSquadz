//19. How to find the frequency of a given number in a Linked List?
//Concept: Traversal Approach

//We can find the frequency of a given number in a singly linked list by traversing the entire list and counting how many times the given number appears.

//Logic:
//1. Initialize a counter variable count = 0.
//2. Start traversing the linked list from the head.
//3. Compare each node's data with the given number.
//4. If both values match, increment the counter.
//5. Continue until the end of the linked list.
//6. Return the final count.


class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class FrequencyLinkedList19 {

    // Find frequency of a given number
    static int findFrequency(Node head, int key) {

        int count = 0;

        Node temp = head;

        while (temp != null) {

            if (temp.data == key) {
                count++;
            }

            temp = temp.next;
        }

        return count;
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

        // Create linked list
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(10);
        head.next.next.next = new Node(30);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.next = new Node(40);

        System.out.println("Linked List:");
        display(head);

        int key = 10;

        int frequency = findFrequency(head, key);

        System.out.println("Number: " + key);
        System.out.println("Frequency: " + frequency);
    }
}
