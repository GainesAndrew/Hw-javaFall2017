package javafall2017.homework;

import java.util.Scanner;

/**
 * Programer: Andrew Gaines
 * 
 * About: Java fall2017
 *        HomeWork 2 
 *        Dr. Macevoy
 *        9/28/2017
 * 
 * Program: Reads input of integers and outputs odd or even.
 *            .kattis problem = oddities
 */
public class App {

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
    
    class EvenOrOdd
    {
        int value;
        boolean isEven;
        
        void setEvenOrOdd()
        {
            if (value % 2 ==0) isEven =true;
            else isEven = false;
        }
    }
    
    int testCases;
    int x[];
    EvenOrOdd numbers[];
    
    void run()
    {
        readInput();
        solveProblem();
        writeOutput();
    }
    
    void readInput()
    {
        Scanner in = new Scanner(System.in);
        readInput(in);
    }
    
    void readInput(Scanner in)
    {
        testCases = in.nextInt();
        x = new int[testCases];
        
        for(int i=0;i<testCases;i++)
        {
            x[i]= in.nextInt();
        }       
    }
    
    void solveProblem()
    {
        numbers= new EvenOrOdd[testCases];
        EvenOrOdd number;
        
        for (int i=0; i<testCases;i++)
        {
            number = new EvenOrOdd();
            number.value = x[i];
            number.setEvenOrOdd();
            numbers[i]=number;
        }        
    }
    
    void writeOutput()
    {
        for (int i=0; i<testCases;i++)
        {
            if(numbers[i].isEven)
                System.out.println(numbers[i].value + " is even");
            else
                System.out.println(numbers[i].value +" is odd");
        }
    }
}
