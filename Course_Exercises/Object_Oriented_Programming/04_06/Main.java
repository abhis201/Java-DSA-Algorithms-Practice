public class Main {

    public static Node<Integer> deleteMiddle(Node<Integer> head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        Node<Integer> slow = head;
        Node<Integer> fast = head;

        Node<Integer> previous = null;

        while(fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            previous = slow;
            slow = slow.getNext();
        }

        // Delete middle node
        previous.setNext(slow.getNext());

        return head;
    }

    public static void printLinkedList(Node<Integer> head) {
        while(head != null) {
            System.out.print(head.getData() + ", ");
            head = head.getNext();
        }
        System.out.println("END");
    }

    public static Node<Integer> buildNode(int data) {
        Node node = new Node();
        node.setData(data);
        node.setNext(null);
        return node;
    }

    public static void main(String[] args) {

        Node<Integer> head = buildNode(8);
        Node<Integer> nodeA = buildNode(3);
        Node<Integer> nodeB = buildNode(18);
        Node<Integer> nodeC = buildNode(12);
        Node<Integer> nodeD = buildNode(1);

        head.setNext(nodeA);
        nodeA.setNext(nodeB);
        nodeB.setNext(nodeC);
        nodeC.setNext(nodeD);

        printLinkedList(head);
        deleteMiddle(head);
        printLinkedList(head);
        deleteMiddle(head);
        printLinkedList(head);
    }

}












