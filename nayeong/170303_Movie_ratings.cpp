/*
INPUT : ��ȭ��(1<=n<=100000) ������(-1000<=r_i<=1000)
OUTPUT : �ִ� ������
FUNCT : MaximizeRatings(), using DFS.
CONST ; 1/0�� ��ŵ����. ������� ���ؾ���.
*/

#include<iostream>
#include<algorithm>
#define MAX_MOV 100001
using namespace std;

int n, r[MAX_MOV] = { 0, }, memo[MAX_MOV] = {0,};

// rating_numb ������ �����迭(r)�� i��° ������ �����ϴ��� ������ ���� �ִ� ����.
// �Լ� ���� ��, memo�� ����.
// ���Խ� 1, ����x 0
//i��° ���� ���Խ� �ִ� ���� ����.

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