// BOJ - 17413
// Problem Sheet - https://www.acmicpc.net/problem/17413

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] letters = bf.readLine().toCharArray();
        Stack<Character> stack = new Stack<>(); // 문자열을 반전시키기 위한 stack
        StringBuilder sb = new StringBuilder(); // 문자열 반전 결과를 저장
        boolean isTag = false; // 현재 태그를 참조 중인 가에 대한 여부

        for(int i=0 ; i<letters.length ; i++) {
            char letter = letters[i]; // 문자열에서 한 개의 문자를 가져옴
            if(!isTag) {
                if(letter == '<') {
                    isTag = true;
                    while(!stack.isEmpty())
                        sb.append(stack.pop());
                    sb.append(letter);
                }
                else if(letter == ' ' || i == letters.length-1) {
                    if(letter != ' ')
                        stack.push(letter);
                    while(!stack.isEmpty())
                        sb.append(stack.pop());
                    if(letter == ' ')
                        sb.append(letter);
                }
                else {
                    stack.push(letter);
                }
            }
            else {
                sb.append(letter);
                if(letter == '>')
                    isTag = false;
            }
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}