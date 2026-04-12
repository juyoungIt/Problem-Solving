// BOJ - 21866
// Problem Sheet - https://www.acmicpc.net/problem/21866

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] assigned = { 100, 100, 200, 200, 300, 300, 400, 400, 500 };
        int sum = 0;
        boolean isHacker = false;
        for (int i=0 ; i<9 ; i++) {
            int score = Integer.parseInt(st.nextToken());
            if (assigned[i] < score) {
                isHacker = true;
            }
            sum += score;
        }
        if (isHacker) System.out.println("hacker");
        else if (sum >= 100) System.out.println("draw");
        else System.out.println("none");
        br.close();
    }
}