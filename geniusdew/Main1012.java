package test;

import java.util.Scanner;
import java.util.Stack;

class Position {
	int x, y;

	public Position(int x, int y) {
		x = this.x;
		y = this.y;
	}
}

public class Main1012 {
	static int roff[] = { 0, 0, 1, -1 };
	static int coff[] = { -1, 1, 0, 0 };
	static int map[][];
	static int chk[][];
	static int t, n, m, k;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		t = sc.nextInt();
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		int a, b;
		map = new int[m][n];
		chk = new int[m][n];

		for (int i = 0; i < k; i++) {
			a = sc.nextInt();
			b = sc.nextInt();

			map[b][a] = 1;
		}
		
		/*for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				System.out.print(map[i][j]+"  ");
			}
			System.out.println();
		}*/

		go();
	}

	public static void go() {
		int cnt = 0;
		Stack<Point> s = new Stack<>();
		Point pos=new Point(0, 0);
		s.push(pos);
		
		int x, y;
		int nx, ny;

		//System.out.println("peek    " + s.peek().x+",  "+s.peek().y);
		
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (chk[i][j] == 1 || map[i][j] == 0)
					continue;
				else{
					x = s.peek().x;
					y = s.peek().y;
					s.pop();
				}
				for (int k = 0; k < 4; k++) {
					nx = x + roff[k];
					ny = y + coff[k];
					if (nx >= n || nx < 0 || ny >= m || ny < 0)
						continue;
					if (map[nx][ny] == 1 && chk[nx][ny] == 0) {
						System.out.println(nx+"  "+ny);
						s.push(new Point(nx, ny));
						chk[nx][ny] = 1;
					}
					if (s.isEmpty()) {
						cnt++;
						break;
					}

				}
				
			}
		}
		System.out.println(cnt);
	}
}
