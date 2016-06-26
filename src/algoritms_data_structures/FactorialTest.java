package algoritms_data_structures;

import static org.junit.Assert.*;

import org.junit.Test;

public class FactorialTest {

	@Test
	public void factorialTestWith8() {
		//Arrange
		int response = 0;
		
		//Act
		try{
			response = Factorial.factorial(8);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//Assert
		assertEquals(40320, response);
	}
	
	@Test
	public void factorialTestWith12() {
		
		//Arrange
		int response = 0;
		
		//Act
		try{
			response = Factorial.factorial(12);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//Assert
		assertEquals(479001600, response);
	}
	
	public void factorialTestWithNegative1() {
		
		//Arrange
		int response = 0;
		
		//Act
		try{
			response = Factorial.factorial(12);
		}catch(Exception e){
			e.printStackTrace();
			
			//Assert
			assertEquals("Undefined Factorial",e.getMessage());
		}
	}
	
	@Test
	public void factorialTestWith1() {
		//Arrange
		int response = 0;
		
		//Act
		try{
			response = Factorial.factorial(1);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//Assert
		assertEquals(1, response);
	}
	
	@Test
	public void factorialTestWith0() {
		//Arrange
		int response = 0;
		
		//Act
		try{
			response = Factorial.factorial(0);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//Assert
		assertEquals(1, response);
	}

}
