// BOJ - 1864
// Problem Sheet - https://www.acmicpc.net/problem/1864

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<Character, Integer> valueMapper = new HashMap<>();
        valueMapper.put('-', 0);
        valueMapper.put('\\', 1);
        valueMapper.put('(', 2);
        valueMapper.put('@', 3);
        valueMapper.put('?', 4);
        valueMapper.put('>', 5);
        valueMapper.put('&', 6);
        valueMapper.put('%', 7);
        valueMapper.put('/', -1);

        while(true) {
            String input = br.readLine();
            if(input.equals("#")) {
                break;
            }
            char[] digits = input.toCharArray();
            int convertedValue = 0;
            for(int i=0 ; i<digits.length ; i++) {
                convertedValue += valueMapper.get(digits[i]) * (int) Math.pow(8, digits.length - 1 - i);
            }
            sb.append(convertedValue).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}