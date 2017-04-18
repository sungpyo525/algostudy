package com.hanwha170417;

import java.util.Scanner;
//¾ËÆÄºª °³¼ö
public class Q10808 {
	static int alpha[] = new int[26];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input;
		
		input=sc.nextLine();
		char c[]=input.toCharArray();
		
		for(int i=0; i<c.length; i++){
			alpha[c[i]-97]++;
		}
		
		for(int i=0; i<alpha.length; i++){
			System.out.print(alpha[i]+" ");
		}

	}
}
