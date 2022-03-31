package week2;

import java.util.Scanner;

public class Subset_BinaryCounting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] input = new int[N];

		
		// N개의 숫자들이 어떤 숫자로 구성되었는지 입력
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		
		Subset(input);
	}
	
	private static void Subset(int[] input) {
		int N = input.length; // 집합의 원소의 수
		for (int flag = 0, caseCount = 1<<N; flag < caseCount; flag++) { 
			// flag : 원소들의 선택상태의 비트열을 나타냄
			for(int i=0; i<N; i++) { // 원소의 크기 만큼 반복하며 각 비트열의 상태를 확인
				if((flag & 1<<i)!=0) {
					System.out.print(input[i]+" ");
				}
			}
			System.out.println();
		}
	}

}