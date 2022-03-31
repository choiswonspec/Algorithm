package week1;

import java.util.LinkedList;
import java.util.Queue;

public class QueueAPI {

	public static void main(String[] args) {
		// TODO Queue 구현
		Queue<String> queue = new LinkedList<String>();
		System.out.println(queue.size()+"//"+queue.isEmpty());
		queue.offer("정여명");
		queue.offer("신용하");
		queue.offer("차다은");
		queue.offer("이상진");
		System.out.println(queue.size()+"//"+queue.isEmpty());
		
		System.out.println(queue.poll());
		System.out.println(queue.size()+"//"+queue.isEmpty());
		System.out.println(queue.peek());
		System.out.println(queue.size()+"//"+queue.isEmpty());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.size()+"//"+queue.isEmpty());
	}

}
