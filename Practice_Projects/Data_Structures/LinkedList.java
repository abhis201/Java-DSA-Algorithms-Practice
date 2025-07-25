package Data_Structures;

public class LinkedList{

    Node head; // head of list
    Node last;

    // Linked list Node.
    // Node is a static nested class
    // so main() can access it
    static class Node {
  
        int data;
        Node next;
  
        // Constructor
        Node(int d) 
        {
            data = d;
            next = null;
        }
    }
  
    // Method to insert a new node
    public static LinkedList insert(LinkedList list,int data)
    {
        // Create a new node with given data
        Node new_node = new Node(data);
        new_node.next = null;
  
        // If the Linked List is empty,
        // then make the new node as head
        if (list.head == null) {
            list.head = new_node;
            list.last = list.head;
        }
        else {
            // Else traverse till the last node
            // and insert the new_node there
            list.last.next = new_node;
            list.last = list.last.next;
            /* use this method when last node is not present
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
  
            // Insert the new_node at last node
            last.next = new_node;
            */
        }
  
        // Return the list by head
        return list;
    }
  
    // Method to print the LinkedList.
    public static void printList(LinkedList list)
    {
        Node currNode = list.head;
  
        System.out.print("LinkedList: ");
  
        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");
  
            // Go to next node
            currNode = currNode.next;
        }
    }

    //Method to delete a node
    public static LinkedList delete(LinkedList list, int value)
    {
        Node currnode = list.head;

        if(list.head.data==value)
        {
            if(length(list)==1)
            {
                list.last=list.last.next;
            }
            list.head = list.head.next;
            currnode = null;
            System.out.println("The only node was deleted :" + value);
        }
        else
        {
            while(currnode.next.data!=value){
                currnode = currnode.next;
            }
            Node delnode = currnode.next;
            if(delnode==list.last){
                list.last=currnode;
                currnode.next=null;
            }
            else{
            currnode.next = delnode.next;
            }
            delnode = null;
            System.out.println("The node with data "+ value +" is deleted.");
            
        }
        return list;
    }

    public static boolean isEmpty(LinkedList list)
    {
        return list.head==null;
    }

    public static int length(LinkedList list)
    {
        Node currnode = list.head;
        int count=0;
        if(currnode==null) return 0;
        else{
            while(currnode!=null)
            {
                currnode = currnode.next;
                count++;
            }
        }
        return count;
    }
  
    // **************MAIN METHOD**************
  
    // method to create a Singly linked list with n nodes
    public static void main(String[] args)
    {
        /* Start with the empty list. */
        LinkedList list = new LinkedList();
  
        //
        // ******INSERTION******
        //
  
        // Insert the values
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 7);
        list = delete(list, 7);
        list = insert(list, 8);;
        list = delete(list, 8);
        printList(list);
        System.out.println("\nLength: "+length(list));
        System.out.println(isEmpty(list));
        list = insert(list, 9);
        list = insert(list, 11);

        System.out.println("Head of List: "+list.head.data);
        System.out.println("Tail of List: "+list.last.data);
  
        // Print the LinkedList
        printList(list);

    }
}