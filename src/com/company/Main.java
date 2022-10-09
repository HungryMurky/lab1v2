package com.company;
import org.jetbrains.annotations.NotNull;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
    int Number;
    Scanner inp = new Scanner(System.in);
    System.out.println("Enter the initial number:");
    Number = inp.nextInt(); //entering and reading the number
    Main.CreateFile();
    Main.WriteToFile(Number);
    System.out.println(Main.ReverseNumber(Main.PushDigitsToStack(Main.ReadFromFile())));
    }
    public static void CreateFile(){
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
    }//creating empty file under the project directory
    public static void WriteToFile(int Number){
        try {
            FileWriter myWriter = new FileWriter("sourcefile.txt",false);
            myWriter.write(Integer.toString(Number));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }//writing number to a file
    public static int ReadFromFile(){
        try {
            File SourceFile = new File("sourcefile.txt");
            Scanner myReader = new Scanner(SourceFile);
            String data = myReader.nextLine();
            myReader.close();
            return(Integer.parseInt(data));

        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return 0;
        }
    }//returning number from the text file
    public static @NotNull Stack<Integer> PushDigitsToStack(int Number){
        Stack<Integer> st= new Stack<>();
        while(Number != 0)
        {
            st.push(Number % 10);
            Number = Number / 10;
        }
       return  st;
    } //returning a stack of "Number" digits
    public static int ReverseNumber(Stack<Integer> st){
        int reverse=0,i=1;
        while (!st.isEmpty())
        {
            reverse = reverse + (st.peek() * i);
            st.pop();
            i = i * 10;
        }
        return reverse;

    }//returning the reverse number formed by stack
}
