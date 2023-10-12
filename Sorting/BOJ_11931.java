// BOJ - 11931
// Problem Sheet - https://www.acmicpc.net/problem/11931

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());
        int[] numbers = new int[n];

        for (int i=0 ; i<n ; i++) {
            numbers[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(numbers);

        for(int i=n-1 ; i>=0 ; i--) {
            sb.append(numbers[i]).append("\n");
        }
        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}