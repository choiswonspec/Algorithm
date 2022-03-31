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

public class AjdList {

	static int N;

	static class Node { // 인덱스가 from, data 가 to

		int vertex; // 정점의 번호
		Node link; // 다음 노드로의 연결

		public Node(int vertex, Node link) {
			this.vertex = vertex; // 인덱스가 from 이면 이 변수에 to Node 숫자 저장
			this.link = link; // 앞에 있는 노드의 참조값을 저장
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link = " + link + "]";
		}

	}

	public static void main(String[] args) {
		// TODO 인접 리스트 무향 그래프
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정점 수
		int C = sc.nextInt(); // 간선 수

		Node[] adjList = new Node[N]; // 정점수 크기로 생성

		for (int i = 0; i < C; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();

			// 인접 리스트는 어차피 링크로 연결된거라 실제로 인접한게 아니기 때문에 순서는 상관이 없다.
			// 따라서 굳이 뒤에다 추가하면 계속 head 부터 시작하여 불필요한 연산이 되는 것이므로 head에다가 추가해준다.
			adjList[from] = new Node(to, adjList[from]); // 이 노드의 참조값이 자연스럽게 헤드에 들어간다.
			// adjList[from]이 원래 헤드가 가지고 있던 참조값(즉, 헤드 다음 노드의 참조 값)
			// 이렇게 하면 원래 헤드가 null이라도 그냥 다음 링크가 null인 노드를 새로 넣으면 되니까 엄청 간결
			adjList[to] = new Node(from, adjList[to]); // 무향 그래프이므로 반대도
		}

		dfs(adjList, new boolean[N], 0);

	}

	// 관련 배열들과 현재 정점을 저장할 변수를 매개 변수로 활용
	public static void dfs(Node[] adjList, boolean[] visited, int current) {
		visited[current] = true;
		System.out.println(current);

		// 방문처리가 기저조건을 대신한다.

		for (Node temp = adjList[current]; temp != null; temp = temp.link) {
			if (!visited[temp.vertex] ) { // 현재 current 행의 열들을 모두 탐색. 인접한 상태이면 진행.
				dfs(adjList, visited, temp.vertex);
			}
		}

	}

}
