package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MST_KRUSKAL {
	// 간선을 표현할 내부 클래스 생성
	static class Edge implements Comparable<Edge>{ 
		int from, to, weight; // 

	public Edge(int from, int to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
		
	@Override
	public int compareTo(Edge o) {
		return this.weight-o.weight;
	}
	
	}
	
	static int N;
	static int[] parents;
	static Edge[] edgeList;
	
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
	public static boolean union(int a, int b) { // kruskal 알고리즘에 사용하기 위해 boolean 으로 선언
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false; // 같은 집합이면 false
		
		parents[bRoot] = aRoot; // 다른 집합이면 합치고 true return
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO KRUSKAL 구현
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		edgeList = new Edge[E]; // Edge 객체들을 담는 배열 생성. 이것을 정렬할 것임.
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken()); 
			edgeList[i] = new Edge(from, to, weight); // 배열에 객체 저장
		}
		
		Arrays.sort(edgeList); // 간선 비용의 오름차순 정렬
		makeSet(); // 단위 집합 생성
		
		int result = 0;
		int cnt=0;
		
		for(Edge edge : edgeList) { // 간선 하나씩 꺼내며 반복문
			if(union(edge.from, edge.to)) { // Union 이 가능하면  간선을 누적합에 더해준다. 불가능하면 다음 for
				result += edge.weight; //
				if(++cnt == N-1) break; // 간선 누적 수가 N-1 개가 되면 끝냄.
			}
		}
		System.out.println(result); // 네트워크 최소 누적 비용
	}

}

/*test case
5 10
0 1 5
0 2 10
0 3 8
0 4 7
1 2 5
1 3 3
1 4 6
2 3 1
2 4 3
3 4 1

output==>10

7 11
0 1 32
0 2 31
0 5 60
0 6 51
1 2 21
2 4 46
2 6 25
3 4 34
3 5 18
4 5 40
4 6 51

output==>175
*/
