// BOJ - 7241
// Problem Sheet - https://www.acmicpc.net/problem/7241

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int x = Integer.parseInt(br.readLine());

        int answer = -1;
        int[] combinations = new int[6];
        int count = 0;
        for (int i=0 ; i<3 ; i++) {
            for (int j=0 ; j<3 ; j++) {
                if (i == j) continue;
                for (int k=0 ; k<3 ; k++) {
                    if (k == i || k == j) continue;
                    int combination = input[i] * 100 + input[j] * 10 + input[k];
                    combinations[count++] = combination;
                }
            }
        }
        Arrays.sort(combinations);

        for (int i=0 ; i<6 ; i++) {
            if (combinations[i] == x) {
                answer = i;
                break;
            }
        }

        System.out.println(answer + 1);
        br.close();
    }
}