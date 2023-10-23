// BOJ - 11728
// Problem Sheet - https://www.acmicpc.net/problem/11728

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arrA = new int[n];
        int[] arrB = new int[m];
        int[] union = new int[n + m];

        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<n ; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<m ; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        int lastA = 0, lastB = 0;
        for(int i=0 ; i<n+m ; i++) {
            if(lastA < n && lastB < m) {
                union[i] = Math.min(arrA[lastA], arrB[lastB]);
                if(arrA[lastA] <= arrB[lastB]) {
                    lastA++;
                } else {
                    lastB++;
                }
            } else if(lastA < n) {
                union[i] = arrA[lastA++];
            } else {
                union[i] = arrB[lastB++];
            }
        }

        for(int element : union) {
            sb.append(element).append(" ");
        }
        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}