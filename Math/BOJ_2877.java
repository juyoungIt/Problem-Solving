// BOJ - 2877
// Problem Sheet - https://www.acmicpc.net/problem/2877

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(bf.readLine());
        List<Integer> accSum = new LinkedList<>();
        getAccSum(accSum, K);

        int diff = K - accSum.get(accSum.size()-2) - 1;
        String binaryString = String.format("%" + (accSum.size()-1) + "s", Integer.toBinaryString(diff)).replace(' ', '0');

        for(int i=0 ; i<binaryString.length() ; i++) {
            sb.append(binaryString.charAt(i) == '0' ? 4 : 7);
        }
        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static void getAccSum(List<Integer> accSum, int K) {
        int digit = 1;
        int currentSum = 2;
        accSum.add(0);
        accSum.add(currentSum);
        while(currentSum < K) {
            currentSum += (int)Math.pow(2, digit+1);
            accSum.add(currentSum);
            digit++;
        }
    }
}