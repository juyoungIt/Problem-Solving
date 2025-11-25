// BOJ - 34761
// Problem Sheet - https://www.acmicpc.net/problem/34761

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        boolean[] isUsed = new boolean[200_001];
        for (int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            isUsed[arr[i]] = true;
        }
        st = new StringTokenizer(br.readLine());
        br.close();
        boolean isAvailable = true;
        // 1. 이미 만들어진 부분 -> 순서가 완벽히 동일해야 함
        for (int i=0 ; i<n ; i++) {
            if (arr[i] != Integer.parseInt(st.nextToken())) {
                isAvailable = false;
                break;
            }
        }
        // 2. 앞으로 만들어낼 부분 -> 배열A가 가진 원소들만을 가지고 있어야 함
        if (isAvailable) {
            for (int i=n ; i<n*2 ; i++) {
                if (!isUsed[Integer.parseInt(st.nextToken())]) {
                    isAvailable = false;
                    break;
                }
            }
        }
        System.out.println(isAvailable ? "YES" : "NO");
    }
}