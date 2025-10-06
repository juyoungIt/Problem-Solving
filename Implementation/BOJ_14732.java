// BOJ - 14732
// Problem Sheet - https://www.acmicpc.net/problem/14732

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] land = new boolean[501][501];
        StringTokenizer st;
        int reserved = 0;
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            int lbx = Integer.parseInt(st.nextToken());
            int lby = Integer.parseInt(st.nextToken());
            int rtx = Integer.parseInt(st.nextToken());
            int rty = Integer.parseInt(st.nextToken());
            for (int y=lby ; y<rty ; y++) {
                for (int x=lbx ; x<rtx ; x++) {
                    if (land[y][x]) continue;
                    land[y][x] = true;
                    reserved++;
                }
            }
        }
        System.out.println(reserved);
        br.close();
    }
}
