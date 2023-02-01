// BOJ - 5397
// Problem Sheet - https://www.acmicpc.net/problem/5397

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tcSize = Integer.parseInt(bf.readLine());
        List<Character> inputField = new LinkedList<>(); // 입력내용을 관리하는 리스트
        for(int i=0 ; i<tcSize ; i++) {
            char[] commands = bf.readLine().toCharArray();
            int cursorIndex = 0; // 커서의 인덱스
            for(char command : commands) {
                switch (command) {
                    case '-':
                        cursorIndex = remove(inputField, cursorIndex);
                        break;
                    case '<':
                        cursorIndex = moveLeft(cursorIndex);
                        break;
                    case '>':
                        cursorIndex = moveRight(inputField, cursorIndex);
                        break;
                    default:
                        cursorIndex = insert(inputField, cursorIndex, command);
                        break;
                }
            }
            for(char command : inputField) {
                sb.append(command);
            }
            sb.append("\n");
            inputField.clear(); // 재사용을 위한 초기화
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    static int insert(List<Character> inputField, int cursorIndex, char command) {
        if(cursorIndex == inputField.size()) {
            inputField.add(command);
        } else {
            inputField.add(cursorIndex, command);
        }
        return ++cursorIndex;
    }

    static int remove(List<Character> inputField, int cursorIndex) {
        if(cursorIndex > 0 && cursorIndex <= inputField.size()) {
            inputField.remove(--cursorIndex);
        }
        return cursorIndex;
    }

    static int moveLeft(int cursorIndex) {
        if(cursorIndex > 0) {
            cursorIndex--;
        }
        return cursorIndex;
    }

    static int moveRight(List<Character> inputField, int cursorIndex) {
        if(cursorIndex < inputField.size()) {
            cursorIndex++;
        }
        return cursorIndex;
    }
}