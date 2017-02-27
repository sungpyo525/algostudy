#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int main()
{
	//N위치,각 센서의 거리 차를 저장할 vector
	vector<int> npos;
	vector<int> sub;
	int N, K, temp, result = 0;
	cin >> N >> K;

	//센서 위치 입력
	for (int i = 0; i < N; i++)
		cin >> temp, npos.push_back(temp);
	
	//내림차순 정렬
	sort(npos.begin(), npos.end());
	
	//각 센서 거리 차 위치 저장
	for (int i = 1; i < N; i++)
		sub.push_back(npos[i] - npos[i - 1]);

	//오름차순 정렬
	sort(sub.rbegin(), sub.rend());

	// K-1 만큼 뺌..
	for (int i = 0; i< sub.size() && i < K-1; i++)
		result -= sub[i];

	cout << npos[N - 1] - npos[0] + result;
	return 0;
}