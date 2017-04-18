package com.hanwha170417;

import java.util.Scanner;
// 숫자 읽기
public class ReadingNumber {
	static char[] num={'영','일', '이', '삼', '사', '오', '육', '칠', '팔', '구'};
	static String[] danwi={"억", "천","백","십","만","천","백","십"};
	
	public static void main(String[] args) {
		Scanner sc= new Scanner (System.in);
		String input;
		input=sc.nextLine();
		
		for(int i=0; i<input.length(); i++){
			int index=input.charAt(i)-48; // 0의 아스키코드가 48이라서 - 해줌
			// 만 자리 이전
			if(i<input.length()-5){
				if(index!=0 && (index!=1 || input.length()==9)) // 억 단위 까지 가면 숫자가 1이어도 출력해줘야 햠
					System.out.print(num[index]);
				if(index!=0)
					System.out.print(danwi[8-input.length()+1+i]);
			} // 만의 자리 (만은 5자리 이상의 숫자부터는 무조건 써줘야한다.)
			else if(i==input.length()-5){
				if(index!=0 && (input.length()>6 || index!=1)) //  (input.length()>6 || index!=1) 이유 : 5자리 숫자가 1로 시작하는 경우를 위해
					System.out.print(num[index]);
				System.out.print(danwi[4]);
			} // 만의 자리 이후
			else if(i>input.length()-5 && i!=input.length()-1){
				if(index!=0 && index!=1)
					System.out.print(num[index]);
				if(index!=0)
					System.out.print(danwi[8-input.length()+1+i]);
			} // 맨 마지막 자리 수
			else if(i==input.length()-1){
				if(input.charAt(i)!='0')
					System.out.print(num[index]);
			}
		}
	}
}
