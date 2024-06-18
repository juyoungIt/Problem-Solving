// BOJ - 28066
// Problem Sheet - https://www.acmicpc.net/problem/28066

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        for (int i=1 ; i<=n ; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            if (queue.size() < k) {
                int first = queue.poll();
                queue.clear();
                queue.add(first);
            } else {
                queue.add(queue.poll());
                for (int i=0 ; i<k-1 ; i++) {
                    queue.poll();
                }
            }
        }

        System.out.println(queue.poll());

        br.close();
        System.exit(0);
    }
}