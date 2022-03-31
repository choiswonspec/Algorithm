package week3;

import java.util.Scanner;

public class Day0222_SWEA3289_서로소집합 {
	static int TC;
	static int n, m;
	static int[] parents;
	
	static void makeSet(int n) {
		parents = new int[n+1];
		for(int i=1; i<=n; i++) {
			parents[i] = i;
		}
	}
	
	static void union(int a, int b) {
		if(findSet(a)==findSet(b)) {
			return;
		}
		parents[findSet(b)] = findSet(a);
		return;
	}
	
	// a가 속한 집합의 대표자 return
	static int findSet(int a) {
		if(a==parents[a]) return a;
		
		return parents[a] = findSet(parents[a]);
	}
	
	// a, b가 같은 집합에 포함되는지 확인
	static int isSameSet(int a, int b) {
		if(findSet(a)==findSet(b)) return 1;
		return 0;
	}
	
	public static void main(String[] args) {
		// 서로소 집합
		Scanner sc = new Scanner(System.in);
		
		
		TC = sc.nextInt();
		
		for(int i=1; i<=TC; i++) {
			n = sc.nextInt();
			m = sc.nextInt();
			
			makeSet(n); // n개의 단위 집합 생성
			
			System.out.print("#"+i+" ");
			for(int j=0; j<m; j++) {
				int x = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				if(x==0) {
					union(a,b);
				}else {
					System.out.print(isSameSet(a, b));
				}
			}
			System.out.println();
			
		}
		
		

	}

}
