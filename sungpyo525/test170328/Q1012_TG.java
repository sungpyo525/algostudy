package com.test170328;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point2 {
	int x;
	int y;

	public Point2(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Q1012_TG {
	static int map[][]=new int[2501][2501];
	static int visited[][]=new int[2501][2501];
	
	static int t, m, n, k;
	static int cnt=0;
	
	static int roff[] = { 1,0,0,-1 };
	static int coff[] = { 0,1,-1,0 };
	
	static Queue<Point2> q = new LinkedList<Point2>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x, y;
		t=sc.nextInt();
		
		for(int i=1; i<=t; i++){
			init(); cnt=0;
			
			m=sc.nextInt();
			n=sc.nextInt();
			k=sc.nextInt();
			
			for(int j=1; j<=k; j++ ){
				x=sc.nextInt();
				y=sc.nextInt();
				
				map[y][x]=1;
				
				// ★★★★★★
				//틀릴수 있는 부분!! 큐에 저장해줄때는 y랑 x 순서 헷갈리지 말기!
				// 행렬로 접근할때는 y를 앞에 써주지만,
				// 큐에 저장할때는 클래스 변수 생성자 함수 순서에 맞게 써줘야 한다.
				q.offer(new Point2(x, y));
				// ★★★★★★
			}
			
			if(q.isEmpty())
				System.out.println("0");
			
			while(!q.isEmpty()){
				x=q.peek().x;
				y=q.peek().y;
				//System.err.println("%%%x,y="+x+", "+y);
				if(visited[y][x]!=1){
					bfs( y, x);
					cnt++;
					//System.out.println("***cnt"+cnt);
				}
				q.poll();
				
				
			}
			
			System.out.println(cnt);
		}
	}

	public static void bfs(int y, int x) {
		//System.err.println("%%%%현재위치 x, y=" + x+", "+y);
		visited[y][x]=1;
		for(int i=0; i<4; i++){
			int nx=x+coff[i];
			int ny=y+roff[i];
			
			//System.out.println("test) nx:"+nx+", ny:"+ny);
			
			if (ny < 0 || ny >= n) { 
				//System.out.println("ny 범위 제외");
				continue;
			}
			if (nx < 0 || nx >= m) { 
				//System.out.println("nx 범위 제외"); 
				continue;
			}
			if (map[ny][nx] == 1 && visited[ny][nx]!=1)
			{
				//System.out.println("발견성공 재귀들어간다!"+"test) nx:"+nx+", ny:"+ny);
				bfs(ny, nx);
			}/* else{
				System.out.println("범위는 통과했지만 조건 불만족");
			}*/
			
		}
		
	}

	public static void init() {
		for( int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				visited[i][j]=0;
				map[i][j]=0;
			}
		}
		
	}
}
