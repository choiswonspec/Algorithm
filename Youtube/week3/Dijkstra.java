package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijkstra {

	static class Vertex implements Comparable<Vertex>{ // 정렬을 위해 Comparable 구현
		int no, minDistance; // 정점번호, 출발지에서 자신으로의 최소비용

		public Vertex(int no, int minDistance) {
			super();
			this.no = no;
			this.minDistance = minDistance;
		}
		
		@Override
		public int compareTo(Vertex o) {
			return this.minDistance-o.minDistance; // 오름차순일 때는 나에서 상대를 빼라. 상대가 크면 음수
		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO 다익스트라 알고리즘으로 최단경로 구하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int V = Integer.parseInt(br.readLine()); // V 는 모든 정점 수
		
		int[][] adjMatrix = new int[V][V];
		int start = 0; // 출발 정점
		int end = V-1; // 도착 정점이 주어지는 유형
		StringTokenizer st = null;
		for(int i=0; i<V; i++) { 
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<V; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] distance = new int[V]; // 출발지에서 자신으로 오는 최소비용 저장할 배열
		boolean[] visited = new boolean[V]; // 최소비용인지 아닌지 확정지을 배열
		PriorityQueue<Vertex> pQueue = new PriorityQueue<Vertex>();
		
		// 인접행렬에서 간선이 없는 두 정점의 값은 0이기 때문에 distance에서 미리 처리해주어야 한다.
		Arrays.fill(distance, Integer.MAX_VALUE); // 0 대신 큰 값으로 초기화해준다. -> 0이면 안됨. 최소 비용 갱신할 때 방해됨
		distance[start] = 0; // 출발정점의 최소 비용 0 입력. (시작점은 무조건 0이다.)
		pQueue.offer(new Vertex(start, distance[start])); // 출발지에서 출발지로. 0 입력됨.
		
		while(!pQueue.isEmpty()) {  // pQueue가 빌 때까지 계속 진행
			// 단계 1 : 최소비용이 확정되지 않은 정점중 최소비용의 정점 선택 -> Priority Queue 활용
			// 최소비용이 확정되지 않은 정점(j) 중 distance[j] 가 최소인 j를 찾는 것임
			// Node 내부 클래스를 만들어서 Priority Queue에 집어 넣으면 자동으로 최소 정점이 root 노드로 가게 설계
			Vertex current = pQueue.poll(); // 비용이 최소인 Vertex 객체가 나온다.
			
			if(visited[current.no]) continue; // pQueue에 최소거리인지 상관없이 업데이트된 값이  모두 추가되었기 때문에 
			// 위 코드가 없다면 이미 최소거리가 확정된 정점들을 계속 확인하게 된다.
			
			visited[current.no] = true; // 해당 정점 최소비용으로 확정. 최소비용 구하는건 아래에서 진행한다.
			if(current.no == end) break; // end 정점이 정해져 있는 유형에서는 이 지점에서 조건문으로 중단시킨다
			
			
			// 단계 2 : '선택된 정점을 경유지'로 하여 아직 최소비용이 확정되지 않은 다른 정점의 최소비용을 갱신
			for(int j=0; j<V; j++) {
				if(!visited[j] && adjMatrix[current.no][j] != 0 && // 최소비용이 확정되지 않았고 선택된 정점을 경유하여 갈 수 있는 정점들
						distance[j] > distance[current.no] + adjMatrix[current.no][j]) { // current를 경유해서 j로 가는 비용보다 기존 j로까지의 최소비용이 크다면 갱신해준다
					distance[j] = distance[current.no] + adjMatrix[current.no][j];
					pQueue.offer(new Vertex(j, distance[j])); //업데이트 될 때마다 Priority Queue에 추가해준다. 이게 확정된 최소거리인지는 상관없음
				}
			}
		}
		
		//System.out.println(distance[end]); // 종료된 시점 출력
		System.out.println(Arrays.toString(distance));
	
	}

}
