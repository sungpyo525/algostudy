/*
	작성일 : 2017-02-23
	작성자 : 박태규
*/

#include<iostream>
#include<set>
#include<memory.h>
#include<queue>
using namespace std;

int check[301][301][301];  // 중복체크하기 위한 배열, A: 0 , B: 0 , C : 10 이라면 check[0][0][10] =1로 바꿔줌 같은 연산을 계속하지않기위한.
int remain[3]; // remain[0] = A의 현재 물의 양 , remain[1] = B의 현재 물의 양,  remain[2] = C의 현재 물의 양
int size[3]; // 각 물통의 최대 물의 양(사이즈)를 저장해둠 , size[1] = A물통의 최대 저장량 ,  size[2] = B물통의 최대 저장량, size[3] = C물통의 최대저장량



set<int> st; // 결과를 저장하는 컨테이너로 set 활용!!
set<int>::iterator st_it; //set 출력을 위한 반복자 (*it)

int main()
{
	queue<int> aQue; //A의 현재 물의 양 저장
	queue<int> bQue; //B의 현재 물의 양 저장
	queue<int> cQue; //C의 현재 물의 양 저장
	
	memset(check, 0, sizeof(check)); //배열 초기화

	for (int i = 0; i < 3; i++)
		cin >> size[i]; //사이즈 입력

	aQue.push(0);    // 0
	bQue.push(0);    // 0
	cQue.push(size[2]); // 10
	check[0][0][size[2]] = 1; // check[0][0][10] = 1 

	while (!aQue.empty())
	{

		remain[0] = aQue.front();
		remain[1] = bQue.front();
		remain[2] = cQue.front();
		
		
		if (remain[0]==0) st.insert(remain[2]); //A가 0일때에만 C의 남은 물양을 저장

		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (i == j || remain[i] == size[i]) continue;
				remain[0] = aQue.front();
				remain[1] = bQue.front();
				remain[2] = cQue.front();
				
				remain[i] += remain[j];
				if (remain[i]>size[i]) remain[j] = remain[i] - size[i], remain[i] = size[i];
				else remain[j] = 0;
				if (check[remain[0]][remain[1]][remain[2]] == 0) 
					check[remain[0]][remain[1]][remain[2]] = 1, aQue.push(remain[0]), bQue.push(remain[1]), cQue.push(remain[2]);
			}
		}
		aQue.pop();
		bQue.pop();
		cQue.pop();
	}
	//출력
	for (st_it = st.begin(); st_it != st.end(); st_it++)
	{	
		if (st_it == st.begin()) cout << *st_it;
		else cout << " " << *st_it;
	}
	return 0;
}