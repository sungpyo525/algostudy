#include<iostream>
using namespace std;
int M, N;
int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };
int map[501][501];
int result[501][501];

/*
[입력]
4 5
50 45 37 32 30
35 50 40 20 25
30 30 25 17 28
27 24 22 15 10

[DP변화]
32221
1-1-111
1-1-11-1
1111-1

출력:3
*/

void printresult()
{
	for (int i = 1; i <= M; i++)
	{
		for (int j = 1; j <= N; j++)
			cout << result[i][j];
		cout << endl;	
	}
	
}
int resultCheck(int y,int x)
{
	if (x == N && y == M) return 1;	
	if (result[y][x] != -1) return result[y][x];

	result[y][x]= 0;
	//printresult();
	for (int i = 0; i < 4; i++)
	{
		int nextx = x + dx[i];
		int nexty = y + dy[i];
		if (nextx <= 0 || nextx >= N+1) continue;
		if (nexty <= 0 || nexty >= M+1) continue;

		if (map[nexty][nextx] < map[y][x])
		{
			result[y][x] += resultCheck(nexty, nextx);
		}
			
	}
	return result[y][x];
}

int main()
{
	cin >> M >> N;
	for (int i = 1; i <= M;i++)
		for (int j = 1; j <= N; j++)
			cin >> map[i][j], result[i][j] = -1;

	resultCheck(1, 1);
	printresult();
	return 0;
}