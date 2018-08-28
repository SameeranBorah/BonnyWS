package com.assignment;

public class assign32 {
    private int[] coef;   // coefficients p(x) = sum { coef[i] * x^i }
    private int degree;   // degree of polynomial (-1 for the zero polynomial)

    /**
     * Initializes a new polynomial a x^b
     * @param a the leading coefficient
     * @param b the exponent
     * @throws IllegalArgumentException if {@code b} is negative
     */
    public assign32(int a, int b) {
        if (b < 0) {
            throw new IllegalArgumentException("exponent cannot be negative: " + b);
        }
        coef = new int[b+1];
        coef[b] = a;
        reduce();
    }

    // pre-compute the degree of the polynomial, in case of leading zero coefficients
    // (that is, the length of the array need not relate to the degree of the polynomial)
    private void reduce() {
        degree = -1;
        for (int i = coef.length - 1; i >= 0; i--) {
            if (coef[i] != 0) {
                degree = i;
                return;
            }
        }
    }

    /**
     * Returns the degree of this polynomial.
     * @return the degree of this polynomial, -1 for the zero polynomial.
     */
    public int degree() {
        return degree;
    }

    /**
     * Returns the sum of this polynomial and the specified polynomial.
     *
     * @param  that the other polynomial
     * @return the polynomial whose value is {@code (this(x) + that(x))}
     */
    public assign32 plus(assign32 that) {
        assign32 poly = new assign32(0, Math.max(this.degree, that.degree));
        for (int i = 0; i <= this.degree; i++) poly.coef[i] += this.coef[i];
        for (int i = 0; i <= that.degree; i++) poly.coef[i] += that.coef[i];
        poly.reduce();
        return poly;
    }

    /**
     * Returns the result of subtracting the specified polynomial
     * from this polynomial.
     *
     * @param  that the other polynomial
     * @return the polynomial whose value is {@code (this(x) - that(x))}
     */
    public assign32 minus(assign32 that) {
        assign32 poly = new assign32(0, Math.max(this.degree, that.degree));
        for (int i = 0; i <= this.degree; i++) poly.coef[i] += this.coef[i];
        for (int i = 0; i <= that.degree; i++) poly.coef[i] -= that.coef[i];
        poly.reduce();
        return poly;
    }

    /**
     * Returns the product of this polynomial and the specified polynomial.
     * Takes time proportional to the product of the degrees.
     * (Faster algorithms are known, e.g., via FFT.)
     *
     * @param  that the other polynomial
     * @return the polynomial whose value is {@code (this(x) * that(x))}
     */
    public assign32 times(assign32 that) {
        assign32 poly = new assign32(0, this.degree + that.degree);
        for (int i = 0; i <= this.degree; i++)
            for (int j = 0; j <= that.degree; j++)
                poly.coef[i+j] += (this.coef[i] * that.coef[j]);
        poly.reduce();
        return poly;
    }

    /**
     * Returns the composition of this polynomial and the specified
     * polynomial.
     * Takes time proportional to the product of the degrees.
     * (Faster algorithms are known, e.g., via FFT.)
     *
     * @param  that the other polynomial
     * @return the polynomial whose value is {@code (this(that(x)))}
     */
    public assign32 compose(assign32 that) {
        assign32 poly = new assign32(0, 0);
        for (int i = this.degree; i >= 0; i--) {
            assign32 term = new assign32(this.coef[i], 0);
            poly = term.plus(that.times(poly));
        }
        return poly;
    }




    /**
     * Returns the result of evaluating this polynomial at the point x.
     *
     * @param  x the point at which to evaluate the polynomial
     * @return the integer whose value is {@code (this(x))}
     */
    public float evaluate(float x) {
        float p = 0;
        for (int i = degree; i >= 0; i--)
            p = coef[i] + (x * p);
        return p;
    }

    /**
     * Return a string representation of this polynomial.
     * @return a string representation of this polynomial in the format
     *         4x^5 - 3x^2 + 11x + 5
     */
    @Override
    public String toString() {
        if      (degree == -1) return "0";
        else if (degree ==  0) return "" + coef[0];
        else if (degree ==  1) return coef[1] + "x + " + coef[0];
        String s = coef[degree] + "x^" + degree;
        for (int i = degree - 1; i >= 0; i--) {
            if      (coef[i] == 0) continue;
            else if (coef[i]  > 0) s = s + " + " + (coef[i]);
            else if (coef[i]  < 0) s = s + " - " + (-coef[i]);
            if      (i == 1) s = s + "x";
            else if (i >  1) s = s + "x^" + i;
        }
        return s;
    }

    /**
     * Unit tests the polynomial data type.
     *
     * @param args the command-line arguments (none)
     */
    public static void main(String[] args) {
        assign32 zero = new assign32(0, 0);

        assign32 p1   = new assign32(4, 3);
        assign32 p2   = new assign32(3, 2);
        assign32 p3   = new assign32(1, 0);
        assign32 p4   = new assign32(2, 1);
        assign32 p    = p1.plus(p2).plus(p3).plus(p4);   // 4x^3 + 3x^2 + 1

        assign32 q1   = new assign32(3, 2);
        assign32 q2   = new assign32(5, 0);
        assign32 q    = q1.plus(q2);                     // 3x^2 + 5



        System.out.println("p(x)        = " + p);
        System.out.println("q(x)        = " + q);
        System.out.println("p(3)        = " + p.evaluate(3));
    }
}