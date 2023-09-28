// BOJ - 28097
// Problem Sheet - https://www.acmicpc.net/problem/28097

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        String[] times = bf.readLine().split(" ");
        int totalTimes = Arrays.stream(times)
                .mapToInt(Integer::parseInt)
                .sum() + 8 * (N-1);

        System.out.println(totalTimes / 24 + " " + totalTimes % 24);

        bf.close();
        System.exit(0);
    }
}