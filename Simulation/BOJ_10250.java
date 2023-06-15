// BOJ - 10250
// Problem Sheet - https://www.acmicpc.net/problem/10250

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int numberOfTestCases = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<numberOfTestCases ; i++) {
            st = new StringTokenizer(bf.readLine());
            int height = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            int sequenceOfRoom = Integer.parseInt(st.nextToken());
            sb.append(sequenceOfRoom%height == 0 ? height : sequenceOfRoom%height)
                    .append(String.format("%02d\n", sequenceOfRoom%height == 0
                            ? sequenceOfRoom/height
                            : sequenceOfRoom/height+1));
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}