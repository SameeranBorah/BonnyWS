package com.online.leetcode;


public class LC_2_AddTwoNumbers {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode prev = null;
        while(l1 != null || l2 != null) {
            int carry = 0;
            int sum = (l1.val + l2.val + carry)%10;
            carry = (l1.val + l2.val + carry)/10;

            ListNode node = new ListNode(sum);
            if(head == null) {
                head = node;
            } else {
                prev.next = node; //link it to the earlier element
            }
            prev = node; // make prev as this current node,

            l1 = l1.next;
            l2 = l2.next;
        }
        return head;
    }

    private ListNode util(ListNode l1, ListNode l2, int carry) {
        if(l1 == null && l2 == null) return null;
        int val1 = l1 == null ? 0 : l1.val;
        int val2 = l1 == null ? 0 : l2.val;
        int sum = val1 + val2 + carry;
        int cout = sum/10;

        ListNode node = new ListNode(sum/10);
//        node.next = util(l1.next,  cout);
        return node;
    }


    public static void main(String[] args) {

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}