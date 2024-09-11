// BOJ - 1337
// Problem Sheet - https://www.acmicpc.net/problem/1337

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] elements = new int[n];
        Set<Integer> elementSet = new HashSet<>();
        for (int i=0 ; i<n ; i++) {
            int element = Integer.parseInt(br.readLine());
            elements[i] = element;
            elementSet.add(element);
        }
        Arrays.sort(elements);

        int minAddCount = 5;
        for (int i=0 ; i<n ; i++) {
            int addCount = 0;
            for (int j=1 ; j<=4 ; j++) {
                if (!elementSet.contains(elements[i] + j)) {
                    addCount++;
                }
            }
            minAddCount = Math.min(minAddCount, addCount);
        }

        System.out.println(minAddCount);

        br.close();
        System.exit(0);
    }
}