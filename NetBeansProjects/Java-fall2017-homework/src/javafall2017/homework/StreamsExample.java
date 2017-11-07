/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafall2017.homework;

import java.util.ArrayList;

/**
 *
 * @author Andrew Gaines
 */
public class StreamsExample {
    void run() throws Exception {
        
ArrayList < String > messages = new ArrayList(6);
messages.add("Robert");
messages.add("Sarah");
messages.add("Audrey");
messages.add("Gabriel");
messages.add("Rachel");
messages.add("Xander");

        // prints out contents of arrayList randomly
        messages.parallelStream().forEach(String -> {
                    System.out.println(String);
                });
        
        // convert to uppercase and sort
        messages.stream().sorted()
                    .map(String::toUpperCase)
                    .forEach(System.out::println);
        
        // returns number of elements in arrayList
        long count = messages.stream().count();
        System.out.println("Number of names: " + count);
   
    }
    
}

