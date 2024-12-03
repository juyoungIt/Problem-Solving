// BOJ - 19709
// Problem Sheet - https://www.acmicpc.net/problem/19709

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[] arr = new int[m];
        for (int i=0 ; i<m ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int answer = 0;
        for (int i=0 ; i<m ; i++) {
            if (N - arr[i] < 0) {
                break;
            }
            answer++;
            N -= arr[i];
        }

        System.out.println(answer);
        br.close();
    }
}