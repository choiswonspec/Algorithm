package week1;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_Graph {

	static int[] di = { 0, 1, 0, -1 };
	static int[] dj = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		// TODO BFS로 그래프 탐색
		int[][] map = { { 9, 0, 0, 0 }, { 1, 1, 1, 0 }, { 0, 0, 7, 0 }, { 0, 1, 0, 1 } };
		boolean[][] visit = new boolean[4][4];

		Queue<Point> queue = new LinkedList<>(); // Queue는 interface라 LinkedList로 객체 생성

		queue.add(new Point(2, 2)); // static 클래스
		visit[2][2] = true;

		while (!queue.isEmpty()) {
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					System.out.print(visit[i][j]?'*':'0');
				}
				System.out.println();
			}
			System.out.println("----------------------");
			
			
			
			Point now = queue.poll();

			for (int d = 0; d < 4; d++) {
				int ni = now.i + di[d];
				int nj = now.j + dj[d];

				if (ni >= 0 && ni < 4 && nj >= 0 && nj < 4 && map[ni][nj] == 0 && !visit[ni][nj]) {
					visit[ni][nj] = true;
					queue.add(new Point(ni, nj));
				}
					
			}
		}

	}

	static class Point { // 내부 클래스. static으로 선언하여 객체화할필요가 없다.
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

}
