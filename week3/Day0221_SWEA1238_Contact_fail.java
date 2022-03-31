package week3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Day0221_SWEA1238_Contact_fail { // 그래프의 깊이와 관련된 문제는 BFS가 좋다
	static int N, start;
	static int answer; 
	static int[] visit_time; // dfs에서 깊이를 생각하면서 진행하기 위해 방문처리를 int형 배열로 생성
	
	public static void main(String[] args) {
		// TODO Contact. 그래프 dfs 탐색 연습문제	
		Scanner sc = new Scanner(System.in);
		
		
		for(int i=1; i<=10; i++) { // testcase 10
			N = sc.nextInt(); // 입력받는 데이터의 길이
			start = sc.nextInt(); // 시작점
			Node[] adjList = new Node[101]; 
			boolean[] visited = new boolean[101];
			
			visited[0] = true;
			
			for(int j=0; j<N/2; j++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				adjList[from] = new Node(to, adjList[from]);
			}
			
			/*// 인접 리스트 출력
			for(Node head: adjList) {
				System.out.println(head);
				
			}
			*/
			//bfs로 풀이시
			bfs(visited, adjList);
			System.out.println("bfs. #"+i+" "+answer);
			
			

			
		}
	}
	
	static class Node{
		int vertex; 
		Node link;
		
		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
		
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link = " + link + "]";
		}
		
	}
	
	
	static void bfs(boolean[] visited, Node[] adjList) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start); // 시작점 삽입
		visited[start] = true; // 시작점 방문처리
		
		while(!queue.isEmpty()) {
			int size = queue.size(); // 현재 큐에 있는 연락후보 갯수(출발점에서 거리가 같은 정점들 갯수)
			
			int biggest = 0; // 현재 깊이에 있는 애들 중 숫자 제일 큰 것 저장할 변수. 깊이마다 초기화되기 때문에 결국 마지막 깊이에 있는 것만 구해진다.
			for(int s =0; s<size; s++) {
				int current = queue.poll();
				biggest = Math.max(biggest, current); // 현재 깊이에 있는 애들 중 제일 큰 것 갱신
				for(Node temp = adjList[current]; temp!=null; temp = temp.link) {
					if(!visited[temp.vertex]) {
						visited[temp.vertex] = true;
						queue.add(temp.vertex);
					}
					
				}
			}
			// 같은 깊이에 있는 애들 poll 완료.. 다음 깊이에 있는 애들만 queue에 남아있음
			answer = biggest;
		}
		
	}
}
