package com.test170221;

import java.util.Scanner;

public class Quiz2749 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int mod= 1000000;
		int p = mod/(10*15);
		
		long n=sc.nextLong();
		int[] f= new int[p];
		f[0]=0;
		f[1]=1;
		
		for(int i=2; i<p; i++){
			f[i]=f[i-1]+f[i-2];
			f[i] %= mod;
		}
		
		System.out.println(f[(int) (n%p)]);

	}
}

