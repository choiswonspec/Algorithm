package week2;

import java.util.Scanner;

public class Day0214_Baekjoon20304_비밀번호제작 {

	public static void main(String[] args) {
		// TODO 비밀번호 제작
		Scanner sc = new Scanner(System.in); // Scanner 클래스의 객체 sc 선언

		int n = sc.nextInt(); // 관리자 패스워드의 최댓값을 나타내는 정수 N
		int m = sc.nextInt(); // 해커가 사용한 패스워드의 개수를 나타내는 정수 M
		int[] input = new int[m]; // m 크기의 정수형 배열 input 선언

		for (int i = 0; i < m; i++) { // m 만큼 반복문 수행
			input[i] = sc.nextInt(); // Scanner를 활용하여 input 배열의 각 인덱스에 값을 입력 받는다.
		}

		int max_boansung = 0;

		for (int i = 0; i <= n; i++) { // 새로운 패스워드는 0이상N이하이기 때문에 0부터 N까지를 for문을 통해 모두 탐색

			int boansung = Integer.MAX_VALUE;

			char[] new_password = Integer.toBinaryString(i).toCharArray(); // 정수 값을 String 형 이진수로 바꿔주는 함수 toBinaryString
																			// 사용
			// 그리고 이 String 형 이진수를 각각의 자릿수를 저장할 수 있도록 toCharArray 를 사용해 char형 배열에 저장한다.
			for (int j = 0; j < m; j++) { // input 배열을 탐색하기 위해 m 크기 만큼 반복문 수행
				char[] password = Integer.toBinaryString(input[j]).toCharArray(); // 기존 패스워드 중 하나를 password 변수에 임시 저장
				// 그리고 이 String 형 이진수를 각각의 자릿수를 저장할 수 있도록 toCharArray 를 사용해 char형 배열에 저장한다.

				int count = 0; // 두 패스워드의 자릿수에서 다른 숫자가 몇개인지를 저장할 변수 count 선언.

				if (new_password.length >= password.length) { // 둘 중 크기가 더 작은 것으로 반복문을 돌리기 위해 크기 비교 조건문을 건다.
					for (int k = password.length - 1; k >= 0; k--) { // 끝자리부터 비교해야 되므로 끝에서부터 탐색
						if (password[k] != new_password[k])
							count++; // 각 자리수마다 같은지를 비교해서 다르다면 count를 +1 한다
					}
					count += new_password.length - password.length;
				} else {
					for (int k = new_password.length - 1; k >= 0; k--) { //
						if (password[k] != new_password[k])
							count++;
					}
					count += password.length - new_password.length;
				}

				boansung = Math.min(boansung, count);
			}
			max_boansung = Math.max(max_boansung, boansung);

		}
		System.out.println(max_boansung);

	}

}
