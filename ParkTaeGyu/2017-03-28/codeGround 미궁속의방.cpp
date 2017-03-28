/*
	�ۼ���: ���±�
	�ۼ���: 2017-03-28

	[�ڵ� �׶��� �̱ü��ǹ湮��]

*/
#include <cstdio>
#include <iostream>
using namespace std;

int main(int argc, char** argv) {
	/* �Ʒ� freopen �Լ��� input.txt �� read only �������� �� ��,
	������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸ� ���� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
	���� ������ PC ���� �׽�Ʈ �� ����, �Է°��� input.txt�� ������ �� freopen �Լ��� ����ϸ�,
	�� �Ʒ����� scanf �Լ� �Ǵ� cin�� ����Ͽ� ǥ���Է� ��� input.txt ���Ϸ� ���� �Է°��� �о� �� �� �ֽ��ϴ�.
	����, ���� PC���� freopen �Լ��� ������� �ʰ� ǥ���Է��� ����Ͽ� �׽�Ʈ�ϼŵ� �����մϴ�.
	��, Codeground �ý��ۿ��� "�����ϱ�" �� ������ �ݵ�� freopen �Լ��� ����ų� �ּ�(//) ó�� �ϼž� �մϴ�. */
	//freopen("input.txt", "r", stdin);

	setbuf(stdout, NULL);

	int TC;
	int test_case;
	int daegak = 1;
	long long result = 1;
	int pos = 1;
	int N, K;
	long long temp;
	scanf("%d", &TC);	// cin ��� ����
	for (test_case = 1; test_case <= TC; test_case++) {
		// �� �κп��� �˰��� ���α׷��� �ۼ��Ͻʽÿ�.
		cin >> N >> K;
		char ch;
		for (int i = 0; i < K; i++)
		{
			cin >> ch;	
			switch (ch)
			{
			case 'U': 
				if (daegak > N) pos++;
				daegak--;
				
				break;
			case 'D': 
				if (daegak >= N) pos--;
				daegak++;
				break;
			case 'R': 
				if (daegak < N) pos++;
				daegak++;
				break;
			case 'L': 
				if (daegak<=N) pos--;
				daegak--;
				break;
			}
		
			if (daegak <= N)
			{
				if ((daegak % 2)== 1)
				{
					temp = daegak * (daegak - 1) / 2;
					result += (temp + pos);
					temp = 0;
				}
				else if((daegak%2) == 0)
				{
					temp = daegak * (daegak + 1) / 2;
					result += (temp - pos + 1);
					temp = 0;
				}
			}

			else if (daegak >N)
			{
				
				if ((daegak % 2) == 1)
				{
					for (int j = 1; j < daegak - N; j++)
					{
						temp += (N - j);
					}
					temp += N*(N +1) / 2;
					result += (temp + pos);
					temp = 0;

				}
				else if ((daegak % 2) == 0)
				{
					for (int j = 1; j <= daegak - N; j++)
					{
						temp += (N - j);
					}
					temp += (N*(N +1)) / 2;
					result += (temp - pos + 1);
					temp = 0;
					
				}
				
				
			}
		}
		// �� �κп��� ������ ����Ͻʽÿ�.
		printf("Case #%d\n", test_case);// cout ��� ����
		cout << result << endl;
		result = 1;
		pos = 1;
		daegak = 1;
	}

	return 0;	// �������� �� �ݵ�� 0�� �����ؾ� �մϴ�.
}