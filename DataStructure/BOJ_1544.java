// BOJ - 1544
// Problem Sheet - https://www.acmicpc.net/problem/1544

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Set<String> words = new HashSet<>(); // 입력된 단어의 Set을 관리
        int n = Integer.parseInt(bf.readLine()); // 단어의 수

        // n개의 단어를 입력받으며, 각각에 대하여 다음을 반복함
        for(int i=0 ; i<n ; i++) {
            String word = bf.readLine(); // 1개의 단어를 읽어옴
            if(i == 0) { // 첫번째 단어인 경우 Set에 바로 등록함
                words.add(word);
            } else { // 두번째 이후 단어인 경우 -> Set에 추가가능한 조합인 지 검사 후 추가
                if(isAppendable(words, word)) {
                    words.add(word);
                }
            }
        }

        System.out.println(words.size()); // 구성한 Set의 Size를 출력함

        bf.close();
        System.exit(0);
    }

    // 입력된 단어가 추가 가능한 단어인 지 확인
    static boolean isAppendable(Set<String> words, String word) {
        StringBuilder sb = new StringBuilder(word);
        if(words.contains(sb.toString())) {
            return false;
        }
        for(int i=0 ; i<word.length()-1 ; i++) {
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
            if(words.contains(sb.toString())) {
                return false;
            }
        }
        return true;
    }
}