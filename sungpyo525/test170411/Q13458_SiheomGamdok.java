package com.test170411;

import java.util.Scanner;

/* Ʋ�� �ҽ�
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
		
		// �߿�****************************************
		long cnt=0; // ��ü ī��Ʈ�� int�� �ϸ� �ȵǴ� ����
		// �б� ���� �� ���� �л� �� �ִ�ġ�� ���� 1000000�̱� ������
		// 1000000*1000000�ϸ� int�� ������ �ʰ��� �� �ִ�.
		
		for(int i=0; i<N; i++){
			// 1. �� ���� �� ���� ����ϰ�
			A[i]=A[i]-B;
			cnt++;
			if(A[i]<=0) continue; // 0������ ��� �ٷ� ���� Ŭ������ ������ 
			
			
			// 2. �� ���� �� ����ϱ� 
			// �� �������� �ο��� ���� ���� �ο��� �� �������� ������ ���ֱ�! (�ƴϸ� �׳� cnt++;��)_
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

