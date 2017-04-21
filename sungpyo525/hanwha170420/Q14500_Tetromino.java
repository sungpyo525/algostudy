package com.hanwha170420;

import java.util.Scanner;

public class Q14500_Tetromino {
	static int map[][];
	static int visit[][];
	static int A[]=new int[4];
	static int dx[]={-1,1,0,0};
	static int dy[]={0,0,-1,1};
	static int N, M, ret;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		
		map=new int[N][M];
		visit=new int[N][M];
		
		for(int i=0; i<N; i++)
			for(int j=0; j<M; j++)
				map[i][j]=sc.nextInt();
		
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				solve(i,j,0);
				visit[i][j]=0;
			}
		}
	
		// で
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				int tmp=map[i][j];
				if(i-1>=0 && j-1>=0 && j+1<M){
					tmp+=map[i-1][j]+map[i][j-1]+map[i][j+1];
					ret=Math.max(ret, tmp);
				}
			}
		}
		
		// ぬ
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				int tmp=map[i][j];
				if(i+1<N && j-1>=0 && j+1<M){
					tmp+=map[i+1][j]+map[i][j-1]+map[i][j+1];
					ret=Math.max(ret, tmp);
				}
			}
		}
		
		// た
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				int tmp=map[i][j];
				if(i-1>=0 && i+1<N && j+1<M){
					tmp+=map[i-1][j]+map[i+1][j]+map[i][j+1];
					ret=Math.max(ret, tmp);
				}
			}
		}
		
		
		// っ 
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				int tmp=map[i][j];
				if(i-1>=0 && j-1>=0 && i+1<N){
					tmp+=map[i-1][j]+map[i][j-1]+map[i+1][j];
					ret=Math.max(ret, tmp);
				}
			}
		}
		
		System.out.println(ret);
	}
	public static void solve(int y, int x, int d) {
		if(d==4)
			return;
		
		visit[y][x]=1;
		A[d]=map[y][x];
		
		for(int i=0; i<4; i++){
			int ny=y+dy[i];
			int nx=x+dx[i];
			
			if(ny>=0 && ny<N && nx>=0 && nx<M && visit[ny][nx]==0){
				solve(ny, nx, d+1);
				visit[ny][nx]=0;
			}
		}
		
		if(d==3){
			int tmp=0;
			for(int i=0; i<4; i++)
				tmp+=A[i];
			
			ret=Math.max(ret, tmp);
		}
		
	}
}
