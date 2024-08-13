// BOJ - 1365
// Problem Sheet - https://www.acmicpc.net/problem/1365

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] connections = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> lis = new ArrayList<>();
        lis.add(0);
        for (int i=0 ; i<n ; i++) {
            if (lis.get(lis.size() - 1) < connections[i]) {
                lis.add(connections[i]);
            } else {
                int lowerBoundIndex = getLowerBoundIndex(lis, connections[i]);
                lis.set(lowerBoundIndex, connections[i]);
            }
        }

        System.out.println(n - lis.size() + 1);

        br.close();
        System.exit(0);
    }

    private static int getLowerBoundIndex(List<Integer> list, int target) {
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