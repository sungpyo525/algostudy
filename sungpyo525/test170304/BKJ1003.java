package com.test170304;

import java.util.Scanner;

public class BKJ1003 {
	
	private static int cnt0=0;
	private static int cnt1=0;
	
	public static int fibo (int n) {
		if(n==0){	
			cnt0++;
			return 0;		
		} else if (n==1){
			cnt1++;
			return 1;
		} else{
			return fibo(n-1)+fibo(n-2);
		}
	
	}

	
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int loop=sc.nextInt();
		for(int i=0 ; i<loop ; i++){
			int N=sc.nextInt();
			fibo(N);
			System.out.println(cnt0+" "+cnt1);
			
			cnt0=0;
			cnt1=0;
		}
	}


}