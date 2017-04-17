package com.hanwha170417;

import java.util.Arrays;
import java.util.Scanner;

public class GreatestNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input;
		input=sc.nextLine();
		char[] grn=new char[input.length()];
		
		grn=input.toCharArray();
		Arrays.sort(grn);
		
		for(int i=grn.length-1; i>=0; i--){
			System.out.print(grn[i]);
		}
	}
}
