// BOJ - 2870
// Problem Sheet - https://www.acmicpc.net/problem/2870

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        List<BigInteger> numbers = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i=0 ; i<n ; i++) {
            String input = br.readLine();
            boolean isConnectedDigit = false;
            int startIndex = 0, endIndex = 0;
            for (int j=0 ; j<input.length() ; j++) {
                if (Character.isDigit(input.charAt(j))) {
                    if (!isConnectedDigit) {
                        startIndex = j;
                        isConnectedDigit = true;
                    }
                    endIndex = j;
                } else {
                    if (startIndex <= endIndex && isConnectedDigit) {
                        BigInteger value = new BigInteger(input.substring(startIndex, endIndex + 1));
                        numbers.add(value);
                    }
                    startIndex = j;
                    endIndex = j;
                    isConnectedDigit = false;
                }
            }
            if (isConnectedDigit) {
                BigInteger value = new BigInteger(input.substring(startIndex, endIndex + 1));
                numbers.add(value);
            }
        }

        Collections.sort(numbers);
        numbers.forEach(num -> sb.append(num).append("\n"));
        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}