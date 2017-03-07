package com.test170304;

import java.util.Arrays;
import java.util.Scanner;

public class Q1920_practice {
	static int arr[] = new int[100001];
	static int n;
	
	public static int Search(int num){
		int start=0;
		int end=n;
		int mid;
		
		while(start<=end){
			mid=(start+end)/2;
			
			if(arr[mid]==num)
				break;
			
			if(arr[mid]<num)
				start=mid+1;
			else
				end=mid-1;
		}
		
		if(start<=end)
			return 1;
		else
			return 0;
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		n=sc.nextInt();
		
		for(int i=0; i<n; i++)
			arr[i]=sc.nextInt();
		
		Arrays.sort(arr);
		
		int m;
		m=sc.nextInt();
		
		for(int i=0; i<m; i++){
			int temp;
			temp=sc.nextInt();
			System.out.println(Search(temp));
		}
	}
}
