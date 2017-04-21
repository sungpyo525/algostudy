package com.hanwha170419;

import java.util.Scanner;

public class Q1517 {

	public static void main(String[] args) {
		int N;
		Scanner sc =new Scanner(System.in);
		
		N=sc.nextInt();
		int d[]=new int[N];
		for(int i=0; i<N; i++)
			d[i]=sc.nextInt();
		
		int i=0;
		int swap=0;
		while(i<=N-2){
			if(d[i]>d[i+1]){
				int temp=d[i+1];
				d[i+1]=d[i];
				d[i]=temp;
				swap++;
				
				if(i==N-2)
					i=-1;
			}
			
			i++;
		}	
		
		System.out.println(swap);
	}

}
