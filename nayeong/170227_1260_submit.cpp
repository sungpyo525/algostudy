/*

#include<iostream>
#include<queue>
#include<stack>

#define MAX_NODE 1000
using namespace std;

void print_adj(bool adj[][MAX_NODE + 1], int N) {
	cout << "\n-----------------------\n";
	for (int i = 1; i <= N; i++)
	{
		for (int j = 1; j <= N; j++)
		{
			cout << adj[i][j];
		}
		cout << endl;
	}
	cout << "-----------------------\n";
}

int main()
{
	int N, M, depart, temp;
	bool adj[MAX_NODE + 1][MAX_NODE + 1] = { 0, };

	freopen("input.txt", "r", stdin);
	//	freopen("output.txt", "w", stdout);

	// 1. N, M, 출발노드 입력
	cin >> N >> M >> depart;

	// 2. 인접행렬 구성
	for (int i = 1; i <= M; i++) {
		int x = 0, y = 0;
		cin >> x >> y;
		adj[x][y] = adj[y][x] = 1;
	}

	// 3. DFS 시작 
	bool dfs_visited[MAX_NODE + 1] = { 0, };
	int current = 0, dfs_popped;
	stack<int> Stack;

	current = depart; // 3-1.노드도착
	dfs_visited[current] = 1;
	cout << current;

	do {
		//3-2. 인접노드 방문유무 체크
		for (temp = 1; temp <= N; temp++) {
			if ((adj[current][temp] == 1) && (dfs_visited[temp] == 0)) { // case1 -인접노드 있을 때 !
				Stack.push(current);
				current = temp;
				dfs_visited[current] = 1;
				cout << " " << current;

				break;
			}
			else if (temp == N) { //case2 -인접 노드 없을 때 !
				dfs_popped = Stack.top();
				Stack.pop();
				current = dfs_popped;
			}
		}
	} while (Stack.empty() == false);

	//4. BFS 시작
	bool bfs_visited[MAX_NODE + 1] = { 0, };
	queue<int> Queue;
	cout << endl;
	Queue.push(depart); // 4-1.첫 노드 도착

	do {
		current = Queue.front(); //POP
		bfs_visited[current] = 1;
		cout << current << " ";
		Queue.pop();

		//4-2. 인접노드 방문유무 체크
		for (temp = 1; temp <= N; temp++) {
			if ((adj[current][temp] == 1) && (bfs_visited[temp] == 0)) { // 인접노드들 PUSH.
				bfs_visited[temp] = 1;
				Queue.push(temp);
			}
		}

	} while (Queue.empty() == false);


	return 0;
}

*/