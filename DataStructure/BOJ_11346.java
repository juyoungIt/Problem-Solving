// BOJ - 11346
// Problem Sheet - https://www.acmicpc.net/problem/11346

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i=0 ; i<t ; i++) {
            Set<String> names = new HashSet<>();
            br.readLine(); // 공백 입력
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int j=0 ; j<n ; j++) {
                names.add(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j=0 ; j<m ; j++) {
                names.add(st.nextToken());
            }
            sb.append(names.size()).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}