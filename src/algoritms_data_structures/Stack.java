package algoritms_data_structures;

import algoritms_data_structures.datastructure.LinearStructuresNode;

public class Stack {
	private LinearStructuresNode top;
	
	public boolean isEmpty(){
		return top == null;
	};	
	
	public int peek(){
		return top.getData();
	}
	
	public void push(int data){
		LinearStructuresNode newNode = new LinearStructuresNode(data);
		newNode.setNext(top);
		top = newNode;
	}
	
	public int pop(){
		int data = top.getData();
		top = top.getNext();
		
		return data;
	}
}
