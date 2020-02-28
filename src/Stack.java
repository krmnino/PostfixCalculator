
public class Stack {
	private Node top;
	private int size;
	
	public Stack() {
		this.top = null;
		this.size = 0;
	}
	
	public boolean isEmpty() {
		if(this.top == null && this.size == 0) {
			return true;
		}
		return false;
	}
	
	public Node peek() {
		return this.top;
	}
	
	public void push(double data_) {
		Node n = new Node(data_);
		n.set_next(this.top);
		this.size++;
		this.top = n;
	}
	
	public Node pop() {
		Node out = this.top;
		this.top = this.top.get_next();
		this.size--;
		return out;
	}
	
	public String toString() { //Use only for debugging purposes
		String out = "";
		Node current = this.top;
		for(int i = 0; i < this.size; i++) {
			out += Double.toString(current.get_data()) + " ";
			current = current.get_next();
		}
		return out;
	}
}
