// BOJ - 29700
// Problem Sheet - https://www.acmicpc.net/problem/29700

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);
        int result = 0;
        for (int i=0 ; i<n ; i++) {
            String row = br.readLine();
            int size = 0;
            for (int j=0 ; j<m ; j++) {
                if (row.charAt(j) == '0') {
                    size++;
                } else {
                    if (size >= k) {
                        result += (size - k) + 1;
                    }
                    size = 0;
                }
            }
            if (size >= k) result += (size - k) + 1;
        }
        System.out.println(result);
        br.close();
    }
}