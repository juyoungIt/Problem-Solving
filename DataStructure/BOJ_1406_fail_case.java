// BOJ - 1406
// Problem Sheet - https://www.acmicpc.net/problem/1406

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        List<Character> buffer = new LinkedList<>();
        String data = br.readLine();
        for (int i=0 ; i<data.length() ; i++) {
            buffer.add(data.charAt(i));
        }

        int M = Integer.parseInt(br.readLine());
        int cursor = data.length() - 1;
        for (int i=0 ; i<M ; i++) {
            st = new StringTokenizer(br.readLine());
            char command = st.nextToken().charAt(0);
            if (command == 'L') {
                cursor = Math.max(-1, cursor - 1);
            } else if (command == 'D') {
                cursor = Math.min(buffer.size() - 1, cursor + 1);
            } else if (command == 'B') {
                if (cursor < 0) continue;
                buffer.remove(cursor);
                cursor = Math.max(-1, cursor - 1);
            } else {
                char letter = st.nextToken().charAt(0);
                buffer.add(++cursor, letter);
            }
        }

        for (char letter : buffer) {
            bw.write(letter);
        }
        bw.flush();

        bw.close();
        br.close();
    }
}