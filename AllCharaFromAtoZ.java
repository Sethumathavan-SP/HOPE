package org.example;

import java.util.*;

public class AllCharaFromAtoZ {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                String s = sc.nextLine();
                int flag = 0;
                for(char ch : s.toCharArray()){
                        flag = flag | (1 << (ch - 'a'));
                }
                String r = (flag == ((1 << 26) - 1)) ? "yes":"no";
                System.out.print(r);
        }
}