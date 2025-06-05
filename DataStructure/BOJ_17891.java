// BOJ - 17891
// Problem Sheet - https://www.acmicpc.net/problem/17891

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int[] socks;
    private static final String IMPOSSIBLE = "impossible";

    public static void main(String[] args) throws IOException {
        input();
        int result = solve();
        System.out.println(result < 0 ? IMPOSSIBLE : result);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        socks = new int[2 * n];
        String[] row = br.readLine().split(" ");
        for (int i=0 ; i<2*n ; i++) {
            socks[i] = Integer.parseInt(row[i]);
        }
        br.close();
    }

    private static int solve() {
        Deque<Integer> main = new ArrayDeque<>();
        Deque<Integer> sub = new ArrayDeque<>();
        for (int sock : socks) {
            main.addLast(sock);
        }
        int movementCount = 0;
        while (!main.isEmpty()) {
            if (!sub.isEmpty() && main.peekFirst().equals(sub.peekFirst())) {
                main.pollFirst();
                sub.pollFirst();
            } else {
                sub.push(main.pop());
            }
            movementCount++;
        }
        return sub.isEmpty() ? movementCount : -1;
    }

}