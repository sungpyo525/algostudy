#include <cstdio>
#include <iostream>
#include<algorithm>
#define TRUE 1
#define FALSE 0
int map[7][7];
int dp[7][7];
using namespace std;
//int plane_x=3, plane_y=7;

int MaxFind();
bool GameFailCheck();
int MaxFind()
{
	int coin = dp[0][0];
	if (GameFailCheck()) return -1;
	for (int i = 1; i < 6; i++)
	{
		coin = max(dp[0][i], coin);
	}
	return coin;
}
bool GameFailCheck()
{
	bool check_game_fail = FALSE;
	for (int i = 0; i < 7; i++)
	{
		if (dp[i][0] == 0 && dp[i][1] == 0 && dp[i][2] == 0 && dp[i][3] == 0 && dp[i][4] == 0 && dp[i][5] == 0 && dp[i][6] == 0)
		{
			check_game_fail = TRUE;
		}
	}
	return check_game_fail;

}


void PlayRound()
{
	if (map[6][2] == 1) dp[6][2] = 1;
	if (map[6][3] == 1) dp[6][3] = 1;
	if (map[6][4] == 1) dp[6][4] = 1;




	for (int i = 5; i >= 0; i--)
	{
		if (map[i][0] == 2) dp[i][0] = 0;
		else dp[i][0] = max(dp[i + 1][0], dp[i + 1][1]);
		if (map[i][6] == 2) dp[i][6] = 0;
		else dp[i][6] = max(dp[i + 1][5], dp[i + 1][6]);
		for (int j = 1; j <= 5; j++)
		{
			if (map[i][j] == 2) dp[i][j] = 0;
			else dp[i][j] = max(max(dp[i + 1][j - 1], dp[i + 1][j]), dp[i + 1][j + 1]) + map[i][j];
		}
	}	

}

void print_dp()
{
	for (int i = 0; i < 7; i++)
	{
		for (int j = 0; j < 7; j++)
		{
			cout<< dp[i][j];
		}
		cout << endl;
	}
}
void print_map()
{
	for (int i = 0; i < 7; i++)
	{
		for (int j = 0; j < 7; j++)
		{
			cout << map[i][j];
		}
		cout << endl;
	}
}
void input_map()
{
	for (int i = 0; i < 7; i++)
	{
		for (int j = 0; j < 7; j++)
		{
			cin >> map[i][j];
		}
	}
}


int main(int argc, char** argv) {
	/* 아래 freopen 함수는 sample_input.txt 를 read only 형식으로 연 후,
	앞으로 표준 입력(키보드) 대신 sample_input.txt 파일로 부터 읽어오겠다는 의미의 코드입니다.
	만약 본인의 PC 에서 테스트 할 때는, 입력값을 sample_input.txt에 저장한 후 freopen 함수를 사용하면,
	그 아래에서 scanf 함수 또는 cin을 사용하여 표준입력 대신 sample_input.txt 파일로 부터 입력값을 읽어 올 수 있습니다.
	또한, 본인 PC에서 freopen 함수를 사용하지 않고 표준입력을 사용하여 테스트하셔도 무방합니다.
	단, Codeground 시스템에서 "제출하기" 할 때에는 반드시 freopen 함수를 지우거나 주석(//) 처리 하셔야 합니다. */
	freopen("input.txt", "r", stdin);
	memset(map, 0, sizeof(map));
	memset(dp, 0, sizeof(dp));
	/* setbuf 함수를 사용하지 않으면, 본인의 프로그램이 제한 시간 초과로 강제 종료 되었을 때,
	C++에서 printf를 사용할 경우, printf로 출력한 내용이 채점되지 않고 '0점'이 될 수도 있습니다.
	따라서 printf를 사용할 경우 setbuf(stdout, NULL) 함수를 반드시 사용하시기 바랍니다. */
	setbuf(stdout, NULL);

	int T;
	int test_case;

	scanf("%d", &T);	// Codeground 시스템에서는 C++에서도 scanf 함수 사용을 권장하며, cin을 사용하셔도 됩니다.
	for (test_case = 1; test_case <= T; test_case++) {
		// 이 부분에서 알고리즘 프로그램을 작성하십시오. 기본 제공된 코드를 수정 또는 삭제하고 본인이 코드를 사용하셔도 됩니다.
		
		input_map();
		PlayRound();
		MaxFind();
        //print_map();
		print_dp();
	
		// 이 부분에서 정답을 출력하십시오. Codeground 시스템에서는 C++에서도 printf 사용을 권장하며, cout을 사용하셔도 됩니다.
		printf("Case #%d\n", test_case);
		int result = MaxFind();
		printf("%d", result);

	}

	return 0;	// 정상종료 시 반드시 0을 리턴해야 합니다.
}