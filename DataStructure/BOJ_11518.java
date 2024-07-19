// BOJ - 11518
// Problem Sheet - https://www.acmicpc.net/problem/11518

import java.util.*;
import java.io.*;

public class Main {

    private static final String MESSAGE_FORMAT = "%s not in dictionary.";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Map<Character, String> codes = new HashMap<>();
        for (int i=0 ; i<26 ; i++) {
            st = new StringTokenizer(br.readLine());
            char key = st.nextToken().charAt(0);
            String code = st.nextToken();
            codes.put(key, code);
        }

        Map<String, String> dictionary = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        for (int i=0 ; i<n ; i++) {
            String word = br.readLine();
            String code = encrypt(codes, word);
            dictionary.put(code, word);
        }

        while (true) {
            int w = Integer.parseInt(br.readLine());
            if (w == 0) break;
            StringBuilder buffer = new StringBuilder();
            boolean isValid = true;
            for (int i=0 ; i<w ; i++) {
                String code = br.readLine();
                if (!isValid) continue;
                if (!dictionary.containsKey(code)) {
                    buffer.setLength(0);
                    sb.append(String.format(MESSAGE_FORMAT, code));
                    isValid = false;
                    continue;
                }
                buffer.append(dictionary.get(code)).append(" ");
            }
            sb.append(buffer).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static String encrypt(Map<Character, String> codes, String source) {
        StringBuilder sb = new StringBuilder();
        for (int i=0 ; i<source.length() ; i++) {
            sb.append(codes.get(source.charAt(i)));
        }
        return sb.toString();
    }
}