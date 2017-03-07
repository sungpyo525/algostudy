package com.test170304;

import java.util.Scanner;

public class Q10828 {
	public static void main(String[] args) {
		Stack stack =new Stack();
		Scanner sc = new Scanner(System.in);
		int commandCtr = sc.nextInt();
		String command;
		
		for(int i=1; i<=commandCtr; i++){
			command=sc.next();
			if(command.equals("push")){
				int x=sc.nextInt();
				stack.push(x);
			} else if(command.equals("pop"))
				stack.pop();
			else if(command.equals("size"))
				stack.size();
			else if(command.equals("empty"))
				stack.empty();
			else if(command.equals("top"))
				stack.top();
		}
		
		
		
	}
	
	static class Stack{
		private int size=0;
		private SNode top=null;
		
		private class SNode{
			int data;
			private SNode next;
		}
		
		public void top(){
			if(top==null)
				System.out.println(-1);
			else
				System.out.println(top.data);
		}
		
		public void empty(){
			if(size==0)
				System.out.println(1);
			else
				System.out.println(0);
		}
		
		public void size(){
			System.out.println(size);
		}
		public void push (int x){
			SNode node= new SNode();
			node.data=x;
			node.next=top;
			top=node;
			size++;
		}
		
		public void pop(){
			if (size==0)
				System.out.println(-1);
			else{
				System.out.println(top.data);
				top=top.next;
				size--;	
			}
		}
	}
}


