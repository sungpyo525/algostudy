package com.hanwha170417;

import java.util.Scanner;
import java.util.Stack;
class Pair{
	char alpha;
	int count;
	
	public Pair(char alpha, int count){
		this.alpha=alpha;
		this.count=count;
	}
}
public class CharCounting {
	static Stack<Pair> stack=new Stack<Pair>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] input=sc.nextLine().toCharArray();
		
		for(int i=0; i<input.length; i++){
			if(i==0)
				stack.push(new Pair(input[i], 1));
			
			while(i>=1){
				if(input[i-1]==input[i]){
					stack.peek().count++;
					break;
				}
				else{
					stack.push(new Pair(input[i],1));
					break;
				}
			}
		}
		
		for(int i=0; i<stack.size(); i++){
			System.out.print(stack.get(i).alpha);
			System.out.print(stack.get(i).count);
		}
	}
}
