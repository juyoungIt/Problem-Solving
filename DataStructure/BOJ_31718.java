// BOJ - 31718
// Problem Sheet - https://www.acmicpc.net/problem/31718

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] seq = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0 ; i<n ; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> countMapper = new HashMap<>();
        for (int element : seq) {
            while (element % 2 == 0) {
                element /= 2;
            }
            countMapper.put(element, countMapper.getOrDefault(element, 0) + 1);
        }

        int maxFrequency = 0;
        for (int frequency : countMapper.values()) {
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
            }
        }

        System.out.println(maxFrequency);

        br.close();
        System.exit(0);
    }
}