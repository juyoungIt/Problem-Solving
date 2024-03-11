// BOJ - 11648
// Problem Sheet - https://www.acmicpc.net/problem/11648

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();

        int seqCount = 0;
        while(n.length() > 1) {
            int[] digits = Arrays.stream(n.split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            n = String.valueOf(Arrays.stream(digits).reduce(1, (a, b) -> a * b));
            seqCount++;
        }

        System.out.println(seqCount);

        br.close();
        System.exit(0);
    }
}