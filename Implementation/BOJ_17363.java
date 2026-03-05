// BOJ - 17363
// Problem Sheet - https://www.acmicpc.net/problem/17363

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] paint = new char[n][m];
        for (int i=0 ; i<n ; i++) {
            String row = br.readLine();
            for (int j=0 ; j<m ; j++) {
                paint[i][j] = row.charAt(j);
            }
        }
        Map<Character, Character> rotate = new HashMap<>();
        rotate.put('.', '.'); rotate.put('O', 'O'); rotate.put('-', '|');
        rotate.put('|', '-'); rotate.put('/', '\\'); rotate.put('\\', '/');
        rotate.put('^', '<'); rotate.put('<', 'v'); rotate.put('v', '>');
        rotate.put('>', '^');
        for (int i=m-1 ; i>=0 ; i--) {
            for (int j=0 ; j<n ; j++) {
                sb.append(rotate.get(paint[j][i]));
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
