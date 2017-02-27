#include<iostream>
#include<algorithm>
#define INF 987654321
using namespace std;
int people[101][101];
int N, M;
int result[101];

void printP()
{
	for (int j = 1; j <= N; j++)
	{
		for (int i = 1; i <= N; i++) 
			cout << " " << people[j][i];
		cout << endl;
	}
	

}


int main()
{
	int resultNum = 1;
	memset(result, 0, sizeof(result));
	
	int from, to;
	cin >> N >> M;
	for (int i = 1; i <= N; i++)
	{
		for (int j = 1; j <= N; j++) people[i][j] = INF;
		people[i][i] = 0;
	}
	
	for (int i = 0; i < M; i++)
		cin >> from >> to, people[from][to] = people[to][from] = 1;
	

	for (int v = 1; v <= N;v++)
		for (int j = 1; j <= N;j++)
			for (int i = 1; i <= N; i++)
				people[j][i] = min(people[j][v] + people[v][i],people[j][i]);

	for (int j = 1; j <= N; j++)
		for (int i = 1; i <= N; i++)
			result[j] += people[j][i];

		
		for (int i = 2; i <= N;i++)
			if (result[resultNum] > result[i]) resultNum = i;

		cout << resultNum;
		
	return 0;
}
