#include<iostream>
#include<queue>
#include<memory.h>
using namespace std;
int onepan[1001];
int N, M;

bool endCheck()
{
	bool chk = true;
	for (int i = 1; i <= N; i++)
		if (onepan[i] != 1) chk = false;
	
	return chk;
}
int main()
{
	queue<int> que;
	int now = 1;
	int zeroCheck = 0;
	cin >> N >> M;
	
	memset(onepan, 0,sizeof(onepan)); //배열 초기화

	if (N == 1)
	{
		que.push(1); cout << "<";
		cout << que.front() << ">";
		que.pop();
				return 0;
	}

	while (!endCheck())   //모든 onepan이 1로 채워질때까지
	{
		
		while (zeroCheck != M)
		{
			if (now >= N+1) now %= N;
			if (onepan[now] == 1) { now++; continue; };
			now++;
			zeroCheck++;
		}

		--now;
		que.push(now);
		onepan[now] = 1;
		zeroCheck = 0;
	}
	
	// 출력
	cout << "<";
	cout << que.front() << ",";
	que.pop();

	for (int i = 0; i < N-2;i++)
	{
		cout <<" "<<que.front()<<",";
		que.pop();
	}
	cout<<" " << que.front();
	que.pop();
	cout << ">";



	return 0;
}