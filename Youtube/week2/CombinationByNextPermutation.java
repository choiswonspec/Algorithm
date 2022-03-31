package week2;

import java.util.Scanner;

public class CombinationByNextPermutation {


	public static void main(String[] args) {
		// TODO 조합을 NextPermutation으로 구현

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int R = sc.nextInt();

		int[] input = new int[N];

		// N개의 숫자 입력 받기
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		int[] p = new int[N];
		// p배열에 0보다 큰 값으로 R개를 맨뒤부터 채운다.
		int cnt = 0;
		while (++cnt <= R)
			p[N - cnt] = 1; // 뒤에서부터 R개만큼 1을 채운다

		do {
			for(int i=0; i<N; i++) {
				if(p[i]==1) {
					System.out.print(input[i]+" ");
				}
			}
			System.out.println();
		} while (np(p));

	}

	private static boolean np(int[] p) { // static 변수보다 이렇게 매개변수로 처리하는게 사실 더 좋음
		
		int N = p.length;
		
		// 1. 교환위치 찾기
		int i = N - 1; // 맨 뒤 인덱스부터 시작
		while (i > 0 && p[i - 1] >= p[i])
			--i; // 커지다가 작아지는 순간 나올 때까지 계속 인덱스 줄여간다. i가 음수되지 않게하는 조건도 같이 준다

		if (i == 0)
			return false; // i가 0인 된 경우는 마지막 순열을 찾은 경우이다.

		// 2. 교환위치에 교환할 값 찾기
		int j = N - 1;
		while (p[i - 1] >= p[j])
			j--; // 교환위치 값 보다 더 큰 값을 찾을 때까지 j를 줄여간다. j는 어차피 꼭대기에 도착하면 코드가 만족되기 때문에 범위 조건 없어도됨

		// j를 찾고나서 코드
		// 3. 교환위치 인덱스 값과 j 인덱스 값 을 교환한다.
		int temp = p[i - 1];
		swap(p, i - 1, j);

		// 4. 꼭대기 부터 맨 뒤까지 만들 수 있는 가장 작은 순열 생성. 즉 오름차순 정렬을 해라
		// 해당 범위에 있는 값의 가장 큰 값과 가장 작은 값을 바꿔주는 식으로 정렬하고 인덱스를 다시 좁혀가면서 바꾸는 식을 반복
		int k = N - 1;
		while (i < k) {
			swap(p, i++, k--); // 꼭대기 인덱스 부터 +1 씩, 맨 뒤 인덱스부터는 -1 씩 좁혀가면서 반복
		} // i와 k가 같아지는 순간 빠져나온다.

		return true; // 다음 순열 생성 성공f

	}

	// 값 교환을 위한 함수 생성
	public static void swap(int[] p, int i, int j) { // static 변수보다 이렇게 매개변수로 처리하는게 사실 더 좋음
		int temp = p[i];
		p[i] = p[j];
		p[j] = temp;
	}

}
