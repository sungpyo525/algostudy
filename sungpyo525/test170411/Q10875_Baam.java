package com.test170411;

import java.util.Scanner;

public class Q10875_Baam {
	static int n;
	static int t[];
	static char dir[];
	static long map[][];
	static long visited[][];
	
	static int x, y;
	
	// (null), 동, 북, 서, 남순
	static int dx[]={0, 0, -1, 1, 0};
	static int dy[]={0, 1, 0, 0, -1};
	
	static int way=1; // 동쪽 방향으로 초기화
	static int order;
	static int count=0;
	
	public static boolean safe(int x, int y){
		boolean what=false;
		if(x>=0 && x<2*n+1 && y>=0 && y<2*n+1 && visited[x][y]!=1)
			what=true;
		return what;
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		n=sc.nextInt();
		int k=sc.nextInt();
		
		map=new long[2*n+1][2*n+1];
		visited=new long[2*n+1][2*n+1];
		visited[n][n]=1;
		x=y=n;
		t=new int[k];
		dir=new char[k];
		
		for(int i=0; i<k; i++){
			t[i]=sc.nextInt();
			dir[i]=sc.next().charAt(0);
		}
		
		// 동1, 북2, 남3, 서4
		oneskip:
		for(int i=0; i<k; i++){
			if(way==1){
				if(dir[i]=='L') order=2;
				else if(dir[i]=='R')	order=3;
			}else if(way==2){
				if(dir[i]=='L') order=4;
				else if(dir[i]=='R') order=1;
			}else if(way==3){
				if(dir[i]=='L') order=1;
				else if(dir[i]=='R') order=4;
			}else if(way==4){
				if(dir[i]=='L') order=3;
				else if(dir[i]=='R')	order=2;
			}
			
			for(int j=0; j<t[i]; j++){
				int nx=x+dx[way];
				int ny=y+dy[way];
				
				if(!safe(nx, ny)){
					count++;
					break oneskip;
				}
				
				visited[nx][ny]=1;
				x=nx;
				y=ny;
				count++;
			}
			
			way=order;
		}
		
		System.out.println(count);
		System.out.println();
		
		
		//테스트 뱀이 지나간 경로 테스트용
		for(int i=0; i<2*n+1; i++){
			for(int j=0; j<2*n+1; j++){
				System.out.print(visited[i][j]);
			}
			System.out.println();
		}
		
	}

}
