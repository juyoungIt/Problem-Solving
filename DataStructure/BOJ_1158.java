// BOJ - 1158
// Problem Sheet - https://www.acmicpc.net/problem/1158

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringJoiner sj = new StringJoiner(", ", "<", ">");

        int n = Integer.parseInt(st.nextToken()); // 수열을 구성하는 수의 수
        int k = Integer.parseInt(st.nextToken()); // 적용할 번째 수
        int curIndex = 0; // 현재 탐색 중인 index

        List<Integer> queue = new LinkedList<>();
        for(int i=1 ; i<=n ; i++) {
            queue.add(i);
        }

        while(!queue.isEmpty()) {
            int index = getNextIndex(curIndex, queue.size(), k);
            sj.add(queue.remove(index).toString());
            curIndex = index;
        }

        System.out.println(sj);

        bf.close();
        System.exit(0);
    }

    static int getNextIndex(int curIndex, int n, int increment) {
        if(curIndex+increment >= n) {
            return (curIndex + increment - 1) % n;
        }
        return curIndex + increment - 1;
    }
}