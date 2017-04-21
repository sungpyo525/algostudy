package com.hanwha170420;

import java.util.Scanner;

public class Q5218_Distances {
	public static void main(String[] args) {
		int N;
		Scanner sc= new Scanner(System.in);
		
		N=sc.nextInt();
		
		for(int i=0; i<N; i++){
			char c1[]=sc.next().toCharArray();
			char c2[]=sc.next().toCharArray();
			int answer[]=new int [c1.length];
		
			for(int j=0; j<c1.length; j++){
				if(c1[j]<=c2[j])
					answer[j]=c2[j]-c1[j];
				else
					answer[j]=26-(c1[j]-c2[j]);
			}
			
			System.out.print("Distances: ");
			for(int j=0; j<c1.length; j++){
				System.out.print(answer[j]+" ");
			}System.out.println();
		}
	}

}
