// BOJ - 33633
// Problem Sheet - https://www.acmicpc.net/problem/33633

import java.util.*;
import java.io.*;

public class Main {

    static class Status {
        long value;
        int depth;

        public Status(long value, int depth) {
            this.value = value;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Status> queue = new ArrayDeque<>();
        queue.add(new Status(1, 1));
        List<Long> starts = new ArrayList<>();
        while (!queue.isEmpty()) {
            Status cur = queue.poll();
            if (cur.depth == n) {
                starts.add(cur.value);
                continue;
            }
            long value1 = cur.value * 2;
            queue.add(new Status(value1, cur.depth + 1));
            if ((cur.value - 1) % 3 != 0) continue;
            long value2 = (cur.value - 1) / 3;
            if (value2 % 2 == 1 && value2 != 1) {
                queue.add(new Status(value2, cur.depth + 1));
            }
        }
        Collections.sort(starts);
        StringBuilder sb = new StringBuilder();
        sb.append(starts.size()).append("\n");
        for (long start : starts) sb.append(start).append("\n");
        System.out.println(sb);
        br.close();
    }
}