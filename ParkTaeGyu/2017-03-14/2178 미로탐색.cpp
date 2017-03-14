#include<iostream>
#include<queue>
#include<memory.h>
using namespace std;
int dx[4] = { 1, 0, 0, -1 };
int dy[4] = { 0, 1, -1, 0 };
int map[102][102];
bool visited[102][102];
int result[102][102];
int main()
{
	queue<pair<int, int>> que;
	vector<int> vec;
	memset(result, 0, sizeof(result));
	memset(visited, false, sizeof(visited));
	int N, M;
	cin >> N >> M;

	for (int i = 1; i <= N; i++)
	for (int j = 1; j <= M; j++)
		scanf("%1d", &map[i][j]);

	int nowx = 1;
	int nowy = 1;
	visited[1][1] = true;
	result[1][1] = 1;
	que.push(make_pair(1, 1));

	while (!que.empty())
	{
		nowx = que.front().first;
		nowy = que.front().second;
		//cout << nowy << nowx << endl;
		if (nowy == N && nowx == M) break;
		que.pop();

		for (int i = 0; i < 4; i++)
		{
			int nx = nowx + dx[i];
			int ny = nowy + dy[i];
			if (ny<1 || nx >M || ny <1 || ny >N) continue;
			if (!visited[ny][nx] && map[ny][nx] == 1)
				visited[ny][nx] = true, que.push(make_pair(nx, ny)), result[ny][nx] = result[nowy][nowx] + 1;
		}

	}
	cout << result[N][M] << endl;
	return 0;
}