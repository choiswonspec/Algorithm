package week1;

public class Node {
	String data; // data필드
	Node link; // Link필드
	
	public Node(String data, Node link) {
		super();
		this.data = data;
		this.link = link;
	}

	public Node(String data) {
		super();
		this.data = data;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Node [data=" + data + ", link=" + link + "]";
	}

	

}
