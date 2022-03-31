package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Day0222_SWEA1251_하나로_fail {

	static int[] parents;
	static double ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO 하나로
		Scanner sc  = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for(int tc=1; tc<=TC; tc++) {
			int N = sc.nextInt();
			
			int[] x = new int[N];
			int[] y = new int[N];
			
			for(int j=0; j<N; j++) {
				x[j] = sc.nextInt();
			}
			
			for(int j=0; j<N; j++) {
				y[j] = sc.nextInt();
			}
			
			double E = sc.nextDouble();
			//end input
			
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			for(int j =0; j<N; j++) {
				for(int k=j+1; k<N; k++) { // j번 섬과 k번 섬과의 거리 계산
					int xx = Math.abs(x[j]-x[k])*Math.abs(x[j]-x[k]);
					int yy = Math.abs(y[j]-y[k])*Math.abs(y[j]-y[k]);
					pq.add(new Edge(j, k, (xx+yy)*E));
					
				}
			}
			
			// KRUSKAL 로 MST 만들기 
			parents = new int[N];
			for(int i=0; i<N; i++) {
				parents[i] = i;
			}
			
			double ans = 0;
			
			int cnt = 0; // 선택한 간선 갯수(섬의 갯수-1)
			while(true) {
				Edge edge = pq.poll(); //짧은 순서대로 간선 빼기
				if(union(edge.n1, edge.n2)) { // 간선 연결 가능하면
					cnt++;
					ans += edge.fee;
				}
				if(cnt==N-1) break;
			}
			System.out.println("#"+tc+" "+Math.round(ans));
		}
	}
	static boolean union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);
		
		if(p1==p2) return false;
		
		parents[p1] = p2;
		return true;
	}
	
	static int find(int n) {
		if(parents[n] ==n) return n;
		return parents[n] = find(parents[n]);
	}

	
	static class Edge implements Comparable<Edge>{
		int n1, n2;
		double fee;
		
		public Edge(int n1, int n2, double fee) {
			this.n1 = n1;
			this.n2 = n2;
			this.fee = fee;
		}
		
		@Override
		public int compareTo(Edge o) {
			if(this.fee > o.fee)
				return 1;
			else if(this.fee<o.fee)
				return -1;
			return 0;
		}
	}
	
}
