// BOJ - 30802
// Problem Sheet - https://www.acmicpc.net/problem/30802

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] orders = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int bundleCountOfShirts = 0;
        int bundleOrderCountOfPen;
        int singleOrderCountOfPen;
        for (int order : orders) {
            bundleCountOfShirts += order / t + ((order % t == 0) ? 0 : 1);
        }
        bundleOrderCountOfPen = n / p;
        singleOrderCountOfPen = n % p;

        System.out.printf("%d\n%d %d\n", bundleCountOfShirts, bundleOrderCountOfPen, singleOrderCountOfPen);

        br.close();
        System.exit(0);
    }
}