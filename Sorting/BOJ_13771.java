// BOJ - 13771
// Problem Sheet - https://www.acmicpc.net/problem/13771

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        double[] prices = new double[N];
        for (int i=0 ; i<N ; i++) {
            prices[i] = Double.parseDouble(br.readLine());
        }
        Arrays.sort(prices);

        System.out.printf("%.2f\n", prices[1]);
        br.close();
    }
}