// BOJ - 2805
// Problem Sheet - https://www.acmicpc.net/problem/2805

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] trees = new int[N];
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<N ; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(trees);

        int bottom = 0;
        int top = trees[N-1];
        int middle;
        int maxHeight = 0;
        while(bottom < top) {
            middle = (bottom + top) >> 1;
            long sum = 0;
            for(int tree : trees) {
                sum += Math.max(tree - middle, 0);
            }
            if(sum < M) {
                top = middle;
            } else {
                maxHeight = middle;
                bottom = middle + 1;
            }
        }

        System.out.println(maxHeight);

        bf.close();
        System.exit(0);
    }
}