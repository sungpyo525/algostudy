package com.test170307;

import java.util.Scanner;


public class Q1149 {
	static int N;
	static int rgb[][]; // �� ���� rgb ĥ�� ���� ��� ����
	static int dp_arr[][]; // ���� ĥ�� �� ���� ��� �ּҰ��� ���
	static int mincost; // �������� �ּ� ��� �� ����
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//���� �� �Է¹ޱ�
		 N=sc.nextInt();
		 
		 rgb=new int[N][3];
		 dp_arr=new int[N][3];
		
		//�� ���� rgb ��� �Է� �ޱ�
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
		// ���� ������ ���� ���� ���� ������ ����� ����Ͽ� �����Ѵ�!
		// ���� 3��°(�ε���3-1) ���� R�� �����ϸ� ���� ���� B�� G�϶��� �ּҰ��� �����ϴ°ɷ�!
		dp_arr[i][0]=rgb[i][0];
		dp_arr[i][1]=rgb[i][1];
		dp_arr[i][2]=rgb[i][2];
		
		if(N>0){
			for(i=1; i<N; i++){
				
				//���� ������ R�϶�, ���� ������ G�� B�� �͵鿡 ���� �ּҰ��� ���ϰ� ��� ����
				if(dp_arr[i-1][1] < dp_arr[i-1][2]){
					//G�� �� �ּ��� ��
					dp_arr[i][0] = dp_arr[i-1][1] + rgb[i][0];
				}
				else{
					//B�� �� �ּ��� ��
					dp_arr[i][0] = dp_arr[i-1][2] + rgb[i][0];
				}
				
				// ���� ������ G�϶�, ���� ������ R�� B�� �͵鿡 ���� �ּҰ��� ���ϰ� ��� ����
				if(dp_arr[i-1][0] < dp_arr[i-1][2]){
					dp_arr[i][1] = dp_arr[i-1][0] + rgb[i][1];
				}else{
					dp_arr[i][1] = dp_arr[i-1][2] + rgb[i][1];
				}
				
				// ���� ������ B�϶�, ���� ������ R�� G�� �͵鿡 ���� �ּҰ��� ���ϰ� ��� ����
				if(dp_arr[i-1][0] < dp_arr[i-1][1]){
					dp_arr[i][2] = dp_arr[i-1][0] + rgb[i][2];
				} else {
					dp_arr[i][2] = dp_arr[i-1][1] + rgb[i][2];
				}
			}
		}
		
		// ������ �������� �ּҰ��� ������ �÷��� ����� �����Ѵ�.
		// dp_arr���� �̹� ���� ��츦 ����ϸ� �� ����� ����� ���̱� ������ ������ ���� ���� �ȴ�.
		mincost = dp_arr[N-1][0];
		if(mincost > dp_arr[N-1][1]){
			mincost=dp_arr[N-1][1];
		}
		if(mincost > dp_arr[N-1][2]){
			mincost=dp_arr[N-1][2];
		}
		
	}
}
