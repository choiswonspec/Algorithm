package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 유리한 비용을 계산할 때 priority queue를 사용해도 된다.
public class MST_PRIM {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int[][] adjMatrix = new int[N][N];
		// minEdge 배열을 생성한다. -> 배열의 인덱스는 정점. 배열의 값은 '신장 트리에 포함된 타 정점에서 그 정점으로 연결하는 간선의 비용중' 최소값 저장(계속 갱신)
		// 정점의 크기로 배열을 생성하고 Integer.Max_value 로 초기화한다 
		int[] minEdge = new int[N]; 
		
		boolean[] visited = new boolean[N]; // 신장 트리에 포함되었는지 표현할 배열 생성. 정점 수 N크기
		
		// 인접행렬 입력 받기
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				adjMatrix[i][j]= Integer.parseInt(st.nextToken());
			}
			minEdge[i] = Integer.MAX_VALUE; // Integer.Max_value 로 초기화
		}

		int result = 0; // MST 누적 비용
		
		minEdge[0] = 0;  // 임의의 시작 정점으로부터 시작 0부터 시작, 자기 자신으로 이어질 수 없으니 비용을 0으로 저장
		
		for(int c=0; c<N; c++) { // N개의 정점을 모두 연결.
			// 신장트리에 연결되지 않은 정점 중 가장 유리한 비용의 정점을 선택.
			int min = Integer.MAX_VALUE;
			int minVertex = 0;
			for(int i=0; i<N; i++) {
				if(!visited[i] && min>minEdge[i] ) { // 정점이 선택되지 않았다면. 
					min = minEdge[i]; // 최소 비용 갱신
					minVertex = i; 
				}
			}
			
			// 선택된 정점을 신장트리에 포함시킴
			visited[minVertex] = true;
			result += min; // 비용 누적 시킴.
			
			// 선택된 정점 기준으로 신장트리에 포함되지 않은 다른 정점으로의 간선비용을 따져보고 최소값 갱신
			for(int i=0; i<N; i++) {
				if(!visited[i] && adjMatrix[minVertex][i]!=0 && minEdge[i] > adjMatrix[minVertex][i] ) { 
					//신장 트리에 포함되지 않았고 인접하지 않았고? 가지고 있던 간선의 최소비용 값
					minEdge[i] = adjMatrix[minVertex][i];
				}
			}
			
		}
		System.out.println(result);
	}
}


/* input

5
0 5 10 8 7 
5 0 5 3 6 
10 5 0 1 3 
8 3 1 0 1 
7 6 3 1 0

output==>10

7
0 32 31 0 0 60 51
32 0 21 0 0 0 0
31 21 0 0 46 0 25
0 0 0 0 34 18 0
0 0 46 34 0 40 51
60 0 0 18 40 0 0
51 0 25 0 51 0 0

output==>175
*/
