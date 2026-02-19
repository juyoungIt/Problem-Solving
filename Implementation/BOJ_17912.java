// BOJ - 17912
// Problem Sheet - https://www.acmicpc.net/problem/17912

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int minValue = Integer.MAX_VALUE, minIndex = 0;
        for (int i=0 ; i<n ; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (value < minValue) {
                minValue = value;
                minIndex = i;
            }
        }
        System.out.println(minIndex);
        br.close();
    }
}
