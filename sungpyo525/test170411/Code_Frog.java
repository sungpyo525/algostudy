package com.test170411;
/* 아래 기본 제공된 코드를 수정 또는 삭제하고 본인이 코드를 사용하셔도 됩니다.
단, 사용하는 클래스명이 Solution 이어야 하며, 가급적 Solution.java 를 사용할 것을 권장합니다.
이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해 볼 수 있습니다. */
import java.util.Scanner;
import java.io.FileInputStream;

class Code_Frog {
	public static void main(String args[]) throws Exception {
		/*
		 * 아래 메소드 호출은 앞으로 표준입력(키보드) 대신 input.txt 파일로 부터 읽어오겠다는 의미의 코드입니다. 만약 본인의
		 * PC 에서 테스트 할 때는, 입력값을 input.txt에 저장한 후 이 코드를 첫 부분에 사용하면, 표준입력 대신
		 * input.txt 파일로 부터 입력값을 읽어 올 수 있습니다. 또한, 본인 PC에서 아래 메소드를 사용하지 않고 표준입력을
		 * 사용하여 테스트하셔도 무방합니다. 단, Codeground 시스템에서 "제출하기" 할 때에는 반드시 이 메소드를 지우거나
		 * 주석(//) 처리 하셔야 합니다.
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

			// 돌의 위치를 입력받음.
			a[0] = 0;
			for (int i = 1; i <= N; i++) {
				a[i] = sc.nextInt();
			}

			// 최대 점프 가능 칸수를 입력
			int K = sc.nextInt();
			int now = 0;
			boolean trueorfalse = true;

			// 1. 실패의 조건을 검사
			for (int i = 0; i < N; i++) {
				if (a[i + 1] - a[i] > K) {
					cnt = -1;
					trueorfalse = false;
					break; // 가장 가까운 반복문을 빠져나감
				}
			}


			while (trueorfalse && a[now] != a[N]) {
				//System.out.println("now: 인덱스"+now+", "+a[now]);
				for (int j = now ; j <= N; j++) {
					//System.out.println("j의값 " +j+", a[j]:"+a[j]);
					if (a[j] - a[now] <= K) {
						//System.out.println("넘어감");
						continue;
					} else if (a[j] + K > a[N]) {
						now=N;
						cnt+=2;
						//System.out.println("LAST next: 인덱스"+now+", "+ + a[now]);
						//System.out.println("cnt 상승\n");
						break;
					} else {
						now = j - 1;
						cnt++;
						//System.out.println("next: 인덱스"+now+", "+ a[now]);
						//System.out.println("cnt 상승!\n");
						break;
					}
				}

			}

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(cnt);
		}

	}
}