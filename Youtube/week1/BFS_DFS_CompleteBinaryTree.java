package week1;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_DFS_CompleteBinaryTree {
	// TODO 완전이진탐색 배열로 구현
	
	private char[] nodes;
	private final int SIZE;
	private int lastIndex;
	
	public BFS_DFS_CompleteBinaryTree(int size) {
		nodes = new char[size+1]; // index0은 사용하지 않기에 size+1 하여 배열 생성
		SIZE = size;
	}
	public boolean isEmpty() {
		return lastIndex == 0;
	}
	public boolean isFull( ) {
		return lastIndex == SIZE;  
	}
	
	// 데이터 추가
	public void add(char e) {  
		if(isFull()) return;
		nodes[++lastIndex] = e; //마지막 저장한 index 다음 index에 저장
		
	}
	
	public void bfs() {
		
		if(isEmpty()) return;
		// 이진 트리의 탐색 순서를 넣을 Queue
		Queue<Integer> queue = new LinkedList<Integer>();
		
		// 루트가 가장 먼저 탐색되도록 queue에 넣기
		queue.offer(1);
		
		while(!queue.isEmpty()) {
			int current = queue.poll(); // 탐색 순서에 맞는 인덱스
			
			// 하고 싶은 기능 구현
			System.out.println(nodes[current]);
			
			// 현재 노드의 자식 노드들의 인덱스를 다음에 순서가 되었을때 탐색하도록 큐에 넣어준다.
			// 이 문제에서는 이진트리이기 때문에 왼쪽 오른쪽 자식만 생각
			// 왼쪽 자식 노드
			if(current*2<=lastIndex) queue.offer(current*2);
			// 오른쪽 자식 노드
			if(current*2+1<=lastIndex) queue.offer(current*2+1);
			
		}
		
		
	}
	public void bfs2() { // 각 Level 을 구분하면서 출력
		
		if(isEmpty()) return;
		// 이진 트리의 탐색 순서를 넣을 Queue
		Queue<Integer> queue = new LinkedList<Integer>();
		
		// 루트가 가장 먼저 탐색되도록 queue에 넣기
		queue.offer(1);
		
		while(!queue.isEmpty()) {
			// 같은 높이의 노드를 모두 탐색, 같은 행에 출력
			int size = queue.size();
			while(--size>=0) {
				int current = queue.poll(); // 탐색 순서에 맞는 인덱스
				
				// 하고 싶은 기능 구현
				System.out.print(nodes[current]+"\t");
				
				// 현재 노드의 자식 노드들의 인덱스를 다음에 순서가 되었을때 탐색하도록 큐에 넣어준다.
				// 이 문제에서는 이진트리이기 때문에 왼쪽 오른쪽 자식만 생각
				// 왼쪽 자식 노드
				if(current*2<=lastIndex) queue.offer(current*2);
				// 오른쪽 자식 노드
				if(current*2+1<=lastIndex) queue.offer(current*2+1);
			}
			
			System.out.println();
		}
		
		
	}
	
	public void dfs() {
		dfsByPreorder(1);
		System.out.println();
	}
	
	private void dfsByPreorder(int current) { // current 가 휘둘리면 안되니 private로 구현하고 위에  dfs() 로 실행
		if(current>lastIndex) return;
		
		// 현재 노드 방문
		System.out.print(nodes[current]+" ");
		
		// 현재 노드의 자식 노드들 방문
		if(current*2<=lastIndex) dfsByPreorder(current*2);
		if(current*2+1<=lastIndex) dfsByPreorder(current*2+1);
		
		
		
	}

}
