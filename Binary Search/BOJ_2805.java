// BOJ - 2805
// Problem Sheet - https://www.acmicpc.net/problem/2805

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int optimalHeight = -1;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int minHeight = 0;
        int[] heights = new int[N];
        int maxHeight = 0;
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<heights.length ; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
            if(heights[i] > maxHeight) {
                maxHeight = heights[i];
            }
        }

        int cutterHeight;
        long totalLength;
        while(minHeight <= maxHeight) {
            cutterHeight = (minHeight + maxHeight) / 2;
            totalLength = getLength(heights, cutterHeight);
            if(totalLength >= M) {
                optimalHeight = cutterHeight;
                minHeight = cutterHeight + 1;
            } else {
                maxHeight = cutterHeight - 1;
            }
        }

        System.out.println(optimalHeight);

        bf.close();
        System.exit(0);
    }

    private static long getLength(int[] heights, int cutterHeight) {
        long totalLength = 0;
        for(int height : heights) {
            totalLength += Math.max(height - cutterHeight, 0);
        }
        return totalLength;
    }
}