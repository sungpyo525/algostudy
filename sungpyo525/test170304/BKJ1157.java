package com.test170304;


import java.util.Arrays;
import java.util.Scanner;

// A-Z : 65 - 90
// a-z : 97 - 122

public class BKJ1157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word=sc.nextLine();
		int count [] = new int [26];
		
		
	/*	for(int i=0; i<count.length; i++){
			count[i]=0;
		}
		*/
		
		for(int i=0 ; i<word.length() ; i++){
			int n=word.charAt(i);
			if(n>=97 && n<=122){
				count[n-97]++;
			}
			else{
				count[n-65]++;
			}
		}
		
		int count_copy[]=Arrays.copyOf(count, 26);
		Arrays.sort(count);

		if(count[25]==count[24]){
			System.out.println("?");
		}else{
			for(int i=0; i<26; i++){
				if(count[25]==count_copy[i])
					System.out.printf("%c",i+65);
			}
		}
		
		/*// 각 개수 확인용 Test for문
		for(int i=0 ;  i<count.length; i++){
			if(count[i] != 0){
				System.out.printf("%c의 개수는 %d개 입니다.%n",i+65 , count[i]);
			}
		}*/
	}

}
