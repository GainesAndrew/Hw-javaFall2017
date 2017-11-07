/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafall2017.homework;

/**
 *
 * @author Andrew Gaines
 */
public class ThreadTwo implements Runnable {
    
    // for tests
    Boolean complete;

    public void run(){
        
                for(int i=8; i >=0 ; --i){
                        System.out.println("Second Thread: " + i);
                       
                        try{
                                Thread.sleep(1000);
                        }
                        catch(InterruptedException ie){
                                System.out.println("Second thread interrupted! " + ie);
                        }
                }
               complete = true;
                System.out.println("Second thread done!");
        } 
    }