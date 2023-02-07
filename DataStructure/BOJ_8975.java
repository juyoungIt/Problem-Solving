// BOJ - 8975
// Problem Sheet - https://www.acmicpc.net/problem/8975

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int detectedWords = 0; // 발견한 제목 단어의 수
        int detectionPoint = 0; // 어떤 곡인지 아는 시점

        int titleWordCount = Integer.parseInt(bf.readLine()); // 제목을 구성하는 단어의 수
        Set<String> titleWords = new HashSet<>(); // 제목을 구성하는 단어들
        for(int i=0 ; i<titleWordCount ; i++) {
            titleWords.add(bf.readLine());
        }

        int lyricWordCount = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<lyricWordCount ; i++) {
            String word = bf.readLine();
            if(detectedWords >= (double)titleWordCount/2) {
                break;
            }
            if(titleWords.contains(word)) {
                detectedWords++;
                titleWords.remove(word);
            }
            detectionPoint++;
        }

        System.out.println(detectionPoint);

        bf.close();
        System.exit(0);
    }
}