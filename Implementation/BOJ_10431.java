// BOJ - 10431
// Problem Sheet - https://www.acmicpc.net/problem/10431

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int p = Integer.parseInt(br.readLine());
        for (int i=0 ; i<p ; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            LinkedList<Integer> sequence = new LinkedList<>();
            sequence.add(Integer.parseInt(st.nextToken()));
            int moveCount = 0;
            for (int j=1 ; j<20 ; j++) {
                int height = Integer.parseInt(st.nextToken());
                int index = getFirstIndex(sequence, height);
                moveCount += sequence.size() - index;
                sequence.add(index, height);
            }
            sb.append(t).append(" ").append(moveCount).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    private static int getFirstIndex(List<Integer> list, int value) {
        int index;
        for (index=0 ; index<list.size() ; index++) {
            if (list.get(index) > value) {
                break;
            }
        }
        return index;
    }
}