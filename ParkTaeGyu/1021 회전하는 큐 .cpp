/*
	작성일 : 2017-02-21
	작성자: 박태규
	
	Flow : 
	1. dec.front()와 1번째 데이터 비교 -->  같으면 pop , 다르면 --> 2로
	2. 데이터에 접근하기 위해서 필요한 [2]연산과 [3]연산 횟수 카운트, 더 적은 연산 횟수를 가진 연산 채택
	3. 채택된 연산을 위에서 계산한 연산 횟수만큼 연산
	-------위를 M만큼 반복--------
	
	[입력] 
	N 10 M 3
	Data 9 6 2

	<dec 변화>
	[1,2,3,4,5,6,7,8,9,10] 
	         
	[9,10,1,2,3,4,5,6,7,8] --> 9 pop  --> [10,1,2,3,4,5,6,7,8]
	
	[6,7,8,10,2,3,4,5] --> 6 pop--> [7,8,10,2,3,4,5]

	[2,3,4,5,7,8,10] --> 2pop --> [3,4,5,7,8,10]  End

	
*/





#include<iostream>
#include<deque>
#include<memory.h>
using namespace std;

int num[51];    //Input 
int cnt = 0;    // 2,3번 연산 카운트
int funcSecondCnt= 0; // 2번 연산 카운트
int funcThirdCnt = 0; // 3번 연산 카운트

int main()
{
	int N, M;
	int nChk;     // 찾으려는 숫자가 dec의 몇번째에 위치하는지 저장하는 변수
	cin >> N >> M; 
	memset(num, 0, sizeof(num)); //배열 초기화 #include<memory.h>
	deque<int> deq;   //컨테이너로 덱 사용

	//dec 입력
	for (int i = 1; i <= N; i++)
		deq.push_back(i);
	
	//Input 입력(찾으려는 숫자 입력)
	for (int i = 0; i < M; i++)
		cin >> num[i];


	//num[M] 만큼 반복.
	for (int i = 0; i < M; i++)
	{
		//만약 찾으려는 숫자가 덱의 첫번째에 위치하면 1번연산이므로 카운트 하지않음.
		if (num[i] == deq.front()) { deq.pop_front(); continue; }

		//찾으려는 숫자의 덱에서의 위치 저장
		for (int j = 0; j < deq.size(); j++)
		{
			if (deq[j] == num[i])
			{
				nChk = j;
				break;
			}
		}
		
		//위치에 따른 2,3번 연산 횟수 계산 
		funcSecondCnt = nChk;
		funcThirdCnt = deq.size()- nChk;

		//더 작은 숫자의 연산을 사용 (ex) 2번연산은 5번 . 3번연산은 2번만에 숫자를 찾을 수있다면 2번 선택
		if (funcSecondCnt <= funcThirdCnt)
		{
			for (int j = 0; j < funcSecondCnt; j++) //2번연산을 계산한 연산횟수만큼 반복
			{
				deq.push_back(deq.front()); 
				deq.pop_front();
				cnt++;
			}
		}
		else
		{
			for (int j = 0; j < funcThirdCnt; j++) // 3번 연산
			{
				deq.push_front(deq.back());
				deq.pop_back();
				cnt++;
			}
		}
		
		--i;
	}

	cout << cnt << endl;

	return 0;
}