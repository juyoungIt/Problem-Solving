// BOJ - 18679
// Problem Sheet - https://www.acmicpc.net/problem/18679

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> wordMapper = new HashMap<>(); // 단어 간의 Mapper

        int n = Integer.parseInt(bf.readLine()); // 단어의 수
        // 단어 간의 mapping 관계를 구성함
        for(int i=0 ; i<n ; i++) {
            String[] mappings = bf.readLine().split(" = ");
            wordMapper.put(mappings[0], mappings[1]);
        }

        int tcSize = Integer.parseInt(bf.readLine()); // 테스트케이스의 수를 구성
        for(int i=0 ; i<tcSize ; i++) {
            StringBuilder sb = new StringBuilder();
            int sentenceSize = Integer.parseInt(bf.readLine());
            String[] words = bf.readLine().split(" ");
            for(int j=0 ; j<sentenceSize ; j++) {
                sb.append(wordMapper.get(words[j]));
                if(j<sentenceSize-1) {
                    sb.append(" ");
                }
            }
            System.out.println(sb);
        }

        bf.close();
        System.exit(0);
    }
}