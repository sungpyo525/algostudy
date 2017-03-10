package com.test170311;

import java.util.Scanner;

public class Q9012_error {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		String vps;
		char vpsArr[];
		
		for(int i=0; i<N; i++){
			
			vps=sc.next();
			vpsArr= vps.toCharArray();
			
			isValid(vpsArr);
			
			vps=null;
		}
	}

	private static void isValid(char[] c) {
		int cnt=0;
		
		for(int i=0; i<c.length ; i++){
			if(c[i]==')' || c[c.length-1]=='('){
				System.out.println("NO");
				cnt=50000;
				break;
			}
			
			if(c[i]=='('){
				cnt+=1;				
			}
			else if (c[i]==')'){
				cnt+=-1;
				if(i>0 && c[i+1]==')'  && cnt==0){
					System.out.println("NO");
					break;
				}
			}
		}
		
		if(cnt==0)
			System.out.println("YES");			
		else if(cnt==50000)
			return;
		else if(cnt!=0)
			System.out.println("NO");
	}
}
