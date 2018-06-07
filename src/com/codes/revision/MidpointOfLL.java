package com.codes.revision;


public class MidpointOfLL {
   protected static Node head;
   protected static Node end;
   MidpointOfLL(){head=null;}
    public void midpoint(Node node){

        Node fast_ptr=node;
        Node slow_ptr=node;
        if(head!=null){
            while(fast_ptr != null && fast_ptr.next != null){
                slow_ptr=slow_ptr.next;
                fast_ptr=fast_ptr.next.next;
            }
            System.out.println(slow_ptr.value);
        }
    }
    public void printList()
    {
        Node tnode = head;
        while (tnode != null)
        {
            System.out.print(tnode.value+"->");
            tnode = tnode.next;
        }
        System.out.println("NULL");
    }
    public void pushInFront(int new_data){
       Node new_node=new Node(new_data);
       if(isEmpty()){
           head=end=new_node;
       }
       else
           new_node.next=head;
            head=new_node;
    }
    public void pushInBAck(int new_data){
       Node new_node=new Node(new_data);
       if(isEmpty()){
           head=end=new_node;
       }
       else
           new_node.next=null;
           end.next=new_node;
           end=new_node;

    }
    void insertIN(int new_data,int pst){
       int count=1;
       Node temp=head;
       Node new_node=new Node(new_data);
       while (temp.next!=null){
           if(count==pst-1){
               new_node.next=temp.next;
               temp.next=new_node;
           }
           count++;
           temp=temp.next;
       }
    }
    public static void main(String[] args) {
        MidpointOfLL list=new MidpointOfLL();
        list.pushInBAck(99);
        list.pushInBAck(49);
        list.pushInBAck(59);
        list.pushInBAck(69);
        list.pushInBAck(9);
        list.pushInFront(33);
        list.pushInBAck(79);
        list.pushInBAck(89);
        list.pushInBAck(39);
        list.insertIN(21,5);
        list.printList();
        list.midpoint(head);

    }

    public boolean isEmpty(){return head==null;}


}
