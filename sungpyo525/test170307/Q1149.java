package com.test170307;

import java.util.Scanner;


public class Q1149 {
	static int N;
	static int rgb[][]; // 각 집의 rgb 칠할 때의 비용 저장
	static int dp_arr[][]; // 집을 칠할 때 마다 드는 최소값을 계산
	static int mincost; // 최종적인 최소 비용 값 저장
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//집의 수 입력받기
		 N=sc.nextInt();
		 
		 rgb=new int[N][3];
		 dp_arr=new int[N][3];
		
		//각 집의 rgb 비용 입력 받기
		for( int i=0; i<N; i++){
			for(int j=0; j<3; j++){
				rgb[i][j] = sc.nextInt();
			}
		}
		
		solve();
		
		System.out.println(mincost);
	}
	
	
	
	public static void solve(){
		int i=0;
		// 새로 저장할 집의 색을 이전 까지의 결과를 고려하여 저장한다!
		// 만약 3번째(인덱스3-1) 집에 R을 선택하면 이전 집이 B나 G일때의 최소값을 저장하는걸로!
		dp_arr[i][0]=rgb[i][0];
		dp_arr[i][1]=rgb[i][1];
		dp_arr[i][2]=rgb[i][2];
		
		if(N>0){
			for(i=1; i<N; i++){
				
				//현재 순번이 R일때, 이전 순번이 G나 B인 것들에 대한 최소값을 비교하고 결과 저장
				if(dp_arr[i-1][1] < dp_arr[i-1][2]){
					//G가 더 최소일 때
					dp_arr[i][0] = dp_arr[i-1][1] + rgb[i][0];
				}
				else{
					//B가 더 최소일 때
					dp_arr[i][0] = dp_arr[i-1][2] + rgb[i][0];
				}
				
				// 현재 순번이 G일때, 이전 순번이 R나 B인 것들에 대한 최소값을 비교하고 결과 저장
				if(dp_arr[i-1][0] < dp_arr[i-1][2]){
					dp_arr[i][1] = dp_arr[i-1][0] + rgb[i][1];
				}else{
					dp_arr[i][1] = dp_arr[i-1][2] + rgb[i][1];
				}
				
				// 현재 순번이 B일때, 이전 순번이 R나 G인 것들에 대한 최소값을 비교하고 결과 저장
				if(dp_arr[i-1][0] < dp_arr[i-1][1]){
					dp_arr[i][2] = dp_arr[i-1][0] + rgb[i][2];
				} else {
					dp_arr[i][2] = dp_arr[i-1][1] + rgb[i][2];
				}
			}
		}
		
		// 마지막 집에서의 최소값을 가지는 컬러로 결과를 저장한다.
		// dp_arr에는 이미 이전 경우를 고려하며 다 결과가 저장된 것이기 때문에 마지막 집만 보면 된다.
		mincost = dp_arr[N-1][0];
		if(mincost > dp_arr[N-1][1]){
			mincost=dp_arr[N-1][1];
		}
		if(mincost > dp_arr[N-1][2]){
			mincost=dp_arr[N-1][2];
		}
		
	}
}
