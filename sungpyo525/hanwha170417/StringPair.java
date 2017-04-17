package com.hanwha170417;

import java.util.Arrays;
import java.util.Scanner;

public class StringPair {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1, str2;
		
		str1=sc.next();
		str2=sc.next();
		char []al1=new char [str1.length()];
		char []al2=new char [str2.length()];
		
		for(int i=0; i<str1.length(); i++)
			al1[i]=str1.charAt(i);
			
		for(int i=0; i<str2.length(); i++)
			al2[i]=str2.charAt(i);
		
		Arrays.sort(al1);
		Arrays.sort(al2);
		
		int count=0;
		
		if(al1.length==al2.length){
			for(int i=0; i<al1.length; i++){
				if(al1[i]==al2[i]){
					count++;
					continue;
				}
				else{
					System.out.println("NO");
					break;
				}
			}
		}else{
			System.out.println("NO");
		}
		
		
		if(al1.length==count)
			System.out.println("YES");
	}
}
