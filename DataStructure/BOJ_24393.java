// BOJ - 24393
// Problem Sheet - https://www.acmicpc.net/problem/24393

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int[][] a;
    private static final int SIZE = 27;
    private static final int LEFT_SIZE = 13, RIGHT_SIZE = 14;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n][];
        for (int i=0 ; i<n ; i++) {
            a[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        br.close();
    }

    private static int solve() {
        Deque<Integer> deque = new ArrayDeque<>(SIZE);
        // 1. 덱의 초기 상태를 세팅
        for (int i=1 ; i<=SIZE ; i++) {
            deque.addLast(i);
        }
        // 2. 주어진 정보를 이용하여 덱을 지속적으로 섞음
        for (int i=0 ; i<n ; i++) {
            // 2-1. 덱을 2분할 (left, right)
            Deque<Integer> left = new ArrayDeque<>(LEFT_SIZE);
            Deque<Integer> right = new ArrayDeque<>(RIGHT_SIZE);
            for (int j=0 ; j<LEFT_SIZE ; j++) left.add(deque.pollFirst());
            for (int j=0 ; j<RIGHT_SIZE ; j++) right.add(deque.pollFirst());
            // 2-2. right top 의 Ai1 장을 덱의 상단에 배치
            for (int j=0 ; j<a[i][0] ; j++) {
                deque.addLast(right.pollFirst());
            }
            // 2-3. left, right 를 번갈아 가면서 덱에 카드를 배치
            for (int j=1 ; j<a[i].length ; j++) {
                if (j % 2 == 0) {
                    for (int k=0 ; k<a[i][j] ; k++) {
                        deque.addLast(right.pollFirst());
                    }
                } else {
                    for (int k=0 ; k<a[i][j] ; k++) {
                        deque.addLast(left.pollFirst());
                    }
                }
            }
        }
        int jokerIndex = 1;
        for (int card : deque) {
            if (card == 1) break;
            jokerIndex++;
        }
        return jokerIndex;
    }

}