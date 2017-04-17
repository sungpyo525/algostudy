package com.test170411;

import java.util.Scanner;

public class Q2468 {
	static int N;
	static final int rain = 4;
	static int map[][];
	static int visited[][];
	static int count = 0;

	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static boolean safe(int x, int y) {
		boolean what = false;
		if (x >= 0 && x < N && y >= 0 && y < N)
			what = true;
		return what;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		visited = new int[N][N];

		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				map[i][j] = sc.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] <= rain)
					visited[i][j] = 1;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] > rain && visited[i][j] == 0) {
					dfs(i, j);
					count++;
				}
			}
		}

		System.out.println(count);

	}

	public static void dfs(int x, int y) {

		visited[x][y] = 1;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (safe(nx, ny) == false)
				continue;
			if (visited[nx][ny] == 1)
				continue;

			dfs(nx, ny);

		}

	}

}
