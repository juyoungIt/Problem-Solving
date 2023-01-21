// BOJ - 1406
// Problem Sheet - https://www.acmicpc.net/problem/1406

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Character> cache = new LinkedList<>(); // 작업한 문자열을 저장하는 공간
        String words = bf.readLine();
        for(int i=0 ; i<words.length() ; i++) {
            cache.add(words.charAt(i));
        }

        ListIterator<Character> iterator = cache.listIterator();
        while(iterator.hasNext()) {
            iterator.next();
        }

        int commandCnt = Integer.parseInt(bf.readLine()); // 사용한 명령어의 수
        for(int i=0 ; i<commandCnt ; i++) {
            String[] commands = bf.readLine().split(" ");
            switch (commands[0]) {
                case "L":
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                    }
                    break;
                case "D":
                    if (iterator.hasNext()) {
                        iterator.next();
                    }
                    break;
                case "B":
                    if(iterator.hasPrevious()) {
                        iterator.previous();
                        iterator.remove();
                    }
                    break;
                case "P":
                    iterator.add(commands[1].charAt(0));
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }

        for(char word : cache) {
            bw.write(word);
        }

        bw.flush();
        bw.close();
        bf.close();
        System.exit(0);
    }
}