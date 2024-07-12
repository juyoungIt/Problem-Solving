// BOJ - 2745
// Problem Sheet - https://www.acmicpc.net/problem/2745

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Character, Integer> valueMapper = new HashMap<>();
        for (int i=0 ; i<36 ; i++) {
            if (i < 10) valueMapper.put((char)(i + 48), i);
            else valueMapper.put((char)(i + 55), i);
        }

        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());
        int answer = 0;
        for (int i=0 ; i<n.length() ; i++) {
            answer += valueMapper.get(n.charAt(i)) * (int) Math.pow(b, n.length()-1-i);
        }
        System.out.println(answer);

        br.close();
        System.exit(0);
    }
}