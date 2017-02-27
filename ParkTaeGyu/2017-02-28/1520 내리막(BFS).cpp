#include<iostream>
#include<queue>
using namespace std;
int map[501][501];
int result[501][501];
int dx[4] = { 0, 1, 0, -1 };
int dy[4] = { 1, 0, -1, 0 };
int M, N;

/*
[입력]
4 5
50 45 37 32 30
35 50 40 20 25
30 30 25 17 28
27 24 22 15 10
[reuslt 변화]
11111
10021
10020
11133

출력:3
*/
void printres()
{
	for (int i = 1; i <= M; i++)
	{
		for (int j = 1; j <= N; j++)
			cout << result[i][j];
		cout << endl;
	}
		
}

int main()
{
	queue<pair<int, int>> que;
	
	cin >> M >> N;
	for (int i = 1; i <= M; i++)
	for (int j = 1; j <= N; j++)
		cin >> map[i][j];



	que.push(make_pair(1, 1));
	result[1][1] = 1;

	while (!que.empty())
	{
		int posy = que.front().first;
		int posx = que.front().second;

		for (int i = 0; i < 4; i++)
		{
			int nexty = posy + dy[i];
			int nextx = posx + dx[i];
			if (nextx < 1 || nextx > N) continue;
			if (nexty < 1 || nexty > M) continue;
			if (map[posy][posx] > map[nexty][nextx]) que.push(make_pair(nexty, nextx)), result[nexty][nextx]++;

		}


		que.pop();
	}
	printres();
	cout << result[M][N];
	return 0;
}