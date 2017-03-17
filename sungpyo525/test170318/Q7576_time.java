package com.test170318;

import java.util.Scanner;

public class Q7576_time {
	static int M, N;
	static int map[][];
	static boolean visited[][];
	
	static int roff[]= {-1, 1, 0, 0};
	static int coff[]= {0, 0, -1, 1};
	
	static boolean istrue=true;
	static int count=0;
	static int result=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		M=sc.nextInt();
		N=sc.nextInt();
		
		map= new int[N][M];
		visited=new boolean [N][M];
		
		
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				map[i][j]=sc.nextInt();
			}
		}
		
		
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				if(map[i][j]==1)
					visited[i][j]=true;
				else
					visited[i][j]=false;
			}
		}
		
		// �Է� ���� ��� �׽�Ʈ
		/*
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}*/
		
		solve();
		System.out.println(count);
		
	}

	public static void solve() {
		//�����ϱ� �� : ��� 1����, ��� 0������ ī��Ʈ�ϱ�
		int cnt0=0, cnt1=0, cntm1=0;
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				if(map[i][j]==0)
					cnt0++;
				else if(map[i][j]==1)
					cnt1++;
				else if(map[i][j]==-1)
					cntm1++;
			}
		}
		
		// ī��Ʈ �� ����� ���� ��� �;�����, ���� �� ������ �Ǻ� �� ����
		if(cnt0==(N*M)-cntm1){
			count= -1; 	// ��� 0�̸� -1 ����
			return;
		}
		if(cnt1==(N*M)-cntm1){
			count= 0; 	// ��� 1�̸� 0 ����
			return;
		}

		while(istrue){
			for (int x=0; x<N; x++){
				for(int y=0; y<M; y++){
					if(map[x][y]==0){
						
						for(int k=0; k<4; k++){
							int nx= x+roff[k];
							int ny= y+coff[k];
							
							// ó�� ĭ ����� �Ȱ�
							if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
							
							// 0�̰ų� -1�̸� �Ȱ�
							if(map[nx][ny]==0 || map[nx][ny]==-1) continue;
							
							if(!visited[nx][ny]) continue;
							
							map[x][y]=1;
							
						}
					}
				}
				
			}
			
			for(int i=0; i<N; i++){
				for(int j=0; j<M; j++){
					if(map[i][j]==1)
						visited[i][j]=true;
					else
						visited[i][j]=false;
				}
			}
			count++;
			
			
			cnt0=0; cnt1=0; cntm1=0;
			for(int i=0; i<N; i++){
				for(int j=0; j<M; j++){
					if(map[i][j]==0)
						cnt0++;
					else if(map[i][j]==1)
						cnt1++;
					else if(map[i][j]==-1)
						cntm1++;
				}
			}
			
			if(cnt0>=1)
				continue;
			if(cnt1==(N*M)-cntm1){
				return;
			}
		}		
	}

}
