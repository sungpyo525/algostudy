#include<iostream>
#include<memory.h>
#include<queue>
using namespace std;
queue<pair<int, int>> que;
int tomato[1001][1001];
int dp[1001][1001];
int dx[4] = { -1, 0, 0, 1 };
int dy[4] = { 0, 1, -1, 0 };
int main()
{

	memset(tomato, -1, sizeof(tomato));
	memset(dp, 0, sizeof(dp));
	int M, N;
	cin >> M >> N;

	for (int i = 1; i <= N; i++)
	for (int j = 1; j <= M; j++)
	{
		cin >> tomato[i][j];
		if (tomato[i][j] == 1)
		{
			que.push(make_pair(i, j));
			dp[i][j] = 0;
		}
	}

	if (que.empty()) { cout << "0" << endl; return 0; }


	while (!que.empty())
	{
		int nowy = que.front().first;
		int nowx = que.front().second;

		for (int i = 0; i < 4; i++)
		{
			int nextx = nowx + dx[i];
			int nexty = nowy + dy[i];
			if (nextx <= 0 || nextx > M) continue;
			if (nexty <= 0 || nexty > N) continue;
			if (tomato[nexty][nextx] == 0)
			{
				tomato[nexty][nextx] = 1; que.push(make_pair(nexty, nextx));
				dp[nexty][nextx] = dp[nowy][nowx] + 1;
			}

		}
		que.pop();

	}

	int result = dp[1][1];
	for (int i = 1; i <= N; i++)
	for (int j = 1; j <= M; j++)
	{
		if (tomato[i][j] == 0){ cout << "-1" << endl; return 0; }
		if (result <= dp[i][j]) result = dp[i][j];
	}
	cout << result;
	return 0;
}