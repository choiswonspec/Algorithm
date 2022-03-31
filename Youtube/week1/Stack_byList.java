package week1;

public class Stack_byList {
	
	private Node top; // List의 Head가 stack의 top이 된다
	// 이 top 에 저장되어 있는 다음 노드의 주소값으로 추가하고 삭제하면 그게 Stack
	public void push(String data) {
		// 첫번째 노드 top(Head)에 삽입
		top = new Node(data, top);
	}
	
	public String pop() {
		
		if(isEmpty()) {
			return null;
		}
		// 첫번째 노드 삭제
		Node popNode = top;
		top = popNode.link; // 지금 지워지는 Node 객체의 link값은 다음 노드의 참조값.
		// 그것을  top에 저장한다.
		
		return popNode.data; 
		
	}

	public boolean isEmpty() {
		return top==null; 
	}
	
	@Override
	public String toString() {
		// top부터 마지막 노드까지 쭉 돌며 data를 문자열로 합치기
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		//top노드부터 시작해서 증감식은 그 노드에 저장되어 있는 다음 노드의 참조값. currNode가 null이 될 때까지
		for(Node currNode=top; currNode!=null; currNode=currNode.link ) { 		
			sb.append(currNode.data).append(",");
		}
		if(!isEmpty()) sb.setLength(sb.length()-1); // 맨뒤에있는 , 없애기
 		sb.append("]");
		return sb.toString(); 
	}

}
