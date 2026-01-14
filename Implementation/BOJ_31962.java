// BOJ - 31962
// Problem Sheet - https://www.acmicpc.net/problem/31962

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int deptTime = -1;
            for (int i=0 ; i<n ; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                if (s + t <= x) {
                    deptTime = Math.max(deptTime, s);
                }
            }
            System.out.println(deptTime);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
