package com.test170307;

import java.util.Scanner;

public class Q2210 {
	static int map[][]=new int[5][5];
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		for(int i=0; i<5; i++){
			for(int j=0; j<5; j++){
				map[i][j]=sc.nextInt();
			}
		}
	}

}
