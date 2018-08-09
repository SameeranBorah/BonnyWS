package com.assignment;
import java.util.Scanner;

public class assign21
{
    static int s[] = new int[16];
    static int m[] = new int[16];

    private static int bellNumber(int n)
    {
        int[][] bell = new int[n+1][n+1];
        bell[0][0] = 1;

        for (int i=1; i<=n; i++)
        {
            bell[i][0] = bell[i-1][i-1];

            for (int j=1; j<=i; j++){
                bell[i][j] = bell[i-1][j-1] + bell[i][j-1];
              //  System.out.println(""+bell[i][j]);
            }
        }


        return bell[n][0];
    }

    public static void main (String[] args) {

        int n;
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the number of records n: ");
        n = in.nextInt();
        System.out.println("Total number of possible clustering arrangements is " + bellNumber(n));

        int i;
        for (i = 0; i < n; ++i) {
            s[i] = 1;
            m[i] = 1;
        }

        printp(s, n);

        while (next(s, m, n)!=0)
            printp(s, n);
        return;
    }

        static void printp (int[] s,int n){
            int part_num = 1;
            int i;
            for (i = 0; i < n; ++i)
                if (s[i] > part_num)
                    part_num = s[i];
            int p;
            for (p = part_num; p >= 1; --p) {
                System.out.print("{");

                for (i = 0; i < n; i++)
                    if (s[i] == p)
                        System.out.print(i+1);
                System.out.print("}");

            }
            System.out.println();
        }


        static int next ( int[] s,int[] m,int n){

            int i = 0;
            ++s[i];
            while ((i < n - 1) && (s[i] > m[i] + 1)) {
                s[i] = 1;
                ++i;
                ++s[i];
            }


            if (i == n - 1)
                return 0;


            int max = s[i];
            for (i = i - 1; i >= 0; --i)
                m[i] = max;


            return 1;
        }


    }

