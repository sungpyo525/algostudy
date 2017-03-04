/*
INPUT : 영화수(1<=n<=100000) 평점들(-1000<=r_i<=1000)
OUTPUT : 최대 평점합
FUNCT : MaximizeRatings(), using DFS.
CONST ; 1/0개 스킵가능. 순서대로 평가해야함.
*/

#include<iostream>
#include<algorithm>
#define MAX_MOV 100001
using namespace std;

int n, r[MAX_MOV] = { 0, }, memo[MAX_MOV] = {0,};

// rating_numb 길이의 평점배열(r)의 i번째 변수를 포함하는지 유무에 따른 최대 평점.
// 함수 종료 후, memo에 저장.
// 포함시 1, 포함x 0
//i번째 변수 포함시 최대 누적 평점.

int MaximizeRatings(int i, int *r, int rating_numb, int incl)
{
	if (i == rating_numb) {
		//cout << (incl)*(r[i]);
		return (incl)*(r[i]);
	}

	if (incl == 1)
	{
		return ((incl)*(r[i]) + max(MaximizeRatings(i + 1, r, rating_numb, 1), MaximizeRatings(i + 1, r, rating_numb, 0)));
	}
	else if (incl == 0) {
		return ((incl)*(r[i]) + MaximizeRatings(i + 1, r, rating_numb, 1) );
	}

}

int main()
{
	freopen("input.txt", "r", stdin);

	cin >> n;
	for (int i = 1; i <= n; i++) { cin >> r[i]; }

	int result = MaximizeRatings(0, r, n, 1);

	cout << result;

	return 0;
}