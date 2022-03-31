package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Day0224_Baekjoon1753_최단경로 {

	static class Node{
		int vertex;
		int weight; // 가중치를 멤버 변수로 가진다
		Node link;
		
		public Node(int vertex, int weight, Node link) {
			this.vertex = vertex;
			this.weight = weight; 
			this.link = link;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO 최단경로
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int V = Integer.parseInt(st.nextToken()); // 정점 수
		int E = Integer.parseInt(st.nextToken()); // 간선 수
		
		int[] Distance = new int[V+1]; // 인덱스를 1부터 사용하기 위해 1크게 생성
		
		int start = Integer.parseInt(br.readLine()); // 시작 정점
		
		Node[] adjList = new Node[V+1]; // 인접리스트로 풀이
		boolean[] selected = new boolean[V+1];
		
		for(int i=0; i<E; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st2.nextToken()); // 시작 정점
			int y = Integer.parseInt(st2.nextToken()); // 도착 정점
			int w = Integer.parseInt(st2.nextToken()); // 가중치
			adjList[x] = new Node(y, w, adjList[x]);
		}
		
		// 시작점 넣기.
		Arrays.fill(Distance,Integer.MAX_VALUE);
		Distance[start] = 0; // 시작점의 값은 0 대입
		for (Node temp = adjList[start]; temp != null; temp = temp.link) {
			Distance[temp.vertex] = temp.weight;
		}
		
		
		for(int i=1; i<=V; i++) { // 총 V번 시행한다. -> 알고리즘 끝남
			
			// 단계 1 : 최소거리 확정되지 않았고 정점들 중 가장 최소거리가 저장되어 있는 정점을 고른다.
			int min = Integer.MAX_VALUE;
			int current = 0;
			
			for(int j=1; j<=V; j++) {
				if(!selected[j] && min>Distance[j]) {
					min = Distance[j];
					current = j;
				}
			}
			
			
			selected[current] = true; // 위에서 결정된 정점을 최소거리 확정 처리해주고 아래에서 실제로 최소거리를 구해준다
			// 단계 2 : 선택된 정점의 최소거리 구하기
			for (Node temp = adjList[current]; temp != null; temp = temp.link) {
				if(!selected[temp.vertex] && Distance[temp.vertex]> Distance[current]+temp.weight) {
					Distance[temp.vertex]= Distance[current]+temp.weight;
				}
			}

		}
		
		for(int i=1; i<=V; i++) {
			if(Distance[i]==Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(Distance[i]);
		}
		

	}

}
