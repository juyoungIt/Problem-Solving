// BOJ - 15656
// Problem Sheet - https://www.acmicpc.net/problem/15656

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int m;
    private static int[] elements;
    private static int[] selected;
    private static StringBuilder result;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        result = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        elements = new int[n];
        selected = new int[m];

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
            for(int element : selected) {
                result.append(element).append(" ");
            }
            result.append("\n");
            return;
        }
        for(int i=0 ; i<n ; i++) {
            selected[curLen] = elements[i];
            generate(curLen + 1);
        }
    }
}