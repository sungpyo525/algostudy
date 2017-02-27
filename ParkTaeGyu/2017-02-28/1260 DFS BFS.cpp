#include<iostream>
#include<queue>
#include<memory.h>
#include<stack>
using namespace std;
int N,M, V;
queue<int> que;
stack<int> stac;
int map[1001][1001];
int visited[1001];

/*
[입력]
4 5 1
1 2
1 3
1 4
2 4
3 4

Map
0 1 1 1 
1 0 0 1
1 0 0 1
1 1 1 0

[출력]
1 2 4 3(DFS)
1 2 3 4(BFS)

*/


void dfs(int start)
{
	visited[start] = 1;
	for (int i = 1; i <= N;i++)
	if (map[start][i] == 1 && !visited[i]) cout << " " << i, dfs(i);
}
void bfs()
{
	cout << V;
	que.push(V);
	visited[V] = 1;
	while (!que.empty())
	{
		int v = que.front();
		for (int i = 1; i <= N;i++)
		if (map[v][i] == 1 && !visited[i]) visited[i] = 1,cout << " " << i , que.push(i);
		que.pop();
	}
}

int main()
{
	int start, to;
	cin >> N >> M >> V;

	for (int i = 0; i < M; i++)
		cin >> start >> to, map[start][to] = map[to][start] = 1;

	cout << V;
	dfs(V);
	cout << endl;

	//초기화
	memset(visited, 0, sizeof(visited));
	
	bfs();
	return 0;
}