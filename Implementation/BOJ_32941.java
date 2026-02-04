// BOJ - 32941
// Problem Sheet - https://www.acmicpc.net/problem/32941

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        boolean isValid = true;
        for (int i=0 ; i<n ; i++) {
            int k = Integer.parseInt(br.readLine());
            int[] arr = new int[k];
            st = new StringTokenizer(br.readLine());
            boolean isExist = false;
            for (int j=0 ; j<k ; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                if (arr[j] == x) isExist = true;
            }
            if (!isExist) {
                isValid = false;
            }
        }
        System.out.println(isValid ? "YES" : "NO");
        br.close();
    }
}
