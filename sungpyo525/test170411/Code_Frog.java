package com.test170411;
/* �Ʒ� �⺻ ������ �ڵ带 ���� �Ǵ� �����ϰ� ������ �ڵ带 ����ϼŵ� �˴ϴ�.
��, ����ϴ� Ŭ�������� Solution �̾�� �ϸ�, ������ Solution.java �� ����� ���� �����մϴ�.
�̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� ������ �� �� �ֽ��ϴ�. */
import java.util.Scanner;
import java.io.FileInputStream;

class Code_Frog {
	public static void main(String args[]) throws Exception {
		/*
		 * �Ʒ� �޼ҵ� ȣ���� ������ ǥ���Է�(Ű����) ��� input.txt ���Ϸ� ���� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�. ���� ������
		 * PC ���� �׽�Ʈ �� ����, �Է°��� input.txt�� ������ �� �� �ڵ带 ù �κп� ����ϸ�, ǥ���Է� ���
		 * input.txt ���Ϸ� ���� �Է°��� �о� �� �� �ֽ��ϴ�. ����, ���� PC���� �Ʒ� �޼ҵ带 ������� �ʰ� ǥ���Է���
		 * ����Ͽ� �׽�Ʈ�ϼŵ� �����մϴ�. ��, Codeground �ý��ۿ��� "�����ϱ�" �� ������ �ݵ�� �� �޼ҵ带 ����ų�
		 * �ּ�(//) ó�� �ϼž� �մϴ�.
		 */
		// Scanner sc = new Scanner(new FileInputStream("input.txt"));

		Scanner sc = new Scanner(System.in);

		int TC;
		int test_case;

		TC = sc.nextInt();
		for (test_case = 1; test_case <= TC; test_case++) {
			int cnt = 0;
			int N = sc.nextInt();
			int a[] = new int[N + 1];

			// ���� ��ġ�� �Է¹���.
			a[0] = 0;
			for (int i = 1; i <= N; i++) {
				a[i] = sc.nextInt();
			}

			// �ִ� ���� ���� ĭ���� �Է�
			int K = sc.nextInt();
			int now = 0;
			boolean trueorfalse = true;

			// 1. ������ ������ �˻�
			for (int i = 0; i < N; i++) {
				if (a[i + 1] - a[i] > K) {
					cnt = -1;
					trueorfalse = false;
					break; // ���� ����� �ݺ����� ��������
				}
			}


			while (trueorfalse && a[now] != a[N]) {
				//System.out.println("now: �ε���"+now+", "+a[now]);
				for (int j = now ; j <= N; j++) {
					//System.out.println("j�ǰ� " +j+", a[j]:"+a[j]);
					if (a[j] - a[now] <= K) {
						//System.out.println("�Ѿ");
						continue;
					} else if (a[j] + K > a[N]) {
						now=N;
						cnt+=2;
						//System.out.println("LAST next: �ε���"+now+", "+ + a[now]);
						//System.out.println("cnt ���\n");
						break;
					} else {
						now = j - 1;
						cnt++;
						//System.out.println("next: �ε���"+now+", "+ a[now]);
						//System.out.println("cnt ���!\n");
						break;
					}
				}

			}

			// �� �κп��� ������ ����Ͻʽÿ�.
			System.out.println("Case #" + test_case);
			System.out.println(cnt);
		}

	}
}