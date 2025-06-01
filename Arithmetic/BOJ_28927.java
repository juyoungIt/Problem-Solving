// BOJ - 28927
// Problem Sheet - https://www.acmicpc.net/problem/28927

import java.io.*;

public class Main {

    private static int t1, t2;
    private static int e1, e2;
    private static int f1, f2;
    private static final int TRAILER = 3, DRAMA = 20, MOVIE = 120;
    private static final String MAX = "Max", MEL = "Mel", DRAW = "Draw";

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
	}

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        t1 = Integer.parseInt(row[0]);
        e1 = Integer.parseInt(row[1]);
        f1 = Integer.parseInt(row[2]);
        row = br.readLine().split(" ");
        t2 = Integer.parseInt(row[0]);
        e2 = Integer.parseInt(row[1]);
        f2 = Integer.parseInt(row[2]);
        br.close();
    }

    private static String solve() {
        int total1 = t1 * TRAILER + e1 * DRAMA + f1 * MOVIE;
        int total2 = t2 * TRAILER + e2 * DRAMA + f2 * MOVIE;
        if (total1 == total2) return DRAW;
        else if (total1 < total2) return MEL;
        else return MAX;
    }

}
