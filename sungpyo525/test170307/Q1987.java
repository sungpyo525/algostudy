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
			String str=sc.next(); // �ι� �Է� �����Ŷ� nextLine �ȵ�!
			for(int j=0; j<C; j++){
				map[i][j]=str.charAt(j);
			}
		}
		
		solve(0,0,1); // ���� �ֻ�� ĭ���� �����ϰ�, ù �Ÿ��� 1�� ȣ��
		
		System.out.println(result);
	}
	
	public static void solve(int r, int c, int dist){
		result=Math.max(result, dist);
		visited[r][c]=true; // ù ���� �湮 �ߴٴ� ó��
		used[map[r][c]-'A'] = true; // ù ������ ���ĺ��� �̹� �ѹ� �������ٴ� ǥ��
		
		for(int d=0; d<4; d++){
			int nr= r+ roff[d];
			int nc= c+ coff[d];
			if(nr<0 || nr>=R || nc<0 || nc>=C || visited[nr][nc])
				continue;
			if( !used[map[nr][nc]-'A'])
				solve(nr, nc, dist+1);
		}
		
		//�湮 ���� ��Ȳ���� �ǵ���
		visited[r][c]=false;
		used[map[r][c]-'A']=false;
	}
}
