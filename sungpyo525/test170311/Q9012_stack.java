package com.test170311;

import java.util.Scanner;
import java.util.Stack;

public class Q9012_stack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		
		while(N>0){
			String str=sc.next();
			if( isVPS(str) ) System.out.println("YES");
			else System.out.println("NO");
			
			N--;
		}
	}

	public static boolean isVPS(String str) {
		Stack<Character> stack = new Stack<>();
		
		//스택 활용 : 제대로 된 괄호는 여는 괄호가 먼저 나오고, 어디에 있든 닫는 괄호가 나온다.
		for(int i=0; i<str.length(); ++i){
			//열린 괄호가 나오면 스택에 넣고!
			if('('==str.charAt(i)){
				stack.push(str.charAt(i));
			} else { // 닫는 괄호가 나오면 미리 넣은 (를 pop 시킨다. (쌍이 있는 거니까)
				if(stack.empty()) return false; // pop할게 없는데 ) 나온거면 그냥 그건 false 
				else stack.pop();
			}
		}
		return stack.empty(); //스택이 아예 다 비어있으면(쌍이 다 맞으면) true
	}

}
