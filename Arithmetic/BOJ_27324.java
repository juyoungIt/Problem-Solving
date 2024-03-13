// BOJ - 27324
// Problem Sheet - https://www.acmicpc.net/problem/27324

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] digits = Arrays.stream(br.readLine().split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(digits[0] == digits[1] ? 1 : 0);

        br.close();
        System.exit(0);
    }
}