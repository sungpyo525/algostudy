package com.test170304;

import java.util.Scanner;

public abstract class Q1920 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int A[] = new int[N];

		for (int i = 0; i < A.length; i++) {
			A[i] = sc.nextInt();
		}

		int M = sc.nextInt();
		int M_arr[] = new int[M];

		for (int i = 0; i < M_arr.length; i++) {
			M_arr[i] = sc.nextInt();
		} // 여기 까지 입력받기 끝냄

		// 비교하고 출력하기 시작
		for (int i = 0; i < M_arr.length; i++) {
			for (int j = 0; j < A.length; j++) {
				if (M_arr[i] == A[j]) {
					System.out.println("1");
					break;
				} else {
					if (j == A.length - 1) {
						System.out.println("0");
						break;
					}
					continue;
				}
			}
		}

	}
}
