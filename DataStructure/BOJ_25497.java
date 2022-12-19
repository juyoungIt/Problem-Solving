// BOJ - 25497
// Problem Sheet - https://www.acmicpc.net/problem/25497

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> lrTechStack = new Stack<>(); // L-R 기술스택
        Stack<Character> skTechStack = new Stack<>(); // S-K 기술스택
        int answer = 0; // 정상적으로 기술을 사용한 총 횟수

        // 1. 기술의 총 사용횟수 입력
        int n = Integer.parseInt(bf.readLine()); // 기술 사용횟수

        // 2. 기술 사용정보 입력
        char[] techs = bf.readLine().toCharArray(); // 기술 사용정보 입력

        for(char tech : techs) {
            if(Character.isDigit(tech))
                answer++;
            else if(tech == 'L' || tech == 'S') {
                if(tech == 'L') lrTechStack.push(tech);
                else skTechStack.push(tech);
            }
            else if(tech == 'R' || tech == 'K') {
                if(tech == 'R') {
                    if(!lrTechStack.isEmpty()) {
                        answer++;
                        lrTechStack.pop();
                    }
                    else break;
                }
                else {
                    if(!skTechStack.isEmpty()) {
                        answer++;
                        skTechStack.pop();
                    }
                    else break;
                }
            }
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}