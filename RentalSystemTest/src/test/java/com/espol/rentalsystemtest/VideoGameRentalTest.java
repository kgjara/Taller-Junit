/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espol.rentalsystemtest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JOSE VIVANCO 
 */
public class VideoGameRentalTest {
    
    VideoGameRental xbox;
    VideoGameRental ps3;
    VideoGameRental wii;
    Ps3Game godOfWar;
    Xbox360Game halo;
    WiiGame marioKart; 
    
    public VideoGameRentalTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        godOfWar = new Ps3Game("god of war");
    	halo = new Xbox360Game("halo");
    	marioKart = new WiiGame("mario kart"); 
        xbox = new VideoGameRental(halo,4,true);
        ps3 = new VideoGameRental(godOfWar,4,true);
        wii = new VideoGameRental (marioKart,2,false);
          
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDaysRented method, of class VideoGameRental.
     */
    @Test
    public void testGetDaysRented() {
        System.out.println("getDaysRented");
        assertEquals(4,xbox.getDaysRented());
        
        assertEquals(4,ps3.getDaysRented());
        
        assertEquals(2,wii.getDaysRented());
    }

    /**
     * Test of getVideoGame method, of class VideoGameRental.
     */
    @Test
    public void testGetVideoGame() {
        System.out.println("getVideoGame");
        
        assertEquals(halo,xbox.getVideoGame());
        
        assertEquals(godOfWar,ps3.getVideoGame());
        
        assertEquals(marioKart,wii.getVideoGame());
    }

    /**
     * Test of getCharge method, of class VideoGameRental.
     */
    @Test
    public void testGetCharge() {
        System.out.println("getCharge");
       
       
        assertEquals(38.99,xbox.getCharge(),0.2);
        
        assertEquals(37.99,ps3.getCharge(),0.2);
        
        assertEquals(3.0,wii.getCharge(),0.2);
    }

    /**
     * Test of getFrequentRenterPoints method, of class VideoGameRental.
     */
    @Test
    public void testGetFrequentRenterPoints() {
        System.out.println("getFrequentRenterPoints");
        
        assertEquals(3,xbox.getFrequentRenterPoints());
        
        assertEquals(2,ps3.getFrequentRenterPoints());
        
        assertEquals(1,wii.getFrequentRenterPoints());
        
    }
    
    @Test
    public void testStatementPs3GameOnly() {
        // Ps3 games cost $4.00 for the first 4 days, and $1.250/day thereafter
        // a rental earns 2 frequent-renter point no matter how many days
        Customer MarkRuffo = new Customer("Mark Ruffo");
        MarkRuffo.addVideoGameRental(new VideoGameRental(godOfWar, 1, false));
        assertEquals("Rental Record for Mark Ruffo\n" +
                "\tLittle god of war\t4.0\n" +
                "Amount owed is 4.0\n" +
                "You earned 2 frequent renter points",
           MarkRuffo.statement());
        MarkRuffo.addVideoGameRental(new VideoGameRental(godOfWar, 3, false));
        assertEquals("Rental Record for Mark Ruffo\n" +
                "\tLittle god of war\t4.0\n" +
                "\tLittle god of war\t4.0\n" +
                "Amount owed is 8.0\n" +
                "You earned 4 frequent renter points",
           MarkRuffo.statement());
        MarkRuffo.addVideoGameRental(new VideoGameRental(godOfWar, 5, false));
        assertEquals("Rental Record for Mark Ruffo\n" +
                "\tLittle god of war\t4.0\n" +
                "\tLittle god of war\t4.0\n" +
                "\tLittle god of war\t5.25\n" +
                "Amount owed is 13.25\n" +
                "You earned 6 frequent renter points",
           MarkRuffo.statement());
    }

    @Test
    public void testStatementWiiGameOnly() {
        // childrens' movies cost $1.50 for the first 3 days, and $1.50/day thereafter
        // a rental earns 1 frequent-renter point no matter how many days
        Customer MarkRock = new Customer("Mark Rock");
        MarkRock.addVideoGameRental(new VideoGameRental(marioKart, 1, false));
        assertEquals("Rental Record for Johnny Doe, Jr.\n" +
                     "\tmario kart.\t3.0\n" +
                     "Amount owed is 3.0\n" +
                     "You earned 1 frequent renter points",
                MarkRock.statement());
        MarkRock.addVideoGameRental(new VideoGameRental(marioKart, 3, false));
        assertEquals("Rental Record for Mark Rock.\n" +
                	 "\tmario kart.\t3.0\n" +
                	 "\tmario kart.\t3.0\n" +
                     "Amount owed is 6.0\n" +
                     "You earned 2 frequent renter points",
                MarkRock.statement());
        MarkRock.addVideoGameRental(new VideoGameRental(marioKart, 5, false));
        assertEquals("Rental Record for Mark Rock.\n" +
           	         "\tmario kart.\t3.0\n" +
        	         "\tmario kart.\t3.0\n" +
        	         "\tmario kart.\t4.5\n" +
                     "Amount owed is 10.5\n" +
                     "You earned 3 frequent renter points",
                MarkRock.statement());
    }
    
    @Test
    public void testStatementXbox360GameOnly() {
        // new releases cost $3.00/day
        // a rental earns 1 frequent-renter point 1 day; 2 points for 2 or more days
        Customer MaryJane = new Customer("Mary Jane");
        MaryJane.addVideoGameRental(new VideoGameRental(halo, 1, false));
        assertEquals("Rental Record for Mary Jane\n" +
                     "\thalo\t3.5\n" +
                     "Amount owed is 3.5\n" +
                     "You earned 2 frequent renter points",
                MaryJane.statement());
        MaryJane.addVideoGameRental(new VideoGameRental(halo, 2, false));
        assertEquals("Rental Record for Mary Jane\n" +
                     "\thalo\t3.5\n" +
                     "\thalo\t3.5\n" +
                     "Amount owed is 7.0\n" +
                     "You earned 4 frequent renter points",
           MaryJane.statement());
        MaryJane.addVideoGameRental(new VideoGameRental(halo, 4, false));
        assertEquals("Rental Record for Mary Jane\n" +
	                 "\thalo\t3.5\n" +
	                 "\thalo\t3.5\n" +
	                 "\thalo\t5.0\n" +
	                 "Amount owed is 12.0\n" +
	                 "You earned 6 frequent renter points",
	      MaryJane.statement());
    }   
    
    
    
}
