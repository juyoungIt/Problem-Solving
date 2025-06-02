// BOJ - 33559
// Problem Sheet - https://www.acmicpc.net/problem/33559

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arrA = new int[n];
        int[] arrB = new int[n];
        String[] row = br.readLine().split(" ");
        for (int i=0 ; i<n ; i++) {
            arrA[i] = Integer.parseInt(row[i]);
        }
        row = br.readLine().split(" ");
        for (int i=0 ; i<n ; i++) {
            arrB[i] = Integer.parseInt(row[i]);
        }
        Arrays.sort(arrA);
        Arrays.sort(arrB);

        int indexA = 0, indexB = 0;
        List<Integer> pairElements = new ArrayList<>();
        List<Integer> notPairElementsA = new ArrayList<>();
        List<Integer> notPairElementsB = new ArrayList<>();
        while (indexA < n && indexB < n) {
            if (arrA[indexA] == arrB[indexB]) {
                pairElements.add(arrA[indexA]);
                indexA++;
                indexB++;
            } else if (arrA[indexA] < arrB[indexB]) {
                notPairElementsA.add(arrA[indexA++]);
            } else {
                notPairElementsB.add(arrB[indexB++]);
            }
        }

        while (indexA < n) notPairElementsA.add(arrA[indexA++]);
        while (indexB < n) notPairElementsB.add(arrB[indexB++]);

        sb.append(pairElements.size()).append("\n");
        for (int pairElement : pairElements) {
            sb.append(pairElement).append(" ");
        }
        for (int notPairElement : notPairElementsA) {
            sb.append(notPairElement).append(" ");
        }

        sb.append("\n");
        for (int pairElement : pairElements) {
            sb.append(pairElement).append(" ");
        }
        for (int notPairElement : notPairElementsB) {
            sb.append(notPairElement).append(" ");
        }

        System.out.println(sb);
        br.close();
    }
}
