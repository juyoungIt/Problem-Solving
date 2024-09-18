// BOJ - 15819
// Problem Sheet - https://www.acmicpc.net/problem/15819

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int targetIndex = Integer.parseInt(st.nextToken());
        String[] handles = new String[n];
        for (int i=0 ; i<n ; i++) {
            handles[i] = br.readLine();
        }
        Arrays.sort(handles);

        System.out.println(handles[targetIndex - 1]);

        br.close();
        System.exit(0);
    }
}