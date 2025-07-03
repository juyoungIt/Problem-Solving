// BOJ - 26506
// Problem Sheet - https://www.acmicpc.net/problem/26506

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int[] s;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = new int[n];
        for (int i=0 ; i<n ; i++) {
            s[i] = Integer.parseInt(br.readLine());
        }
        br.close();
    }

    private static int solve() {
        Arrays.sort(s);
        int start = 0, end = n - 1;
        int minTeamRating = Integer.MAX_VALUE;
        while (start < end) {
            int teamRating = s[start++] + s[end--];
            minTeamRating = Math.min(minTeamRating, teamRating);
        }
        return minTeamRating;
    }

}
