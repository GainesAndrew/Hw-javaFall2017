/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafall2017.homework;
import java.sql.*;

/**
 * Programer: Andrew Gaines
 * About: Java fall2017 HomeWork 5
 * Dr. Macevoy 11/07/2017 
 * 
 * Program uses threads and streams
 * 
 */

public class App {
    
    static public class ThreadThree extends Thread {
    
    // for tests
    Boolean complete;

    public void run(){
        
                for(int i=0; i <=3 ; ++i){
                        System.out.println("Third Thread: Its an exiting race!");
                       
                        try{
                                sleep((int)(Math.random() * 4000));
                        }
                        catch(InterruptedException ie){
                                System.out.println("Third thread interrupted! " + ie);
                        }
                }
               complete = true;
                System.out.println("Third thread done!");
        } 
    }
    
    
    public static void main(String[] args) throws Exception {
        // Testing streams
        StreamsExample names = new StreamsExample();
        names.run();
       
        ThreadOne fstThread = new ThreadOne();
        ThreadTwo secThread = new ThreadTwo();
        ThreadThree thrdThread;
        thrdThread = new ThreadThree();
        
          //Starting the first thread
        Thread threadA = new Thread(fstThread);
        threadA.start();
 
        //Starting the second thread
        Thread threadB = new Thread(secThread);
        threadB.start();
        
        //Starting thrird thread
        thrdThread.start();
    
}
}
