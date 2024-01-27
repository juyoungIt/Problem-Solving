// BOJ - 2863
// Problem Sheet - https://www.acmicpc.net/problem/2863

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int a, b, c, d;
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        double[] candidates = new double[4];
        candidates[0] = (double)a / c + (double)b / d;
        candidates[1] = (double)c / d + (double)a / b;
        candidates[2] = (double)d / b + (double)c / a;
        candidates[3] = (double)b / a + (double)d / c;

        int maxIdx = 0;
        double maxVal = candidates[0];
        for(int i=0 ; i<4 ; i++) {
            if(maxVal < candidates[i]) {
                maxIdx = i;
                maxVal = candidates[i];
            }
        }
        System.out.println(maxIdx);

        br.close();
        System.exit(0);
    }
}