package com.test170304;

import java.util.Scanner;
import java.util.Stack;

public class Q1260 {
	static int n, m, v;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		v=sc.nextInt();
		
		int graph[][] = new int[n+1][n+1];
		int x,y;
		
		for(int i=0; i<m; i++){
			x=sc.nextInt();
			y=sc.nextInt();
			
			graph[x][y]=graph[y][x]=1;
			
			dfs(graph, v);
			System.out.println();
			bfs(graph, v);
		}
		
	}

	private static void dfs(int graph[][], int v) {
		int chk[]=new int[n+1];
		int peek, flag;
		Stack<Integer> s= new Stack<>();
		
		s.push(v);
		chk[v]=1;
		System.out.print("처음:"+ v + "-");
		
		while (!s.isEmpty()){
			peek=s.peek();
			flag=0;
			for(int i=1; i<graph.length; i++){
				if(graph[peek][i]==1 && chk[i]==0){
					chk[i]=1;
					flag=1;
					s.push(i);
					System.out.print("다음:"+i+"-");
					
					break;
				}
			}
			if(flag==0)
				s.pop();
		}
		
		
	}
	
	private static void bfs(int graph[][], int v) {
		// TODO Auto-generated method stub
		
	}

}
