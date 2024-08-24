// BOJ - 14003
// Problem Sheet - https://www.acmicpc.net/problem/14003

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] seq = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] lisIndex = new int[n];

        List<Integer> lis = new ArrayList<>();
        lis.add(Integer.MIN_VALUE);
        for (int i=0 ; i<n ; i++) {
            if (lis.get(lis.size() - 1) < seq[i]) {
                lisIndex[i] = lis.size();
                lis.add(seq[i]);
            } else {
                int lowerBoundIndex = getLowerBoundIndex(lis, seq[i]);
                lis.set(lowerBoundIndex, seq[i]);
                lisIndex[i] = lowerBoundIndex;
            }
        }

        Stack<Integer> lisValues = new Stack<>();
        int findIndex = lis.size() - 1;
        for (int i=n-1 ; i>=0 ; i--) {
            if (findIndex == lisIndex[i]) {
                lisValues.push(seq[i]);
                findIndex--;
            }
        }

        sb.append(lis.size() - 1).append("\n");
        while (!lisValues.isEmpty()) {
            sb.append(lisValues.pop()).append(" ");
        }
        System.out.println(sb);

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