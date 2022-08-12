// BOJ - 1213
// Problem Sheet - https://www.acmicpc.net/problem/1213

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        String name = key.nextLine(); // 임한수의 이름
        int[] alphaCount = new int[26]; // 각 알파벳의 카운트 정보 저장
        char[] result = new char[name.length()]; // 생성할 팰린드롬을 저장
        int evenCount = 0, oddCount = 0; // 짝수, 홀수개 갯수 알파벳의 수
        int tmpIdx = 0; // 팰린드롬 생성에 사용하는 인덱스 저장용 변수

        // 이름을 구성하는 알파벳 카운트 정보를 갱신
        for(int i=0 ; i<name.length() ; i++)
            alphaCount[name.charAt(i)-65]++;
        for(int i=0 ; i<26 ; i++) {
            if(alphaCount[i] > 0 && alphaCount[i]%2 == 0)
                evenCount++;
            else if(alphaCount[i] > 0 && alphaCount[i]%2 == 1)
                oddCount++;
        }

        // 팰린드롬 생성이 가능한 지 확인
        if(oddCount > 1 || (name.length()%2 == 0 && oddCount > 0)) {
            System.out.println("I'm Sorry Hansoo");
            System.exit(0);
        }

        // 팰린드롬을 생성함
        if(name.length()%2 == 0) {
            for(int i=0 ; i<26 ; i++) {
                if(alphaCount[i] == 0)
                    continue;
                result[tmpIdx] = (char)(i+65);
                result[name.length()-1-tmpIdx] = (char)(i+65);
                alphaCount[i] -= 2;
                if(alphaCount[i] != 0)
                    i--;
                tmpIdx++;
            }
        }
        else {
            for(int i=0 ; i<26 ; i++) {
                if(alphaCount[i] == 0)
                    continue;
                if(alphaCount[i]%2 != 0) {
                    result[(name.length()-1)/2] = (char)(i+65);
                    alphaCount[i]--;
                    i--;
                    continue;
                }
                result[tmpIdx] = (char)(i+65);
                result[name.length()-1-tmpIdx] = (char)(i+65);
                alphaCount[i] -= 2;
                if(alphaCount[i] != 0)
                    i--;
                tmpIdx++;
            }
        }

        for(char c : result)
            System.out.print(c);
        System.out.println();

        key.close();
        System.exit(0);
    }
}