package javafall2017.homework;

import java.util.Arrays;


/**
 * Programer: Andrew Gaines
 * 
 * About: Java fall2017
 *        HomeWork 3 
 *        Dr. Macevoy
 *        10/12/2017
 */


public class App {
    String [] args;
    App(String[] _args) {
        args = _args;
    }

    public static void main(String[] args) throws Exception {
        App app = new App(args);
        app.run();
    }
    
    void run() throws Exception {
        System.out.println("args: " + Arrays.toString(args));
    }
    
}
