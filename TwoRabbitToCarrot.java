import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		int[][] mat = new int[r][c];
		int ar = -1, ac = -1, br = -1, bc = -1;
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				mat[i][j] = sc.nextInt();
				if (mat[i][j] == 1) {
					ar = i;
					ac = j;
				}
				else if (mat[i][j] == 2) {
					br = i;
					bc = j;
				}
			}
		}
		
		int step1 = bfs(mat,ar,ac);
		int step2 = bfs(mat,br,bc);
		System.out.println((step1 < step2)?"A":"B");
	}
	
	static int[] pos = {0,1,0,-1,0};
	public static int bfs(int[][] mat, int r, int c) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {r,c,0});
		while (!queue.isEmpty()) {
			int[] arr = queue.poll();
			r = arr[0];
			c = arr[1];
			int steps = arr[2];
			if (mat[r][c] == 5) {
				return steps;
			}
			
			for (int i = 0; i < 4; i++) {
				int ar = pos[i] + r;
				int ac = pos[i+1] + c;
				if (0 <= ar && ar < mat.length && 0 <= ac && ac < mat[c].length && mat[ar][ac] != -1) {
					queue.add(new int[] {ar,ac,steps+1});
				}
			}
		}
		return -1;
	}
}