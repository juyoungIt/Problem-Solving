// BOJ - 9728
// Problem Sheet - https://www.acmicpc.net/problem/9728

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int numberOfTestCases = Integer.parseInt(bf.readLine());
        for(int i=1 ; i<=numberOfTestCases ; i++) {
            int validPairCount = 0;
            st = new StringTokenizer(bf.readLine());
            int numberOfElements = Integer.parseInt(st.nextToken());
            int[] sequence = new int[numberOfElements];
            int targetPairSum = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(bf.readLine());
            for(int j=0 ; j<numberOfElements ; j++) {
                sequence[j] = Integer.parseInt(st.nextToken());
            }

            int start = 0;
            int end = numberOfElements-1;
            while(start < end) {
                int pairSum = sequence[start] + sequence[end];
                if(pairSum > targetPairSum) {
                    end--;
                } else {
                    if(pairSum == targetPairSum) {
                        validPairCount++;
                    }
                    start++;
                }
            }

            sb.append("Case #")
                    .append(i)
                    .append(": ")
                    .append(validPairCount)
                    .append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}