package algoritms_data_structures;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueTest {
	
	@Test
	public void testQueueAddPerson() {
		
		try {
			//Arrange
			Queue queue = new Queue(4);
			
			//Act
			queue.addPerson("John");
			String response = queue.removePerson();
			
			//Assert
			assertEquals("John", response);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testQueueRemovePerson() {
		
		try {
			//Arrange
			Queue queue = new Queue(4);
			
			//Act
			queue.addPerson("John");
			queue.addPerson("Vito");
			String response = queue.removePerson();
			
			//Assert
			assertEquals("John", response);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testQueueRemove2people() {
		
		try {
			//Arrange
			Queue queue = new Queue(4);
			
			//Act
			queue.addPerson("John");
			queue.addPerson("Vito");
			queue.removePerson();
			String response = queue.removePerson();
			
			//Assert
			assertEquals("Vito", response);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testQueueRemove3people() {
		
		try {
			//Arrange
			Queue queue = new Queue(4);
			
			//Act
			queue.addPerson("John");
			queue.addPerson("Vito");
			queue.addPerson("Tulkas");
			queue.addPerson("Cata");
			queue.removePerson();
			queue.removePerson();
			String response = queue.removePerson();
			
			//Assert
			assertEquals("Tulkas", response);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testQueueAddAndRemovePerson() {
		
		try {
			//Arrange
			Queue queue = new Queue(4);
			
			//Act
			queue.addPerson("John");
			queue.removePerson();
			queue.addPerson("Vito");
			queue.addPerson("Tulkas");
			String response = queue.removePerson();
			
			//Assert
			assertEquals("Vito", response);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testQueueNext() {
		
		try {
			//Arrange
			Queue queue = new Queue(4);
			
			//Act
			queue.addPerson("John");
			queue.addPerson("Vito");
			queue.addPerson("Tulkas");
			queue.addPerson("Cata");
			queue.removePerson();
			queue.removePerson();
			queue.removePerson();
			String response = queue.next();
			
			//Assert
			assertEquals("Cata", response);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testQueueSize() {
		
		try {
			//Arrange
			Queue queue = new Queue(8);
			
			//Act
			queue.addPerson("John");
			queue.addPerson("Vito");
			
			int queueSize = queue.getSize();
			
			//Assert
			assertEquals(2, queueSize);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testQueueEmpty() {
		
		try {
			//Arrange
			Queue queue = new Queue(2);
			
			//Act
			queue.addPerson("John");
			queue.addPerson("Vito");
			queue.removePerson();
			queue.removePerson();
			
			int queueSize = queue.getSize();
			
			//Assert
			assertEquals(0, queueSize);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testQueueWrongInitialSize() {
		
		try {
			//Arrange and act
			Queue queue = new Queue(0);
			fail();
		} catch (Exception e) {
			assertEquals("Invalid queue size", e.getMessage());
		}
	}
	
	@Test
	public void testQueueNoRoomForPerson() {
		
		try {
			//Arrange
			Queue queue = new Queue(1);
			
			//Act
			queue.addPerson("John");
			queue.addPerson("Vito");
			
			fail();
			
		} catch (Exception e) {
			//Assert
			assertEquals("No room for Vito", e.getMessage());
		}
	}
}
