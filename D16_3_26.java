package org.example;

import java.util.*;

public class D16_3_26 {
        public static void main(String args[]) {
                Scanner sc = new Scanner(System.in);

                int r = sc.nextInt();
                int c = sc.nextInt();

                char [][] arr = new char[r][c];

                sc.nextLine();
                for (int i = 0; i < r; i++) {
                        arr[i] = sc.nextLine().toCharArray();
                }

                int A = -1, B = -1;
                for (int i = 0; i < r && (A == -1 || B == -1); i++) {
                        for (int j = 0; j < c; j++) {
                                if (arr[i][j] == 'A' || arr[i][j] == 'B') {
                                        if (arr[i][j] == 'A') {
                                                A = firstMethod(arr, r, c, i, j);
                                        }
                                        else if (arr[i][j] == 'B'){
                                                B = firstMethod(arr, r, c, i, j);
                                        }
                                }
                        }
                }
                if (A > B) System.out.println("A");
                if (B > A) System.out.println("B");
                if (A == -1 && B == -1) System.out.println("-1");
        }
        public static int firstMethod(char[][] arr, int r, int c, int rr, int rc) {
                Queue<int[]> queue = new LinkedList<int[]>();
                queue.add(new int[] {rr,rc,0});

                boolean[][] flag = new boolean[arr.length][arr[0].length];
                int[] posR = {1,1,1,0,0,-1,-1,-1};
                int[] posC = {-1,0,1,-1,1,-1,0,1};

                while (!queue.isEmpty()) {

                        int[] curr = queue.poll();
                        if (0 > curr[0] || curr[0] >= r || 0 > curr[1] || curr[1] >= c) {
                                continue;
                        }

                        if (arr[curr[0]][curr[1]] == 'C') {
                                return curr[2];
                        }

                        for (int i = 0; i < 4; i++) {
                                if (flag[curr[0]][curr[1]] || arr[curr[0]][curr[1]] == '*') continue;
                                flag[curr[0]][curr[1]] = true;
                                queue.add(new int[] {curr[0]+posR[i], curr[1] + posC[i],curr[2]+1});
                        }
                }
                return -1;
        }
}