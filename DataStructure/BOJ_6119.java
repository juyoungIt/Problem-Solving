// BOJ - 6119
// Problem Sheet - https://www.acmicpc.net/problem/6119

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int s = Integer.parseInt(br.readLine());
        Deque<Integer> line = new ArrayDeque<>();
        int cowNumber = 1;
        for (int i=0 ; i<s ; i++) {
            String[] row = br.readLine().split(" ");
            if (row[0].charAt(0) == 'A') {
                if (row[1].charAt(0) == 'L') line.addFirst(cowNumber++);
                else line.addLast(cowNumber++);
            } else {
                int k = Integer.parseInt(row[2]);
                if (row[1].charAt(0) == 'L') while (k-- > 0) line.pollFirst();
                else while (k-- > 0) line.pollLast();
            }
        }

        while (!line.isEmpty()) {
            sb.append(line.pollFirst()).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}