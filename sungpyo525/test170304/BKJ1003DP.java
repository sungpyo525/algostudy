package com.test170304;

import java.util.Scanner;

public class BKJ1003DP{
	
	public static Fibo[] fibos; // Memoization을 위한 객체 생성 (공간 크기 설정은 아직 안됨)
	public static int zeroCounter =0;
	public static int oneCounter=0;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int _case=0; _case<T; _case++){
			zeroCounter = oneCounter= 0;
			fibos=null;
			
			int N=sc.nextInt();
			if(N<0 || N>40) break;
			
			fibos=new Fibo[N+1]; //2를 입력한다 가정하면, 0 1 2 총 세 개를 해야하니까! 세개의 크기로 확보!
			fibonacci(N);
			System.out.println(zeroCounter+" "+oneCounter);
		}
		sc.close();
	}
	
	public static int fibonacci(int n){
		if(n==0){
			if(fibos[0]==null){
				fibos[0]=new Fibo(0,1,0);
			}
			zeroCounter+=fibos[0].zero;
			return 0;
		}
	
		else if(n==1){
			if(fibos[1]==null){
				fibos[1]=new Fibo(1,0,1);
			}
			oneCounter+=fibos[1].one;
			return 1;
		}
		else{
			int fibo1, fibo2; // 재귀로 n-1과  n-2의 값을 저장하는 곳
			
			if(fibos[n-1]==null) // Memoization 된것이 없으면 새로 n-1로 재귀 호출
				fibo1=fibonacci(n-1);
			else{ // 기록된 것이 있으면 또 기록하지 않고 원래 있던 것 사용하기 (시간 절약)
				fibo1=fibos[n-1].fibo;
				//System.out.println("기록1: "+fibo1);
				zeroCounter+=fibos[n-1].zero;
				oneCounter+=fibos[n-1].one;
			}
			
			if(fibos[n-2]==null)  // Memoization 된것이 없으면 새로 n-1로 재귀 호출
				fibo2=fibonacci(n-2);
			else{ // 기록된 것이 있으면 또 기록하지 않고 원래 있던 것 사용하기 (시간 절약)
				fibo2=fibos[n-2].fibo;
				//System.out.println("기록2: "+fibo2);
				zeroCounter+=fibos[n-2].zero;
				oneCounter+=fibos[n-2].one;
			}
			
			if(fibos[n]==null){ // Memoization : 리턴하고 끝내기 전에 또 기록해주기
				fibos[n]=new Fibo(fibo1+fibo2, zeroCounter, oneCounter);
			} else{
				zeroCounter+=fibos[n].zero;
				oneCounter+=fibos[n].one;
			}
			
			return fibo1+fibo2;
		}
	}

}




class Fibo{
	int fibo;
	int zero;
	int one;
	
	public Fibo(int fibo, int zero, int one){
		this.fibo=fibo;
		this.zero=zero;
		this.one=one;
	}
}
