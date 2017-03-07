package com.test170304;

/*import java.util.Scanner;

public class BFSExample {
	static int n; // �Էµ� ������ ����
	static int rear, front; // ť�� �հ� �ڸ� ��Ÿ���� ����
	static int map [][]  = new int [30][30]; // ���� ���
	static int queue []= new int [30]; // ť
	static int visit [] = new int [30]; // �湮 ��� �迭
	
	public static void breadthfirstSearch(int v){
		
		
		visit[v]=1;	// ���� v�� �湮�ߴٰ� ǥ��
		System.out.println(v+"���� ����");
		queue[rear++]=v;		// ť�� v�� �����ϰ� ������ 1 ����
		
		while (front<rear){ 	// �Ĵ��� ���ܰ� ���ų� ������ ������ ����
			
			// ť�� ù��°�� �ִ� �����͸� �����ϰ� ���ܵ� ���� ��������, ���� 1 ����
			v=queue[front++];
			
			for(int i=1; i<=n; i++){
				if(map[v][i]==1 && visit[i]==0){
					visit[i]=1; // ���� i�� �湮�ߴٰ� ǥ��
					System.out.println(v+"���� "+ i +"�� �̵�");
					queue[rear++] = i; // ť�� i�� �����ϰ� �Ĵ��� 1������Ŵ
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

		n = sc.nextInt(); // ������ ����
		m = sc.nextInt(); // ������ ���� (�Է��� �� ����)
		v = sc.nextInt(); // ������ ��ȣ

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