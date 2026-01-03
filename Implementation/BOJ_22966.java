// BOJ - 22966
// Problem Sheet - https://www.acmicpc.net/problem/22966

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String answer = "";
        int minLevel = 5;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String title = st.nextToken();
            int level = Integer.parseInt(st.nextToken());
            if (level < minLevel) {
                minLevel = level;
                answer = title;
            }
        }
        System.out.println(answer);
        br.close();
    }
}
