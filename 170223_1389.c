#include<stdio.h>
#define USER_MAX 101
#define FRIEND_MAX 999999

int main()
{
	int N, M;
	int from, to;
	int standard, compare;
	int friendship[USER_MAX][USER_MAX] = { 0 };
	int temp_sum = 0, min_user, min_value;
	freopen("input.txt", "r", stdin);
	scanf("%d %d", &N, &M);

	// 1) 유저 간 관계표 작성 (비용행렬 작성)
	for (int i = 1; i <= M; i++) {
		from = 0, to = 0;
		scanf("%d %d", &from, &to);
		friendship[from][to] = 1;
		friendship[to][from] = 1;
	}


	for (int i = 1; i <= M; i++) {
		for (int j = 1; j <= M; j++) {

			standard = friendship[i][j];
			if (standard == 1) { continue; } // case1. 직접 연결된 노드는 점프
			if (i == j) { continue; }

			for (int z = 1; z <= M; z++) {
				if ((friendship[i][z] != 0) && (friendship[z][j] != 0)) {
					compare = friendship[i][z] + friendship[z][j];

					if (standard == 0) { friendship[i][j] = compare, friendship[j][i] = compare; }
					else if (compare < standard) { friendship[i][j] = compare, friendship[j][i] = compare; }
				}
			}
		}
	}

	min_user = 1, min_value = FRIEND_MAX;

	for (int i = 1; i <= M; i++) {
		temp_sum = 0;
		for (int j = 1; j <= M; j++) {
			temp_sum += friendship[i][j];
		}
		if (min_value > temp_sum) { min_user = i; min_value = temp_sum; }
	}

	printf("%d", min_user);

	return 0;
}