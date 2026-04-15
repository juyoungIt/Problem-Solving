// BOJ - 25285
// Problem Sheet - https://www.acmicpc.net/problem/25285

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            double bmi = weight / Math.pow(height * 0.01, 2);
            if (height < 140.1) {
                sb.append(6);
            } else if (140.1 <= height && height < 146) {
                sb.append(5);
            } else if (146 <= height && height < 159) {
                sb.append(4);
            } else if (159 <= height && height < 161) {
                sb.append((16.0 <= bmi && bmi < 35.0) ? 3 : 4);
            } else if (161 <= height && height < 204) {
                if (20.0 <= bmi && bmi < 25.0) sb.append(1);
                else if (18.5 <= bmi && bmi < 20.0 || 25.0 <= bmi && bmi < 30.0) sb.append(2);
                else if (16.0 <= bmi && bmi < 18.5 || 30.0 <= bmi && bmi < 35.0) sb.append(3);
                else sb.append(4);
            } else if (204 <= height) {
                sb.append(4);
            } else {
                throw new IllegalArgumentException();
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}