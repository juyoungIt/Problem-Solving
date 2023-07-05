// BOJ - 11728
// Problem Sheet - https://www.acmicpc.net/problem/11728

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arrA = new int[N];
        int[] arrB = new int[M];

        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<N ; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<M ; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        int arrAIndex = 0;
        int arrBIndex = 0;
        while(arrAIndex < N && arrBIndex < M) {
            if(arrA[arrAIndex] < arrB[arrBIndex]) {
                sb.append(arrA[arrAIndex++]).append(" ");
            } else {
                sb.append(arrB[arrBIndex++]).append(" ");
            }
        }
        while(arrAIndex < N) {
            sb.append(arrA[arrAIndex++]).append(" ");
        }
        while(arrBIndex < M) {
            sb.append(arrB[arrBIndex++]).append(" ");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}