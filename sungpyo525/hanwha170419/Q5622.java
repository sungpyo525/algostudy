package com.hanwha170419;
import java.util.Scanner;

public class Q5622 {

   static String input;
   static String[] alphaber = { "0", "0", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ" };
   static int result = 0;

   public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      input = sc.nextLine();
      // System.out.println(input);
      char[] char_str = input.toCharArray();
      for (int i = 0; i < char_str.length; i++) {

         for (int j = 2; j < alphaber.length; j++) {

            if (alphaber[j].indexOf(char_str[i]) != -1) {
               result += (j + 1);
            }

         }

      }

      System.out.println(result);

   }
}