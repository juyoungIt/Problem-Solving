// BOJ - 11004
// Problem Sheet - https://www.acmicpc.net/problem/11004

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] numbers = new int[n];

        st = new StringTokenizer(bf.readLine());
        for (int i=0 ; i<n ; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        System.out.println(numbers[k-1]);

        bf.close();
        System.exit(0);
    }
}