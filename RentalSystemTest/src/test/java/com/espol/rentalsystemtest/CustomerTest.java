/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espol.rentalsystemtest;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JOSE ADRIAN GUANIN
 */
public class CustomerTest {
    
    Customer MarkRuffo ;
    MovieRental Hulkrented;
    VideoGameRental Pokemonrented;
    
    
    public CustomerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
       MarkRuffo = new Customer("Mark Ruffo");
       Hulkrented = new MovieRental(new Movie("The incredible Hulk",Movie.CHILDRENS),2);
       Pokemonrented = new VideoGameRental(new WiiGame("Pokemon"),3,false);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addMovieRental method, of class Customer.
     */
    @Test
    public void testAddMovieRental() {
        System.out.println("Test Añadir un Movie Rental");
        MarkRuffo.addMovieRental(Hulkrented);
        assertTrue(MarkRuffo.getMovieRentals().contains(Hulkrented));
    }

    /**
     * Test of addVideoGameRental method, of class Customer.
     */
    @Test
    public void testAddVideoGameRental() {
        System.out.println("Test Añadir un VideoGame Rental");
        MarkRuffo.addVideoGameRental(Pokemonrented);
        assertTrue(MarkRuffo.getVideoGameRental().contains(Pokemonrented));
    }

    /**
     * Test of statement method, of class Customer.
     */
    @Test
    public void testChildrenMovieStatementLessThan3() {
        System.out.println("Prueba de un Statement para películas Infantiles Rentadas menos de 3 días");
        System.out.println("Película: hulk. Categoría: Childrens. Días Rentados: 2");
        MarkRuffo.addMovieRental(Hulkrented);
        String expResult = "Rental Record for " + MarkRuffo.getName() + "\n";
        
        double amount = 1.5;
        int frequentRenterPoints = 1;
        
        expResult += "\t" + Hulkrented.getMovie()._title+ "\t"
                    + String.valueOf(amount) + "\n";
        expResult += "Amount owed is " + String.valueOf(amount) + "\n";
        expResult += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
            
        String result = MarkRuffo.statement();
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of statement method, of class Customer.
     */
    @Test
    public void testChildrenMovieStatementMoreThan3() {
        System.out.println("Prueba de un Statement para películas Infantiles Rentadas más de 3 días");
        System.out.println("Película: hulk. Categoría: Childrens. Días Rentados: 10");
        
        MovieRental hulkrented10 = new MovieRental(new Movie("Mulan",Movie.CHILDRENS),10);
        MarkRuffo.addMovieRental(hulkrented10);
        String expResult = "Rental Record for " + MarkRuffo.getName() + "\n";
        
        double amount = 1.5;
        amount += (hulkrented10.getDaysRented()-3)*1.25;
        int frequentRenterPoints = 1;
        
        expResult += "\t" + hulkrented10.getMovie()._title+ "\t"
                    + String.valueOf(amount) + "\n";
        expResult += "Amount owed is " + String.valueOf(amount) + "\n";
        expResult += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
            
        String result = MarkRuffo.statement();    
        assertEquals(expResult, result);
    }
    
    @Test
    public void testStatementRegularMovieOnly() {
        System.out.println("Prueba de un Statement para películas regulares");
        Movie interestellar = new Movie("Interestellar", Movie.REGULAR);
        MovieRental mv = new MovieRental(interestellar,3);
        MarkRuffo.addMovieRental(mv);
        
        String expResult = "Rental Record for " + MarkRuffo.getName() + "\n";
        
        double amount = 0;
        amount+=2;
        amount+=(mv.getDaysRented()-2)*1.5;
        int frequentRenterPoints = 0;
        frequentRenterPoints++;
        
        expResult += "\t" + mv.getMovie()._title+ "\t"
                    + String.valueOf(amount) + "\n";
        expResult += "Amount owed is " + String.valueOf(amount) + "\n";
        expResult += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
            
        String result = MarkRuffo.statement();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testStatementNewReleaseOnly() {
        System.out.println("Prueba de un Statement para películas Recién Estrenadas");
        Movie spiderman = new Movie("Spiderman", Movie.NEW_RELEASE);
        MovieRental mv = new MovieRental(spiderman,3);
        MarkRuffo.addMovieRental(mv);
        
        String expResult = "Rental Record for " + MarkRuffo.getName() + "\n";
        
        double amount = 0;
        amount +=mv.getDaysRented()*3;
        int frequentRenterPoints = 0;
        frequentRenterPoints++;
        frequentRenterPoints++;
        
        expResult += "\t" + mv.getMovie()._title+ "\t"
                    + String.valueOf(amount) + "\n";
        expResult += "Amount owed is " + String.valueOf(amount) + "\n";
        expResult += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
            
        String result = MarkRuffo.statement();
        assertEquals(expResult, result);
    }
    

    /**
     * Test of getName method, of class Customer.
     */
    /**@Test
    public void testGetName() {
        System.out.println("getName");
        Customer instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMovieRentals method, of class Customer.
     */
    /**@Test
    public void testGetMovieRentals() {
        System.out.println("getMovieRentals");
        Customer instance = null;
        ArrayList<MovieRental> expResult = null;
        ArrayList<MovieRental> result = instance.getMovieRentals();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVideoGameRental method, of class Customer.
     */
    /**@Test
    public void testGetVideoGameRental() {
        System.out.println("getVideoGameRental");
        Customer instance = null;
        ArrayList<VideoGameRental> expResult = null;
        ArrayList<VideoGameRental> result = instance.getVideoGameRental();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
}
