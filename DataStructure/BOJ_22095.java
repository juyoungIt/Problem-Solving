// BOJ - 22095
// Problem Sheet - https://www.acmicpc.net/problem/22095

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] row = br.readLine().split(" ");
            int n = Integer.parseInt(row[0]);
            int m = Integer.parseInt(row[1]);
            Queue<Integer>[] members = new ArrayDeque[n + 1];
            for (int i=1 ; i<=n ; i++) {
                members[i] = new ArrayDeque<>();
            }
            for (int i=0 ; i<m ; i++) {
                row = br.readLine().split(" ");
                int a = Integer.parseInt(row[0]);
                int b = Integer.parseInt(row[1]);
                if (members[a].isEmpty()) {
                    members[b].add(a);
                    sb.append("NO").append("\n");
                } else {
                    if (members[a].peek() == b) {
                        sb.append("YES").append("\n");
                    } else {
                        sb.append("NO").append("\n");
                    }
                    members[b].add(members[a].poll());
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}