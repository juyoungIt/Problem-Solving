// BOJ - 2143
// Problem Sheet - https://www.acmicpc.net/problem/2143

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        int n = Integer.parseInt(bf.readLine());
        int[] arrA = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<n ; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(bf.readLine());
        int[] arrB = new int[m];
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<m ; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        long answer = 0;
        Map<Integer, Integer> arrAPrefixSumCounts = getAllPrefixSumCounts(arrA);
        Map<Integer, Integer> arrBPrefixSumCounts = getAllPrefixSumCounts(arrB);
        for(Map.Entry<Integer, Integer> entry : arrBPrefixSumCounts.entrySet()) {
            answer += (long)entry.getValue() * arrAPrefixSumCounts.getOrDefault(T - entry.getKey(), 0);
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }

    private static Map<Integer, Integer> getAllPrefixSumCounts(int[] arr) {
        Map<Integer, Integer> countMapper = new HashMap<>();

        for(int i=0 ; i<arr.length ; i++) {
            int sum = arr[i];
            countMapper.put(sum, countMapper.getOrDefault(sum, 0) + 1);
            for(int j=i+1 ; j<arr.length ; j++) {
                sum += arr[j];
                countMapper.put(sum, countMapper.getOrDefault(sum, 0) + 1);
            }
        }
        return countMapper;
    }
}