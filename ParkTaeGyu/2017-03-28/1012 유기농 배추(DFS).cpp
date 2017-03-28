#include<iostream>
#include<queue>
#include<memory.h>
using namespace std;
int test_case, M, N, K;
int location[2501][2501];
int visited[2501][2501];
int dx[4] = { 1, 0, 0, -1 };
int dy[4] = { 0, 1, -1, 0 };

void Jaegui(int y,int x)
{
	visited[y][x] = 1;
	for (int j = 0; j < 4; j++)
	{
		int nexty = y + dy[j];
		int nextx = x + dx[j];
		if (nexty < 0 || nexty >= N) continue;
		if (nextx < 0 || nextx >= M) continue;
		if (location[nexty][nextx] == 1 && !visited[nexty][nextx])
		{
			Jaegui(nexty, nextx);
		}
	}
}
int main()
{
	int x, y;
	int test_case;
	cin >> test_case;
	
	for (int j = 0; j < test_case; j++)
	{
		int cnt = 0;
		cin >> M >> N >> K;
		queue<pair<int, int>> Queue;
		for (int i = 0; i < K; i++)
		{
			cin >> x >> y;
			location[y][x] = 1;
			Queue.push(make_pair(y, x));
		}

		if (Queue.empty()) cout << "0" << endl;

		while (!Queue.empty())
		{
				y = Queue.front().first;
				x = Queue.front().second;
				if (!visited[y][x]) { Jaegui(y, x); cnt++; }
				Queue.pop();
				
		}
		cout << cnt << endl;
		memset(location, 0, sizeof(location));
		memset(visited, 0, sizeof(location));
	}
	

	

	return 0;
}