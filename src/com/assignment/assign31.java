package com.assignment;
public class assign31 {
    private Node first = new Node(0, 0);  // sentinel
    private Node last  = first;

    public class Node {
        int coef;
        int exp;
        Node next;
        Node(int coef, int exp) {
            this.coef = coef;
            this.exp  = exp;
        }
    }


    // 0
     assign31() { }

    // a * x^b
    public assign31(int coef, int exp) {
        last.next = new Node(coef, exp);
        last = last.next;
    }

    // return c = a + b
    public assign31 plus(assign31 b) {
        assign31 a = this;
        assign31 c = new assign31();
        Node x = a.first.next;
        Node y = b.first.next;
        while (x != null || y != null) {
            Node t = null;
            if      (x == null)     { t = new Node(y.coef, y.exp);  y = y.next; }
            else if (y == null)     { t = new Node(x.coef, x.exp);  x = x.next; }
            else if (x.exp > y.exp) { t = new Node(x.coef, x.exp);  x = x.next; }
            else if (x.exp < y.exp) { t = new Node(y.coef, y.exp);  y = y.next; }

            else {
                int coef = x.coef + y.coef;
                int exp  = x.exp;
                x = x.next;
                y = y.next;
                if (coef == 0) continue;
                t = new Node(coef, exp);
            }

            c.last.next = t;
            c.last = c.last.next;
        }
        return c;
    }


    // return c = a + b
    public assign31 times(assign31 b) {
        assign31 a = this;
        assign31 c = new assign31();
        for (Node x = a.first.next; x!= null; x = x.next) {
            assign31 temp = new assign31();
            for (Node y = b.first.next; y!= null; y = y.next) {
                temp.last.next = new Node(x.coef * y.coef, x.exp + y.exp);
                temp.last = temp.last.next;
            }
            c = c.plus(temp);
        }
        return c;
    }


    // convert to string representation
    public String toString() {
        String s = "";
        for (Node x = first.next; x != null; x = x.next) {
            if      (x.coef > 0) s = s + " + " +   x.coef  + "x^" + x.exp;
            else if (x.coef < 0) s = s + " - " + (-x.coef) + "x^" + x.exp;
        }
        return s;
    }

    // test client
    public static void main(String[] args) {
        assign31 zero = new assign31(0, 0);

        assign31 p1   = new assign31(4, 3);
        assign31 p2   = new assign31(3, 2);
        assign31 p3   = new assign31(1, 0);
        assign31 p4   = new assign31(2, 1);
        assign31 p    = p1.plus(p2).plus(p3).plus(p4);   // 4x^3 + 3x^2 + 1

        assign31 q1   = new assign31(3, 2);
        assign31 q2   = new assign31(5, 0);
        assign31 q    = q1.plus(q2);                     // 3x^2 + 5

        assign31 s    = p.times(q);
        System.out.println("p(x) =        " + p);
        System.out.println("q(x) =        " + q);
        System.out.println("p(x) * q(x) = " + s);
    }

}


