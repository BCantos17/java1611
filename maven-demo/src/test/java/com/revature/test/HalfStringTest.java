package com.revature.test;

import static org.junit.Assert.*;
import junit.framework.*; // deprecated

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.java.CodingBat;

/**
 * Can contain multiple tests.
 * Maven command Maven install
 * 		mvn install  compile -> test -> jar -> install 
 * 		install 'goal' (install: copy the jar to output directory)
 * @author Owner
 *
 */
public class HalfStringTest {

	/**
	 * Tells JUnit when to execute these methods:
	 * BeforeClass: initialize static resources
	 * 		used for ALL Tests..
	 * 		Executes 1 time before all tests
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("BeforeClass");
		
	}

	/**
	 * AfterClass: executes 1 time after ALL tests
	 * 		used to clean-up the BeforeClass stuff
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("AfterClass");
	}

	/**
	 * Before: Executes 1 time for EACH test
	 * 		initialize non-static variables
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("Before");
	}

	/**
	 * After: Executes 1 time for EACH test
	 * 		cleanup non-static variables
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("After");
	}

	/**
	 * Actually test something!!
	 * Returning first half of an even String
	 * 	firstHalf("WooHoo") → "Woo"
	 * 	firstHalf("HelloThere") → "Hello"
     * 	firstHalf("abcdef") → "abc"
	 */
	@Test
	public void test() {
		CodingBat bat = new CodingBat();
		// throws AssertionError is they don't match
		// or any exception gets thrown --> test fails
		assertEquals("Woo", bat.firstHalf("WooHoo"));
		assertEquals("Hello", bat.firstHalf("HelloThere"));
		assertEquals("abc", bat.firstHalf("abcdef"));
		assertNotEquals("pickle", bat.firstHalf("dannpickle"));
	}

	/**
	 * If odd String is passed,
	 * IllegalArgumentException.
	 * 
	 * In this Test, I 'expect' 
	 * {@link IllegalArgumentException}
	 * to be thrown.
	 * If this exception type of subclass type
	 * 	 NOT thrown, test fails
	 * 
	 */
	@Test(expected=IllegalArgumentException.class)
	public void abc() {
		CodingBat bat = new CodingBat();
		bat.firstHalf("abcgt");
	}

}




