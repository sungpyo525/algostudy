package com.test170307;

import java.util.Scanner;

public class Q1987 {
	static int roff[]= {-1, 1, 0, 0};
	static int coff[]= {0, 0, -1, 1};
	
	static int R, C, result;
	static char map[][];
	static boolean visited[][];
	static boolean used[]=new boolean[26];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R=sc.nextInt();
		C=sc.nextInt();
		
		map = new char [R][C];
		visited= new boolean[R][C];
		
		for( int i=0; i<R; i++){
			String str=sc.next(); // 두번 입력 받을거라 nextLine 안됨!
			for(int j=0; j<C; j++){
				map[i][j]=str.charAt(j);
			}
		}
		
		solve(0,0,1); // 왼쪽 최상단 칸에서 시작하고, 첫 거리는 1로 호출
		
		System.out.println(result);
	}
	
	public static void solve(int r, int c, int dist){
		result=Math.max(result, dist);
		visited[r][c]=true; // 첫 지점 방문 했다는 처리
		used[map[r][c]-'A'] = true; // 첫 지점에 알파벳은 이미 한번 지나갔다는 표시
		
		for(int d=0; d<4; d++){
			int nr= r+ roff[d];
			int nc= c+ coff[d];
			if(nr<0 || nr>=R || nc<0 || nc>=C || visited[nr][nc])
				continue;
			if( !used[map[nr][nc]-'A'])
				solve(nr, nc, dist+1);
		}
		
		//방문 전의 상황으로 되돌림
		visited[r][c]=false;
		used[map[r][c]-'A']=false;
	}
}
