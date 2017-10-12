package javafall2017.homework;

// Programer: Andrew Gaines

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
     * Test of main method, of class App.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main untested");
    }

    /**
     * Test of run method, of class App.
     */
    @Test
    public void testRun() throws Exception {
        System.out.println("run untested");
    }
   
    @Test
    public void testppGames() {
        Set<Points> ppGames = new TreeSet < Points> ();
        
        ppGames.add(new PointsPerGame("Steph Curry",25));
        ppGames.add(new PointsPerGame("James Harden",29));
        ppGames.add(new PointsPerGame("Isaiah Thomas",30));
        ppGames.add(new PointsPerGame("Klay Thompson", 22));
        
        for (Points n : ppGames) {
            System.out.println("Stat: " + n.description());
        }
    }
    
    static class Cmp_ppGames implements Comparator < Points > {
        @Override
        public int compare(Points a, Points b) {
            return a.compareTo(b);
        }
    }
    
    @Test
    public void testSortDirectives() {
        ArrayList<Points> ppGames = new ArrayList < Points> ();
        
        ppGames.add(new PointsPerGame("James Harden",29));
        ppGames.add(new PointsPerGame("Klay Thompson", 22));
        ppGames.add(new PointsPerGame("Steph Curry",25));
        ppGames.add(new PointsPerGame("Isaiah Thomas",30));
        
        ppGames.sort(new Cmp_ppGames());

        ppGames.sort(new Comparator<Points>() {
            @Override
            public int compare(Points a, Points b) {
                return -a.compareTo(b);
            }  
        });
        ppGames.sort((a,b)->a.compareTo(b));
        
        assertEquals(new PointsPerGame("Klay Thompson", 22), ppGames.get(0));
        assertEquals(new PointsPerGame("Steph Curry",25), ppGames.get(1));
        assertEquals(new PointsPerGame("James Harden",29), ppGames.get(2));
        assertEquals(new PointsPerGame("Isaiah Thomas" ,30), ppGames.get(3));
    }  
}