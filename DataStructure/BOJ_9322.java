// BOJ - 9322
// Problem Sheet - https://www.acmicpc.net/problem/9322

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tcSize = Integer.parseInt(bf.readLine()); // 테스트 케이스의 수
        for(int i=0 ; i<tcSize ; i++) {
            Map<Integer, Integer> keyMapper = new HashMap<>(); // 암호화 방식 저장
            int wordCnt = Integer.parseInt(bf.readLine()); // 단어의 수
            List<String> publicKeyOne = new ArrayList<>(List.of(bf.readLine().split(" "))); // 공개키1
            List<String> publicKeyTwo = new ArrayList<>(List.of(bf.readLine().split(" "))); // 공개키2
            for(int j=0 ; j<wordCnt ; j++)
                keyMapper.put(j, publicKeyOne.indexOf(publicKeyTwo.get(j)));
            List<String> cryptogram = new ArrayList<>(List.of(bf.readLine().split(" "))); // 암호문
            String[] plainText = new String[cryptogram.size()];
            for(int j=0 ; j<wordCnt ; j++)
                plainText[keyMapper.get(j)] = cryptogram.get(j);
            // 종합된 결과를 출력함
            for(String word : plainText)
                System.out.print(word + " ");
            System.out.println();
        }

        bf.close();
        System.exit(0);
    }
}