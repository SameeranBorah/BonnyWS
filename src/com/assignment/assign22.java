package com.assignment;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.lang.String;
import java.io.FileInputStream;

public class assign22 {

    public static void main(String [] args){
//Reads file containing fractions
        Scanner inputFile = null;
        try {
            inputFile = new Scanner(new FileInputStream("C:\\Users\\siddhab\\Desktop\\Sample_Input_File_Assignment2.txt"));
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(0);
        }

//variables
        String xyz;
        String[] fractions = new String[100]; //will take in the fractions
        String[] split = new String[2]; //used to split the fractions
        int[] numerator = new int[100]; //store numerators
        int[] denominator = new int[100]; //store denominators
        int count = 0; //number of lines in file
        int duplicate = 0; //number of fractions that are the duplicate
        boolean[] counted = new boolean[100];
        String[] array= new String[100];


        xyz = inputFile.next();
        array=xyz.split(",");

        count=(xyz.length()/4);

        //split the fractions[] into two arrays: numerator and denominator
        for(int i = 0; i < count; i++){
            split = array[i].split("/");
            numerator[i] = Integer.parseInt(split[0]);
            denominator[i] = Integer.parseInt(split[1]);
            if(denominator[i]>15) {
                System.out.println("denominator must be less than or equal to 15");
                return;
            }
            if(numerator[i]>denominator[i]){
                System.out.println("numerator should be less than denominator");
            return;
            }
        }

        int num;
        int den;


        for(int i = 0; i < count; i++){
            den = denominator[i];
            num = numerator[i];
            int smaller = num < den ? num : den;
            int HCF = -1;
            for (int j = smaller; j > 0; --j) {
                if (num%j==0&&den%j==0) {
                    HCF = j;
                    numerator[i]=(num/HCF);
                    denominator[i]=(den/HCF);
                    break;
                }
            }


            for(int a = 0; a < count; a++){
                if (!counted[a]) {
                    if(den == denominator[a]){ //compare denominators
                        if(num == numerator[a]){ //compare numerators
                            duplicate++;
                            counted[a] = true;
                        }
                    }
                }
            }

            if (duplicate>0) {
                System.out.println(num + "/" + den + " has a count of "+ duplicate);
            }
            duplicate = 0;
        }
    }
}