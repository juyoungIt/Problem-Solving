// BOJ - 1268
// Problem Sheet - https://www.acmicpc.net/problem/1268

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][5];
        for (int i=1 ; i<=n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0 ; j<5 ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxCount = 0;
        int student = 1;
        for (int i=1 ; i<=n ; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j=0 ; j<5 ; j++) {
                for (int k=1 ; k<=n ; k++) {
                    if (i == k) continue;
                    if (arr[i][j] == arr[k][j]) {
                        set.add(k);
                    }
                }
            }
            if (set.size() > maxCount) {
                maxCount = set.size();
                student = i;
            }
        }

        System.out.println(student);
        br.close();
    }
}
