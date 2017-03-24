package com.test170311;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javafx.util.Pair;

// ������ ��ġ ������ Ŭ���� ����ü
class Point{
	int x;
	int y;
	
	public Point(int x, int y){
		this.x=x;
		this.y=y;
	}
}

public class Q2178 {
	static int N, M;
	static int map[][];
	static boolean visited[][];
	static int result;
	
	static Point point = new Point(0, 0);
	static Queue<Point> q= new LinkedList<Point>();
	
	static int roff[]= {-1, 1, 0, 0};
	static int coff[]= {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		
		 map= new int[N][M];
		 visited=new boolean[N][M];
		 
		 for(int i=0; i<N; i++){
			 String str=sc.next();
			 for(int j=0; j<M; j++){
				 map[i][j]=(int)(str.charAt(j)-48);
			 }
		 }
		 
		 solve();
		 
		 //������������ +1�� ���� �� ���
		 System.out.println(result+1);

	}

	public static void solve() {

		// ť�� ��ó�� ��ġ�� �߰��ϰ�, �湮�� ������ ǥ���Ѵ�.
		q.offer(point);
		visited[0][0]=true;
		
		while(!q.isEmpty()){
			int qSize=q.size();
			for( int a=0; a<qSize; a++){
				
				// ������ ��ġ�� ������ ��,
				// ť������ ������.
				int x=q.peek().x;
				int y=q.peek().y;
				q.poll();
				
				// ���� ���� ��ġ�� �������̶�� ����!
				if(x==N-1 && y==M-1){
					return;
				}
				
				// ������(roff, coff)�� �̿��� �����¿� Ž���� �����Ѵ�!
				for( int k=0; k<4; k++){
					int nx= x+ roff[k];
					int ny= y+ coff[k];
					
					// ó�� ĭ ����� �Ȱ�
					if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
					
					// 0�̸� �Ȱ�
					if(map[nx][ny]==0) continue;
					
					// ���� ���̸� �Ȱ�
					if(visited[nx][ny]) continue;
					
					visited[nx][ny]=true;
					
					//���� ��ġ ���� ����
					point = new Point(nx, ny);
					q.offer(point);
				}
				
			}
			result++;
		}
		
		
			
	}
}
