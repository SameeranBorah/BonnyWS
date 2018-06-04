package com.codes.lists;

public class LinkListWithAddedFunctionality extends MyLinkedList {


     void midpoint() {

         Node slow_ptr, fast_ptr;

         for(slow_ptr = fast_ptr = head;
             fast_ptr != null && fast_ptr.next != null;
             fast_ptr = fast_ptr.next.next, slow_ptr = slow_ptr.next);



         System.out.println("The middle element is [" + slow_ptr.data + "] \n");
     }

    public static void main(String[] args) {
        LinkListWithAddedFunctionality linkedList = new LinkListWithAddedFunctionality();
        linkedList.pushFront(10);
        linkedList.pushFront(11);
        linkedList.pushFront(12);
        linkedList.pushFront(13);
        linkedList.pushFront(10);
        linkedList.pushFront(11);
        linkedList.pushFront(12);
        linkedList.pushFront(13);
       linkedList.midpoint();
        linkedList.printList();
    }
}
