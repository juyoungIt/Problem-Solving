// BOJ - 5077
// Problem Sheet - https://www.acmicpc.net/problem/5077

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int li = Integer.parseInt(st.nextToken());
            int ci = Integer.parseInt(st.nextToken());
            char[][] window = new char[li][ci];
            for (int i=0 ; i<li ; i++) {
                String row = br.readLine();
                for (int j=0 ; j<ci ; j++) {
                    window[i][j] = row.charAt(j);
                }
            }
            st = new StringTokenizer(br.readLine());
            int lm = Integer.parseInt(st.nextToken());
            int cm = Integer.parseInt(st.nextToken());
            char[][] map = new char[lm][cm];
            for (int i=0 ; i<lm ; i++) {
                String row = br.readLine();
                for (int j=0 ; j<cm ; j++) {
                    map[i][j] = row.charAt(j);
                }
            }
            int count = 0;
            for (int i=0 ; i<=lm-li ; i++) {
                for (int j=0 ; j<=cm-ci ; j++) {
                    if (isMatched(map, window, i, j)) {
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static boolean isMatched(char[][] map, char[][] window, int l, int c) {
        for (int i=l ; i<l+window.length ; i++) {
            for (int j=c ; j<c+window[0].length ; j++) {
                if (map[i][j] != window[i-l][j-c]) {
                    return false;
                }
            }
        }
        return true;
    }
}