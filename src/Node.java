public class Node {
	private double data;
	private Node next;
	
	public Node() {
		this.data = 0;
		this.next = null;
	}
	
	public Node(double data_) {
		this.data = data_;
		this.next = null;
	}
	
	public void set_data(double data_) {
		this.data = data_;
	}
	
	public void set_next(Node n) {
		this.next = n;
	}
	
	public double get_data() {
		return this.data;
	}
	
	public Node get_next() {
		return this.next;
	}
	public String toString() {
		return Double.toString(this.data);
	}
}
