#include<iostream>
#include<string>
#define MAX M*N
using namespace std;

int N, M;
string temp_str;
int map[999999][100] = { 0 }; // �������ؾ������𸣰���...
int visited[999999][100] = { 0 };
int cost[999999][100] = { 0 };
int now_x = 0, now_y = 0;
int post_x[4] = { 1, 0, -1, 0 }, post_y[4] = { 0, 1, 0, -1 };

void print_dim(int map[][100], int N, int M) {
	for (int i = 0; i<N; i++) {
		for (int j = 0; j<M; j++) {
			cout << map[i][j] << " ";
		}
		cout << endl;
	}
} //map / visit ����Լ�

int cost_cal(int now_x, int now_y, int cumulative_cost) {

	visited[now_x][now_y] = 1; // '��������' (now_x, now_y) �湮 ��
	cumulative_cost++;
	cout << "�������� " << now_x << " , " << now_y << "  ; " << cumulative_cost << endl;

	// �������� ; ������ ���� 
	if (now_x == (N - 1) && now_y == (M - 1)) {
		cout << " ; arrival" << endl;
		if (cost[N][M] > cumulative_cost) {
			cost[N][M] = cumulative_cost;
		}
		return cost[N - 1][M - 1];
	}

	int min_cost = MAX, min_cost_cpr;

	for (int i = 0; i < 4; i++) // ���� �湮���� �ʾ����鼭, '���� ����'�̶� ����Ǿ� �ִ� ������ ��� '���� ����'���� �д�.
	{
		if ((visited[now_x + post_x[i]][now_y + post_y[i]] == 0) && (map[now_x + post_x[i]][now_y + post_y[i]] == 1)) // �������� Ž��
		{
			min_cost_cpr = cost_cal(now_x + post_x[i], now_y + post_y[i], cumulative_cost);

			if (min_cost_cpr < min_cost) {
				min_cost = min_cost_cpr;
				cost[now_x][now_y] = min_cost;
			}
		}
	}

	return min_cost;
}

int main() {
	freopen("input.txt", "r", stdin);
	//freopen("output.txt", "w", stdout);

	cin >> N >> M;

	// 1. map�� ����
	for (int i = 0; i < N; i++)
	{
		cin >> temp_str;
		for (int j = 0; j < M; j++)
		{
			map[i][j] = temp_str[j] - 48;  //'0'�� �ƽ�Ű�ڵ� 48.
			cost[i][j] = MAX;
		}
	}

	// 2. DP & DFS
//	print_dim(cost, N, M);

	cout << cost_cal(now_x, now_y, 0) << endl;
//	print_dim(cost, N, M);


	return 0;
}