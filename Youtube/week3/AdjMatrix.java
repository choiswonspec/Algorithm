package week3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* input 
7 
8 
0 1 
0 2	
1 3
1 4
2 4
3 5
4 5
5 6
*/
public class AdjMatrix {
	static int N;
	
	public static void main(String[] args) {
		// TODO 인접행렬. 무향 그래프 간선의 정보를 통해 인접행렬만들기
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정점 수
		int C = sc.nextInt(); // 간선 수
		
		int[][] adjMatrix = new int[N][N]; // 정점수 크기로 정방행렬 생성
		
		for(int i=0; i<C; i++) {
			int from  = sc.nextInt();
			int to  = sc.nextInt();
			
			// 무향 그래프 이므로 반대도 넣어준다
			adjMatrix[from][to] = adjMatrix[to][from] = 1;
			
		}
		
		bfs(adjMatrix,0);

	}
	
	public static void bfs(int[][] adjMatrix, int start) {
		Queue<Integer> queue = new LinkedList<Integer>(); // Queue 생성
		boolean[] visited = new boolean[N]; // 방문처리 배열 생성
		
		queue.offer(start); //시작 정점 enqueue
		visited[start] = true; // 시작 정점 방문처리
		
		while(!queue.isEmpty()) {  // queue 가 빌 때까지 반복문 수행
			int current = queue.poll(); // dequeue 후 current에 저장
			//System.out.println((char)(current+65)); // current 알파벳으로 출력
			System.out.println(current); // current 알파벳으로 출력
			
			// current 정점의 방문하지 않은 인접 정점 방문처리하고 enqueue 
			for(int i=0; i<N; i++) { // current 가 현재 노드의 번호(인접 행렬에서 행 번호) 인접 행렬의 열을 N 만큼 탐색 
				// 방문한적 없고 인접행렬 상 연결된 노드들을 조건문으로 찾는다.
				if(!visited[i] 
						&& adjMatrix[current][i]!=0) { // 가중치가 있을 수 있기 때문에 != 0 으로 조건을 건다
					queue.offer(i); // dequeue
					visited[i] = true; // 방문 처리
				}
			}
		}
	}

}