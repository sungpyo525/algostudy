package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Position {
	int x, y;

	public Position(int x, int y) {
		x = this.x;
		y = this.y;
	}
}

public class Main1012_0329 {
	static int roff[] = { 0, 0, 1, -1 };
	static int coff[] = { -1, 1, 0, 0 };
	static int map[][];
	static int chk[][];
	static int t, n, m, k;
	static int cnt = 0;
	static Queue<Point> q = new LinkedList<Point>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		t = sc.nextInt();
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		int x, y;

		map = new int[m][n];
		chk = new int[m][n];

		for (int i = 0; i < t; i++) {
			for (int j = 0; j < k; j++) {
				x = sc.nextInt();
				y = sc.nextInt();

				map[y][x] = 1;
				q.add(new Point(x, y));
			}
			for (int a = 0; a < m; a++) {
				for (int b = 0; b < n; b++) {
					System.out.print(map[a][b] + " ");
				}
				System.out.println();
			}
			System.out.println(q.size());

			if (q.isEmpty()) {
				System.out.println(0);
			}
			while (!q.isEmpty()) {
				x = q.peek().x;
				y = q.peek().y;

				if (chk[y][x] == 0) {
					System.out.println("chk1  "+chk[y][x]);
					System.out.println((x + 1) + "   " + (y + 1));

					go(y, x);
					cnt++;
					System.out.println("cnt  " + cnt);
				}
				q.poll();

			}
			System.out.println(cnt);

		}
	}

	public static void go(int y, int x) {
		chk[y][x] = 1;
		System.out.println("go1  "+ (x + 1) + "  "+ (y + 1));
		System.out.println("chk  "+chk[y][x]);
		for (int i = 0; i < 4; i++) {
			int nx = x + coff[i];
			int ny = y + roff[i];
			System.out.println("go2  " + i + "  " + (nx + 1) + "  "+ (ny + 1));
			// System.out.println("test) nx:"+nx+", ny:"+ny);

			if (ny < 0 || ny >= n) {
				// System.out.println("ny 범위 제외");
				continue;
			}
			if (nx < 0 || nx >= m) {
				// System.out.println("nx 범위 제외");
				continue;
			}
			if (map[ny][nx] == 1 && chk[ny][nx] != 1) {
				System.out.println("go3  " + i + "  " + (nx + 1) + "  "+ (ny + 1));
				go(ny, nx);
			}
		}
	}
}
