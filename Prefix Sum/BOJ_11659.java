// BOJ - 11659
// Problem Sheet - https://www.acmicpc.net/problem/11659

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int numberOfElements = Integer.parseInt(st.nextToken());
        int numberOfQueries = Integer.parseInt(st.nextToken());
        int[] arr = new int[numberOfElements+1];
        int[] acc = new int[numberOfElements+1];
        st = new StringTokenizer(bf.readLine());
        for(int i=1 ; i<=numberOfElements ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            acc[i] = acc[i-1] + arr[i];
        }

        for(int i=0 ; i<numberOfQueries ; i++) {
            st = new StringTokenizer(bf.readLine());
            int leftIndex = Integer.parseInt(st.nextToken());
            int rightIndex = Integer.parseInt(st.nextToken());
            sb.append(acc[rightIndex] - acc[leftIndex-1]).append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}