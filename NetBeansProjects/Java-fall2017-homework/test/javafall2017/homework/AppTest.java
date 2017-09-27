/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafall2017.homework;

import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author xanderjuice
 */
public class AppTest {
    
    public AppTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of run method, of class App.
     */
    @Test
    public void testRun() {
        System.out.println("run untested");
        
    }
    
    /**
     * Test of readInput method, of class App.
     */
    @Test
    public void testReadInput_Scanner() {
        System.out.println("readInput");
        Scanner in = new Scanner("3\n"+"10\n"+"9\n"+"2");
        App app = new App();
        app.readInput(in);
        assertEquals(3,app.testCases);
        assertEquals(10, app.x[0]); 
        assertEquals(9, app.x[1]);
        assertEquals(2, app.x[2]);
    }

    /**
     * Test of solveProblem method, of class App.
     */
    @Test
    public void testSolveProblem() {
        System.out.println("solveProblem");
        Scanner in = new Scanner("3\n"+"10\n"+"9\n"+"2");
        App app = new App();
        app.readInput(in);
        app.solveProblem();
        assertEquals(3, app.testCases);
        assertEquals(true, app.numbers[0].isEven);
        assertEquals(false, app.numbers[1].isEven);
        assertEquals(true, app.numbers[2].isEven);
    }
    
    /**
     * Test of solveProblem2 method, of class App.
     */
    @Test
    public void testSolveProblem2() {
        System.out.println("solveProblem");
        Scanner in = new Scanner("4\n"+"-10\n"+"7\n"+"3\n" +"1");
        App app = new App();
        app.readInput(in);
        app.solveProblem();
        assertEquals(4,app.testCases);
        assertEquals(true, app.numbers[0].isEven);
        assertEquals(false, app.numbers[1].isEven);
        assertEquals(false, app.numbers[2].isEven); 
        assertEquals(false, app.numbers[3].isEven);
    }

    /**
     * Test of writeOutput method, of class App.
     */
    @Test
    public void testWriteOutput() {
        System.out.println("writeOutput untested");

    }

    /**
     * Test of main method, of class App.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        App.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readInput method, of class App.
     */
    @Test
    public void testReadInput_0args() {
        System.out.println("readInput");
        App instance = new App();
        instance.readInput();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
