// BOJ - 28444
// Problem Sheet - https://www.acmicpc.net/problem/28444

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] digits = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int result = digits[0] * digits[1] - digits[2] * digits[3] * digits[4];
        System.out.println(result);

        br.close();
        System.exit(0);
    }
}