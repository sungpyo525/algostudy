package com.test170307;

import java.util.Scanner;

public class Q1149_again {
	static int N, rgb[][], dparr[][], mincost;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		
		rgb=new int[N][3];
		dparr=new int[N][3];
		
		for(int i=0; i<N; i++){
			for(int j=0; j<3; j++){
				rgb[i][j]=sc.nextInt();
			}
		}
		
		solve();
		System.out.println(mincost);
	}

	private static void solve() {
		int i=0;
		dparr[i][0]=rgb[i][0];
		dparr[i][1]=rgb[i][1];
		dparr[i][2]=rgb[i][2];
		
		if(N>0)
			for( i=1; i<N ; i++){
				
				//현재가 R일때
				if(dparr[i-1][1] < dparr[i-1][2])
					dparr[i][0]=dparr[i-1][1]+rgb[i][0];
				else
					dparr[i][0]=dparr[i-1][2]+rgb[i][0];
				
				
				//현재가 G일때
				if(dparr[i-1][0] < dparr[i-1][2])
					dparr[i][1]=dparr[i-1][0]+rgb[i][1];
				else
					dparr[i][1]=dparr[i-1][2]+rgb[i][1];
				
				//현재가 B일때
				if(dparr[i-1][0] < dparr[i-1][1])
					dparr[i][2]=dparr[i-1][0]+rgb[i][2];
				else
					dparr[i][2]=dparr[i-1][1]+rgb[i][2];
					
				
				mincost=dparr[N-1][0];
				if(mincost>dparr[N-1][1])
					mincost=dparr[N-1][1];
				if(mincost>dparr[N-1][2])
					mincost=dparr[N-1][2];
			}
		
	}
	
	
}
