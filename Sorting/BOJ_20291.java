// BOJ - 20291
// Problem Sheet - https://www.acmicpc.net/problem/20291

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(bf.readLine());
        String[] extensions = new String[N];
        for(int i=0 ; i<N ; i++) {
            extensions[i] = bf.readLine().split("\\.")[1];
        }
        Arrays.sort(extensions);

        int curCount = 1;
        for(int i=1 ; i<N ; i++) {
            if(extensions[i-1].equals(extensions[i])) {
                curCount++;
            } else {
                sb.append(extensions[i-1]).append(" ").append(curCount).append("\n");
                curCount = 1;
            }
        }
        sb.append(extensions[N-1]).append(" ").append(curCount).append("\n");

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}