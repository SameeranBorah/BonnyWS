package com.assignment;

import java.io.*;
import java.util.Scanner;

public class assign91_21 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("C:\\Users\\siddhab\\IdeaProjects\\BonnyWS\\src\\com\\assignment\\text.txt"));
        printRecursive(scanner);
    }


    public static void printRecursive(Scanner scanner) {
        if (!scanner.hasNextLine()) {
            return;
        }

        String line = scanner.nextLine();
        printRecursive(scanner);
        System.out.println(line);
    }
}