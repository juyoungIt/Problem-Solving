// BOJ - 10799
// Problem Sheet - https://www.acmicpc.net/problem/10799

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        int pieceCount = 0; // 조각의 갯수

        char[] aligns = bf.readLine().toCharArray(); // 쇠막대기가 놓여진 형태 정보
        char prev = ' '; // 이전문자
        for(char align : aligns) {
            if(align == '(') {
                stack.push(align);
            } else if(align == ')' && prev == '(') { // 레이저인 경우
                stack.pop();
                pieceCount += stack.size();
            } else { // 막대의 끝인 경우
                stack.pop();
                pieceCount++;
            }
            prev = align; // 이전문자 상태 업데이트
        }

        System.out.println(pieceCount);

        bf.close();
        System.exit(0);
    }
}