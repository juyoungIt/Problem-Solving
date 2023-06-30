// BOJ - 2110
// Problem Sheet - https://www.acmicpc.net/problem/2110

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] locations = new int[N];
        for(int i=0 ; i<N ; i++) {
            locations[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(locations);

        int start = 0;
        int end = locations[N-1] - locations[0] + 1;
        int middle;
        while(start < end) {
            middle = (start + end) >> 1;
            if(getInstallCount(locations, middle) < C) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }

        System.out.println(end-1);

        bf.close();
        System.exit(0);
    }

    private static int getInstallCount(int[] locations, int distance) {
        int installCount = 1;
        int lastIndex = 0;
        for(int i=1 ; i<locations.length ; i++) {
            if(locations[i]-locations[lastIndex] >= distance) {
                lastIndex = i;
                installCount++;
            }
        }
        return installCount;
    }
}