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

	// 1. N, M, ��߳�� �Է�
	cin >> N >> M >> depart;

	// 2. ������� ����
	for (int i = 1; i <= M; i++) {
		int x = 0, y = 0;
		cin >> x >> y;
		adj[x][y] = adj[y][x] = 1;
	}

	// 3. DFS ���� 
	bool dfs_visited[MAX_NODE + 1] = { 0, };
	int current = 0, dfs_popped;
	stack<int> Stack;

	current = depart; // 3-1.��嵵��
	dfs_visited[current] = 1;
	cout << current;

	do {
		//3-2. ������� �湮���� üũ
		for (temp = 1; temp <= N; temp++) {
			if ((adj[current][temp] == 1) && (dfs_visited[temp] == 0)) { // case1 -������� ���� �� !
				Stack.push(current);
				current = temp;
				dfs_visited[current] = 1;
				cout << " " << current;

				break;
			}
			else if (temp == N) { //case2 -���� ��� ���� �� !
				dfs_popped = Stack.top();
				Stack.pop();
				current = dfs_popped;
			}
		}
	} while (Stack.empty() == false);

	//4. BFS ����
	bool bfs_visited[MAX_NODE + 1] = { 0, };
	queue<int> Queue;
	cout << endl;
	Queue.push(depart); // 4-1.ù ��� ����

	do {
		current = Queue.front(); //POP
		bfs_visited[current] = 1;
		cout << current << " ";
		Queue.pop();

		//4-2. ������� �湮���� üũ
		for (temp = 1; temp <= N; temp++) {
			if ((adj[current][temp] == 1) && (bfs_visited[temp] == 0)) { // �������� PUSH.
				bfs_visited[temp] = 1;
				Queue.push(temp);
			}
		}

	} while (Queue.empty() == false);


	return 0;
}

*/