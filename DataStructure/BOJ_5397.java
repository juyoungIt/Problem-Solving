// BOJ - 5397
// Problem Sheet - https://www.acmicpc.net/problem/5397

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int tcSize = Integer.parseInt(bf.readLine()); // 테스트 케이스의 크기
        List<String> storage = new LinkedList<>(); // 사용자 입력내용
        for(int i=0 ; i<tcSize ; i++) {
            String[] commands = bf.readLine().split("");
            int cursorIndex = -1;
            for(String command : commands) {
                switch (command) {
                    case "-":
                        cursorIndex = remove(storage, cursorIndex);
                        break;
                    case "<":
                        cursorIndex = moveLeft(cursorIndex);
                        break;
                    case ">":
                        cursorIndex = moveRight(storage, cursorIndex);
                        break;
                    default:
                        cursorIndex = insert(storage, cursorIndex, command);
                        break;
                }
            }

            // 해당 테스트 케이스에 대한 처리결과를 출력함
            StringBuilder sb = new StringBuilder();
            for(String letter : storage) {
                sb.append(letter);
            }
            System.out.println(sb);
            storage.clear(); // 재사용을 위한 초기화
        }

        bf.close();
        System.exit(0);
    }

    // 커서 뒤에 1개의 문자를 추가하고, 커서를 이동함
    static int insert(List<String> storage, int cursor, String command) {
        if(cursor == -1) {
            storage.add(0, command);
        } else if(cursor < storage.size()) {
            storage.add(cursor+1, command);
        } else {
            storage.add(command);
        }
        return ++cursor;
    }

    // 커서 앞의 문자를 1개 지움
    static int remove(List<String> storage, int cursor) {
        if(cursor >= storage.size()) {
            cursor = storage.size()-1;
        }
        if(cursor >= 0) {
            storage.remove(cursor);
        } else {
            cursor = -1;
        }
        return cursor;
    }

    // 커서를 왼쪽으로 1칸 이동함
    static int moveLeft(int cursor) {
        if(cursor >= 0) {
            cursor--;
        }
        return cursor;
    }

    // 커서를 오른쪽으로 1칸 이동함
    static int moveRight(List<String> storage, int cursor) {
        if(cursor < storage.size()) {
            cursor++;
        }
        return cursor;
    }
}