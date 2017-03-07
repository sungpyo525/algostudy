package com.test170304;

import java.util.Scanner;

public class BKJ1003DP{
	
	public static Fibo[] fibos; // Memoization�� ���� ��ü ���� (���� ũ�� ������ ���� �ȵ�)
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
			
			fibos=new Fibo[N+1]; //2�� �Է��Ѵ� �����ϸ�, 0 1 2 �� �� ���� �ؾ��ϴϱ�! ������ ũ��� Ȯ��!
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
			int fibo1, fibo2; // ��ͷ� n-1��  n-2�� ���� �����ϴ� ��
			
			if(fibos[n-1]==null) // Memoization �Ȱ��� ������ ���� n-1�� ��� ȣ��
				fibo1=fibonacci(n-1);
			else{ // ��ϵ� ���� ������ �� ������� �ʰ� ���� �ִ� �� ����ϱ� (�ð� ����)
				fibo1=fibos[n-1].fibo;
				//System.out.println("���1: "+fibo1);
				zeroCounter+=fibos[n-1].zero;
				oneCounter+=fibos[n-1].one;
			}
			
			if(fibos[n-2]==null)  // Memoization �Ȱ��� ������ ���� n-1�� ��� ȣ��
				fibo2=fibonacci(n-2);
			else{ // ��ϵ� ���� ������ �� ������� �ʰ� ���� �ִ� �� ����ϱ� (�ð� ����)
				fibo2=fibos[n-2].fibo;
				//System.out.println("���2: "+fibo2);
				zeroCounter+=fibos[n-2].zero;
				oneCounter+=fibos[n-2].one;
			}
			
			if(fibos[n]==null){ // Memoization : �����ϰ� ������ ���� �� ������ֱ�
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
