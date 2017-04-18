package com.hanwha170417;

import java.util.Scanner;
// 상수(숫자 거꾸로 읽는 애)
public class Q2908 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		String str[]=sc.nextLine().split(" ");
		
		String str1=new StringBuilder(str[0]).reverse().toString();
		String str2=new StringBuilder(str[1]).reverse().toString();

		if(Integer.parseInt(str1)>Integer.parseInt(str2))
			System.out.println(str1);
		else
			System.out.println(str2);

	}
}
