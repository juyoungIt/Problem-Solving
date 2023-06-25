// BOJ - 19951
// Problem Sheet - https://www.acmicpc.net/problem/19951

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int sizeOfGround = Integer.parseInt(st.nextToken());
        int numberOfRequests = Integer.parseInt(st.nextToken());
        int[] ground = new int[sizeOfGround+1];
        st = new StringTokenizer(bf.readLine());
        for(int i=1 ; i<=sizeOfGround ; i++) {
            ground[i] = Integer.parseInt(st.nextToken());
        }

        int[] delta = new int[sizeOfGround + 2];
        for(int i=1 ; i<=numberOfRequests ; i++) {
            st = new StringTokenizer(bf.readLine());
            int startIndex = Integer.parseInt(st.nextToken());
            int endIndex = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            delta[startIndex] += height;
            delta[endIndex+1] -= height;
        }

        int[] accDelta = new int[sizeOfGround + 1];
        for(int i=1 ; i<=sizeOfGround ; i++) {
            accDelta[i] = accDelta[i-1] + delta[i];
        }

        for(int i=1 ; i<=sizeOfGround ; i++) {
            sb.append(ground[i] + accDelta[i]).append(" ");
        }
        sb.append("\n");

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}