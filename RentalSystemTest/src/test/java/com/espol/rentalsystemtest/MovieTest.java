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
public class MovieTest {
    
    Movie avengers, hulk, thor;
    
    public MovieTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        avengers = new Movie("The Man Who Knew Too Much", Movie.REGULAR);
        hulk = new Movie("Mulan", Movie.CHILDRENS);
        thor = new Movie("Slumdog Millionaire", Movie.NEW_RELEASE);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPriceCode method, of class Movie.
     */
    @Test
    public void testGetPriceCode() {
        //CHILDRENS MOVIE
        assertEquals(Movie.CHILDRENS, hulk.getPriceCode());
        
        //REGULAR MOVIE
        assertEquals(Movie.REGULAR, avengers.getPriceCode());
        
        //NEW_RELEASE MOVIE
        assertEquals(Movie.NEW_RELEASE, thor.getPriceCode());
    }

    /**
     * Test of setPriceCode method, of class Movie.
     */
    @Test
    public void testSetPriceCode() {
        
        //CHILDRENS MOVIE
        hulk.setPriceCode(1);
        assertEquals(1,hulk.getPriceCode());
        
        //REGULAR MOVIE 
        avengers.setPriceCode(2);
        assertEquals(2,avengers.getPriceCode());
        
        //NEW_RELEASE MOVIE
        thor.setPriceCode(0);
        assertEquals(0,thor.getPriceCode());
        
    }
    
}
