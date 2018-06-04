package com.codes.lists;

public class LinkListDemo {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.pushFront(10);
        linkedList.pushFront(11);
        linkedList.pushFront(12);
        linkedList.pushFront(13);
        System.out.println(linkedList.toString());
        linkedList.printList();
    }

}
