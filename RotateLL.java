package dsa;
// the problem state is to rotate a linked list for k times
// Algorithm
// 1) make the list - a circular linked list
// 2) numberofrotations = k % n (n = number of nodes)
// 3) traverse to l = n - numberofrotations spaces
// 4) l.next = null - break the link

public class RotateLL {
  
    public static void main(String[] args) {
        LL1 obj = new LL1();
        obj.insert(1);
        obj.insert(2);
        obj.insert(3);
        obj.insert(4);
        obj.insert(5);
        obj.printLL1(obj.head);
        ListNode x = obj.rotateList(obj.head,3);
        obj.printLL1(x);


    }



}
class LL1{
    ListNode head;
    LL1(){ // creation of linked list obj
        head = null;
    }
    public void insert(int data){
        ListNode n = new ListNode(data);
        if(head == null){

            head = n;
            return;
        }
        ListNode temp = head;

        while (temp.next != null){
            temp = temp.next;

        }
        temp.next = n;
    }
    public ListNode rotateList(ListNode first, int k){

        // corner cases
        if(first == null){
            return null;
        }
        if(k == 0){
            return first; // return same node since no rotations will be made
        }
        int size = 0;
        // find size
        ListNode trav = first;
        while (trav != null){
            size = size + 1;
            trav = trav.next;
        }
        int num_rotations = k % size;
        if(num_rotations == 0){
            return first;
        }
        int move = size - num_rotations;
        int x = 1;
        ListNode trav2 = first;
        while (x != move){
            x = x + 1;
            trav2 = trav2.next;
        }


        ListNode temp = first;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = first;

        first = trav2.next;
        trav2.next = null;
        return first;


    }
    public void printLL1(ListNode u){
        ListNode temp = u;
        while (temp != null){

            System.out.print(temp.data + "-->");

            temp = temp.next;


        }
        if(temp == null){
            System.out.println("null");
        }
    }
}
class ListNode{
    int data;
    ListNode next;

    // default constructor for creation of dummy node
    ListNode(){}
    ListNode(int data){
        this.data= data;
    }
}
