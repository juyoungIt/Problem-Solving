// BOJ - 2343
// Problem Sheet - https://www.acmicpc.net/problem/2343

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int maxLectureSize = 0;
        int[] lectures = new int[N];
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<N ; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            if(maxLectureSize < lectures[i]) {
                maxLectureSize = lectures[i];
            }
        }

        int minSize = maxLectureSize;
        int maxSize = N * 10000;
        int curSize;
        int curBluRayCount;
        int optimalSize = -1;
        while(minSize <= maxSize) {
            curSize = (minSize + maxSize) / 2;
            curBluRayCount = getBluRayCount(lectures, curSize);
            if(curBluRayCount <= M) {
                optimalSize = curSize;
                maxSize = curSize - 1;
            } else {
                minSize = curSize + 1;
            }
        }

        System.out.println(optimalSize);

        bf.close();
        System.exit(0);
    }

    private static int getBluRayCount(int[] lectures, int unitSize) {
        int count = 1;
        int remainSpace = unitSize;
        for(int lecture : lectures) {
            if(remainSpace < lecture) {
                count++;
                remainSpace = unitSize;
            }
            remainSpace -= lecture;
        }
        return count;
    }
}