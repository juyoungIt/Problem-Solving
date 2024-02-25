// BOJ - 1377
// Problem Sheet - https://www.acmicpc.net/problem/1377

import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node> {
        private final int index;
        private final int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() { return this.index; }
        public int getValue() { return this.value; }

        @Override
        public int compareTo(Node n) {
            return this.value - n.getValue();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Node[] arr = new Node[n];
        for(int i=0 ; i<n ; i++) {
            arr[i] = new Node(i, Integer.parseInt(br.readLine()));
        }
        Arrays.sort(arr);

        int maxDiff = 0;
        for(int i=0 ; i<n ; i++) {
            int indexDiff = arr[i].getIndex() - i;
            if(indexDiff > maxDiff) {
                maxDiff = indexDiff;
            }
        }

        System.out.println(maxDiff + 1);

        br.close();
        System.exit(0);
    }
}