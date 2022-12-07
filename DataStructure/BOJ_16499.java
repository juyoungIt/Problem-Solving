// BOJ - 16499
// Problem Sheet - https://www.acmicpc.net/problem/16499

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Set<String> wordGroups = new HashSet<>(); // 문자열 그룹
        int n = Integer.parseInt(bf.readLine()); // 단어의 수

        // 단어를 입력받으며, 적절한 그룹을 구성함
        for(int i=0 ; i<n ; i++) {
            StringBuilder sb = new StringBuilder(); // 문자열을 구성하는 부분
            char[] words = bf.readLine().toCharArray(); // 입력한 단어에 대한 배열구성
            Arrays.sort(words); // 구성 문자를 사전 순으로 정렬
            sb.append(words); // 정렬한 문자를 문자열로 구성함
            wordGroups.add(sb.toString());
        }

        System.out.println(wordGroups.size());

        bf.close();
        System.exit(0);
    }
}