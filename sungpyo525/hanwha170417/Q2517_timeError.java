package com.hanwha170417;

import java.util.Scanner;
// 달리기 (현재 시간 초과)

public class Q2517_timeError {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
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
			System.out.println(result[i]);
	}

}
