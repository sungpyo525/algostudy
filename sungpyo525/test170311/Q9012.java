package com.test170311;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;

public class Q9012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(br.readLine());
		int cnt;
		String str;
		
		for (int j=0; j<N; j++){
			cnt=0;
			str=br.readLine();
			
			
			for(int i=0; i<str.length(); i++){
				if(str.charAt(i)=='(')
					cnt++;
				else if(str.charAt(i)==')' && cnt>0){
					cnt--;
				}
				else if(str.charAt(i)==')' && cnt<=0){
					cnt--;
					break;
				}
			}
			
			if(cnt==0)
				System.out.println("YES");
			else
				System.out.println("NO");
			
			str=null;
			
		}
	}

}
