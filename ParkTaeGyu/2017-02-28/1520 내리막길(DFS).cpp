#include<iostream>
#include<cstring>
using namespace std;
int map[501][501];
int result[501][501];
int M, N;
void printres();

/*
[입력]
4 5
50 45 37 32 30
35 50 40 20 25
30 30 25 17 28
27 24 22 15 10

[result]
11111
10021
10020
11133

출력:3
*/
void Check(int y,int x)
{
	if (x + 1 <= N && map[y][x+1]<map[y][x] )
	{	
			result[y][x + 1]++;
			Check(y, x + 1);
	}

	if (y + 1 <= M && map[y+1][x] <map[y][x])
	{
			result[y + 1][x]++;
			Check(y+1, x);
	}

	if (x - 1 >= 1 && map[y][x-1]<map[y][x])
	{
			result[y][x - 1]++;
			Check(y, x-1);
	}

	if (y - 1 >= 1 && map[y-1][x] <map[y][x])
	{
			result[y - 1][x]++;
			Check(y-1,x);
	}
}
void printresult()
{
	for (int i = 1; i <= M; i++)
	{
		for (int j = 1; j <= N; j++)
		{
			cout<< result[i][j];
		}
		cout << endl;
	}
}
int main()
{

	memset(map, 0, sizeof(map));
	memset(result, 0, sizeof(result));
	
	cin >> M >> N;
	for (int i = 1; i <= M; i++)
	{
		for (int j = 1; j <= N; j++)
		{
			cin >> map[i][j];
		}
	}
	result[1][1] = 1;
	Check(1, 1);
	//printres();
	cout << result[M][N];


	return 0;
}