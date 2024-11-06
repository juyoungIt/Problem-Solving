// BOJ - 15828
// Problem Sheet - https://www.acmicpc.net/problem/15828

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int bufferLimit = Integer.parseInt(br.readLine());
        Queue<Integer> buffer = new LinkedList<>();
        while (true) {
            int request = Integer.parseInt(br.readLine());
            if (request == -1) {
                break;
            } else if (request == 0) {
                buffer.poll();
            } else {
                if (buffer.size() < bufferLimit) {
                    buffer.add(request);
                }
            }
        }

        if (buffer.isEmpty()) {
            sb.append("empty");
        } else {
            while (!buffer.isEmpty()) {
                sb.append(buffer.poll()).append(" ");
            }
        }
        System.out.println(sb);

        br.close();
    }
}