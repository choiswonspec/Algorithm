package week4;

import java.util.Arrays;
import java.util.Scanner;

public class DP_MinCoin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		int[] D = new int[money+1]; // 해당 금액을 인덱스를 써야 하므로 배열의 크기를 +1을 해준다.
		D[0] = 0; // 0원을 만드는 최소 동전 개수는 0
		for(int i=1; i<=money; i++) {
			// 1, 4, 6원을 각각 하나씩 사용했을 때의 최소동전개수 중 가장 최적해(최소값)
			int min = Integer.MAX_VALUE;
			if(i>=1 && D[i-1]+1 < min) min=D[i-1]+1;
			if(i>=4 && D[i-4]+1 < min) min=D[i-4]+1;
			if(i>=6 && D[i-6]+1 < min) min=D[i-6]+1;
			
			D[i] = min; 
		}
		
		System.out.println(D[money]);
		System.out.println(Arrays.toString(D));
	}

}
