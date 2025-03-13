// BOJ - 30034
// Problem Sheet - https://www.acmicpc.net/problem/30034

import java.util.*;
import java.io.*;

public class Main {

    private static int N, M, K, S;
    private static String str;

    private static final Set<Character> delimiters = new HashSet<>();

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] row = br.readLine().split(" ");
        for (int i=0 ; i<N ; i++) {
            delimiters.add(row[i].charAt(0));
        }
        M = Integer.parseInt(br.readLine());
        row = br.readLine().split(" ");
        for (int i=0 ; i<M ; i++) {
            delimiters.add(row[i].charAt(0));
        }
        K = Integer.parseInt(br.readLine());
        row = br.readLine().split(" ");
        for (int i=0 ; i<K ; i++) {
            delimiters.remove(row[i].charAt(0));
        }
        S = Integer.parseInt(br.readLine());
        str = br.readLine();
        delimiters.add(' ');
        br.close();
    }

    private static String solve() {
        StringBuilder sb = new StringBuilder();
        int tokenLength = 0;
        for (int i=0 ; i<S ; i++) {
            if (delimiters.contains(str.charAt(i))) {
                if (tokenLength > 0) {
                    sb.append("\n");
                    tokenLength = 0;
                }
            } else {
                sb.append(str.charAt(i));
                tokenLength++;
            }
        }
        return sb.toString();
    }
}
