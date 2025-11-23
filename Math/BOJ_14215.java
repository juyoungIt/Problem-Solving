// BOJ - 14215
// Problem Sheet - https://www.acmicpc.net/problem/14215

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        int[] arr = new int[3];
        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = Integer.parseInt(st.nextToken());
        arr[2] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int sum = arr[0] + arr[1];
        if (sum > arr[2]) System.out.println(sum + arr[2]);
        else System.out.println(sum * 2 - 1);
    }
}
