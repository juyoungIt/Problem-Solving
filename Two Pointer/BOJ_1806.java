// BOJ - 1806
// Problem Sheet - https://www.acmicpc.net/problem/1806

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] sequence = new int[N];
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<N ; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int leftIndex = 0;
        int rightIndex = 0;
        int currentSum = sequence[0];
        int minLength = N+1;
        while(true) {
            int length = rightIndex - leftIndex + 1;
            if(currentSum >= S) {
                minLength = Math.min(minLength, length);
                currentSum -= sequence[leftIndex++];
            } else {
                if(rightIndex + 1 >= N) {
                    break;
                }
                currentSum += sequence[++rightIndex];
            }
        }

        System.out.println(minLength > N ? 0 : minLength);

        bf.close();
        System.exit(0);
    }
}