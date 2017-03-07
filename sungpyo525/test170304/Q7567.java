package com.test170304;

import java.util.Scanner;

public class Q7567 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h=10;
		String plate=sc.nextLine();
		char c[] =plate.toCharArray();
		
		for(int i=1; i<c.length; i++){
			if(c[i-1]==c[i])
				h+=5;
			else
				h+=10;
		}
		
		System.out.println(h);
	}
}
