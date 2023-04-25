package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import utils.AleatoricName;

class AleatoricNameTest {

	// @Test
	void testGenerateMich() {
		AleatoricName name = new AleatoricName();
		long counter = 0l;
		String name1 = "";
		
		do {
			name1 = name.generateAleatoricName(4,4);
			// System.out.println(name1);
			counter++;
			int nameLength = name1.length();
			assertEquals(nameLength,4);
		} while (!name1.equals("Mich"));
		
		System.out.println("Mich in: " + counter + " attempts");

	}
	
	// @Test
	void testGenerateFer() {
		AleatoricName name = new AleatoricName();
		long counter = 0l;
		String name1 = "";
		
		do {
			name1 = name.generateAleatoricName(3,3);
			// System.out.println(name1);
			counter++;
			int nameLength = name1.length();
			assertEquals(nameLength,3);
		} while (!name1.equals("Fer"));
		
		System.out.println("Fer in: " + counter + " attempts");

	}
	
	// @Test
	void testGenerateMiguel() {
		AleatoricName name = new AleatoricName();
		long counter = 0l;
		String name1 = "";

		do {
			name1 = name.generateAleatoricName(6, 6);
			// System.out.println(name1);
			counter++;
			int nameLength = name1.length();
			assertEquals(nameLength, 6 , 1);
		} while (!name1.equals("Miguel"));

		System.out.println("Miguel in: " + counter + " attempts");

	}
	
	@Test
	void testGenerateFernando() {
		AleatoricName name = new AleatoricName();
		long counter = 0l;
		String name1 = "";

		do {
			name1 = name.generateAleatoricName(8, 8);
			// System.out.println(name1);
			counter++;
			int nameLength = name1.length();
			assertEquals(nameLength, 8, 6);
		} while (!name1.equals("Fernando"));

		System.out.println("Fernando in: " + counter + " attempts");

	}

}
