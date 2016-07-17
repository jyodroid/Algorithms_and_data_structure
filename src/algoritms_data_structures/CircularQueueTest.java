package algoritms_data_structures;

import static org.junit.Assert.*;

import org.junit.Test;

public class CircularQueueTest {

	@Test
	public void testCircularQueueAddPerson() {
		
		try {
			//Arrange
			CircularQueue circularQueue = new CircularQueue(1,0);
			
			//Act
			circularQueue.addPerson("John");
			String response = circularQueue.removePerson();
			
			//Assert
			assertEquals("John", response);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testCircularQueueRemovePerson() {
		
		try {
			//Arrange
			CircularQueue circularQueue = new CircularQueue(4, 2);
			
			//Act
			circularQueue.addPerson("John");
			circularQueue.addPerson("Vito");
			String response = circularQueue.removePerson();
			
			//Assert
			assertEquals("John", response);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testCircularQueueRemove2people() {
		
		try {
			//Arrange
			CircularQueue circularQueue = new CircularQueue(4, 2);
			
			//Act
			circularQueue.addPerson("John");
			circularQueue.addPerson("Vito");
			circularQueue.removePerson();
			String response = circularQueue.removePerson();
			
			//Assert
			assertEquals("Vito", response);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	@Test
	public void testCircularQueueRemove3people() {
		
		try {
			//Arrange
			CircularQueue circularQueue = new CircularQueue(4,2);
			
			//Act
			circularQueue.addPerson("John");
			circularQueue.addPerson("Vito");
			circularQueue.addPerson("Tulkas");
			circularQueue.addPerson("Cata");
			circularQueue.removePerson();
			circularQueue.removePerson();
			String response = circularQueue.removePerson();
			
			//Assert
			assertEquals("Tulkas", response);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testCircularQueueAddAndRemovePerson() {
		
		try {
			//Arrange
			CircularQueue circularQueue = new CircularQueue(4,2);
			
			//Act
			circularQueue.addPerson("John");
			circularQueue.removePerson();
			circularQueue.addPerson("Vito");
			circularQueue.addPerson("Tulkas");
			String response = circularQueue.removePerson();
			
			//Assert
			assertEquals("Vito", response);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testCircularQueueNext() {
		
		try {
			//Arrange
			CircularQueue circularQueue = new CircularQueue(4,2);
			
			//Act
			circularQueue.addPerson("John");
			circularQueue.addPerson("Vito");
			circularQueue.addPerson("Tulkas");
			circularQueue.addPerson("Cata");
			circularQueue.removePerson();
			circularQueue.removePerson();
			circularQueue.removePerson();
			String response = circularQueue.next();
			
			//Assert
			assertEquals("Cata", response);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testCircularQueueNextFromEmpty() {
		
		try {
			//Arrange
			CircularQueue circularQueue = new CircularQueue(4,2);
			
			//Act
			circularQueue.addPerson("John");
			circularQueue.addPerson("Vito");
			circularQueue.addPerson("Tulkas");
			circularQueue.addPerson("Cata");
			circularQueue.removePerson();
			circularQueue.removePerson();
			circularQueue.removePerson();
			circularQueue.removePerson();
			String response = circularQueue.next();
			
			//Assert
			assertEquals("Empty Queue", response);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testCircularQueueNextFromFull() {
		
		try {
			//Arrange
			CircularQueue circularQueue = new CircularQueue(4,2);
			
			//Act
			circularQueue.addPerson("John");
			circularQueue.addPerson("Vito");
			circularQueue.addPerson("Tulkas");
			circularQueue.addPerson("Cata");
			String response = circularQueue.next();
			
			//Assert
			assertEquals("John", response);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testCircularQueueSize2() {
		
		try {
			//Arrange
			CircularQueue circularQueue = new CircularQueue(8,2);
			
			//Act
			circularQueue.addPerson("John");
			circularQueue.addPerson("Vito");
			
			int queueSize = circularQueue.getSize();
			
			//Assert
			assertEquals(2, queueSize);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testCircularQueueSize8() {
		
		try {
			//Arrange
			CircularQueue circularQueue = new CircularQueue(8,2);
			
			//Act
			circularQueue.addPerson("John");
			circularQueue.addPerson("Vito");
			circularQueue.addPerson("Jeimmy");
			circularQueue.addPerson("Tulkas");
			circularQueue.addPerson("Cata");
			circularQueue.addPerson("Santiago");
			circularQueue.addPerson("Justin");
			circularQueue.addPerson("Federico");
			
			int queueSize = circularQueue.getSize();
			
			//Assert
			assertEquals(8, queueSize);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testCircularQueueSize0() {
		
		try {
			//Arrange
			CircularQueue circularQueue = new CircularQueue(8,2);
			
			//Act (no adding people)
			
			int queueSize = circularQueue.getSize();
			
			//Assert
			assertEquals(0, queueSize);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testCircularQueueSize3() {
		
		try {
			//Arrange
			CircularQueue circularQueue = new CircularQueue(8,7);
			
			//Act
			circularQueue.addPerson("John");
			circularQueue.addPerson("Vito");
			circularQueue.addPerson("Tulkas");
			
			int queueSize = circularQueue.getSize();
			
			//Assert
			assertEquals(3, queueSize);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testCircularQueueEmpty() {
		
		try {
			//Arrange
			CircularQueue queue = new CircularQueue(2,1);
			
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
	public void testCircularQueueWrongInitialSize() {
		
		try {
			//Arrange and act
			CircularQueue circularQueue = new CircularQueue(0,1);
			fail();
		} catch (Exception e) {
			assertEquals("Invalid queue size", e.getMessage());
		}
	}
	
	@Test
	public void testCircularQueueWrongStartIndexBigger() {
		
		try {
			//Arrange and act
			CircularQueue circularQueue = new CircularQueue(8,9);
			fail();
		} catch (Exception e) {
			assertEquals("Invalid startIndex", e.getMessage());
		}
	}
	
	@Test
	public void testCircularQueueWrongStartIndexSmaller() {
		
		try {
			//Arrange and act
			CircularQueue circularQueue = new CircularQueue(8,9);
			fail();
		} catch (Exception e) {
			assertEquals("Invalid startIndex", e.getMessage());
		}
	}
	
	@Test
	public void testCircularQueueNoRoomForPerson() {
		
		try {
			//Arrange
			CircularQueue circularQueue = new CircularQueue(1,0);
			
			//Act
			circularQueue.addPerson("John");
			circularQueue.addPerson("Vito");
			fail();
			
		} catch (Exception e) {
			//Assert
			assertEquals("No room for Vito", e.getMessage());
		}
	}

}
