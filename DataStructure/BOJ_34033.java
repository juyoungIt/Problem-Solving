// BOJ - 34033
// Problem Sheet - https://acmicpc.net/problem/34033

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> priceMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            priceMap.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        int answer = 0;
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            String productName = st.nextToken();
            int price = Integer.parseInt(st.nextToken());
            if (priceMap.get(productName) * 1.05 < price) {
                answer++;
            }
        }
        System.out.println(answer);
        br.close();
    }
}
