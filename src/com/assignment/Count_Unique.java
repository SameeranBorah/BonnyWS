package com.assignment;
import java.io.*;

public class Count_Unique {
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\siddhab\\Desktop\\Sample_Input_File_Assignment2.txt"));

            String line = null;

            while((line = br.readLine()) != null){

                String[] values = line.split(",");
                int[] intValues = new int[values.length];
                for (int i = 0; i < values.length; i++) {
                    try {
                        intValues[i] = Integer.parseInt(values[i]);
                    }
                    // didn't work, moving over next String value
                    catch (NumberFormatException nfe) {
                        continue;
                    }
                }
                System.out.println(intValues[0]);
                System.out.println(values[0]);
                for(String str : values){
                    System.out.println(str);
                }

            }

            System.out.println("");

            br.close();

        }
    }


