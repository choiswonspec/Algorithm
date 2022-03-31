package week3;

import java.util.Arrays;

public class DisjointSet {
	static int N;
	static int[] parents;
	
	// 단위집합 생성하는 메서드
	public static void makeSet() {
		parents = new int[N]; // N개의 최소 단위 집합 넣을 배열 생성. 인덱스는 자신, 값은 부모 인덱스
		// 자신의 부모 노드를 자신의 값으로 세팅.. 
		for(int i=0; i<N; i++) {
			parents[i] = i; 
		}
	}
	
	// a가 속한 집합의 대표자 찾는 메서드
	public static int findSet(int a) { 
		if(a==parents[a]) { // 자신이 자신의 부모와 같다면 -> 루트 노드
			return a;
		}
		// Path Compression
		return parents[a] = findSet(parents[a]); // 내 부모의 부모를 찾아서 root 까지 이동
	}
	
	// a, b 두 집합 합치기
	public static boolean union(int a, int b) { // 나중에 kruskal 알고리즘에 사용하기 위해 boolean 으로 선언
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false; // 같은 집합이면 false
		
		parents[bRoot] = aRoot; // 다른 집합이면 합치고 true return
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		N = 5;
		makeSet();
		System.out.println(Arrays.toString(parents));
		System.out.println(union(0, 1));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(2, 1));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(3, 2));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(4, 3));
		System.out.println(Arrays.toString(parents));
		
		System.out.println("==============find=====================");
		System.out.println(findSet(4));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(3));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(2));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(0));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(1));
		System.out.println(Arrays.toString(parents));
	}

}
