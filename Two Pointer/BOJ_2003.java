// BOJ - 2003
// Problem Sheet - https://www.acmicpc.net/problem/2003

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int result = 0;

        int numberOfElements = Integer.parseInt(st.nextToken());
        int targetSum = Integer.parseInt(st.nextToken());

        int[] sequence = new int[numberOfElements];
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<numberOfElements ; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int currentSum = sequence[start];
        while(start < numberOfElements) {
            if(currentSum < targetSum) {
                if(end + 1 >= numberOfElements) {
                    break;
                }
                currentSum += sequence[++end];
            } else {
                if(currentSum == targetSum) {
                    result++;
                }
                currentSum -= sequence[start++];
            }
        }

        System.out.println(result);

        bf.close();
        System.exit(0);
    }
}