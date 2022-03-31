package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Day0208_SWEA1218 {

	public static void main(String[] args) throws IOException {
		// TODO 괄호 짝짓기
		int tc = 10;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=1; i<=tc; i++) {
		
			int n = Integer.parseInt(br.readLine());
			// 괄호 문자 저장할 stack 생성
			Stack<String> stack = new Stack<>();
			StringTokenizer st = new StringTokenizer(br.readLine(),"");
			for(int j=0; j<n; j++) {
				String str = st.nextToken();
				boolean isGodd = true;
				if(str.equals("{") || str.equals("(") || str.equals("[") || str.equals("<")) {
					stack.push(str);
				}else{
					switch(str) {
					case("}"):
						if(stack.pop() != "{" ) {
							System.out.println("#"+i+" "+1);
							isGodd = false;
						}
						break;
					case(")"):
						if(stack.pop() != "(" ) {
							System.out.println("#"+i+" "+1);
							isGodd = false;
						}
						break;
					case("]"):
						if(stack.pop() != "[" ) {
							System.out.println("#"+i+" "+1);
							isGodd = false;
						}
						break;
					case(">"):
						if(stack.pop() != "<" ) {
							System.out.println("#"+i+" "+1);
							isGodd = false;
						}
						break;
					} // switch 문 종료
				} // else문 종료
				if(isGodd==false) {
					break;
				}
			}
			System.out.println("#"+i+" "+0);
			
		}

	}

}
