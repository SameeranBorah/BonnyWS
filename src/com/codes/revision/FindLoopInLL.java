package com.codes.revision;

public class FindLoopInLL extends MidpointOfLL{
     int findLoop(Node head) {
        Node slw_ptr = head;
        Node fast_ptr = head;

        while (slw_ptr != null) {
            slw_ptr = slw_ptr.next;
            fast_ptr = fast_ptr.next.next;
            if(slw_ptr==fast_ptr)
                break;

        }
        slw_ptr = head;
        while (slw_ptr != fast_ptr) {
            slw_ptr = slw_ptr.next;
            fast_ptr=fast_ptr.next;
        }
        return slw_ptr.value;
    }
     void makeLoop(){
        end.next=head.next.next.next.next;

    }

    public static void main(String[] args) {
        FindLoopInLL list =new FindLoopInLL();
        list.pushInFront(20);
        list.pushInFront(44);
        list.pushInFront(33);
        list.pushInFront(66);
        list.pushInFront(70);
        list.pushInFront(84);
        list.pushInFront(100);
        list.pushInFront(43);
        list.pushInFront(26);
        list.makeLoop();
        System.out.println(list.end.next.value);

        System.out.println(""+list.findLoop(list.head));

    }

}

