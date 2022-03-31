package week3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Day0221_Baekjoon1260_DFS와BFS {

	static int N, M, V;
	static int[][] adjMatrix;
	
	public static void main(String[] args) {
		// TODO 인접 행렬로 풀어야함.
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		
		adjMatrix = new int[N+1][N+1];
		boolean[] visited = new boolean[N+1];
		visited[0] = true;
		
		for(int i=0; i<M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			adjMatrix[from][to] = 1;
			adjMatrix[to][from] = 1;
		}
		// dfs
		dfs(adjMatrix, visited, V);
		System.out.println();
		// bfs
		boolean[] visited2 = new boolean[N+1];
		visited2[0] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		bfs(adjMatrix, visited2, V);
	}
	
	static void dfs(int[][] adjMatrix, boolean[] visited, int current) {
		visited[current] = true;
		System.out.print(current+" ");
		
		for(int i=1; i<N+1; i++) {
			if(visited[i]==false && adjMatrix[current][i]!=0) {
				dfs(adjMatrix, visited, i);
			}
		}	
	}
	
	static void bfs(int[][] adjMatrix, boolean[] visited, int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[start] = true;
		queue.offer(start);
		
		
		while(!queue.isEmpty()) {
			
			int current = queue.poll();
			System.out.print(current+" ");
			
			for(int i=1; i<N+1; i++) {
				if(!visited[i] && adjMatrix[current][i]!=0) {
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
		
		
		
	}
	

}
