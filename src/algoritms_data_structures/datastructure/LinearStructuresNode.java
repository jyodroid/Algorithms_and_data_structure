package algoritms_data_structures.datastructure;

public class LinearStructuresNode {
	private int data;
	private LinearStructuresNode next;
	public LinearStructuresNode(int data){
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public LinearStructuresNode getNext() {
		return next;
	}
	public void setNext(LinearStructuresNode next) {
		this.next = next;
	}
}
