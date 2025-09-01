// BOJ - 4402
// Problem Sheet - https://www.acmicpc.net/problem/4402

import java.util.*;
import java.io.*;

public class Main {

    static final Map<Character, Integer> codeMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        codeMap.put('B', 1); codeMap.put('F', 1); codeMap.put('P', 1); codeMap.put('V', 1);
        codeMap.put('C', 2); codeMap.put('G', 2); codeMap.put('J', 2); codeMap.put('K', 2);
        codeMap.put('Q', 2); codeMap.put('S', 2); codeMap.put('X', 2); codeMap.put('Z', 2);
        codeMap.put('D', 3); codeMap.put('T', 3);
        codeMap.put('L', 4);
        codeMap.put('M', 5); codeMap.put('N', 5);
        codeMap.put('R', 6);

        while (true) {
            String input = br.readLine();
            if (input == null) break;
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i=0 ; i<input.length() ; i++) {
                char c = input.charAt(i);
                if (!deque.isEmpty() && deque.peekLast().intValue() == codeMap.getOrDefault(c, 0)) continue;
                deque.addLast(codeMap.getOrDefault(c, 0));
            }
            while (!deque.isEmpty()) {
                int code = deque.pollFirst();
                if (code <= 0) continue;
                sb.append(code);
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }

}