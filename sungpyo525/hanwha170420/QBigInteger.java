package com.hanwha170420;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class QBigInteger {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		/*
		long a=sc.nextLong();
		a++;
		System.out.println(a);
		*/
		
		BigInteger bi;
		bi=sc.nextBigInteger();
		BigInteger bi2= new BigInteger(sc.next());
		
		//둘다 가능
		System.out.println(bi.add(bi2));
		System.out.println(bi.add(new BigInteger("1")));
	}
}
