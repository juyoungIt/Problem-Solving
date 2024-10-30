// BOJ - 26215
// Problem Sheet - https://www.acmicpc.net/problem/26215

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> homes = new PriorityQueue<>(Collections.reverseOrder());
        int N = Integer.parseInt(br.readLine());
        Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(homes::add);

        int totalMinutes = 0;
        while (!homes.isEmpty()) {
            int homeA = homes.poll();
            homeA--;
            if (!homes.isEmpty()) {
                int homeB = homes.poll();
                homeB--;
                if (homeB > 0) {
                    homes.add(homeB);
                }
            }
            if (homeA > 0) {
                homes.add(homeA);
            }
            totalMinutes++;
        }

        System.out.println(totalMinutes > 1_440 ? -1 : totalMinutes);

        br.close();
    }
}