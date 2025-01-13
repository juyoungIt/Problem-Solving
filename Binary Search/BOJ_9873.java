// BOJ - 9873
// Problem Sheet - https://www.acmicpc.net/problem/9873

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] cows = new int[N];
        for (int i=0 ; i<N;  i++) {
            cows[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(cows);

        int answer = 0;
        for (int i=0 ; i<N-2 ; i++) {
            for (int j=i+1 ; j<N-1 ; j++) {
                int bestCowIndexA = findBestCowIndexA(cows, j + 1, N - 1, cows[j] - cows[i]);
                int bestCowIndexB = findBestCowIndexB(cows, j + 1, N - 1, cows[j] - cows[i]);
                if (bestCowIndexA > j && bestCowIndexB > j) {
                    answer += bestCowIndexB - bestCowIndexA + 1;
                }
            }
        }

        System.out.println(answer);
        br.close();
    }

    private static int findBestCowIndexA(int[] cows, int start, int end, int firstThrowDist) {
        int bestCowIndex = -1;
        int secondCowIndex = start - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int throwDist = cows[mid] - cows[secondCowIndex];
            if (throwDist < firstThrowDist) {
                start = mid + 1;
            } else if (throwDist > firstThrowDist * 2) {
                end = mid - 1;
            } else {
                bestCowIndex = mid;
                end = mid - 1;
            }
        }
        return bestCowIndex;
    }

    private static int findBestCowIndexB(int[] cows, int start, int end, int firstThrowDist) {
        int bestCowIndex = -1;
        int secondCowIndex = start - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int throwDist = cows[mid] - cows[secondCowIndex];
            if (throwDist < firstThrowDist) {
                start = mid + 1;
            } else if (throwDist > firstThrowDist * 2) {
                end = mid - 1;
            } else {
                bestCowIndex = mid;
                start = mid + 1;
            }
        }
        return bestCowIndex;
    }
}