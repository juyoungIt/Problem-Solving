// BOJ - 4589
// Problem Sheet - https://www.acmicpc.net/problem/4589

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st;
            sb.append("Gnomes:").append("\n");
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int[] arr = new int[3];
                for (int j = 0; j < 3; j++) {
                    arr[j] = Integer.parseInt(st.nextToken());
                }
                if (arr[0] < arr[1] && arr[1] < arr[2] || arr[2] < arr[1] && arr[1] < arr[0]) {
                    sb.append("Ordered").append("\n");
                } else {
                    sb.append("Unordered").append("\n");
                }
            }
            System.out.println(sb);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}