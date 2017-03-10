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
		
		//���� Ȱ�� : ����� �� ��ȣ�� ���� ��ȣ�� ���� ������, ��� �ֵ� �ݴ� ��ȣ�� ���´�.
		for(int i=0; i<str.length(); ++i){
			//���� ��ȣ�� ������ ���ÿ� �ְ�!
			if('('==str.charAt(i)){
				stack.push(str.charAt(i));
			} else { // �ݴ� ��ȣ�� ������ �̸� ���� (�� pop ��Ų��. (���� �ִ� �Ŵϱ�)
				if(stack.empty()) return false; // pop�Ұ� ���µ� ) ���°Ÿ� �׳� �װ� false 
				else stack.pop();
			}
		}
		return stack.empty(); //������ �ƿ� �� ���������(���� �� ������) true
	}

}
