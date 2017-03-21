package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main7576 {
	static int roff[] = { -1, 1, 0, 0 };
	static int coff[] = { 0, 0, -1, 1 };
	static Queue<Point> q = new LinkedList<Point>();
	static int room[][];
	static int chk[][];
	static int n, m;
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		room = new int[n][m];
		chk = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				room[i][j] = sc.nextInt();
				chk[i][j] = -1;

				if (room[i][j] == 1) {
					chk[i][j] = 0;
					q.add(new Point(i, j));
				}
			}
		}

		System.out.println(go());
	}

	public static int go() {
		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;

			q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = x + roff[i];
				int ny = y + coff[i];

				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if (room[nx][ny] == 0 && chk[nx][ny] == -1) {
						chk[nx][ny] = chk[x][y] + 1;
						q.add(new Point(nx, ny));
					}
				}
			}
		}

		int max = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (max < chk[i][j]) {
					max = chk[i][j];
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (room[i][j] == 0 && chk[i][j] == -1) {
					max = -1;
				}
			}

		}
		return max;
	}
}