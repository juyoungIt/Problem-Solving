// BOJ - 28281
// Problem Sheet - https://www.acmicpc.net/problem/28281

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] prices = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=n ; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        int minPrice = Integer.MAX_VALUE;
        for(int i=1 ; i<n ; i++) {
            int totalPrice = prices[i] * x + prices[i + 1] * x;
            if(totalPrice < minPrice) {
                minPrice = totalPrice;
            }
        }
        System.out.println(minPrice);

        br.close();
        System.exit(0);
    }
}