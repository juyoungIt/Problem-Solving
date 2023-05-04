// BOJ - 1212
// Problem Sheet - https://www.acmicpc.net/problem/1212

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] binaryNumbers = {"000", "001", "010", "011", "100", "101", "110", "111"};
        String octalNumber = bf.readLine();

        if(octalNumber.charAt(0) == '0') {
            sb.append(0);
        } else {
            for(char digit : octalNumber.toCharArray()) {
                if(sb.length() == 0) {
                    sb.append(Integer.toBinaryString(Integer.parseInt(digit+"")));
                    continue;
                }
                sb.append(binaryNumbers[digit - '0']);
            }
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}