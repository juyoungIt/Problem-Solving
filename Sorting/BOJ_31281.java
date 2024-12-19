// BOJ - 31281
// Problem Sheet - https://www.acmicpc.net/problem/31281

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .sorted()
                .toArray();

        System.out.println(arr[1]);
        br.close();
    }
}