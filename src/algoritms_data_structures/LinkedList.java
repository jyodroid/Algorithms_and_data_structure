package algoritms_data_structures;

import algoritms_data_structures.datastructure.LinkedListNode;

public class LinkedList {
	
	boolean hasCycle(LinkedListNode head) {
	    if (head == null) {
	        return false;
	    }
	    LinkedListNode tortoise = head;
	    LinkedListNode hare = head.getNext();
	    while (tortoise != hare) {
	        if (hare == null || hare.getNext() == null){
	            return false;
	        }
	        tortoise = tortoise.getNext();
	        hare = hare.getNext().getNext();
	    }
	    
	    return true;
	}


}
