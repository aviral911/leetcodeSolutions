class MyLinkedList {
  Node head;
  int size;
    public MyLinkedList() {
        head = null;
        size = 0;
    }
    
    public int get(int index) {
        // mistake || should be used in place of &&
        if(index < 0 ||  index >= size) return -1;
        Node temp = head;
        for(int i = 0;i<index;i++) temp = temp.next;
        traverse();
        System.out.println(index+" "+size);
        return temp.data; 
    }
    
    public void addAtHead(int val) {
        Node n = new Node(val);
        n.next = head;
        head = n;
        size++;
    }
    
    public void addAtTail(int val) { 
        Node n = new Node(val);
        size++;
        if(head == null){ // when list is empty
           head = n;
           return;
        }
        Node temp = head; // when list has some data 
        while(temp.next != null){
           temp = temp.next;
        }
        temp.next = n;   
    }
    public void traverse(){ // traverse 
        Node temp = head;
        while(temp != null){
          System.out.print(temp.data+" -> ");
          temp = temp.next; 
        }
        System.out.println();
    }
    
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > size) return;
        if(index == 0) {
            addAtHead(val);
            return;
        }
        if(index == size){
            addAtTail(val);
            return;
        }
        Node n = new Node(val);
        size++;
        Node temp = head;
        for(int i = 0; i<index-1;i++) temp = temp.next;
        n.next = temp.next;
        temp.next = n;
    }
    
    public void deleteAtIndex(int index) {
      if(index <0 || index >= size) return; // two case 
      // when first node dlt krni hai 
      size--;
      if(index == 0){
        head = head.next;
        return;
      }
     // when kahi or se node hatani
     Node temp = head;
     for(int i = 0 ;i<index-1;i++) temp = temp.next;
     temp.next = temp.next.next;
    }
}
class Node{
    int data;
    Node next;
    public Node(int d){ // constructor
        data = d;
    }
}