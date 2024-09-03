// BOJ - 14729
// Problem Sheet - https://www.acmicpc.net/problem/14729

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        List<Double> scores = new ArrayList<>(7);
        for (int i=0 ; i<7 ; i++) {
            double score = Double.parseDouble(br.readLine());
            scores.add(score);
        }
        Collections.sort(scores);

        for (int i=7 ; i<n ; i++) {
            double score = Double.parseDouble(br.readLine());
            if (scores.get(6) > score) {
                int lowerBoundIndex = getLowerBoundIndex(scores, score);
                scores.add(lowerBoundIndex, score);
            }
        }

        for (int i=0 ; i<7 ; i++) {
            sb.append(String.format("%.3f\n", scores.get(i)));
        }
        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static int getLowerBoundIndex(List<Double> list, double target) {
        int start = 0;
        int end = list.size() - 1;
        int lowerBoundIndex = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) >= target) {
                lowerBoundIndex = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return lowerBoundIndex;
    }
}