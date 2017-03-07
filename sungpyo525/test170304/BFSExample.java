package com.test170304;

/*import java.util.Scanner;

public class BFSExample {
	static int n; // 입력될 정수의 갯수
	static int rear, front; // 큐의 앞과 뒤를 나타내는 변수
	static int map [][]  = new int [30][30]; // 인접 행렬
	static int queue []= new int [30]; // 큐
	static int visit [] = new int [30]; // 방문 기록 배열
	
	public static void breadthfirstSearch(int v){
		
		
		visit[v]=1;	// 정점 v에 방문했다고 표시
		System.out.println(v+"에서 시작");
		queue[rear++]=v;		// 큐에 v를 삽입하고 전단을 1 증가
		
		while (front<rear){ 	// 후단이 전단과 같거나 작으면 루프를 나옴
			
			// 큐의 첫번째의 있는 데이터를 제외하고 제외된 값을 가져오며, 전단 1 증가
			v=queue[front++];
			
			for(int i=1; i<=n; i++){
				if(map[v][i]==1 && visit[i]==0){
					visit[i]=1; // 정점 i를 방문했다고 표시
					System.out.println(v+"에서 "+ i +"로 이동");
					queue[rear++] = i; // 큐에 i를 삽입하고 후단을 1증가시킴
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int start;
		int v1, v2;
		
		Scanner sc = new Scanner(System.in);
		start=sc.nextInt();
		
		while(true){
			v1=sc.nextInt();
			v2=sc.nextInt();
			
			if(v1<0 && v2<0)
				break;
			
			map[v1][v2]=map[v2][v1]=1;
		}
		
		breadthfirstSearch(start);
	}
}

*/

//1260

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BFSExample {

	static int n;
	static int m;
	static int v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt(); // 정점의 개수
		m = sc.nextInt(); // 간선의 개수 (입력할 쌍 개수)
		v = sc.nextInt(); // 시작할 번호

		int graph[][] = new int[n + 1][n + 1];
		int x, y;
		for (int i = 0; i < m; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			graph[x][y] = 1;
			graph[y][x] = 1;
		}
		/*
		 * for(int i=1;i<=n;i++){ for(int j=1;j<=n;j++){
		 * System.out.print(graph[i][j]); } System.out.println(); }
		 */

		dfs(graph, v);
		System.out.println();
		bfs(graph, v);
	}

	public static void bfs(int graph[][], int v) {
		int chk[] = new int[n + 1];
		int out;
		Queue<Integer> q = new LinkedList<>();

		q.add(v);
		chk[v] = 1;
		while (!q.isEmpty()) {
			out = q.poll();
			System.out.print(out + " ");
			for (int i = 1; i < graph.length; i++) {
				if (graph[out][i] == 1 && chk[i] == 0) {
					chk[i] = 1;
					q.add(i);
				}
			}
		}
	}

	public static void dfs(int graph[][], int v) {
		int chk[] = new int[n + 1];
		int peek, flag;
		Stack<Integer> s = new Stack<>();

		s.push(v);
		chk[v] = 1;
		System.out.print(v + " ");
		while (!s.isEmpty()) {
			peek = s.peek();
			flag = 0;
			for (int i = 1; i < graph.length; i++) {
				if (graph[peek][i] == 1 && chk[i] == 0) {
					chk[i] = 1;
					flag = 1;
					s.push(i);
					System.out.print(i + " ");

					break;

				}
			}
			if (flag == 0)
				s.pop();
		}
	}
}