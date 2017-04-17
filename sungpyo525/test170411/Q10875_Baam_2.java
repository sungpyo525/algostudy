package com.test170411;

import java.util.ArrayList;
import java.util.Scanner;

class Point{
	int x;
	int y;
	
	public Point(int x, int y){
		this.x=x;
		this.y=y;
	}
}

public class Q10875_Baam_2 {	
	static int n;
	static int t[];
	static char dir[];
	//static long map[][];
	//static long visited[][];
	
	static int x, y;

	// 북동남서
	static int dx[]={-1, 0, 1, 0}; 
	static int dy[]={0, 1, 0, -1};
	// (null), 동, 북, 남, 서
//	static int dx[]={0, 0, -1, 1, 0};
//	static int dy[]={0, 1, 0, 0, -1};
	
	static int way=1; // 동쪽 방향으로 초기화
	static int order;
	static int count=0;
	
	static ArrayList<Point> map= new ArrayList<Point>();
	
	public static boolean safe(int x, int y){
		boolean what=false;
		//boolean check=true;
		
		for(int i=0; i<map.size(); i++){
			if(map.get(i).x==x && map.get(i).y==y){
				//check=false;
				return what;
			}	
		}
		
		if(x>=-1*n && x<=n && y>=-1*n && y<n)
			what=true;
		return what;
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		n=sc.nextInt();
		int k=sc.nextInt();
		
		map.add(new Point(0, 0));
		x=y=0;
		t=new int[k];
		dir=new char[k];
		
		for(int i=0; i<k; i++){
			t[i]=sc.nextInt();
			dir[i]=sc.next().charAt(0);
		}
		
		// 동1, 북2, 남3, 서4
		oneskip:
		for(int i=0; i<k; i++){
			/*if(way==1){
				if(dir[i]=='L') order=2;
				else order=3;
			}else if(way==2){
				if(dir[i]=='L') order=4;
				else order=1;
			}else if(way==3){
				if(dir[i]=='L') order=1;
				else order=4;
			}else if(way==4){
				if(dir[i]=='L') order=3;
				else order=2;
			}*/
			
			if(dir[i]=='L')
				order=(way+3)%4;
			else
				order=(way+5)%4;
			
			for(int j=0; j<t[i]; j++){
				int nx=x+dx[way];
				int ny=y+dy[way];
				
				if(!safe(nx, ny)){
					count++;
					break oneskip;
				}
				
				map.add(new Point(nx, ny));
				x=nx;
				y=ny;
				count++;
			}
			
			way=order;
		}
		
		System.out.println(count);
		System.out.println();
		
		
		/*//테스트 뱀이 지나간 경로 테스트용
		for(int i=0; i<2*n+1; i++){
			for(int j=0; j<2*n+1; j++){
				System.out.print(visited[i][j]);
			}
			System.out.println();
		}*/
		
	}
}
