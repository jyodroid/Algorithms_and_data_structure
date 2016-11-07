package algoritms_data_structures;

import static org.junit.Assert.*;

import org.junit.Test;

public class MapsTest {

	@Test
	public void successTest1() {
		//Arrange
		String magazineWords = "Abada cadabra test case";
		String noteWords = "Abada case";
		Maps mapsExample = new Maps(magazineWords, noteWords);
		
		//Act
		boolean isPosible = mapsExample.solve();
		
		//Assert
		assertTrue(isPosible);
	}
	
	@Test
	public void successTest2() {
		//Arrange
		String magazineWords = "Abada cadabra test case Adaba";
		String noteWords = "Abada case";
		Maps mapsExample = new Maps(magazineWords, noteWords);
		
		//Act
		boolean isPosible = mapsExample.solve();
		
		//Assert
		assertTrue(isPosible);
	}
	
	@Test
	public void failTest1() {
		//Arrange
		String magazineWords = "Abada cadabra test case";
		String noteWords = "Abada case Abada";
		Maps mapsExample = new Maps(magazineWords, noteWords);
		
		//Act
		boolean isPosible = mapsExample.solve();
		
		//Assert
		assertFalse(isPosible);
	}
	
	@Test
	public void failTest2() {
		//Arrange
		String magazineWords = "Abada cadabra test case";
		String noteWords = "abada case";
		Maps mapsExample = new Maps(magazineWords, noteWords);
		
		//Act
		boolean isPosible = mapsExample.solve();
		
		//Assert
		assertFalse(isPosible);
	}

}
