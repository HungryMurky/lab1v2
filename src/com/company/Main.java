package com.company;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class Main {

    public static void main(String[] args) {
	// write your code here
    int Number,ReverseNumber;
    Scanner inp = new Scanner(System.in);
    System.out.println("Enter the initial number:");
    Number = inp.nextInt(); //entering and reading the number


    try {
        File SourceFile = new File("sourcefile.txt");
        if (SourceFile.createNewFile()) {
            System.out.println("File created");
        } else {
            System.out.println("File exists");
        }
    } catch (IOException e) {
        System.out.println("An error occurred");
        e.printStackTrace();
    }

    try {

            FileWriter myWriter = new FileWriter("sourcefile.txt",false);
            myWriter.write(Integer.toString(Number));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
