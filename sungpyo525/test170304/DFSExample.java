package com.test170304;

import java.util.Scanner;

public class DFSExample {
	static int [][] map; // map을 나타내는 배열
	//static int [][] visited; // 0과 1을 이동 때마다 처리할것이기 때문에 필요 없음
	static int map_size; // map의 사이즈
	static int min; // 최단 거리
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map_size= sc.nextInt();// map의 사이즈를 입력받는다.
		map=new int[map_size][map_size];
		
		// 일단 map의 배열의 크기를 입력받은 map_size크기로 만든다.
		//		(모든 경로를 돌아다녀도 n*n이기 떄문에, 최소값의 최대치가 된다.)
		min = map_size * map_size; 
		
		// 이동할 수 있는 path를 입력받기위해 for를 사용
		for(int i=0; i<map_size; i++){
			for(int j=0; j<map_size; j++){
				map[i][j]=sc.nextInt();
			}
		}
		depthfirstSearch(0,0,1);
		
		System.out.println("최단 거리 : " + min);
	}


	
	
	//dfs 알고리즘 시작
	private static void depthfirstSearch(int x, int y, int length) {
		if(x==map_size-1 && y==map_size-1){
			if(min>length) min=length;
			return;
		}
		
		map[x][y]=0;
		
		//왼쪽으로 이동할 경우
		if(x>0 && map[x-1][y]==1)
			depthfirstSearch(x-1, y, length+1);
		
		//오른쪽으로 이동할 경우
		if(x<map_size-1&& map[x+1][y]==1)
			depthfirstSearch(x+1, y, length+1);
		
		//아래로 이동할 경우
		if(y<map_size-1 && map[x][y+1]==1)
			depthfirstSearch(x, y+1, length+1);
		
		//위로 이동할 경우
		if(y>0 && map[x][y-1]==1)
			depthfirstSearch(x, y-1, length+1);
		
		map[x][y]=1;
		
	}
}
