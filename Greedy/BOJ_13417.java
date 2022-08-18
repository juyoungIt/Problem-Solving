// BOJ - 13417
// Problem Sheet - https://www.acmicpc.net/problem/13417

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(bf.readLine()); // 테스트 케이스 수
        String[] answers = new String[t]; // 각 테스트 케이스의 정답을 저장
        for(int i=0 ; i<t ; i++) {
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(bf.readLine()); // 카드의 갯수
            st = new StringTokenizer(bf.readLine());
            char front = st.nextToken().charAt(0);
            sb.append(front);
            for(int j=1 ; j<n ; j++) {
                char letter = st.nextToken().charAt(0);
                if(letter <= front) {
                    sb.insert(0, letter);
                    front = sb.charAt(0);
                }
                else
                    sb.append(letter);
            }
            answers[i] = sb.toString();
        }

        for(String answer : answers)
            System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}