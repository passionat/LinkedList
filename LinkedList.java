// Singly linked list implementation with insert, delete, print and size operations
package dsa;

// Node Class
class Node{
    int data;
    Node next; 

    // default constructor

    Node(){} // used for dummy node

    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }

    Node(int data){
        this.data = data;
        this.next = null;

    }
}
// Class linked list
class LL{

    Node head;


    public void insert(int data){
        Node n = new Node(data);
        if(head == null){
            head = n;
        }else{
            Node temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = n;
        }
    }
    // method for inserting at beginning
    public void insertbeg(int data){
        Node n = new Node(data);
        if(head == null){
            head= n;
            return;
        }
        n.next = head;
        head = n;
    }
    // method for inserting at certain index
    public void insertindex(int data, int x){

        int trav = 0;
        Node temp = head;
        while (trav + 1 != x){
            temp = temp.next;
            trav = trav + 1;
        }
        Node n = new Node(data);
        n.next = temp.next;
        temp.next = n;

    }
  // method for deleting first element
    public int delFirst(){
        int deleted_value = head.data;
        head = head.next;
        return deleted_value;

    }
// method for deleting last element
    public int deleteLast(){

        Node temp = head;
        if(head.next == null){
            int d = head.data;
            head = null;
            return d;
        }
        while (temp.next.next != null){
            temp = temp.next;
        }
        int d = temp.data;
        temp.next = temp.next.next;
        return  d;
    }
  // method for deleting at cetain index
    public int delIndex(int index){
        int trav = 0;
        Node temp = head;
        while (trav +1 != index){
            temp = temp.next;
            trav = trav + 1;
        }
        int val = temp.next.data;
        temp.next = temp.next.next;
        return val;

    }
  // method for printing node values
    public void printVal(){
        Node temp = head;
        while (temp != null){
            if(temp.next == null){
                System.out.print(temp.data);
            }else{
                System.out.print(temp.data + "->");
            }
            temp = temp.next;


        }

    }
  // method for finding size of linked list
    public int findSize(){
        if(head == null){
            return 0;
        }
        int size = 1;
        Node temp = head;
        while (temp != null){
            size = size + 1;
            temp = temp.next;
        }
        return size;
    }
}

public class LinkedList {

    public static void main(String[] args) {
      // create linked list object
        LL obj = new LL();
        obj.insert(12);
        obj.insertbeg(11);
        obj.insert(8);
        obj.insertindex(34,2);
        obj.printVal();
        System.out.println();
        obj.findSize(); // 4
        System.out.println();
        obj.delFirst(); // 11
        obj.deleteLast(); // 8
        obj.printVal();
        System.out.println();
        obj.delIndex(1);
        obj.printVal(); // 12


    }


}
