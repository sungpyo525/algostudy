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
		
		// �ڿ��� �׹�° �ڸ����� �� �� ���� �� �ڸ��� ĳ���ͷ� �޾Ƽ�
		// �ƽ�Ű �ڵ� ������ 1�� �ƽ�Ű�ڵ� ����ŭ ����.
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
				int x=(int)input[i].charAt(j);	// �Է¹��� ���� ù��° ���ڴ� �����ΰ�
				if(x>=97) // a~f������ 87�� ���ְ�
					System.out.print(binary[x-87]+" ");
				else // 0~9������ 48�� ���ٰ��̴�.
					System.out.print(binary[x-48]+" ");
			}
			System.out.println();
		}
			
		// 1�� ����� ����ϱ�
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
		
		// 1�� ������ ����� count[][] ����ϱ�
		for(int j=0; j<4; j++){
			for(int k=0; k<4; k++){
				if(count[j][k]>=10)
					count[j][k]=count[j][k]%10;
				System.out.print(count[j][k]);
			} System.out.print(" ");
		} System.out.println();
	}
}


