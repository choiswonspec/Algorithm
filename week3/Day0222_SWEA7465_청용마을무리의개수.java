package week3;

import java.util.Scanner;

public class Day0222_SWEA7465_청용마을무리의개수 {

	static int[] parents;
	static int N, M, TC;
	static int countSet;
	// 단위 집합 생성
	static void makeSet(int n) {
		parents = new int[n+1];
		for(int i=1; i<=n; i++) {
			parents[i] = i;
		}
	}
	// 두 집합 합치는  
	static void union(int a, int b) {
		if(findSet(a) == findSet(b)) return;
		
		parents[findSet(b)] = findSet(a);
		
	}
	
	// 집합 대표자  반환 
	static int findSet(int a) {
		if(parents[a]==a) return a;
		
		return parents[a] = findSet(parents[a]); // 내 부모의 부모를 찾아서 root 까지 이동
	}
	
	
	
	public static void main(String[] args) {
		// TODO 청용 마을 무리의 개수
		Scanner sc = new Scanner(System.in);
		
		TC = sc.nextInt();
		
		for(int i=1; i<=TC; i++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			makeSet(N); // N 단위집합 생성
			
			for(int j=0; j<M; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				union(x, y);
 			}
			
		}
		
		
		

	}

}
