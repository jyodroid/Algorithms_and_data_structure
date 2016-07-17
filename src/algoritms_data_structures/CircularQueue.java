package algoritms_data_structures;

public class CircularQueue {
	private String[] peopleQueue;
	private int counter;
	private int startElement;
	private boolean startMovement = true;

	public CircularQueue(int size, int startIndex) throws Exception{
		if (size > 0){
			peopleQueue = new String[size];
		}else{
			throw new Exception("Invalid queue size");
		}

		if (startIndex > size - 1 || startIndex < 0){
			throw new Exception("Invalid startIndex");
		}else{
			counter = startIndex;
			this.startElement = startIndex; 
		}
	}

	public void addPerson(String person) throws Exception{

		//Circular is full when startElement will reach the counter
		if (startElement == counter && !startMovement){
			throw new Exception("No room for " + person);
		}
		
		peopleQueue[counter] = person;
		startMovement = false;
		counter++;

		//is after last queue element
		if(counter == peopleQueue.length){
			counter = 0;
		}
	}

	public String removePerson() throws Exception{
		
		//Empty List state
		if (counter == startElement && startMovement) {
			throw new Exception("Empty circular list");
		}
		
		//return first person (start element of circular)
		String person =  peopleQueue[startElement];
		
		//if remove start element our star element become its next element
		if(startElement == peopleQueue.length - 1){
			startElement = 0;
		}else{
			startElement++;
		}
		startMovement = true;
		return person;
	}

	public int getSize(){
		if(counter > startElement){
			return counter - startElement;
		}else if (counter < startElement){
			return peopleQueue.length - startElement + counter;
		}else{
			if(startMovement){
				return 0;
			}else{
				return peopleQueue.length;
			}
		}
	}

	public String next(){
		if(counter == startElement){
			return "Empty Queue";
		}else{
			return peopleQueue[startElement];
		}
	}
}
