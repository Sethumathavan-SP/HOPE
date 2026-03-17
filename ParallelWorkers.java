package org.example;

import java.util.Scanner;

public class ParallelWorkers  {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int N = sc.nextInt();
                int numOfWorkers = sc.nextInt();
                for (int i = 0; i < numOfWorkers; i++) {
                        Worker worker = new Worker(N,i);
                        worker.start();
                }
        }
}
