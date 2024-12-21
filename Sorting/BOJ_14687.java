// BOJ - 14687
// Problem Sheet - https://www.acmicpc.net/problem/14687

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        PriorityQueue<Integer> lowTides = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> highTides = new PriorityQueue<>();
        for (int i=0 ; i<n/2 ; i++) {
            lowTides.add(arr[i]);
            highTides.add(arr[n - 1 - i]);
        }
        if (n % 2 == 1) lowTides.add(arr[n / 2]);

        while (!lowTides.isEmpty() && !highTides.isEmpty()) {
            sb.append(lowTides.poll())
                    .append(" ")
                    .append(highTides.poll())
                    .append(" ");
        }
        if (!lowTides.isEmpty()) sb.append(lowTides.poll());

        System.out.println(sb);
        br.close();
    }
}