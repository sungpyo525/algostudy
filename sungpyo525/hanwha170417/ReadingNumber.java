package com.hanwha170417;

import java.util.Scanner;
// ���� �б�
public class ReadingNumber {
	static char[] num={'��','��', '��', '��', '��', '��', '��', 'ĥ', '��', '��'};
	static String[] danwi={"��", "õ","��","��","��","õ","��","��"};
	
	public static void main(String[] args) {
		Scanner sc= new Scanner (System.in);
		String input;
		input=sc.nextLine();
		
		for(int i=0; i<input.length(); i++){
			int index=input.charAt(i)-48; // 0�� �ƽ�Ű�ڵ尡 48�̶� - ����
			// �� �ڸ� ����
			if(i<input.length()-5){
				if(index!=0 && (index!=1 || input.length()==9)) // �� ���� ���� ���� ���ڰ� 1�̾ �������� �t
					System.out.print(num[index]);
				if(index!=0)
					System.out.print(danwi[8-input.length()+1+i]);
			} // ���� �ڸ� (���� 5�ڸ� �̻��� ���ں��ʹ� ������ ������Ѵ�.)
			else if(i==input.length()-5){
				if(index!=0 && (input.length()>6 || index!=1)) //  (input.length()>6 || index!=1) ���� : 5�ڸ� ���ڰ� 1�� �����ϴ� ��츦 ����
					System.out.print(num[index]);
				System.out.print(danwi[4]);
			} // ���� �ڸ� ����
			else if(i>input.length()-5 && i!=input.length()-1){
				if(index!=0 && index!=1)
					System.out.print(num[index]);
				if(index!=0)
					System.out.print(danwi[8-input.length()+1+i]);
			} // �� ������ �ڸ� ��
			else if(i==input.length()-1){
				if(input.charAt(i)!='0')
					System.out.print(num[index]);
			}
		}
	}
}
