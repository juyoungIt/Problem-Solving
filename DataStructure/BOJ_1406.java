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

        ListIterator<Character> iter = buffer.listIterator(buffer.size());
        int M = Integer.parseInt(br.readLine());
        for (int i=0 ; i<M ; i++) {
            st = new StringTokenizer(br.readLine());
            char command = st.nextToken().charAt(0);
            if (command == 'L') {
                if (iter.hasPrevious()) {
                    iter.previous();
                }
            } else if (command == 'D') {
                if (iter.hasNext()) {
                    iter.next();
                }
            } else if (command == 'B') {
                if (iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }
            } else {
                char letter = st.nextToken().charAt(0);
                iter.add(letter);
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