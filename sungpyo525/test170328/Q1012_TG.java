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
				
				// �ڡڡڡڡڡ�
				//Ʋ���� �ִ� �κ�!! ť�� �������ٶ��� y�� x ���� �򰥸��� ����!
				// ��ķ� �����Ҷ��� y�� �տ� ��������,
				// ť�� �����Ҷ��� Ŭ���� ���� ������ �Լ� ������ �°� ����� �Ѵ�.
				q.offer(new Point2(x, y));
				// �ڡڡڡڡڡ�
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
		//System.err.println("%%%%������ġ x, y=" + x+", "+y);
		visited[y][x]=1;
		for(int i=0; i<4; i++){
			int nx=x+coff[i];
			int ny=y+roff[i];
			
			//System.out.println("test) nx:"+nx+", ny:"+ny);
			
			if (ny < 0 || ny >= n) { 
				//System.out.println("ny ���� ����");
				continue;
			}
			if (nx < 0 || nx >= m) { 
				//System.out.println("nx ���� ����"); 
				continue;
			}
			if (map[ny][nx] == 1 && visited[ny][nx]!=1)
			{
				//System.out.println("�߰߼��� ��͵���!"+"test) nx:"+nx+", ny:"+ny);
				bfs(ny, nx);
			}/* else{
				System.out.println("������ ��������� ���� �Ҹ���");
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
