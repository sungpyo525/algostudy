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