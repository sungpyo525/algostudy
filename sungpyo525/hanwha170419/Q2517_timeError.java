package com.hanwha170419;

import java.util.Arrays;
import java.util.Scanner;
// 달리기 (현재 시간 초과)
class Pair{
	int x;
	int y;
	public Pair(int x, int y){
		this.x=x;
		this.y=y;
	}
}
class fenwick{
	int tree[] = new int [500005];
	int size;
	public fenwick(int sz){
		Arrays.fill(tree, 0);
		size=sz+1;
	}
	public int sum(int pos){
		++pos;
		int ret=0;
		while(pos>0){
			ret+=tree[pos];
		}
		return 0;
	}
}

public class Q2517_timeError {
	static int n;
	static Pair [] num= new Pair[500002];
	static int[] mapped=new int [500002];
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		/*
		int N=sc.nextInt();
		int []player=new int[N];
		int []result=new int[N];
		
		for(int i=0; i<N; i++){
			player[i]=sc.nextInt();
		}
		
		for(int i=0; i<N; i++){
			result[i]=i+1;
			
			int j=i;
			while(j>0){
				if(player[j-1]<player[i])
					result[i]--;
				j--;
			}
		}
		
		for(int i=0; i<N; i++)
			System.out.println(result[i]);*/
		
		
		
	}

}
