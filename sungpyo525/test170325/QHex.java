package com.test170325;

/*
1025
1001
0a0b
2399
0b2d
530b
abcd
2801
3001
4101
*/

import java.util.Scanner;

public class QHex {
	public static void main(String[] args) {
		String binary[] = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111" };
		// char hex[] = {'1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
		String input[]=new String[10];
		int count[][]= new int[4][4];
		
		// 뒤에서 네번째 자리부터 맨 뒤 까지 각 자리를 캐릭터로 받아서
		// 아스키 코드 값에서 1의 아스키코드 값만큼 뺀다.
/*		System.out.println((int)'0'); //48
		System.out.println((int)'1'); // 49
		System.out.println((int)'2'); // 50
		System.out.println((int)'a'); // 97
*/		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<10; i++){
			//System.out.println("0x");
			input[i]=sc.next();
		}
		
		for(int i=0; i<10; i++){
			for(int j=0; j<4; j++){
				int x=(int)input[i].charAt(j);	// 입력받은 것의 첫번째 글자는 무엇인가
				if(x>=97) // a~f까지는 87을 빼주고
					System.out.print(binary[x-87]+" ");
				else // 0~9까지는 48을 빼줄것이다.
					System.out.print(binary[x-48]+" ");
			}
			System.out.println();
		}
			
		// 1이 몇개인지 계산하기
		for (int i=0; i<10; i++){
			for(int j=0; j<4; j++){
				for(int k=0; k<4; k++){
					int x=(int)input[i].charAt(j);
					if(x>=97)
						x=x-87;
					else
						x=x-48;
					
					if(binary[x].charAt(k)=='1')
						count[j][k]++;
				}
			}
		}
		
		// 1의 개수를 계산한 count[][] 출력하기
		for(int j=0; j<4; j++){
			for(int k=0; k<4; k++){
				if(count[j][k]>=10)
					count[j][k]=count[j][k]%10;
				System.out.print(count[j][k]);
			} System.out.print(" ");
		} System.out.println();
	}
}


