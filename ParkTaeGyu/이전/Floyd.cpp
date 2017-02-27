#include<iostream>
using namespace std;
#include<algorithm>
#define INF 987654321
int map[8][8] = { { 0, 1, 5, 1, INF, INF, INF, INF }, { INF, 0, INF, INF, INF, INF, 3, 1 }, { INF, INF, 0, INF, 3, INF, 1, INF }, { INF, INF, 7, 0, 2, INF, INF, INF },
{ INF, INF, INF, INF, 0, 1, 1, INF }, { INF, INF, INF, INF, INF, 0, INF, 7 }, { INF, INF, INF, INF, INF, INF, 0, 1 }, { INF, INF, INF, INF, INF, INF, INF, 0 } };

void printmap()
{
	for (int j = 0; j < 8; j++)
	{
		for (int i = 0; i < 8; i++)
		{
			cout << " " <<map[j][i];
			//if (map[j][i] != INF) cout << " 1";
			//else cout << " -1";
		}
			
		cout << endl;
	}
	
}

int main()
{
	for (int k = 0; k < 8;k++)
		for (int j = 0; j < 8;j++)
		for (int i = 0; i < 8; i++)
		for (int v = 0; v < 8; v++)
		{
			if (map[i][j] == 0) continue; 
			map[i][j] = min(map[i][v] + map[v][j], map[i][j]);
		}



	printmap();
}