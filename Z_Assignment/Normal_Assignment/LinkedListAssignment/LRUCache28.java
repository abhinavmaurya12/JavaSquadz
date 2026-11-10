//28.How to implement LRU cache in Java using linked list?

//An LRU (Least Recently Used) Cache is a data structure that stores a limited number 
//of elements and removes the least recently used element when the cache becomes full


import java.util.HashMap;

public class LRUCache28 {

    // Doubly Linked List Node
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;

    // Constructor
    public LRUCache28(int capacity) {

        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    // Remove node from linked list
    private void remove(Node node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Insert node immediately after head
    private void insertAtFront(Node node) {

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    // Get value from cache
    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        // Move accessed node to front
        remove(node);
        insertAtFront(node);

        return node.value;
    }

    // Insert or update cache
    public void put(int key, int value) {

        if (capacity <= 0) {
            return;
        }

        // If key already exists
        if (map.containsKey(key)) {

            Node node = map.get(key);
            node.value = value;

            remove(node);
            insertAtFront(node);

        } else {

            // Create new node
            Node node = new Node(key, value);

            // Add to HashMap
            map.put(key, node);

            // Add to front
            insertAtFront(node);

            // Remove least recently used node
            if (map.size() > capacity) {

                Node lru = tail.prev;

                remove(lru);
                map.remove(lru.key);
            }
        }
    }

    // Display cache
    public void display() {

        Node current = head.next;

        System.out.print("Cache: ");

        while (current != tail) {

            System.out.print(
                "(" + current.key + ":" + current.value + ")"
            );

            current = current.next;

            if (current != tail) {
                System.out.print(" <-> ");
            }
        }

        System.out.println();
    }

    // Main method
    public static void main(String[] args) {

        LRUCache28 cache = new LRUCache28(3);

        cache.put(1, 100);
        cache.put(2, 200);
        cache.put(3, 300);

        cache.display();

        System.out.println("Get Key 1: " + cache.get(1));

        cache.display();

        cache.put(4, 400);

        cache.display();

        System.out.println("Get Key 2: " + cache.get(2));

        System.out.println("Get Key 3: " + cache.get(3));
    }
}
