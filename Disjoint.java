package org.example;

import java.util.*;
public class Disjoint {
        static Scanner sc = new Scanner(System.in);
        public static void main(String[] args) {
                int N = sc.nextInt();
                int Q = sc.nextInt();
                int[] ldr = new int[N + 1];
                for(int i = 1;i <=N;i++) ldr[i] = i;
                for(int i = 0;i < Q;i++){
                        int lt = sc.nextInt();
                        int rt = sc.nextInt();
                        ldr[findldr(ldr,rt)] = findldr(ldr,lt);
                }
                for(int n =1;n <= N;n++){
                        System.out.print(findldr(ldr,n) + " ");
                }
        }
        public static int findldr(int[] ldr,int node){
                if(node == ldr[node]){
                        return node;
                }
                ldr[node] = findldr(ldr,ldr[node]);
                return ldr[node];
        }
}