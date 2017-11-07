package javafall2017.homework;

/**
 * Programer: Andrew Gaines
 *
 */

// first thread will be count to 15 
public class ThreadOne implements Runnable {
    
    // for tests
    Boolean complete;

    public void run(){
        
                for(int i=1; i <= 8; i++){
                        System.out.println("First Thread: " + i);
                       
                        try{
                                Thread.sleep(1000);
                        }
                        catch(InterruptedException ie){
                                System.out.println("First thread interrupted! " + ie);
                        }
                }
               complete = true;
                System.out.println("First thread done!");
        } 
    }
  
