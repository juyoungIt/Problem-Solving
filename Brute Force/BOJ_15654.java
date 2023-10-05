// BOJ - 15654
// Problem Sheet - https://www.acmicpc.net/problem/15654

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int m;
    private static boolean[] used;
    private static int[] elements;
    private static int[] status;
    private static StringBuilder result;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        result = new StringBuilder();

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        used = new boolean[n];
        elements = new int[n];
        status = new int[m];

        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<n ; i++) {
            elements[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(elements);

        generate(0);
        System.out.println(result);

        bf.close();
        System.exit(0);
    }

    private static void generate(int curLen) {
        if(curLen == m) {
            for(int element : status) {
                result.append(element).append(" ");
            }
            result.append("\n");
            return;
        }
        for(int i=0 ; i<n ; i++) {
            if(!used[i]) {
                status[curLen] = elements[i];
                used[i] = true;
                generate(curLen + 1);
                used[i] = false;
            }
        }
    }
}