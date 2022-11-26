// BOJ - 11478
// Problem Sheet - https://www.acmicpc.net/problem/11478

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String userInput = bf.readLine();
        Set<String> subStrings = new HashSet<>(); // 입력된 문자열의 부분문자열을 저장하는 set

        // 부분 문자열의 크기를 1씩 증가시키며 다음을 반복
        for(int i=1 ; i<=userInput.length() ; i++)
            for(int j=0 ; j<userInput.length()-i+1 ; j++)
                subStrings.add(userInput.substring(j, j+i));

        // 부분 문자열의 수를 출력
        System.out.println(subStrings.size());

        bf.close();
        System.exit(0);
    }
}