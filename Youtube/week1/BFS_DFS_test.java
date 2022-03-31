package week1;

public class BFS_DFS_test {

	public static void main(String[] args) {
		// TODO BFS 실행
		int size = 9; // 이진트리에 A부터 I까지 저장하게 만들고 싶다
		BFS_DFS_CompleteBinaryTree bfs = new BFS_DFS_CompleteBinaryTree(size);
		
		for(int i=0; i<size; i++) {
			bfs.add((char)(65+i)); // A, B, C, D, E, F, G, H, I
		}
		
		bfs.bfs();
		System.out.println("---------------------");
		bfs.bfs2();
		System.out.println("---------------------");
		bfs.dfs();
	}

}
