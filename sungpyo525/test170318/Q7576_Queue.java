package com.test170318;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class Point{
	int x;
	int y;
	
	public Point(int x, int y){
		this.x=x;
		this.y=y;
	}
}

public class Q7576_Queue {
	
	static int map[][]= new int[1000][1000];
	static int roff[]= {-1, 1, 0, 0};
	static int coff[]= {0, 0, -1, 1};
	
	static int tomato=0;
	static int maxtime=1;
	
	static Point point = new Point(0, 0);
	static Queue<Point> q= new LinkedList<Point>();
	
	public static void main(String[] args) {
		int h, w;
		Scanner sc= new Scanner(System.in);
		
		h=sc.nextInt();
		w=sc.nextInt();
		
		for(int i=0; i<h; i++){
			for(int j=0; j<w; j++){
				map[i][j]=sc.nextInt();
				if(map[i][j]==1 || map[i][j]==0) tomato++;
				if(map[i][j]==1) q.offer(new Point(i,j));
			}
		}
		System.out.println(bfs(h,w));
	}

	public static int bfs(int h, int w) {
		while(!q.isEmpty()){
			Point here=q.peek();
			int hi= here.x;
			int hj= here.y;
			q.poll();
			tomato--;
			
			for(int i=0; i<4; ++i){
				int ni=hi+roff[i];
				int nj=hj+coff[i];
				if(ni<0 || ni>=h || nj<0 || nj>=w) continue;
				if(map[ni][nj]==0){
					map[ni][nj]=map[hi][hj]+1;
					if(maxtime<map[ni][nj]) maxtime=map[ni][nj];
					q.offer(new Point(ni, nj));
				}
			}
		}
		
		if(tomato==0){
			return maxtime-1;
		} else{
			return -1;
		}
		
	}
}
