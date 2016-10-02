package algoritms_data_structures;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnagramsTest {

	@Test
	public void switchTest() {
		//Arrange
		String anagram = "abadacadabra";
		Anagrams anagrams = new Anagrams();
		
		//Act
		anagram = anagrams.switchCharacters(anagram, 0, 9);
		
		//Assert
		assertEquals("bbadacadaara", anagram);
	}
	
	@Test
	public void switchToBiggerFromPositionTest() {
		//Arrange
		String anagram = "abadacadabra";
		Anagrams anagrams = new Anagrams();
		
		//Act
		try {
			anagram = anagrams.switchCharacters(anagram, 20, 9);
		} catch (Exception e) {
			//Assert
			assertEquals("invalid indexes", e.getMessage());
		}
	}
	
	@Test
	public void switchToBiggerToPositionTest() {
		//Arrange
		String anagram = "abadacadabra";
		Anagrams anagrams = new Anagrams();
		
		//Act
		try {
			anagram = anagrams.switchCharacters(anagram, 0, 19);
		} catch (Exception e) {
			//Assert
			assertEquals("invalid indexes", e.getMessage());
		}
	}
	
	@Test
	public void isAnagramTest() {
		//Arrange
		String a = "bacdc";
		String b = "dcbac";
		Anagrams anagrams = new Anagrams();
		
		//Act
		//Assert
		assertTrue(anagrams.isAnagram(a, b));
	}

}
