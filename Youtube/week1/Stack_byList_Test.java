package week1;

public class Stack_byList_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack_byList stack = new Stack_byList();
		System.out.println(stack.isEmpty());
		stack.push("송재영");
		System.out.println(stack);
		stack.push("최승원");
		System.out.println(stack);
		stack.push("조이현");
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
	}

}
