// BOJ - 1182
// Problem Sheet - https://www.acmicpc.net/problem/1182

import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static int S;
    private static int[] arr;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0 ; i<N ; i++) {
            searchTargetSum(i, arr[i]);
        }

        System.out.println(count);

        bf.close();
        System.exit(0);
    }

    private static void searchTargetSum(int startIdx, int acc) {
        if(acc == S) {
            count++;
        }
        for(int i=startIdx+1 ; i<N ; i++) {
            acc += arr[i];
            searchTargetSum(i, acc);
            acc -= arr[i];
        }
    }
}