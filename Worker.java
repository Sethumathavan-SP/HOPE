package org.example;

public class Worker extends Thread{
        int N;
        int id;
        public Worker(int n, int id) {
                this.N = n;
                this.id = id;
        }

        public void run() {
                for (int i = 0; i < N; i++) {
                        System.out.println("Worker-ID:" + id + " work:" + id);
                }
        }
}
