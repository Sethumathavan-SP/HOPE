package org.example;

import java.util.Scanner;

public class Threads {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int N = sc.nextInt();
                int k = sc.nextInt();
                worker work1 = new worker(k,N);
                worker work2 = new worker(k+10,N+10);
                Thread t1 = new Thread(work1);
                Thread t2 = new Thread(work2);
                t1.start();
                t2.start();
        }
}

class worker2 extends Thread {
        private int n, x;

        worker2(int n, int x) {
                this.n = n;
                this.x = x;
        }

        public void run() {
                for (int i = 0; i < x; i++) {
                        System.out.println(n + " work " + i);
                }
        }
}

class worker implements Runnable{
        private int n,x;
        worker(int n,int x){
                this.n = n;
                this.x = x;
        }
        @Override
        public void run(){
                for(int i = 0; i < x;i++){
                        System.out.println(n + " work " + i);
                }
        }
}