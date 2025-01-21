// BOJ - 11596
// Problem Sheet - https://www.acmicpc.net/problem/11596

import java.util.*;
import java.io.*;

public class Main {

    private static int[] rectA, rectB;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve() ? "YES" : "NO");
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        rectA = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        rectB = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        br.close();
    }

    private static boolean solve() {
        if (!Arrays.equals(rectA, rectB)) {
            return false;
        }
        return isRightTriangle(rectA);
    }

    private static boolean isRightTriangle(int[] rect) {
        return Math.pow(rect[0], 2) + Math.pow(rect[1], 2) == Math.pow(rect[2], 2);
    }
}