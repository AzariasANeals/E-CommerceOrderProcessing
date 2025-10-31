
/**
 * Write a description of class OrderProcessing here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

class Order{
    private String orderId;
    private String customerName;
    private String orderDetails;

    public Order(String orderId, String customerName, String orderDetails){
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString(){
        return "Order ID: " + orderId + ", Customer Name: " + customerName + ", Order Details: " + orderDetails;
    }

}
class Node{
    Order data;
    Node next;

    public Node(Order data){
        this.data = data;
        next = null;
    }
}

class OrdersList{
    private Node head;

    public void append(Order order){
        Node newNode = new Node(order);
        if (head == null){
            head = newNode;
            return;
        }

        Node current = head;
        while(current.next != null){
            current = current.next;
        }

        current.next = newNode;
    }

    public void display(){
        if(head == null){
            System.out.println("No orders in the list");
            return;
        }
        Node current = head;
        while (current!= null){
            System.out.println(current.data);
            current = current.next;
        }

    }

    public void reverse(){
        Node prev = null;
        Node current = head;
        Node nextNode;

        while (current != null){
            nextNode = current.next; // Save the next node
            current.next = prev; // Reverse pointer
            prev = current; // Move the prev forward
            current = nextNode; // Move current forward
        }

        head = prev; // New head of the reversed list

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


public class EcommerceOrderProcessing{
    public static void main(String[] args){
        OrdersList list = new OrdersList();

        list.append(new Order("001", "Azarias", "Computer"));            
        list.append(new Order("002", "Alex", "Smart Phone"));            
        list.append(new Order("003", "Brittany", "Keyboard"));            
        list.append(new Order("004", "Ashley", "Trombone"));            
        list.append(new Order("005", "Brian", "Trash Can"));        

        System.out.println("Orders in original order");
        list.display();

        list.reverse();

        System.out.println("\n Orders reversed (most recent order first");
        list.display();

    }

}

