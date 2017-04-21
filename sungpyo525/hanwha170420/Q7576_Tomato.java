package com.hanwha170420;

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
public class Q7576_Tomato {
	static int N, M;
	static int map[][];
	static int tomato=0;
	static int max=1;
	
	static int rx[]={-1,1,0,0};
	static int ry[]={0,0,-1,1};
	
	static Queue<Point> q = new LinkedList<Point>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		M=sc.nextInt();
		N=sc.nextInt();
		
		map=new int[N][M];
		
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				map[i][j]=sc.nextInt();
				
				if(map[i][j]==0 || map[i][j]==1) tomato++;
				if(map[i][j]==1)
					q.offer(new Point (i, j));
			}
		}
		
		while(!q.isEmpty()){
			int hx=q.peek().x;
			int hy=q.peek().y;
			q.poll();
			tomato--;
			
			for(int i=0; i<4; i++){
				int nx=hx+rx[i];
				int ny=hy+ry[i];
				
				if(!safe(nx, ny))
					continue;
				
				if(map[nx][ny]==0){
					map[nx][ny]=map[hx][hy]+1;
					if(max<map[nx][ny])
						max=map[nx][ny];
					q.offer(new Point (nx, ny));
				}
				
			}
			
		}
		
		if(tomato==0){
			System.out.println(max-1);
		} else{
			System.out.println(-1);
		}
		
		for(int i=0; i<N; i++){
			
			for(int j=0; j<M; j++){
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}

	public static boolean safe(int x, int y) {
		boolean what=false;
		if(x>=0 &&  x<N && y>=0 && y<M){
			what=true;
		}
		return what;
	}

}
