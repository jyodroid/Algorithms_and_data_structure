package algoritms_data_structures;

public class Queue {

	private String[] peopleQueue;
	private int queueSize; 
	private int counter = -1;
	
	public Queue(int size) throws Exception{
		if (size > 0){
			peopleQueue = new String[size];
			this.queueSize = size;
		}else{
			throw new Exception("Invalid queue size");
		}
	}
	
	public void addPerson(String person) throws Exception{
		counter++;
		if(counter < peopleQueue.length){
			peopleQueue[counter] = person;
		}else{
			counter--;
			throw new Exception("No room for " + person);
		}
	}
	
	public String removePerson(){
		if(counter == -1){
			return "Empty Queue";
		}else{
			
			//return first person
			String person =  peopleQueue[0];
			
			//re order queue
			for(int i = 0; i < counter; i++){
				peopleQueue[i] = peopleQueue[i + 1];
			}
			
			//adjust counter
			counter--;
			
			return person;
		}
	}
	
	public int getSize(){
		return counter + 1;
	}
	
	public String next(){
		if(counter == -1){
			return "Empty Queue";
		}else{
			return peopleQueue[counter];
		}
	}
	
}
