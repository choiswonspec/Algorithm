package week1;

public class DFS_Graph {
	static int[] di = { -1, 0, 1, 0 }; // up, left, down, right
	static int[] dj = { 0, -1, 0, 1 };

	static int[][] map = { 
			{ 9, 0, 0, 0 }, 
			{ 1, 1, 1, 0 }, 
			{ 0, 0, 7, 0 }, 
			{ 0, 1, 0, 1 } 
			};
	static boolean[][] visit = new boolean[4][4];

	public static void main(String[] args) {

		dfs(2, 2);
	}

	static void dfs(int nowi, int nowj) {
		System.out.println("현재 방문 : " + nowi + "," + nowj);
		visit[nowi][nowj] = true; // 방문내역 기록.
/////////////////////////////////////////////////////////////////	
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(visit[i][j] ? '*' : '0');
			}
			System.out.println();
		}
		System.out.println("---------------");
///////////////////////////////////////////////////////////////////
		for (int d = 0; d < 4; d++) {
			int nexti = nowi + di[d];
			int nextj = nowj + dj[d];

//			if(nexti<0 || nexti>=4 || nextj<0 || nextj>=4 || 
//					visit[nexti][nextj] || map[nexti][nextj]==1) continue;
			if (nexti >= 0 && nexti < 4 && nextj >= 0 && nextj < 4 
					&& !visit[nexti][nextj] && map[nexti][nextj] == 0) {
				dfs(nexti, nextj);
			}
		}
	}
}
