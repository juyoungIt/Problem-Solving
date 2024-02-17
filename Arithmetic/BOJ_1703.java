// BOJ - 1703
// Problem Sheet - https://www.acmicpc.net/problem/1703

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            if(age == 0) break;
            int leafs = 1;
            for(int i=0 ; i<age ; i++) {
                int splittingFactor = Integer.parseInt(st.nextToken());
                int removedBranches = Integer.parseInt(st.nextToken());
                leafs = leafs * splittingFactor - removedBranches;
            }
            sb.append(leafs).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}