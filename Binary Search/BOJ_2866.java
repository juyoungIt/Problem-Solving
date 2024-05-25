// BOJ - 17269
// Problem Sheet - https://www.acmicpc.net/problem/17269

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] table = new char[r][c];
        for (int i=0 ; i<r ; i++) {
            table[i] = br.readLine().toCharArray();
        }

        Set<String> tokens = new HashSet<>();
        int start = 0, end = r;
        while (start <= end) {
            int mid = (start + end) / 2;
            tokens.clear();
            for (int j=0 ; j<c ; j++) {
                sb.setLength(0);
                for (int k=0 ; k<r ; k++) {
                    sb.append(table[k][j]);
                }
                tokens.add(sb.substring(mid));
            }
            if (tokens.size() < c) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(end);

        br.close();
        System.exit(0);
    }
}