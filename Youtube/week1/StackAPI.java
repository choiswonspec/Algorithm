package week1;

import java.util.Stack;

public class StackAPI {

	public static void main(String[] args) {
		// TODO Stack API 사용
		Stack<String> stack = new Stack<String>();
		// empty는 Stack의 메서드, isEmpty는 리스트의 인터페이스 오버라이드 메서드 둘 다 사용해도 무관.
		System.out.println(stack.size()+"//"+stack.empty()+"//"+stack.isEmpty());
		stack.push("김태희");
		stack.push("송혜교");
		stack.push("최승원");
		
		System.out.println(stack.size()+"//"+stack.empty());
		System.out.println(stack.pop());
		System.out.println(stack.size()+"//"+stack.isEmpty());
		System.out.println(stack.peek());
		System.out.println(stack.size()+"//"+stack.empty());
		

	}

}
