// BOJ - 32684
// Problem Sheet - https://www.acmicpc.net/problem/32684

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double cSum = 0, eSum = 1.5;
        int[] scores = { 13, 7, 5, 3, 3, 2 };
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0 ; i<6 ; i++) {
            cSum += Integer.parseInt(st.nextToken()) * scores[i];
        }
        st = new StringTokenizer(br.readLine());
        for (int i=0 ; i<6 ; i++) {
            eSum += Integer.parseInt(st.nextToken()) * scores[i];
        }
        System.out.println(cSum < eSum ? "ekwoo" : "cocjr0208");
        br.close();
    }
}
