// BOJ - 4575
// Problem Sheet - https://www.acmicpc.net/problem/4575

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String inputStr;
        Set<Character> tokenSet = new HashSet<>();
        while(!(inputStr = bf.readLine()).equals("END")) {
            char[] tokens = inputStr.toCharArray();
            boolean isValid = true;
            for(char token : tokens) {
                if(tokenSet.contains(token) && token != ' ') {
                    isValid = false;
                    break;
                }
                tokenSet.add(token);
            }
            if(isValid) {
                sb.append(inputStr).append("\n");
            }
            tokenSet.clear();
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}