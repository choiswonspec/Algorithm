package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day0216_Baekjoon1992_fail { // 쿼드트리

	public static int size;
    public static int[][] quadTree;
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        size = Integer.parseInt(br.readLine());
        quadTree = new int[size][size];
        sb = new StringBuilder();
        
        for(int i=0; i < size; i++) {
            String str = br.readLine();
            for(int j=0; j < size; j++) {
                quadTree[i][j] = Integer.parseInt(str.substring(j, j+1));
            }
        }
        
        srcQuadTree(0, 0, size);
        System.out.println(sb.toString());
    }
    
    public static boolean isAble(int row, int col, int size) {
        int t = quadTree[row][col];
        
        for(int i=row; i < row+size; i++) {
            for(int j=col; j < col+size; j++) {
                if(t != quadTree[i][j]) return false;
            }
        }
        return true;
    }
    
    public static void srcQuadTree(int row, int col, int size) {
        if(isAble(row, col, size)) {
            sb.append(quadTree[row][col]);
        }else {
            sb.append("(");
            int newSize = size/2;
            
            srcQuadTree(row, col, newSize);
            srcQuadTree(row, col + newSize, newSize);
            srcQuadTree(row + newSize, col, newSize);
            srcQuadTree(row + newSize, col + newSize, newSize);
            
            sb.append(")");
        }
    }

}
