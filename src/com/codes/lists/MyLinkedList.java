package com.codes.lists;
public class MyLinkedList {
     class Node {
        int data;
        Node next;
        public Node(int d){
            data=d;
            next=null;
        }

    }
    protected Node head;
    protected Node end;
    public MyLinkedList(){
        head=null;
    }


    public void pushFront(int new_data) {
        Node new_node = new Node(new_data);
        if(empty()) {
            head = end = new_node;
        } else {
            new_node.next = head;
            head = new_node;
        }
    }

    public void pushBack(int new_data) {
        Node newLastNode = new Node(new_data);

        //for the first element, head and end both will point to it.
        if(empty()) {
            head = end = newLastNode;
        } else {
            //when a new element enters, point the last elements' next to it
            // and point the end to this element
            end.next = newLastNode;
            end = newLastNode;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Node temp = head; temp != null; temp = temp.next) {
            sb.append(temp.data + " ");
        }
        return sb.toString();
    }

    public void printList()
    {
        Node tnode = head;
        while (tnode != null)
        {
            System.out.print(tnode.data+"->");
            tnode = tnode.next;
        }
        System.out.println("NULL");
    }

    public boolean empty() {
        return head == null || end == null;
    }
}

