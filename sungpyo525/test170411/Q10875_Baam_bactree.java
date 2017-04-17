package com.test170411;

import java.util.ArrayList;
import java.util.Scanner;

class Line {
	int x1, y1, x2, y2;
	int dir;

	public Line(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;

		if (x1 == x2)
			dir = 0;
		else
			dir = 1;
		set_point();
	}

	public void set_point() {
		if (x1 > x2) {
			int temp = x2;
			x2 = x1;
			x1 = temp;
		}

		if (y1 > y2) {
			int temp = y2;
			y2 = y1;
			y1 = temp;
		}
	}
}

public class Q10875_Baam_bactree {
	static ArrayList<Line> line = new ArrayList<Line>();
	static int l, n;
	static int inf = 0x3f3f3f3f;
	static ArrayList<Point> spin = new ArrayList<Point>();

	static int dx[] = { 0, -1, 0, 1 };
	static int dy[] = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		l = sc.nextInt();
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int d = sc.nextInt();
			char input = sc.next().charAt(0);

			if (input == 'L')
				spin.add(new Point(d, 1));
			else
				spin.add(new Point(d, -1));
		}
		spin.get(n-1).x = inf;
		spin.get(n-1).y = -1;

		line.add(new Line(-l - 1, -l - 1, l + 1, -l - 1));
		line.add(new Line(-l - 1, -l - 1, -l - 1, l + 1));
		line.add(new Line(-l - 1, l + 1, l + 1, l + 1));
		line.add(new Line(l + 1, -l - 1, l + 1, l + 1));

		int x, y, dir;
		x = y = 0;
		dir = 3;

		long ans = 0;
		for (int i = 0; i <= n; i++) {
			int t = inf;
			for (int j = 0; j < line.size(); j++) {
				if (line.get(j).dir == 0) {
					if (dir == 0) {
						if (x == line.get(j).x1 && y < line.get(j).y1)
							t = Math.min(t, line.get(j).y1 - y);
					} else if (dir == 1) {
						if (line.get(j).y1 <= y && y <= line.get(j).y2 && line.get(j).x1 < x)
							t = Math.min(t, x - line.get(j).x1);
					} else if (dir == 2) {
						if (x == line.get(j).x1 && line.get(j).y2 < y)
							t = Math.min(t, y - line.get(j).y2);
					} else {
						if (line.get(j).y1 <= y && y <= line.get(j).y2 && x < line.get(j).x1)
							t = Math.min(t, line.get(j).x1 - x);
					}
				} else {
					if (dir == 0) {
						if (line.get(j).x1 <= x && x <= line.get(j).x2 && y < line.get(j).y1)
							t = Math.min(t, line.get(j).y1 - y);
					} else if (dir == 1) {
						if (line.get(j).y1 == y && line.get(j).x2 < x)
							t = Math.min(t, x - line.get(j).x2);
					} else if (dir == 2) {
						if (line.get(j).x1 <= x && x <= line.get(j).x2 && line.get(j).y1 < y)
							t = Math.min(t, y - line.get(j).y1);
					} else {
						if (line.get(j).y1 == y && x < line.get(j).x1)
							t = Math.min(t, line.get(j).x1 - x);
					}
				}
			}
			if (t <= spin.get(i-1).x) {
				System.out.println(ans + t);
			}
			ans += spin.get(i-1).x;
			int nx = x + dx[dir] * spin.get(i-1).x;
			int ny = y + dy[dir] * spin.get(i-1).x;
			dir = (dir + spin.get(i-1).y + 4) % 4;
			line.add(new Line(x, y, nx, ny));
			x = nx;
			y = ny;
		}
	}
}
