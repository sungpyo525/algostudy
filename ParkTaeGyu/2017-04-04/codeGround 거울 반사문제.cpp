// 아래 기본 제공된 코드를 수정 또는 삭제하고 본인이 코드를 사용하셔도 됩니다.
#include <cstdio>
#include <iostream>
#include <memory.h>
using namespace std;
int map[1001][1001];
int visitedCheck[1001][1001];
int y, x, N;
int direction = 4; //북:1 동:2 남:3 서:4 (처음 들어오는 위치가 1,1에서 서로들어오므로 서쪽방향으로 디폴트 지정)
int main(int argc, char** argv) {
	/* 아래 freopen 함수는 input.txt 를 read only 형식으로 연 후,
	앞으로 표준 입력(키보드) 대신 input.txt 파일로 부터 읽어오겠다는 의미의 코드입니다.
	만약 본인의 PC 에서 테스트 할 때는, 입력값을 input.txt에 저장한 후 freopen 함수를 사용하면,
	그 아래에서 scanf 함수 또는 cin을 사용하여 표준입력 대신 input.txt 파일로 부터 입력값을 읽어 올 수 있습니다.
	또한, 본인 PC에서 freopen 함수를 사용하지 않고 표준입력을 사용하여 테스트하셔도 무방합니다.
	단, Codeground 시스템에서 "제출하기" 할 때에는 반드시 freopen 함수를 지우거나 주석(//) 처리 하셔야 합니다. */
	//freopen("input.txt", "r", stdin);

	setbuf(stdout, NULL);
	x = 1, y = 1;
	int TC;
	int test_case;
	memset(map, -1, sizeof(map));
	scanf("%d", &TC);	// cin 사용 가능
	for (test_case = 1; test_case <= TC; test_case++) {
		// 이 부분에서 알고리즘 프로그램을 작성하십시오.
		cin >> N;
		int cnt = 0;
		bool chk = false;
		memset(visitedCheck, -1, sizeof(visitedCheck));
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= N; j++)
				scanf("%1d", &map[i][j]);

			for (int i = 1; i <= N; i++)
			{
				if (map[1][i] != 0)
				{
					x = i;
					chk = true;
					break;
				}
	
			}
			//cout << y << x << endl;
			if (!chk) { cout << "0" << endl; return 0; }
	
			while (y >= 1 && y <= N && x >= 1 && x <= N && chk)
			{
				//cout << y << x << endl;
				chk = false;
				visitedCheck[y][x] = 1;
				
				if (map[y][x] == 1) {
					switch (direction)
					{
					case 1:
						direction = 2;
						for (int i = --x; i >= 1; i--)
						if (map[y][i] != 0)
						{
							x = i;
							chk = true;
							break;
						}
						else chk = false;
						break;
					case 2:
						direction = 1;
						for (int i = ++y; i <= N; i++)
						if (map[i][x] != 0)
						{
							y = i;
							chk = true;
							break;
						}
						else chk = false;
						break;
					case 3:
						direction = 4;
						for (int i = ++x; i <= N; i++)
						if (map[y][i] != 0)
						{
							x = i;
							chk = true;
							break;
						}
						else chk = false;
						break;
					case 4:
						direction = 3;
						for (int i = --y; i >= 1; i--)
							if (map[i][x] != 0)
							{
								y = i;
								chk = true;
								break;
							}
							else chk = false;
						break;
					}
				}
				else if (map[y][x] == 2) {
					switch (direction)
					{
					case 1:
						direction = 4;
						for (int i = ++x; i <= N; i++)
						if (map[y][i] != 0)
						{
							x = i;
							chk = true;
							break;
						}
						else chk = false;
						break;
					case 2:
						direction = 3;
						for (int i = --y; i >=1; i--)
						if (map[i][x] != 0)
						{
							y = i;
							chk = true;
							break;
						}
						else chk = false;
						break;
					case 3:
						direction = 2;
						for (int i = --x; i >= 1; i--)
						if (map[y][i] != 0)
						{
							x = i;
							chk = true;
							break;
						}
						else chk = false;
						break;
					case 4:
						direction = 1;
						for (int i = ++y; i <=N; i++)
						if (map[i][x] != 0)
						{
							y = i;
							chk = true;
							break;
						}
						else chk = false;
						break;
					}
				}
			}
			
			
		direction = 4;
		x = y = 1;
		for (int i = 1; i <= N;i++)
		for (int j = 1; j <= N;j++)
		if (visitedCheck[i][j] == 1) ++cnt;
		// 이 부분에서 정답을 출력하십시오.
		printf("Case #%d\n", test_case);	// cout 사용 가능
		printf("%d\n", cnt);
		
	}

	return 0;	// 정상종료 시 반드시 0을 리턴해야 합니다.
}