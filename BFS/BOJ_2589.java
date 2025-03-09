// BOJ - 2589
// Problem Sheet - https://www.acmicpc.net/problem/2589

import java.util.*;
import java.io.*;

public class Main {

	static class Point {
		private final int x;
		private final int y;
		private final int dist;

		public Point(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		public int getX() { return this.x; }
		public int getY() { return this.y; }
		public int getDist() { return this.dist; }
	}
	
	private static int N, M;
	private static char[][] map;
	private static int maxDist = 0;

	private static final Queue<Point> queue = new ArrayDeque<>();
	private static final int[] xi = { -1, 1, 0, 0 };
	private static final int[] yi = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
		input();
		solve();
		System.out.println(maxDist);
    }

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		map = new char[N][M];
		for (int i=0 ; i<N ; i++) {
			String row = br.readLine();
			for (int j=0 ; j<M ; j++) {
				map[i][j] = row.charAt(j);
			}
		}
		br.close();
	}

	private static void solve() {
		for (int i=0 ; i<N ; i++) {
			for (int j=0 ; j<M ; j++) {
				if (map[i][j] == 'L') {
					bfs(j, i);
				}
			}
		}
	}

	private static void bfs(int x, int y) {
		boolean[][] visited = new boolean[N][M];
		queue.add(new Point(x, y, 0));
		visited[y][x] = true;
		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			for (int i=0 ; i<4 ; i++) {
				int nx = cur.getX() + xi[i];
				int ny = cur.getY() + yi[i];
				if (isOutOfRange(nx, ny) || visited[ny][nx] || map[ny][nx] == 'W') continue;
				queue.add(new Point(nx, ny, cur.getDist() + 1));
				visited[ny][nx] = true;
				maxDist = Math.max(maxDist, cur.getDist() + 1);
			}
		}
	}

	private static boolean isOutOfRange(int x, int y) {
		return !(x>=0 && y>=0 && x<M && y<N);
	}
}
