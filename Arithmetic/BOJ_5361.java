// BOJ - 5361
// Problem Sheet - https://www.acmicpc.net/problem/5361

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        double[] unitPrices = { 350.34, 230.90, 190.55, 125.30, 180.90 };
        int t = Integer.parseInt(bf.readLine());
        for(int i=0; i<t ; i++) {
            double sum = 0;
            st = new StringTokenizer(bf.readLine());
            for(int j=0 ; j<5 ; j++) {
                sum += Integer.parseInt(st.nextToken()) * unitPrices[j];
            }
            sb.append('$').append(String.format("%.2f\n", sum));
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}