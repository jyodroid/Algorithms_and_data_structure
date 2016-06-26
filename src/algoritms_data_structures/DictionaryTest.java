package algoritms_data_structures;

import static org.junit.Assert.*;

import org.junit.Test;

public class DictionaryTest {

	@Test
	public void testAddPerson() {
		
		//Arrange
		Dictionary dictionary = new Dictionary();
		
		//Act
		dictionary.addPerson("John", "Software engineer");
		String carreer = dictionary.getProfession("John");
		
		
		//Assert
		assertEquals("Software engineer", carreer);
	}
	
	@Test
	public void testAddExistingPerson() {
		
		//Arrange
		Dictionary dictionary = new Dictionary();
		
		//Act
		dictionary.addPerson("John", "Software engineer");
		dictionary.addPerson("John", "Programmer");
		String carreer = dictionary.getProfession("John");
		
		//Assert
		assertEquals("Programmer", carreer);
	}
	
	@Test
	public void testAddSeveralPeople() {
		
		//Arrange
		Dictionary dictionary = new Dictionary();
		
		//Act
		dictionary.addPerson("John", "Software engineer");
		dictionary.addPerson("Jeimmy", "Accountant");
		dictionary.addPerson("Martha", "Bussiness");
		String carreer = dictionary.getProfession("Jeimmy");
		
		
		//Assert
		assertEquals("Accountant", carreer);
	}
	
	@Test
	public void testRemovePerson() {
		
		//Arrange
		Dictionary dictionary = new Dictionary();
		
		//Act
		dictionary.addPerson("John", "Software engineer");
		dictionary.addPerson("Jeimmy", "Accountant");
		dictionary.addPerson("Martha", "Bussiness");
		dictionary.removePerson("Jeimmy");
		String carreer = dictionary.getProfession("Jeimmy");
		
		
		//Assert
		assertEquals("Not Found", carreer);
	}
	
	@Test
	public void testRemoveTwiceAPerson() {
		
		//Arrange
		Dictionary dictionary = new Dictionary();
		
		//Act
		dictionary.addPerson("John", "Software engineer");
		dictionary.addPerson("Jeimmy", "Accountant");
		dictionary.addPerson("Martha", "Bussiness");
		dictionary.removePerson("Jeimmy");
		dictionary.removePerson("Jeimmy");
		String carreer = dictionary.getProfession("Jeimmy");
		
		//Assert
		assertEquals("Not Found", carreer);
	}
	
	@Test
	public void testRemoveTwiceAPersonThenFindAnother() {
		
		//Arrange
		Dictionary dictionary = new Dictionary();
		
		//Act
		dictionary.addPerson("John", "Software engineer");
		dictionary.addPerson("Jeimmy", "Accountant");
		dictionary.addPerson("Martha", "Bussiness");
		dictionary.removePerson("Jeimmy");
		dictionary.removePerson("Jeimmy");
		String carreer = dictionary.getProfession("Martha");
		
		//Assert
		assertEquals("Bussiness", carreer);
	}
	
	@Test
	public void testRemovePersonThenAddAgain() {
		
		//Arrange
		Dictionary dictionary = new Dictionary();
		
		//Act
		dictionary.addPerson("Jeimmy", "Accountant");
		dictionary.addPerson("John", "Software engineer");
		dictionary.removePerson("Jeimmy");
		dictionary.addPerson("Jeimmy", "Accountant");
		String carreer = dictionary.getProfession("Jeimmy");
		
		//Assert
		assertEquals("Accountant", carreer);
	}
}
