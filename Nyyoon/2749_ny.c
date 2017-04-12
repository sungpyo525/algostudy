#include<stdio.h>

void fibo(int n) {
	int temp, now;
	int one_before=1;
	int two_before=0;

	if (n<= 1) { printf("%d", n); exit(1); }
	else if (n > 1) {
		for (int i = 2; i <= n; i++)
		{
			now = (one_before + two_before) % (1000000);

			temp = one_before;
			one_before = (now) % (1000000);
			two_before = temp % (1000000);

		}
	}
	printf("%d", now); exit(1);
}

int main()
{
	int input;

	scanf("%d", &input);
	fibo(input);

	return 0;
}
