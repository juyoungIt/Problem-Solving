// BOJ - 5397
// Problem Sheet - https://www.acmicpc.net/problem/5397

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            char[] inputs = br.readLine().toCharArray();
            List<Character> buffer = new LinkedList<>();
            ListIterator<Character> iterator = buffer.listIterator();
            for (char command : inputs) {
                switch (command) {
                    case '-':
                        if (iterator.hasPrevious()) {
                            iterator.previous();
                            iterator.remove();
                        }
                        break;
                    case '<':
                        if (iterator.hasPrevious()) {
                            iterator.previous();
                        }
                        break;
                    case '>':
                        if (iterator.hasNext()) {
                            iterator.next();
                        }
                        break;
                    default:
                        iterator.add(command);
                }
            }
            StringBuilder tmpBuffer = new StringBuilder();
            for (char letter : buffer) {
                tmpBuffer.append(letter);
            }
            sb.append(tmpBuffer).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}