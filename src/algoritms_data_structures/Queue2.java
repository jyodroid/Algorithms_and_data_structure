package algoritms_data_structures;

import algoritms_data_structures.datastructure.LinearStructuresNode;

public class Queue2 {
	private LinearStructuresNode head; //remove from head
	private LinearStructuresNode tail; //add to tail
	
	public boolean isEmpty(){
		return head == null;
	};	
	
	public int peek(){
		return head.getData();
	}
	
	public void add(int data){
		LinearStructuresNode newNode = new LinearStructuresNode(data);
		if (tail != null){
			tail.setNext(newNode);
		}
		tail = newNode;
		if (head == null){
			head = tail;
		}
	}
	
	public int remove(){
		int data = head.getData();
		head = head.getNext();
		
		if (head == null){
			tail = null;
		}
		
		return data;
	}
}
