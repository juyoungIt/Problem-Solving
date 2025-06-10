// BOJ - 19718
// Problem Sheet - https://www.acmicpc.net/problem/19718

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[3];
        for (int i=0 ; i<3 ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int count = arr[2] + arr[1] - 2 * arr[0];
        System.out.println(count);
        br.close();
    }
}