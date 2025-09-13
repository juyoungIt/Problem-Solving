// BOJ - 11321
// Problem Sheet - https://www.acmicpc.net/problem/11321

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.equals("0")) break;
            int[] operands = Arrays.stream(input.split("\\+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            boolean[] isPaired = new boolean[operands.length];
            List<Integer> result = new ArrayList<>();
            for (int i=0 ; i<operands.length-1 ; i++) {
                if (isPaired[i]) continue;
                for (int j=i+1 ; j<operands.length ; j++) {
                    if (isPaired[j]) continue;
                    if ((operands[i] + operands[j]) % 10 == 0) {
                        result.add(operands[i]);
                        result.add(operands[j]);
                        isPaired[i] = true;
                        isPaired[j] = true;
                        break;
                    }
                }
            }
            for (int i=0 ; i<operands.length ; i++) {
                if (isPaired[i]) continue;
                result.add(operands[i]);
            }
            StringJoiner sj = new StringJoiner("+");
            result.forEach(o -> sj.add(Integer.toString(o)));
            sb.append(sj).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
