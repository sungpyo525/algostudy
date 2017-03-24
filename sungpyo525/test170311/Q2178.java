package com.test170311;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javafx.util.Pair;

// 현재의 위치 저장할 클래스 구조체
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
		 
		 //도착지점까지 +1을 해준 값 출력
		 System.out.println(result+1);

	}

	public static void solve() {

		// 큐에 맨처음 위치를 추가하고, 방문한 것으로 표시한다.
		q.offer(point);
		visited[0][0]=true;
		
		while(!q.isEmpty()){
			int qSize=q.size();
			for( int a=0; a<qSize; a++){
				
				// 현재의 위치를 가져온 후,
				// 큐에서는 삭제함.
				int x=q.peek().x;
				int y=q.peek().y;
				q.poll();
				
				// 만약 현재 위치가 도착점이라면 종료!
				if(x==N-1 && y==M-1){
					return;
				}
				
				// 오프셋(roff, coff)를 이용한 상하좌우 탐색을 시작한다!
				for( int k=0; k<4; k++){
					int nx= x+ roff[k];
					int ny= y+ coff[k];
					
					// 처음 칸 벗어나면 안감
					if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
					
					// 0이면 안감
					if(map[nx][ny]==0) continue;
					
					// 갔던 곳이면 안감
					if(visited[nx][ny]) continue;
					
					visited[nx][ny]=true;
					
					//현재 위치 새로 설정
					point = new Point(nx, ny);
					q.offer(point);
				}
				
			}
			result++;
		}
		
		
			
	}
}
