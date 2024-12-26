// BOJ - 6147
// Problem Sheet - https://www.acmicpc.net/problem/6147

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        int[] heights = new int[N];
        for (int i=0 ; i<N ; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(heights);

        int answer = 0;
        while (B > 0) {
            B -= heights[N - 1 - answer++];
        }

        System.out.println(answer);
        br.close();
    }
}