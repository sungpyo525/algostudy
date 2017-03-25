package test;

import java.util.Scanner;

public class Hexa {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String bin[] = { "0000", "0001", "0010", "0011", "0100", "0101",
				"0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101",
				"1110", "1111" };
		String hex[] = new String[10];
		String tmp[]={"","","","","","","","","","",};
		int sum[]=new int[16];
		
		for (int i = 0; i < 10; i++) {
			hex[i] = sc.next();
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 4; j++) {

				if (hex[i].charAt(j) < 'a')
					tmp[i]+= bin[hex[i].charAt(j)-48];
				else if(hex[i].charAt(j) >= 'a'){
					tmp[i]+= bin[hex[i].charAt(j) - 87];
				}
			}
		}

		for(int i=0;i<10;i++){
			for(int j=0;j<16;j++){
				sum[j]+=tmp[i].charAt(j);
			}
		}
		
		for (int i = 0; i < 16; i++) {
				System.out.print(sum[i]%10);
				if((i+1)%4==0)System.out.print(" ");
		}

	}
}
