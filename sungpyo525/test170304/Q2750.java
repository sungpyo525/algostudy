package com.test170304;

import java.util.Arrays;
import java.util.Scanner;

public class Q2750 {
/*	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int arr[]=new int[N];
		
		for(int i=0; i<arr.length; i++){
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		for(int i=0; i<arr.length; i++){
			System.out.println(arr[i]);
		}
	}*/
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int arr[]=new int[N];
		
		for(int i=0; i<arr.length; i++){
			arr[i]=sc.nextInt();
		}
		
		for(int i=1; i <arr.length; i++){
			int key=arr[i];
			int j=i;
				
			while(j>0 && (key>arr[j-1])){
				int temp=arr[j-1];
				arr[j-1]=arr[j];
				arr[j]=temp;
				j--;
			}
		}
		
		for(int i=0; i<arr.length; i++){
			System.out.println(arr[i]);
		}
	}
}
