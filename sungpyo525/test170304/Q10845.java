package com.test170304;

import java.util.Scanner;

public class Q10845 {
	public static void main(String[] args) {
		Queue que =new Queue();
		Scanner sc = new Scanner(System.in);
		int commandCtr = sc.nextInt();
		String command;
		
		for(int i=1; i<=commandCtr; i++){
			command=sc.next();
			if(command.equals("push")){
				int x=sc.nextInt();
				que.push(x);
			} else if(command.equals("pop"))
				que.pop();
			else if(command.equals("size"))
				que.size();
			else if(command.equals("empty"))
				que.empty();
			else if(command.equals("front"))
				que.front();
			else if(command.equals("back"))
				que.back();
		}
		
		
		
	}
	
	static class Queue{
		private int size=0;
		private SNode front=null;
		private SNode back=null;
		
		private class SNode{
			int data;
			private SNode next;
		}
		
		public void front(){
			if(front==null)
				System.out.println(-1);
			System.out.println();
		}
		
		public void back(){
			if(back==null)
				System.out.println(-1);
			System.out.println();
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
			node.next=back;
			back=node;
			size++;
		}
		
		public void pop(){
			if (size==0)
				System.out.println(-1);
			else{
				System.out.println(front.data);
				front=front.next;
				size--;	
			}
		}
	}
}


