// BOJ - 1590
// Problem Sheet - https://www.acmicpc.net/problem/1590

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        Set<Integer> departureTimeSet = new HashSet<>();
        for (int x=0 ; x<n ; x++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            departureTimeSet.add(s);
            for (int y=1 ; y<c ; y++) {
                departureTimeSet.add(s + i * y);
            }
        }

        int[] departureTimes = departureTimeSet.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        Arrays.sort(departureTimes);

        int lowerBoundIndex = getLowerBoundIndex(departureTimes, t);
        if (lowerBoundIndex >= departureTimes.length) {
            System.out.println(-1);
        } else {
            System.out.println(departureTimes[lowerBoundIndex] - t);
        }

        br.close();
        System.exit(0);
    }

    private static int getLowerBoundIndex(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int lowerBoundIndex = arr.length;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= target) {
                lowerBoundIndex = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return lowerBoundIndex;
    }
}