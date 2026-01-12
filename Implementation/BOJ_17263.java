// BOJ - 17263
// Problem Sheet - https://www.acmicpc.net/problem/17263

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int max = -1;
            for (int i=0 ; i<n ; i++) {
                int e = Integer.parseInt(st.nextToken());
                max = Math.max(max, e);
            }
            System.out.println(max);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
