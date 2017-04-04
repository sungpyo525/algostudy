// �Ʒ� �⺻ ������ �ڵ带 ���� �Ǵ� �����ϰ� ������ �ڵ带 ����ϼŵ� �˴ϴ�.
#include <cstdio>
#include <iostream>
#include <memory.h>
using namespace std;
int map[1001][1001];
int visitedCheck[1001][1001];
int y, x, N;
int direction = 4; //��:1 ��:2 ��:3 ��:4 (ó�� ������ ��ġ�� 1,1���� ���ε����Ƿ� ���ʹ������� ����Ʈ ����)
int main(int argc, char** argv) {
	/* �Ʒ� freopen �Լ��� input.txt �� read only �������� �� ��,
	������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸ� ���� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
	���� ������ PC ���� �׽�Ʈ �� ����, �Է°��� input.txt�� ������ �� freopen �Լ��� ����ϸ�,
	�� �Ʒ����� scanf �Լ� �Ǵ� cin�� ����Ͽ� ǥ���Է� ��� input.txt ���Ϸ� ���� �Է°��� �о� �� �� �ֽ��ϴ�.
	����, ���� PC���� freopen �Լ��� ������� �ʰ� ǥ���Է��� ����Ͽ� �׽�Ʈ�ϼŵ� �����մϴ�.
	��, Codeground �ý��ۿ��� "�����ϱ�" �� ������ �ݵ�� freopen �Լ��� ����ų� �ּ�(//) ó�� �ϼž� �մϴ�. */
	//freopen("input.txt", "r", stdin);

	setbuf(stdout, NULL);
	x = 1, y = 1;
	int TC;
	int test_case;
	memset(map, -1, sizeof(map));
	scanf("%d", &TC);	// cin ��� ����
	for (test_case = 1; test_case <= TC; test_case++) {
		// �� �κп��� �˰��� ���α׷��� �ۼ��Ͻʽÿ�.
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
		// �� �κп��� ������ ����Ͻʽÿ�.
		printf("Case #%d\n", test_case);	// cout ��� ����
		printf("%d\n", cnt);
		
	}

	return 0;	// �������� �� �ݵ�� 0�� �����ؾ� �մϴ�.
}