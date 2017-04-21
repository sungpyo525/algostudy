package com.hanwha170419;

import java.util.Scanner;

public class Q1074 {
	static int N;
	static int [][]map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		int size=2;
		
		for(int i=1; i<N; i++){
			size*=2;
		}
		
		map=new int[size][size];
		
		for(int i=0; i<size; i++){
			for(int j=0;j<size; j++)
				System.out.print(map[i][j]);
			System.out.println();
		}
		
	}
}
