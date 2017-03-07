package com.test170304;

import java.util.Scanner;

public class DepthFirstSearch {
	static int vertex;  //정점의 개수
	static int startVertex; //시작정점
	static int[][] vertextMap; //인접 행렬 생
	static int[] vertexVisit; // 정점의 방문 여부를 가리키는 배열;
	static int vt1, vt2;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		vertex = sc.nextInt(); // 정점의 개수 입력
		startVertex=Integer.parseInt(sc.nextLine().trim()); // 시작할 정점 입력
		vertextMap = new int[vertex+1][vertex+1]; // 1을 플러스하면 정점의 시작을 0이 아닌 1로 할 수있다.
		vertexVisit= new int[vertex+1]; // 상동
		
		while(true){
			vt1=sc.nextInt();
			vt2=sc.nextInt();
			
			
			if(vt1<0 && vt2<0) // 두개의 점이 0보다 작을 경우는 break
				break; // -1 -1 입력해주면 그 전 값까지만 저장
			
			vertextMap[vt1][vt2]=vertextMap[vt2][vt1]=1; //정점 vt2와 vt1이 연결되었음을 표기
			//인접 행렬을 이해하면 알 수있음
		}
		
		dfs(startVertex);
	}


	private static void dfs(int start) {
		vertexVisit[start]=1;
		for(int i=1; i<=vertex; i++){
			// =1 : 간선 연결이 되어있고, ==0 : 안들렸던 곳이면! 
			if(vertextMap[start][i]==1 && vertexVisit[i]==0){
				// 이동하여라
				System.out.println(start + "->" + i + "로 이동합니다.");
				dfs(i);
			}
		}	
	}
}
