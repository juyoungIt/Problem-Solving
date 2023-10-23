// BOJ - 15565
// Problem Sheet - https://www.acmicpc.net/problem/15565

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dolls = new int[n];
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<n ; i++) {
            dolls[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0, r = 0;
        int minSize = n + 1;
        int ryanCount = dolls[0] == 1 ? 1 : 0;
        while(true) {
            if(ryanCount < k) {
                if(r >= n-1) {
                    break;
                }
                ryanCount += dolls[++r] == 1 ? 1 : 0;
            } else {
                int size = r - l + 1;
                if(size < minSize) {
                    minSize = size;
                }
                ryanCount -= dolls[l++] == 1 ? 1 : 0;
            }
        }

        System.out.println(minSize < n + 1 ? minSize : -1);

        bf.close();
        System.exit(0);
    }
}