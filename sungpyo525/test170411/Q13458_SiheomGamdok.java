package com.test170411;

import java.util.Scanner;

/* 틀린 소스
public class Q13458_SiheomGamdok {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N=sc.nextInt();
		int A[]=new int[N];
		for(int i=0; i<N; i++){
			A[i]=sc.nextInt();
		}
		int B=sc.nextInt();
		int C=sc.nextInt();
		
		int chongGD=N;
		int buGD[]=new int [N];
		
		for(int i=0; i<N; i++){
			A[i]=A[i]-B;
			if(A[i]==0){
				buGD[i]=0;
				continue;
			}
			buGD[i]=A[i]/C;
			if(A[i]%C!=0){
				buGD[i]++;
			}
		}
		
		int total=chongGD;
		for(int i=0; i<N; i++){
			total=total+buGD[i];
		}
		System.out.println(total);
	}
}
*/

public class Q13458_SiheomGamdok {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N=sc.nextInt();
		int A[]=new int[N];
		for(int i=0; i<N; i++){
			A[i]=sc.nextInt();
		}
		int B=sc.nextInt();
		int C=sc.nextInt();
		
		// 중요****************************************
		long cnt=0; // 전체 카운트를 int로 하면 안되는 이유
		// 학급 수와 각 반의 학생 수 최대치가 각각 1000000이기 때문에
		// 1000000*1000000하면 int의 범위를 초과할 수 있다.
		
		for(int i=0; i<N; i++){
			// 1. 총 감독 수 부터 계산하고
			A[i]=A[i]-B;
			cnt++;
			if(A[i]<=0) continue; // 0이하일 경우 바로 다음 클래스로 가도록 
			
			
			// 2. 부 감독 수 계산하기 
			// 부 감독가능 인원수 보다 남은 인원이 더 많을때만 나누기 해주기! (아니면 그냥 cnt++;만)_
			if(C<A[i]){ 
				if(A[i]%C==0)
					cnt+=A[i]/C;
				else cnt+=A[i]/C+1;
			}else{
				cnt++;
			}
		}			
		System.out.println(cnt);
	}
}

