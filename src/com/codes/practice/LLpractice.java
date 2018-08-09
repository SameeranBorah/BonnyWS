package com.codes.practice;

public class LLpractice {
   protected NodeL Head;
   protected NodeL End;

    void push(int data){
        NodeL lastnode=new NodeL(data);

        if(empty()) {
            Head = End = lastnode;}
        End.next=lastnode;
        lastnode.next=null;
        End=lastnode;
    }
    void pushFront(int data){
        NodeL newNode= new NodeL(data);
        newNode.next=Head;
        Head=newNode;

    }
    void print(NodeL temp){
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
    void printMiddle(){
        NodeL fastptr=Head;
        NodeL slwptr=Head;
        if (Head != null) {
            while(fastptr!= null && fastptr.next != null) {
                fastptr = fastptr.next.next;
                slwptr = slwptr.next;
            }
        }
        System.out.println(slwptr.data);
    }
    NodeL reverseList(NodeL Head){
        NodeL prev = null;
        NodeL current = Head;
        NodeL next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    NodeL reverse(NodeL curr, NodeL prev){
        if (curr.next == null) {
            Head = curr;

            /* Update next to prev node */
            curr.next = prev;

            return Head;
        }

        /* Save curr->next node for recursive call */
        NodeL next = curr.next;

        /* and update next ..*/
        curr.next = prev;

        reverse(next, curr);
        return Head;
    }

    public static void main(String[] args) {
        LLpractice ll = new LLpractice();
        ll.push(20);
        ll.push(23);
        ll.push(40);
        ll.push(90);
        ll.pushFront(100);
        ll.pushFront(22);
        ll.pushFront(00);

        ll.print(ll.Head);

        System.out.println("============================================");
        ll.print(ll.reverseList(ll.Head));
        NodeL x=ll.reverse(ll.End,null);
        ll.print(x);
        ll.printMiddle();
    }
    public boolean empty() {
        return Head == null || End == null;
    }

}
class NodeL{
    int data;
    NodeL next;
    NodeL(int d)
    {
        data=d;
        next=null;
    }
}