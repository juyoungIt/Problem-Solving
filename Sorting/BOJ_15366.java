// BOJ - 15366
// Problem Sheet - https://www.acmicpc.net/problem/15366

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] wands = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        int[] boxes = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        boolean result = true;
        for (int i=0 ; i<N ; i++) {
            if (wands[i] > boxes[i]) {
                result = false;
                break;
            }
        }

        System.out.println(result ? "DA" : "NE");
        br.close();
    }
}