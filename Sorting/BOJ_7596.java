// BOJ - 7596
// Problem Sheet - https://www.acmicpc.net/problem/7596

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int index = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            String[] names = new String[n];
            for (int i=0 ; i<n ; i++) {
                names[i] = br.readLine();
            }
            Arrays.sort(names);
            sb.append(index++).append("\n");
            for (int i=0 ; i<n ; i++) {
                sb.append(names[i]).append("\n");
            }
        }

        System.out.println(sb);

        br.close();
    }
}