package week3;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Day0224_Jungol1681_해밀턴순환회로_fail {

	static class Node implements Comparable<Node>{
		int number;
		int minDistance;
		public Node(int number, int minDistance) {
			super();
			this.number = number;
			this.minDistance = minDistance;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.minDistance - o.minDistance;
		}
	}
	public static void main(String[] args) {
		// TODO 해밀턴 순환회로
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] graph = new int[N][N];
		int[] minEdge = new int[N];
		boolean[] visited = new boolean[N];
		
		// input 받기
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				graph[i][j] = sc.nextInt();
			}
			minEdge[i] = Integer.MAX_VALUE;
		}
		
		int result = 0;
		minEdge[0] = 0;
		for(int c=0; c<N; c++) {
			int min = Integer.MAX_VALUE;
			int minVertex=0;
			for(int i=0; i<N; i++) {
				if(!visited[i] && min>minEdge[i]) {
					min = minEdge[i];
					minVertex=i;
				}
			}
			
			visited[minVertex] = true;
			result += min;
			
			for(int i=0; i<N; i++) {
				if(!visited[i] && graph[minVertex][i]!=0 && minEdge[i] > graph[minVertex][i] ) {
					minEdge[i] = graph[minVertex][i];
				}
			}
		}
		System.out.println(result);
		
		

	}

}
