// BOJ - 31872
// Problem Sheet - https://www.acmicpc.net/problem/31872

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] rooms = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i=1 ; i<=n ; i++) {
            rooms[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(rooms);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0 ; i<n ; i++) {
            pq.add(rooms[i + 1] - rooms[i]);
        }
        for (int i=0 ; i<k ; i++) {
            pq.poll();
        }
        long time = 0;
        while (!pq.isEmpty()) {
            time += pq.poll();
        }
        System.out.println(time);
        br.close();
    }
}
