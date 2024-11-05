// BOJ - 11663
// Problem Sheet - https://www.acmicpc.net/problem/11663

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] points = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int lowerBoundIndex = getLowerBoundIndex(points, start);
            int upperBoundIndex = getUpperBoundIndex(points, end);
            sb.append(upperBoundIndex - lowerBoundIndex).append("\n");
        }
        System.out.println(sb);

        br.close();
    }

    private static int getLowerBoundIndex(int[] src, int target) {
        int start = 0;
        int end = src.length - 1;
        int lowerBoundIndex = src.length;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (src[mid] >= target) {
                lowerBoundIndex = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return lowerBoundIndex;
    }

    private static int getUpperBoundIndex(int[] src, int target) {
        int start = 0;
        int end = src.length - 1;
        int upperBoundIndex = src.length;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (src[mid] > target) {
                upperBoundIndex = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return upperBoundIndex;
    }
}