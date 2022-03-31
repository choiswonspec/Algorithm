package week1;

import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		
		// default 는 최소힙. 최소값 순서로 출력됨.
		PriorityQueue<Integer> pQueue = new PriorityQueue<>();
		pQueue.offer(10);
		pQueue.offer(30);
		pQueue.offer(5);
		pQueue.offer(50);
		pQueue.offer(20);
		
		// poll() 명령어로 삭제되면서 반환됨.
		System.out.println(pQueue.poll());
		System.out.println(pQueue.poll());
		System.out.println(pQueue.poll());
		System.out.println(pQueue.poll());
		System.out.println(pQueue.poll());
	}

}
