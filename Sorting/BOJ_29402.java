// BOJ - 29402
// Problem Sheet - https://www.acmicpc.net/problem/29402

import java.util.*;
import java.io.*;

public class Main {

    private static final String YES = "YES", NO = "NO";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] row = br.readLine().split(" ");
        for (int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(row[i]);
        }
        Arrays.sort(arr);

        boolean isValid = true;
        if (n <= 2) System.out.println(YES);
        else {
            for (int i=2 ; i<n ; i++) {
                if (arr[i - 2] + arr[i - 1] != arr[i]) {
                    isValid = false;
                    break;
                }
            }
            System.out.println(isValid ? YES : NO);
        }
        br.close();
    }
}