package com.hanwha170417;

import java.util.Scanner;
//그룹 단어 체커

public class Q1316 {
	static int N;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N=sc.nextInt();
		String[] str=new String [N];
		int count=0;
		
		for(int i=0; i<N; i++){
			str[i]=sc.next();
			char[] c=str[i].toCharArray();
			int char_cnt=0;
			int temp_index=0;
			
			
			
			oneskip:
			for(int j=0; j<c.length; j++){
				//System.out.println("처본순"+c[j]+" "+j+" 증가");
				char_cnt++;
				for(int k=c.length-1; k>j; k--){
					if(c[j]==c[k]){
						temp_index=k;
						//System.out.println(j);
						//System.out.println(temp_index);
						break;
					}
				}
				
				if(temp_index==0)
					continue;
				
				for(int k=j+1; k<=temp_index; k++){
					if(c[j]!=c[k])
						break oneskip;
					else{
						//System.out.println(c[k]+" "+k+" 증가");
						char_cnt++;
					}
				}
				
				j=temp_index;
				temp_index=0;				
			}
			
			//System.out.println(c.length);
			//System.out.println(char_cnt);
			if(c.length==char_cnt){
				count++;
				/*for(int z=0; z<c.length; z++)
					System.out.print(c[z]);
				System.out.println();*/
			}
		}
		
		System.out.println(count);
	}
}
