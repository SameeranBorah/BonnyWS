package com.codes.practice;

public class LinkedListPractice {
     Node head;

      class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
    Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    public void push(int new_data)
    {
        //Allocate new node and putting data
        Node new_node = new Node(new_data);

        //Make next of new node as head
        new_node.next = head;

        //Move the head to point to new Node
        head = new_node;
    }
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        LinkedListPractice l1= new LinkedListPractice();
        l1.push(10);
        l1.push(22);
        l1.push(40);
        l1.push(10);
        l1.push(22);
        l1.push(40);
        l1.printList(l1.reverse(l1.head));


    }
}