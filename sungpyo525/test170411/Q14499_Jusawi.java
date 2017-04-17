package com.test170411;

import java.util.Scanner;

public class Q14499_Jusawi {
	static int n, m, x, y, k;
	static int [][]map=new int[20][20];
	static int dice[]={0, 0, 0, 0, 0, 0, 0};
	
	
	//이번 오프셋은 동, 서, 북, 남 순으로 함
	static int dx[]={0,0,-1,1};
	static int dy[]={1,-1,0,0};
	
	public static boolean safe(int x, int y){
		boolean what=false;
		if(x>=0 && x<n && y>=0 && y<m)
			what=true;
		return what;
	}

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		x=sc.nextInt();
		y=sc.nextInt();
		k=sc.nextInt();
		
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				map[i][j]=sc.nextInt();
			}
		}
		int ndice[]=new int[7];
		for(int i=0; i<k; i++){
			int order;
			order=sc.nextInt();
			order--;
			
			int nx=x+dx[order];
			int ny=y+dy[order];
			
			if(!safe(nx, ny))
				continue;
			
			
			if(order==0){
				ndice[3]=dice[1];
				ndice[1]=dice[4];
				ndice[4]=dice[6];
				ndice[6]=dice[3];
				ndice[2]=dice[2];
				ndice[5]=dice[5];
			}if(order==1){
				ndice[1]=dice[3];
				ndice[3]=dice[6];
				ndice[6]=dice[4];
				ndice[4]=dice[1];
				ndice[2]=dice[2];
				ndice[5]=dice[5];
			}
			if(order==2){
				ndice[1]=dice[5];
				ndice[5]=dice[6];
				ndice[6]=dice[2];
				ndice[2]=dice[1];
				ndice[3]=dice[3];
				ndice[4]=dice[4];
			}
			if(order==3){
				ndice[1]=dice[2];
				ndice[2]=dice[6];
				ndice[6]=dice[5];
				ndice[5]=dice[1];
				ndice[3]=dice[3];
				ndice[4]=dice[4];
			}
			
			if(map[nx][ny]==0){
				map[nx][ny]=ndice[6];
			} else{
				ndice[6]=map[nx][ny];
				map[nx][ny]=0;
			}
			System.out.println(ndice[1]);
			
			for(int j=0; j<7; j++){
				dice[j]=ndice[j];
			}
			x=nx;
			y=ny;
		}
		
	}
}
