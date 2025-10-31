class Order {
    private String orderId;
    private String customerName;
    private String orderDetails;

    public Order(String orderId, String customerName, String orderDetails) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Customer: " + customerName + ", Details: " + orderDetails;
    }
}

// Node structure for singly linked list
class Node {
    Order data;
    Node next;

    public Node(Order data) {
        this.data = data;
        next = null;
    }
}

class OrdersList {
    private Node head;

    // Append order to end of list
    public void append(Order order) {
        Node newNode = new Node(order);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Display orders in list order
    public void display() {
        if (head == null) {
            System.out.println("No orders in the list.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    // Reverse the linked list in-place
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node nextNode;

        while (current != null) {
            nextNode = current.next; // Save next node
            current.next = prev;     // Reverse pointer
            prev = current;          // Move prev forward
            current = nextNode;      // Move current forward
        }

        head = prev; // New head of reversed list
    }

    public String toListString() {
        if (head == null) return "";
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data.toString()).append("\n");
            current = current.next;
        }
        return sb.toString().trim();
    }
}

public class EcommerceOrderProcessing {
    public static void main(String[] args) {
        OrdersList list = new OrdersList();

        // Test Case 1: Add orders
        list.append(new Order("001", "Alice", "Laptop"));
        list.append(new Order("002", "Bob", "Headphones"));
        list.append(new Order("003", "Charlie", "Smartphone"));
        list.append(new Order("004", "Diana", "Gaming Console"));

        // Test Case 2: Display original order (first-in-first-out)
        System.out.println("Orders in original order (oldest first):");
        list.display();

        // Test Case 3: Reverse the list
        list.reverse();

        // Test Case 4: Display reversed order (most recent first)
        System.out.println("\nOrders after reversal (most recent first):");
        list.display();
    }
}
