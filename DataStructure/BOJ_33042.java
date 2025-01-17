// BOJ - 33042
// Problem Sheet - https://www.acmicpc.net/problem/33042

import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static String[] tokens;
    private static final int LIMIT = 5;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tokens = br.readLine().split(" ");
        br.close();
    }

    private static int solve() {
        Map<String, Integer> tokenCounts = new HashMap<>();
        int index = 1;
        for (String token : tokens) {
            if (!tokenCounts.containsKey(token)) {
                tokenCounts.put(token, 0);
            }
            tokenCounts.put(token, tokenCounts.get(token) + 1);
            if (tokenCounts.get(token) >= LIMIT) {
                break;
            }
            index++;
        }
        return index <= N ? index : 0;
    }

}
