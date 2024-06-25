// BOJ - 29160
// Problem Sheet - https://www.acmicpc.net/problem/29160

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer>[] lineup = new PriorityQueue[11];
        for (int i=0 ; i<11 ; i++) {
            lineup[i] = new PriorityQueue<>(Collections.reverseOrder());
        }

        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            lineup[p-1].add(w);
        }

        int totalSquadValue = 0;
        for (int i=0 ; i<k ; i++) {
            for(PriorityQueue<Integer> candidates : lineup) {
                if (!candidates.isEmpty()) {
                    candidates.add(Math.max(candidates.poll() - 1, 0));
                }
            }
        }

        for (int i=0 ; i<11 ; i++) {
            if (!lineup[i].isEmpty()) {
                totalSquadValue += lineup[i].peek();
            }
        }

        System.out.println(totalSquadValue);

        br.close();
        System.exit(0);
    }
}