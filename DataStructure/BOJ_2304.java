// BOJ - 2304
// Problem Sheet - https://www.acmicpc.net/problem/2304

import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static int[][] pillars;
    private static int maxHeightIndex = -1, maxHeight = -1;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pillars = new int[N][2];
        for (int i=0 ; i<N ; i++) {
            String[] row = br.readLine().split(" ");
            pillars[i][0] = Integer.parseInt(row[0]);
            pillars[i][1] = Integer.parseInt(row[1]);
        }
        Arrays.sort(pillars, Comparator.comparingInt(p -> p[0]));
        for (int i=0 ; i<N ; i++) {
            if (maxHeight < pillars[i][1]) {
                maxHeightIndex = i;
                maxHeight = pillars[i][1];
            }
        }
        br.close();
    }

    private static int solve() {
        int area = 0;
        Deque<Integer> indexStack = new ArrayDeque<>();
        Deque<Integer> heightStack = new ArrayDeque<>();
        // 1. L to Top
        for (int i=0 ; i<maxHeightIndex ; i++) {
            if (heightStack.isEmpty() || heightStack.peek() < pillars[i][1]) {
                indexStack.push(pillars[i][0]);
                heightStack.push(pillars[i][1]);
            }
        }
        int prevIndex = pillars[maxHeightIndex][0];
        while (!indexStack.isEmpty() && !heightStack.isEmpty()) {
            area += (prevIndex - indexStack.peek()) * heightStack.pop();
            prevIndex = indexStack.pop();
        }
        // 2. R to Top
        for (int i=N-1 ; i>maxHeightIndex ; i--) {
            if (heightStack.isEmpty() || heightStack.peek() < pillars[i][1]) {
                indexStack.push(pillars[i][0]);
                heightStack.push(pillars[i][1]);
            }
        }
        prevIndex = pillars[maxHeightIndex][0];
        while (!indexStack.isEmpty() && !heightStack.isEmpty()) {
            area += (indexStack.peek() - prevIndex) * heightStack.pop();
            prevIndex = indexStack.pop();
        }

        return area + maxHeight;
    }
}
