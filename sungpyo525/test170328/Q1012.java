package com.test170328;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Q1012 {
	static int T;
	static int M, N, K;
	static int map[][]=new int[55][55];
	static int visited[][]=new int[55][55];

	static int warm = 0;

	static int roff[] = { -1, 1, 0, 0 };
	static int coff[] = { 0, 0, 1, -1 };

	static Queue<Point> q = new LinkedList<Point>();

	
	public static int init(){
		for( int i=0; i<55; i++){
			for(int j=0; j<55; j++){
				visited[i][j]=0;
				map[i][j]=0;
			}
		}
		return 0;
	}
	

	public static void bfs() {
		//System.out.println("test2");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if ( visited[i][j] == 0 && map[i][j] == 1) {
					
					q.offer(new Point(j, i));
					warm++;

					while (!q.isEmpty()) {
						Point here = q.peek();
						int hi = here.x;
						int hj = here.y;
						q.poll();

						for (int k = 0; k < 4; k++) {
							int ni = hi + roff[k];
							int nj = hj + coff[k];

							if (ni >= 0 && ni < M && nj >= 0 && nj < N && map[ni][nj]==1 && visited[ni][nj]==0){
								visited[ni][nj] = 1;
								q.offer(new Point(ni, nj));								
							}
						}
					}
				}
			}
		}
		//System.out.println("Test3");
	}

	public static void main(String[] args) {
		int x, y;

		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for( int i=0; i<T; i++){
			init();
			warm=0;
			
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			
			for( int j=0; j<K; j++){
				x=sc.nextInt();
				y=sc.nextInt();
				map[y][x]=1;
				//System.out.println("test11 **"+j);
			}
			
			bfs(); 
			System.out.println(warm);
		}

		
	}
}
