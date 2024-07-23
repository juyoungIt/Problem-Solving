// BOJ - 12015
// Problem Sheet - https://www.acmicpc.net/problem/12015

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> lis = new ArrayList<>();
        lis.add(0);
        for (int i=0 ; i<n ; i++) {
            if (arr[i] > lis.get(lis.size() - 1)) {
                lis.add(arr[i]);
            } else {
                int lowerBoundIndex = getLowerBoundIndex(lis, arr[i]);
                lis.set(lowerBoundIndex, arr[i]);
            }
        }
        System.out.println(lis.size() - 1);

        br.close();
        System.exit(0);
    }

    private static int getLowerBoundIndex(List<Integer> source, int target) {
        int start = 0;
        int end = source.size() - 1;
        int lowerBoundIndex = source.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (source.get(mid) >= target) {
                lowerBoundIndex = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return lowerBoundIndex;
    }

}