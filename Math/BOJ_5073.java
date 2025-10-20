// BOJ - 5073
// Problem Sheet - https://www.acmicpc.net/problem/5073

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[3];
            for (int i=0 ; i<3 ; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) break;
            Arrays.sort(arr);
            if (arr[0] + arr[1] <= arr[2]) {
                sb.append("Invalid");
            } else if (arr[0] == arr[1] && arr[1] == arr[2]) {
                sb.append("Equilateral");
            } else if (arr[0] == arr[1] || arr[1] == arr[2]) {
                sb.append("Isosceles");
            } else {
                sb.append("Scalene");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
